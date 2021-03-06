package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.backstage.vo.UserVo;
import com.nacos.common.annotation.Authority;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProUserRoleService;
import com.nacos.system.UserService;
import com.nacos.system.dto.ProUser;
import com.nacos.system.dto.ProUserRole;
import com.nacos.system.request.ProUserRoleRequest;
import com.nacos.system.request.User;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@Api(value = "管理员操作接口")
@SuppressWarnings("unchecked")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    IProUserRoleService proUserRoleService;

    @PostMapping(value = "/userPageList")
    @ApiOperation(value = "分页查询管理员列表")
    @Log(name = "管理员日志", value = "分页查询管理员列表", source = "system-app")
    @Authority(values = {"admin_select"})
    @SentinelResource(value = "user/userPageList")
    public ServiceResponse<List<UserVo>> getUsers(@RequestBody User user) {
        return new ServiceResponse<List<UserVo>>()
                .run(serviceResponse -> {

                    // 获取结果
                    ServiceResponse<List<ProUser>> response = userService.getPageList(new ProParameter<User>(user))
                            .copyPage(serviceResponse);

                    // 验证请求状态
                    response.checkState();

                    if (response.getObj().size() > 0) {

                        // 过滤取得userId数组
                        List<Integer> userIds = response.getObj().stream()
                                .map(proUser -> proUser.getUserId())
                                .distinct()
                                .collect(Collectors.toList());
                        ProUserRoleRequest proUserRoleRequest = new ProUserRoleRequest();
                        proUserRoleRequest.setIds(userIds);

                        // 通过in查询
                        ServiceResponse<List<ProUserRole>> proUserRoleServiceResponse = proUserRoleService.findIdsList(new ProParameter<>(proUserRoleRequest));
                        proUserRoleServiceResponse.checkState();

                        // 拼装数据
                        List<ProUser> proUsers = response.getObj();
                        List<UserVo> userVos = proUsers.stream()
                                .map(proUser -> {
                                    UserVo userVo = new UserVo();
                                    BeanUtils.copyProperties(proUser,userVo);
                                    if (proUser.getLastLoginTime() != null)
                                    userVo.setLastLoginTime(DateUtil.getyyMMddHHmmss(proUser.getLastLoginTime()));
                                    userVo.setCreateTime(DateUtil.getyyMMddHHmmss(proUser.getCreateTime()));
                                    Integer[] ids = proUserRoleServiceResponse.getObj()
                                            .stream()
                                            .filter(proUserRole -> proUserRole.getUserId().equals(proUser.getUserId()))
                                            .map(proUserRole -> proUserRole.getRoleId())
                                            .distinct()
                                            .toArray(Integer[]::new);
                                    userVo.setIds(ids);
                                    return userVo;
                                }).collect(Collectors.toList());
                        return userVos;
                    }
                    return new ArrayList<>();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除用户")
    @Log(name = "管理员日志", value = "删除用户", source = "system-app")
    @GlobalTransactional
    @Authority(values = {"admin_del"})
    @SentinelResource(value = "user/delete")
    public ServiceResponse<Integer> delete(@RequestBody User user) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    return userService.delete(new ProParameter<User>(user))
                            .beginTransaction().checkState().getObj();
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "添加用户")
    @Authority(values = {"addadmin"})
    @Log(name = "管理员日志", value = "添加", source = "system-app")
    @GlobalTransactional(rollbackFor = Exception.class)
    @SentinelResource(value = "user/save")
    public ServiceResponse<Integer> save(@RequestBody User user) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    User userPro = new User();
                    userPro.setUserName(user.getUserName());
                    ServiceResponse<ProUser> response = userService.userNameGetUser(new ProParameter<>(userPro));
                    if (response.getObj() != null) {
                        serviceResponse.setCode(500);
                        serviceResponse.setMsg("此账号已经存在");
                        throw new Exception("sss");
                    }
                    ServiceResponse<Integer> saveResponse = userService.save(new ProParameter<User>(user));
                    saveResponse.beginTransaction();
                    saveResponse.checkState();
                    return saveResponse.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/updateStats")
    @ApiOperation(value = "修改用户状态")
    @Log(name = "管理员日志", value = "修改用户状态", source = "system-app")
    @Authority(values = {"admin_edit"})
    @GlobalTransactional
    @SentinelResource(value = "user/updateStats")
    public ServiceResponse<Integer> updateStats(@RequestBody User user) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    return userService.update(new ProParameter<User>(user)).beginTransaction().checkState().getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改用户")
    @Log(name = "管理员日志", value = "修改用户", source = "system-app")
    @GlobalTransactional
    @Authority(values = {"admin_edit"})
    @SentinelResource(value = "user/update")
    public ServiceResponse<Integer> update(@RequestBody User user) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    User userPro = new User();
                    userPro.setUserName(user.getUserName());
                    ServiceResponse<ProUser> response = userService.userNameGetUser(new ProParameter<>(userPro));
                    response.beginTransaction().checkState();
                    if (response.getObj() != null && !response.getObj().getUserId().equals(user.getUserId())) {
                        serviceResponse.setCode(500);
                        serviceResponse.setMsg("此账号已经存在");
                        return -1;
                    }
                    return userService.update(new ProParameter<User>(user)).beginTransaction().checkState().getObj();
                })
                .exec();
    }
}

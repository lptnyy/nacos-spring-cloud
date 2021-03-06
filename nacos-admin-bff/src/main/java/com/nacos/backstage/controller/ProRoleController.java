package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.backstage.vo.ProRoleMenuVo;
import com.nacos.backstage.vo.ProRoleVo;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProRoleMenuService;
import com.nacos.system.IProRoleService;
import com.nacos.system.dto.ProRole;
import com.nacos.system.dto.ProRoleMenu;
import com.nacos.system.request.ProRoleMenuRequest;
import com.nacos.system.request.ProRoleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 系统角色表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@RestController
@RequestMapping(value = "proRole")
@Api(value = "ProRoleController", description = "系统角色表 ")
@SuppressWarnings("unchecked")
public class ProRoleController {

    @Autowired
    IProRoleService proRoleService;

    @Autowired
    IProRoleMenuService proRoleMenuService;

    @Autowired
    IProRoleMenuService iProRoleMenuService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "系统角色表", value = "分页查询列表", source = "admin-app")
    @SentinelResource(value = "proRole/getPageList")
    public ServiceResponse<List<ProRoleVo>> getPageList(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<List<ProRoleVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProRole>> response = proRoleService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 查询所有角色权限关系  如果权限很多 请改写
                    ServiceResponse<List<ProRoleMenu>> roleMenuResponse = proRoleMenuService.getList(new ProParameter<>(new ProRoleMenuRequest()));

                    // 角色权限关联
                    List<ProRoleMenu> proRoleMenus = roleMenuResponse.getObj();

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProRole> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProRoleVo> returnList = resultList.stream()
                            .map(proRole -> {
                                ProRoleVo proRolevo = new ProRoleVo();
                                BeanUtils.copyProperties(proRole,proRolevo);
                                proRolevo.setCreateTime(DateUtil.getyyMMddHHmmss(proRole.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要

                                // 代替mysql 过滤数据
                                List<ProRoleMenuVo> proRoleMenuVos = proRoleMenus.stream()
                                        .filter(proRoleMenu -> proRoleMenu.getRoleId().equals(proRole.getRoleId()))
                                        .map(proRoleMenu -> {
                                            ProRoleMenuVo proRoleMenuVo = new ProRoleMenuVo();
                                            BeanUtils.copyProperties(proRoleMenu,proRoleMenuVo);
                                            proRoleMenuVo.setCreateTime(DateUtil.getyyMMddHHmmss(proRoleMenu.getCreateTime()));
                                            // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                            return proRoleMenuVo;
                                        }).collect(Collectors.toList());
                                // 存放数据
                                proRolevo.setProRoleMenuVos(proRoleMenuVos);
                                return proRolevo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "系统角色表", value = "获取单条信息", source = "admin-app")
    @SentinelResource(value = "proRole/get")
    public ServiceResponse<ProRoleVo> get(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<ProRoleVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProRole> response = proRoleService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProRole proRole = response.getObj();
                    ProRoleVo proRoleVo = new ProRoleVo();
                    BeanUtils.copyProperties(proRole,proRoleVo);
                    return proRoleVo;
                })
                .exec();
    }

    @PostMapping(value = "/getList")
    @ApiOperation(value = "获取所有角色信息")
    @Log(name = "系统角色表", value = "获取所有角色信息", source = "admin-app")
    @SentinelResource(value = "proRole/getList")
    public ServiceResponse<List<ProRole>> getList(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<List<ProRole>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProRole>> response = proRoleService.getList(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    //@GlobalTransactional
    @SentinelResource(value = "proRole/save")
    @Log(name = "系统角色表", value = "保存", source = "admin-apps")
    public ServiceResponse<ProRoleVo> save(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<ProRoleVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProRole> response = proRoleService.get(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回结果 包括数据库插入id
                    ProRole proRole = proRoleService.save(new ProParameter<>(request))
                            .beginTransaction()
                            .checkState()
                            .getObj();

                    ProRoleVo proRoleVo = new ProRoleVo();
                    BeanUtils.copyProperties(proRole,proRoleVo);
                    return proRoleVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    //@GlobalTransactional
    @SentinelResource(value = "proRole/idsDelete")
    @Log(name = "系统角色表", value = "批量删除", source = "admin-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleService.idsDelete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    //@GlobalTransactional
    @SentinelResource(value = "proRole/delete")
    @Log(name = "系统角色表", value = "删除", source = "admin-app")
    public ServiceResponse<Integer> delete(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleService.delete(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 删除角色下面所有的权限设置
                    ProRoleMenuRequest proRoleMenuRequest = new ProRoleMenuRequest();
                    proRoleMenuRequest.setRoleId(request.getRoleId());
                    response = proRoleMenuService.delete(new ProParameter<>(proRoleMenuRequest));
                    response.beginTransaction();
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    //@GlobalTransactional
    @SentinelResource(value = "proRole/update")
    @Log(name = "系统角色表", value = "修改", source = "admin-app")
    public ServiceResponse<Integer> update(@RequestBody ProRoleRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}

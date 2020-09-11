package com.nacos.backstage.controller;
import com.nacos.backstage.vo.ProAppVo;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.system.IProAppService;
import com.nacos.system.dto.ProApp;
import com.nacos.system.request.ProAppRequest;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
    * 应用管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-19
 */
@RestController
@RequestMapping(value = "proApp")
@Api(value = "ProAppController", description = "应用管理")
@SuppressWarnings("unchecked")
public class ProAppController {

    @Autowired
    IProAppService proAppService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "应用管理", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"app_select"})
    public ServiceResponse<List<ProAppVo>> getPageList(@RequestBody ProAppRequest request) {
      return new ServiceResponse<List<ProAppVo>>()
          .run(serviceResponse -> {
            // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
             ServiceResponse<List<ProApp>> response = proAppService.getPageList(new ProParameter<>(request)
               .setRequestPage(request));

             // 获取调用服务状态
             response.checkState();

             // 获取返回的分页信息
             response.copyPage(serviceResponse);

             // 获取服务返回的结果
             List<ProApp> resultList = response.getObj();

             // 组装vo 返回数据 也可以不组装直接返回原始数据
             List<ProAppVo> returnList = resultList.stream()
               .map(proApp -> {
                  ProAppVo proAppvo = new ProAppVo();
                  BeanUtils.copyProperties(proApp,proAppvo);
                  proAppvo.setCreateTime(DateUtil.getyyMMddHHmmss(proApp.getCreateTime()));
                  // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                  return proAppvo;
               })
               .collect(Collectors.toList());
             return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "应用管理", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"app_select"})
    public ServiceResponse<ProAppVo> get(@RequestBody ProAppRequest request) {
      return new ServiceResponse<ProAppVo>()
          .run(serviceResponse -> {
             // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
             ServiceResponse<ProApp> response = proAppService.get(new ProParameter<>(request));

             // 获取调用服务状态
             response.checkState();

             // 组装返回的vo
             ProApp proApp = response.getObj();
             ProAppVo proAppVo = new ProAppVo();
             BeanUtils.copyProperties(proApp,proAppVo);
             return proAppVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @Log(name = "应用管理", value = "保存", source = "admin-app")
    @Authority(values = {"app_create"})
    @GlobalTransactional
    public ServiceResponse<ProAppVo> save(@RequestBody ProAppRequest request) {
      return new ServiceResponse<ProAppVo>()
              .beginTransaction()
          .run(serviceResponse -> {
              // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ServiceResponse<ProApp> response = proAppService.get(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              response = proAppService.save(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 获取返回数据
              ProApp proApp = response.getObj();
              ProAppVo proAppVo = new ProAppVo();
              BeanUtils.copyProperties(proApp,proAppVo);
              return proAppVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "应用管理", value = "批量删除", source = "admin-app")
    @Authority(values = {"app_del"})
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProAppRequest request) {
      return new ServiceResponse<Integer>()
          .run(serviceResponse -> {
             // 标记通过enumid删除
             request.setId(1);

             // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
             ServiceResponse<Integer> response = proAppService.idsDelete(new ProParameter<>(request));
             response.beginTransaction();

             // 获取调用服务状态
             response.checkState();

             return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "应用管理", value = "删除", source = "admin-app")
    @Authority(values = {"app_del"})
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProAppRequest request) {
      return new ServiceResponse<Integer>()
          .run(serviceResponse -> {

             // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
             ServiceResponse<Integer> response = proAppService.delete(new ProParameter<>(request));
             response.beginTransaction();

             // 获取调用服务状态
             response.checkState();

             return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "应用管理", value = "修改", source = "admin-app")
    @Authority(values = {"app_edit"})
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProAppRequest request) {
      return new ServiceResponse<Integer>()
          .run(serviceResponse -> {

            // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
            ServiceResponse<Integer> response = proAppService.update(new ProParameter<>(request));
            response.beginTransaction();

            // 获取调用服务状态
            response.checkState();

            return response.getObj();
          })
          .exec();
    }
}

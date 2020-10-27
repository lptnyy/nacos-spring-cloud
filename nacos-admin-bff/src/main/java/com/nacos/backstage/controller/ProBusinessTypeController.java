package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.business.IProBusinessTypeService;
import com.nacos.business.dto.ProBusinessType;
import com.nacos.business.request.ProBusinessTypeRequest;
import com.nacos.backstage.vo.ProBusinessTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.seata.spring.annotation.GlobalTransactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
    * 商家类型
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@RestController
@RequestMapping(value = "proBusinessType")
@Api(value = "ProBusinessTypeController", description = "商家类型 ")
@SuppressWarnings("unchecked")
public class ProBusinessTypeController {

    @Autowired
    IProBusinessTypeService proBusinessTypeService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "商家类型 ", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"business_type_select"})
    @SentinelResource(value = "proBusinessType/getPageList")
    public ServiceResponse<List<ProBusinessTypeVo>> getPageList(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<List<ProBusinessTypeVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              request.setIsDel(0);
              List<ProBusinessType> resultList = proBusinessTypeService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProBusinessTypeVo> returnList = resultList.stream()
                .map(proBusinessType -> {
                    ProBusinessTypeVo proBusinessTypevo = new ProBusinessTypeVo();
                    BeanUtils.copyProperties(proBusinessType,proBusinessTypevo);
                    proBusinessTypevo.setCreateTime(DateUtil.getyyMMddHHmmss(proBusinessType.getCreateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proBusinessTypevo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "商家类型 ", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"business_type_select"})
    @SentinelResource(value = "proBusinessType/get")
    public ServiceResponse<ProBusinessTypeVo> get(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<ProBusinessTypeVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProBusinessType proBusinessType = proBusinessTypeService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProBusinessTypeVo proBusinessTypeVo = new ProBusinessTypeVo();
              BeanUtils.copyProperties(proBusinessType,proBusinessTypeVo);
              return proBusinessTypeVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "商家类型 ", value = "保存", source = "admin-app")
    @Authority(values = {"business_type_add"})
    @SentinelResource(value = "proBusinessType/save")
    public ServiceResponse<ProBusinessTypeVo> save(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<ProBusinessTypeVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProBusinessType proBusinessType = proBusinessTypeService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ProBusinessTypeVo proBusinessTypeVo = new ProBusinessTypeVo();
              BeanUtils.copyProperties(proBusinessType,proBusinessTypeVo);
              return proBusinessTypeVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "商家类型 ", value = "批量删除", source = "admin-app")
    @Authority(values = {"business_type_del"})
    @SentinelResource(value = "proBusinessType/idsDelete")
    @GlobalTransactional
    public ServiceResponse<List<ProBusinessType>> idsDelete(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<List<ProBusinessType>>()
          .beginTransaction()
          .run(serviceResponse -> {
              List<ProBusinessTypeRequest> requests = new ArrayList<>();
              request.getIds().forEach(id -> {
                ProBusinessTypeRequest newRequst = new ProBusinessTypeRequest();
                newRequst.setTypeId(id);
                newRequst.setIsDel(1);
                requests.add(newRequst);
              });

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proBusinessTypeService
                  .batchUpdate(new ProParameter<>(requests))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "商家类型 ", value = "删除", source = "admin-app")
    @Authority(values = {"business_type_del"})
    @SentinelResource(value = "proBusinessType/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              request.setIsDel(1);
              return proBusinessTypeService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "商家类型 ", value = "修改", source = "admin-app")
    @Authority(values = {"business_type_update"})
    @SentinelResource(value = "proBusinessType/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProBusinessTypeRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proBusinessTypeService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}

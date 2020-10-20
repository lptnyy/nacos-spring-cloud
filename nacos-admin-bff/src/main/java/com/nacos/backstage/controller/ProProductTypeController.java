package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.product.IProProductTypeService;
import com.nacos.product.dto.ProProductType;
import com.nacos.product.request.ProProductTypeRequest;
import com.nacos.backstage.vo.ProProductTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@RestController
@RequestMapping(value = "proProductType")
@Api(value = "ProProductTypeController", description = "产品分类 ")
@SuppressWarnings("unchecked")
public class ProProductTypeController {

    @Autowired
    IProProductTypeService proProductTypeService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "产品分类 ", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"product_type_select"})
    @SentinelResource(value = "proProductType/getPageList")
    public ServiceResponse<List<ProProductTypeVo>> getPageList(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<List<ProProductTypeVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<ProProductType> resultList = proProductTypeService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 筛选出父级id
              List<Integer> pIds = resultList.stream()
                  .filter(proProductType -> {
                    if (!proProductType.getParentId().equals(0)){
                      return true;
                    }
                    return false;
                  }).map(proProductType -> {
                    return proProductType.getParentId();
                  })
                  .distinct()
                  .collect(Collectors.toList());

              // 查询父级ids数据
              ProProductTypeRequest proProductTypeRequest = new ProProductTypeRequest();
              proProductTypeRequest.setTypeId(1);
              proProductTypeRequest.setIds(pIds);
              Map<Integer, String> integerStringMap = new HashMap<>();
              integerStringMap.put(0,"");
              if (pIds.size() > 0)
              proProductTypeService
                  .findIdsList(new ProParameter<>(proProductTypeRequest))
                  .checkState()
                  .getObj()
                  .forEach(proProductType -> {
                    integerStringMap.put(proProductType.getTypeId(),proProductType.getName());
                  });

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProProductTypeVo> returnList = resultList.stream()
                .map(proProductType -> {
                    ProProductTypeVo proProductTypevo = new ProProductTypeVo();
                    BeanUtils.copyProperties(proProductType,proProductTypevo);
                    proProductTypevo.setParentName(integerStringMap.get(proProductTypevo.getParentId()));
                    proProductTypevo.setCreateTime(DateUtil.getyyMMddHHmmss(proProductType.getCreateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proProductTypevo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

  @PostMapping(value = "/getList")
  @ApiOperation(value = "分页查询列表")
  @Log(name = "产品分类 ", value = "分页查询列表", source = "admin-app")
  @SentinelResource(value = "proProductType/getList")
  public ServiceResponse<List<ProProductTypeVo>> getList(@RequestBody ProProductTypeRequest request) {
    return new ServiceResponse<List<ProProductTypeVo>>()
        .run(serviceResponse -> {

          // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
          List<ProProductType> resultList = proProductTypeService.getList(new ProParameter<>(request))
              .checkState()
              .getObj();

          // 组装vo 返回数据 也可以不组装直接返回原始数据
          List<ProProductTypeVo> returnList = resultList.stream()
              .map(proProductType -> {
                ProProductTypeVo proProductTypevo = new ProProductTypeVo();
                BeanUtils.copyProperties(proProductType,proProductTypevo);
                proProductTypevo.setCreateTime(DateUtil.getyyMMddHHmmss(proProductType.getCreateTime()));
                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                return proProductTypevo;
              })
              .collect(Collectors.toList());

          List<ProProductTypeVo> asRetunList = new ArrayList<>();
          ProProductTypeVo proProductTypeVo = new ProProductTypeVo();
          proProductTypeVo.setTypeId(0);
          proProductTypeVo.setName("根目录");
          asRetunList.add(proProductTypeVo);
          asRetunList.addAll(returnList);
          return asRetunList;
        })
        .exec();
  }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "产品分类 ", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"product_type_select"})
    @SentinelResource(value = "proProductType/get")
    public ServiceResponse<ProProductTypeVo> get(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<ProProductTypeVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProProductType proProductType = proProductTypeService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProProductTypeVo proProductTypeVo = new ProProductTypeVo();
              BeanUtils.copyProperties(proProductType,proProductTypeVo);
              return proProductTypeVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "产品分类 ", value = "保存", source = "admin-app")
    @Authority(values = {"product_type_add"})
    @SentinelResource(value = "proProductType/save")
    public ServiceResponse<ProProductTypeVo> save(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<ProProductTypeVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProProductType proProductType = proProductTypeService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ProProductTypeVo proProductTypeVo = new ProProductTypeVo();
              BeanUtils.copyProperties(proProductType,proProductTypeVo);
              return proProductTypeVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "产品分类 ", value = "批量删除", source = "admin-app")
    @Authority(values = {"product_type_del"})
    @SentinelResource(value = "proProductType/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setTypeId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proProductTypeService
                  .idsDelete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "产品分类 ", value = "删除", source = "admin-app")
    @Authority(values = {"product_type_del"})
    @SentinelResource(value = "proProductType/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proProductTypeService
                  .delete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "产品分类 ", value = "修改", source = "admin-app")
    @Authority(values = {"product_type_update"})
    @SentinelResource(value = "proProductType/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProProductTypeRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proProductTypeService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}

package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.member.IProMerchantService;
import com.nacos.member.dto.ProMerchant;
import com.nacos.member.request.ProMerchantRequest;
import com.nacos.backstage.vo.ProMerchantVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    * 商户表
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@RestController
@RequestMapping(value = "proMerchant")
@Api(value = "ProMerchantController", description = "商户表 ")
@SuppressWarnings("unchecked")
public class ProMerchantController {

    @Autowired
    IProMerchantService proMerchantService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "商户表 ", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"merchant_select"})
    @SentinelResource(value = "proMerchant/getPageList")
    public ServiceResponse<List<ProMerchantVo>> getPageList(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<List<ProMerchantVo>>()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<ProMerchant> resultList = proMerchantService.getPageList(new ProParameter<>(request)
                .setRequestPage(request))
                .checkState()
                .copyPage(serviceResponse)
                .getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProMerchantVo> returnList = resultList.stream()
                .map(proMerchant -> {
                    ProMerchantVo proMerchantvo = new ProMerchantVo();
                    BeanUtils.copyProperties(proMerchant,proMerchantvo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proMerchantvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "商户表 ", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"merchant_select"})
    @SentinelResource(value = "proMerchant/get")
    public ServiceResponse<ProMerchantVo> get(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<ProMerchantVo>()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProMerchant proMerchant = proMerchantService
                .get(new ProParameter<>(request))
                .checkState()
                .getObj();

              // 组装返回的vo
              ProMerchantVo proMerchantVo = new ProMerchantVo();
              BeanUtils.copyProperties(proMerchant,proMerchantVo);
              return proMerchantVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "商户表 ", value = "保存", source = "admin-app")
    @Authority(values = {"merchant_add"})
    @SentinelResource(value = "proMerchant/save")
    public ServiceResponse<ProMerchantVo> save(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<ProMerchantVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProMerchant proMerchant = proMerchantService
                .save(new ProParameter<>(request))
                .beginTransaction()
                .checkState()
                .getObj();

              // 获取返回数据
              ProMerchantVo proMerchantVo = new ProMerchantVo();
              BeanUtils.copyProperties(proMerchant,proMerchantVo);
              return proMerchantVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "商户表 ", value = "批量删除", source = "admin-app")
    @Authority(values = {"merchant_del"})
    @SentinelResource(value = "proMerchant/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setMerchantId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proMerchantService
                 .idsDelete(new ProParameter<>(request))
                 .beginTransaction()
                 .checkState()
                 .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "商户表 ", value = "删除", source = "admin-app")
    @Authority(values = {"merchant_del"})
    @SentinelResource(value = "proMerchant/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proMerchantService
                .delete(new ProParameter<>(request))
                .beginTransaction()
                .checkState()
                .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "商户表 ", value = "修改", source = "admin-app")
    @Authority(values = {"merchant_update"})
    @SentinelResource(value = "proMerchant/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProMerchantRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proMerchantService
                .update(new ProParameter<>(request))
                .beginTransaction()
                .checkState()
                .getObj();
          })
          .exec();
    }
}

package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.business.IProBusinessService;
import com.nacos.business.dto.ProBusiness;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.backstage.vo.ProBusinessVo;
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
    * 商家信息表
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-29
 */
@RestController
@RequestMapping(value = "proBusiness")
@Api(value = "ProBusinessController", description = "商家信息表 ")
@SuppressWarnings("unchecked")
public class ProBusinessController {

    @Autowired
    IProBusinessService proBusinessService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "商家信息表 ", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"business_select"})
    @SentinelResource(value = "proBusiness/getPageList")
    public ServiceResponse<List<ProBusinessVo>> getPageList(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<List<ProBusinessVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              request.setIsDel(0);
              List<ProBusiness> resultList = proBusinessService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProBusinessVo> returnList = resultList.stream()
                .map(proBusiness -> {
                    ProBusinessVo proBusinessvo = new ProBusinessVo();
                    BeanUtils.copyProperties(proBusiness,proBusinessvo);
                    proBusinessvo.setCreateTime(DateUtil.getyyMMddHHmmss(proBusiness.getCreateTime()));
                    proBusinessvo.setUpdateTime(DateUtil.getyyMMddHHmmss(proBusiness.getUpdateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proBusinessvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "商家信息表 ", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"business_select"})
    @SentinelResource(value = "proBusiness/get")
    public ServiceResponse<ProBusinessVo> get(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<ProBusinessVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProBusiness proBusiness = proBusinessService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProBusinessVo proBusinessVo = new ProBusinessVo();
              BeanUtils.copyProperties(proBusiness,proBusinessVo);
              return proBusinessVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "商家信息表 ", value = "保存", source = "admin-app")
    @Authority(values = {"business_add"})
    @SentinelResource(value = "proBusiness/save")
    public ServiceResponse<ProBusinessVo> save(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<ProBusinessVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProBusiness proBusiness = proBusinessService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ProBusinessVo proBusinessVo = new ProBusinessVo();
              BeanUtils.copyProperties(proBusiness,proBusinessVo);
              return proBusinessVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "商家信息表 ", value = "批量删除", source = "admin-app")
    @Authority(values = {"business_del"})
    @SentinelResource(value = "proBusiness/idsDelete")
    @GlobalTransactional
    public ServiceResponse<List<ProBusiness>> idsDelete(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<List<ProBusiness>>()
          .beginTransaction()
          .run(serviceResponse -> {
              List<ProBusinessRequest> requests = new ArrayList<>();
              request.getIds().forEach(id -> {
                ProBusinessRequest newRequst = new ProBusinessRequest();
                newRequst.setBusinessId(id);
                newRequst.setIsDel(1);
                requests.add(newRequst);
              });

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proBusinessService
                  .batchUpdate(new ProParameter<>(requests))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "商家信息表 ", value = "删除", source = "admin-app")
    @Authority(values = {"business_del"})
    @SentinelResource(value = "proBusiness/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              request.setIsDel(1);
              return proBusinessService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "商家信息表 ", value = "修改", source = "admin-app")
    @Authority(values = {"business_update"})
    @SentinelResource(value = "proBusiness/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProBusinessRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proBusinessService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}

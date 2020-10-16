package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProProvinceService;
import com.nacos.system.dto.ProProvince;
import com.nacos.system.request.ProProvinceRequest;
import com.nacos.backstage.vo.ProProvinceVo;
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
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@RestController
@RequestMapping(value = "proProvince")
@Api(value = "ProProvinceController", description = "")
@SuppressWarnings("unchecked")
public class ProProvinceController {

    @Autowired
    IProProvinceService proProvinceService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @SentinelResource(value = "proProvince/getPageList")
    public ServiceResponse<List<ProProvinceVo>> getPageList(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<List<ProProvinceVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<List<ProProvince>> response = proProvinceService.getPageList(new ProParameter<>(request)
                .setRequestPage(request));

              // 获取调用服务状态
              response.checkState();

              // 获取返回的分页信息
              response.copyPage(serviceResponse);

              // 获取服务返回的结果
              List<ProProvince> resultList = response.getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProProvinceVo> returnList = resultList.stream()
                .map(proProvince -> {
                    ProProvinceVo proProvincevo = new ProProvinceVo();
                    BeanUtils.copyProperties(proProvince,proProvincevo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proProvincevo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @SentinelResource(value = "proProvince/get")
    public ServiceResponse<ProProvinceVo> get(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<ProProvinceVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<ProProvince> response = proProvinceService.get(new ProParameter<>(request));

              // 获取调用服务状态
              response.checkState();

              // 组装返回的vo
              ProProvince proProvince = response.getObj();
              ProProvinceVo proProvinceVo = new ProProvinceVo();
              BeanUtils.copyProperties(proProvince,proProvinceVo);
              return proProvinceVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proProvince/save")
    public ServiceResponse<ProProvinceVo> save(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<ProProvinceVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ServiceResponse<ProProvince> response = proProvinceService.get(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              response = proProvinceService.save(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 获取返回数据
              ProProvince proProvince = response.getObj();
              ProProvinceVo proProvinceVo = new ProProvinceVo();
              BeanUtils.copyProperties(proProvince,proProvinceVo);
              return proProvinceVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @SentinelResource(value = "proProvince/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proProvinceService.idsDelete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @SentinelResource(value = "proProvince/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proProvinceService.delete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @SentinelResource(value = "proProvince/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProProvinceRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proProvinceService.update(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }
}

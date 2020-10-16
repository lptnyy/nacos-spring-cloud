package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProCityService;
import com.nacos.system.dto.ProCity;
import com.nacos.system.request.ProCityRequest;
import com.nacos.backstage.vo.ProCityVo;
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
@RequestMapping(value = "proCity")
@Api(value = "ProCityController", description = "")
@SuppressWarnings("unchecked")
public class ProCityController {

    @Autowired
    IProCityService proCityService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @SentinelResource(value = "proCity/getPageList")
    public ServiceResponse<List<ProCityVo>> getPageList(@RequestBody ProCityRequest request) {
      return new ServiceResponse<List<ProCityVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<List<ProCity>> response = proCityService.getPageList(new ProParameter<>(request)
                .setRequestPage(request));

              // 获取调用服务状态
              response.checkState();

              // 获取返回的分页信息
              response.copyPage(serviceResponse);

              // 获取服务返回的结果
              List<ProCity> resultList = response.getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProCityVo> returnList = resultList.stream()
                .map(proCity -> {
                    ProCityVo proCityvo = new ProCityVo();
                    BeanUtils.copyProperties(proCity,proCityvo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proCityvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @SentinelResource(value = "proCity/get")
    public ServiceResponse<ProCityVo> get(@RequestBody ProCityRequest request) {
      return new ServiceResponse<ProCityVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<ProCity> response = proCityService.get(new ProParameter<>(request));

              // 获取调用服务状态
              response.checkState();

              // 组装返回的vo
              ProCity proCity = response.getObj();
              ProCityVo proCityVo = new ProCityVo();
              BeanUtils.copyProperties(proCity,proCityVo);
              return proCityVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proCity/save")
    public ServiceResponse<ProCityVo> save(@RequestBody ProCityRequest request) {
      return new ServiceResponse<ProCityVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ServiceResponse<ProCity> response = proCityService.get(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              response = proCityService.save(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 获取返回数据
              ProCity proCity = response.getObj();
              ProCityVo proCityVo = new ProCityVo();
              BeanUtils.copyProperties(proCity,proCityVo);
              return proCityVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @SentinelResource(value = "proCity/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProCityRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proCityService.idsDelete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @SentinelResource(value = "proCity/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProCityRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proCityService.delete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @SentinelResource(value = "proCity/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProCityRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proCityService.update(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }
}

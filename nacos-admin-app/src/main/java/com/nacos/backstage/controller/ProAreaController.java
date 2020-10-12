package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProAreaService;
import com.nacos.system.dto.ProArea;
import com.nacos.system.request.ProAreaRequest;
import com.nacos.backstage.vo.ProAreaVo;
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
@RequestMapping(value = "proArea")
@Api(value = "ProAreaController", description = "")
@SuppressWarnings("unchecked")
public class ProAreaController {

    @Autowired
    IProAreaService proAreaService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @SentinelResource(value = "proArea/getPageList")
    public ServiceResponse<List<ProAreaVo>> getPageList(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<List<ProAreaVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<List<ProArea>> response = proAreaService.getPageList(new ProParameter<>(request)
                .setRequestPage(request));

              // 获取调用服务状态
              response.checkState();

              // 获取返回的分页信息
              response.copyPage(serviceResponse);

              // 获取服务返回的结果
              List<ProArea> resultList = response.getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProAreaVo> returnList = resultList.stream()
                .map(proArea -> {
                    ProAreaVo proAreavo = new ProAreaVo();
                    BeanUtils.copyProperties(proArea,proAreavo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proAreavo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @SentinelResource(value = "proArea/get")
    public ServiceResponse<ProAreaVo> get(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<ProAreaVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<ProArea> response = proAreaService.get(new ProParameter<>(request));

              // 获取调用服务状态
              response.checkState();

              // 组装返回的vo
              ProArea proArea = response.getObj();
              ProAreaVo proAreaVo = new ProAreaVo();
              BeanUtils.copyProperties(proArea,proAreaVo);
              return proAreaVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proArea/save")
    public ServiceResponse<ProAreaVo> save(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<ProAreaVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ServiceResponse<ProArea> response = proAreaService.get(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              response = proAreaService.save(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 获取返回数据
              ProArea proArea = response.getObj();
              ProAreaVo proAreaVo = new ProAreaVo();
              BeanUtils.copyProperties(proArea,proAreaVo);
              return proAreaVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @SentinelResource(value = "proArea/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proAreaService.idsDelete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @SentinelResource(value = "proArea/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proAreaService.delete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @SentinelResource(value = "proArea/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProAreaRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proAreaService.update(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }
}

package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProSchoolService;
import com.nacos.system.dto.ProSchool;
import com.nacos.system.request.ProSchoolRequest;
import com.nacos.backstage.vo.ProSchoolVo;
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
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@RestController
@RequestMapping(value = "proSchool")
@Api(value = "ProSchoolController", description = "")
@SuppressWarnings("unchecked")
public class ProSchoolController {

    @Autowired
    IProSchoolService proSchoolService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @SentinelResource(value = "proSchool/getPageList")
    public ServiceResponse<List<ProSchoolVo>> getPageList(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<List<ProSchoolVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<List<ProSchool>> response = proSchoolService.getPageList(new ProParameter<>(request)
                .setRequestPage(request));

              // 获取调用服务状态
              response.checkState();

              // 获取返回的分页信息
              response.copyPage(serviceResponse);

              // 获取服务返回的结果
              List<ProSchool> resultList = response.getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProSchoolVo> returnList = resultList.stream()
                .map(proSchool -> {
                    ProSchoolVo proSchoolvo = new ProSchoolVo();
                    BeanUtils.copyProperties(proSchool,proSchoolvo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proSchoolvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @SentinelResource(value = "proSchool/get")
    public ServiceResponse<ProSchoolVo> get(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<ProSchoolVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<ProSchool> response = proSchoolService.get(new ProParameter<>(request));

              // 获取调用服务状态
              response.checkState();

              // 组装返回的vo
              ProSchool proSchool = response.getObj();
              ProSchoolVo proSchoolVo = new ProSchoolVo();
              BeanUtils.copyProperties(proSchool,proSchoolVo);
              return proSchoolVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proSchool/save")
    public ServiceResponse<ProSchoolVo> save(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<ProSchoolVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ServiceResponse<ProSchool> response = proSchoolService.get(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              response = proSchoolService.save(new ProParameter<>(request));
              response.beginTransaction();
              response.checkState();

              // 获取返回数据
              ProSchool proSchool = response.getObj();
              ProSchoolVo proSchoolVo = new ProSchoolVo();
              BeanUtils.copyProperties(proSchool,proSchoolVo);
              return proSchoolVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @SentinelResource(value = "proSchool/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setSchoolId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proSchoolService.idsDelete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @SentinelResource(value = "proSchool/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proSchoolService.delete(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @SentinelResource(value = "proSchool/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProSchoolRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ServiceResponse<Integer> response = proSchoolService.update(new ProParameter<>(request));
              response.beginTransaction();

              // 获取调用服务状态
              response.checkState();

              return response.getObj();
          })
          .exec();
    }
}

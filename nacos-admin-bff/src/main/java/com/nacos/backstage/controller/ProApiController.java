package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.system.IProApiService;
import com.nacos.system.IProEnumService;
import com.nacos.system.dto.ProApi;
import com.nacos.system.request.ProApiRequest;
import com.nacos.backstage.vo.ProApiVo;
import com.nacos.system.request.ProEnumRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    * api管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@RestController
@RequestMapping(value = "proApi")
@Api(value = "ProApiController", description = "api管理")
@SuppressWarnings("unchecked")
public class ProApiController {

    @Autowired
    IProApiService proApiService;

    @Autowired
    IProEnumService proEnumService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "api管理", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"api_select"})
    @SentinelResource(value = "proApi/getPageList")
    public ServiceResponse<List<ProApiVo>> getPageList(@RequestBody ProApiRequest request) {
      return new ServiceResponse<List<ProApiVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<ProApi> resultList = proApiService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 获取枚举表状态信息
              ProEnumRequest proEnumRequest = new ProEnumRequest();
              proEnumRequest.setType("api_stat");
              Map<Integer, String> enums = new HashMap<>();
              proEnumService
                  .getList(new ProParameter<>(proEnumRequest))
                  .checkState()
                  .getObj()
                  .forEach(proEnum -> {
                    enums.put(Integer.valueOf(proEnum.getValuestr()), proEnum.getKeystr());
                  });

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProApiVo> returnList = resultList.stream()
                .map(proApi -> {
                    ProApiVo proApivo = new ProApiVo();
                    BeanUtils.copyProperties(proApi,proApivo);
                    proApivo.setStatStr(enums.get(proApi.getStat()));
                    proApivo.setCreateTime(DateUtil.getyyMMddHHmmss(proApi.getCreateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proApivo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "api管理", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"api_select"})
    @SentinelResource(value = "proApi/get")
    public ServiceResponse<ProApiVo> get(@RequestBody ProApiRequest request) {
      return new ServiceResponse<ProApiVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProApi proApi = proApiService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProApiVo proApiVo = new ProApiVo();
              BeanUtils.copyProperties(proApi,proApiVo);
              return proApiVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "api管理", value = "保存", source = "admin-app")
    @Authority(values = {"api_add"})
    @SentinelResource(value = "proApi/save")
    public ServiceResponse<ProApiVo> save(@RequestBody ProApiRequest request) {
      return new ServiceResponse<ProApiVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProApi proApi = proApiService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ProApiVo proApiVo = new ProApiVo();
              BeanUtils.copyProperties(proApi,proApiVo);
              return proApiVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "api管理", value = "批量删除", source = "admin-app")
    @Authority(values = {"api_del"})
    @SentinelResource(value = "proApi/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProApiRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setApiId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proApiService
                  .idsDelete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "api管理", value = "删除", source = "admin-app")
    @Authority(values = {"api_del"})
    @SentinelResource(value = "proApi/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProApiRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proApiService
                  .delete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "api管理", value = "修改", source = "admin-app")
    @Authority(values = {"api_update"})
    @SentinelResource(value = "proApi/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProApiRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proApiService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}

package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.backstage.vo.ProLogVo;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProLogService;
import com.nacos.system.dto.ProLog;
import com.nacos.system.request.ProLogRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-08
 */
@RestController
@RequestMapping(value = "proLog")
@Api(value = "ProLogController", description = "操作日志")
@SuppressWarnings("unchecked")
public class ProLogController {

    @Autowired
    IProLogService proLogService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @SentinelResource(value = "proLog/getPageList")
    public ServiceResponse<List<ProLogVo>> getPageList(@RequestBody ProLogRequest request) {
        return new ServiceResponse<List<ProLogVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProLog>> response = proLogService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProLog> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProLogVo> returnList = resultList.stream()
                            .map(proLog -> {
                                ProLogVo proLogvo = new ProLogVo();
                                BeanUtils.copyProperties(proLog,proLogvo);
                                proLogvo.setCreateTime(DateUtil.getyyMMddHHmmss(proLog.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proLogvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @SentinelResource(value = "proLog/get")
    public ServiceResponse<ProLogVo> get(@RequestBody ProLogRequest request) {
        return new ServiceResponse<ProLogVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProLog> response = proLogService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProLog proLog = response.getObj();
                    ProLogVo proLogVo = new ProLogVo();
                    BeanUtils.copyProperties(proLog,proLogVo);
                    return proLogVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    //@GlobalTransactional
    @SentinelResource(value = "proLog/save")
    @Log(name = "操作日志", value = "保存", source = "admin-app")
    public ServiceResponse<ProLogVo> save(@RequestBody ProLogRequest request) {
        return new ServiceResponse<ProLogVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProLog> response = proLogService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    response = proLogService.save(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 获取返回数据
                    ProLog proLog = response.getObj();
                    ProLogVo proLogVo = new ProLogVo();
                    BeanUtils.copyProperties(proLog,proLogVo);
                    return proLogVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    //@GlobalTransactional
    @SentinelResource(value = "proLog/idsDelete")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProLogRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setLogId(1);

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<Integer> response = proLogService.idsDelete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    //@GlobalTransactional
    @SentinelResource(value = "proLog/delete")
    public ServiceResponse<Integer> delete(@RequestBody ProLogRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<Integer> response = proLogService.delete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    //@GlobalTransactional
    @SentinelResource(value = "proLog/update")
    public ServiceResponse<Integer> update(@RequestBody ProLogRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<Integer> response = proLogService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}

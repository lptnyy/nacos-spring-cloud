package com.nacos.backstage.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.backstage.vo.ProEnumVo;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProEnumService;
import com.nacos.system.dto.ProEnum;
import com.nacos.system.request.ProEnumRequest;
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
    * 枚举表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@RestController
@RequestMapping(value = "proEnum")
@Api(value = "ProEnumController", description = "枚举表 ")
@SuppressWarnings("unchecked")
public class ProEnumController {

    @Autowired
    IProEnumService proEnumService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "枚举表", value = "分页查询列表", source = "admin-app")
    @SentinelResource(value = "proEnum/getPageList")
    public ServiceResponse<List<ProEnumVo>> getPageList(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<List<ProEnumVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProEnum>> response = proEnumService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProEnum> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProEnumVo> returnList = resultList.stream()
                            .map(proEnum -> {
                                ProEnumVo proEnumvo = new ProEnumVo();
                                BeanUtils.copyProperties(proEnum,proEnumvo);
                                proEnumvo.setCreateTime(DateUtil.getyyMMddHHmmss(proEnum.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proEnumvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "枚举表", value = "获取单条信息", source = "admin-app")
    @SentinelResource(value = "proEnum/get")
    public ServiceResponse<ProEnumVo> get(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<ProEnumVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProEnum> response = proEnumService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProEnum proEnum = response.getObj();
                    ProEnumVo proEnumVo = new ProEnumVo();
                    BeanUtils.copyProperties(proEnum,proEnumVo);
                    return proEnumVo;
                })
                .exec();
    }

    @PostMapping(value = "/getList")
    @ApiOperation(value = "获取列表")
    @Log(name = "枚举表", value = "获取列表", source = "admin-app")
    @SentinelResource(value = "proEnum/getList")
    public ServiceResponse<List<ProEnumVo> > getList(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<List<ProEnumVo> >()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProEnum>> response = proEnumService.getList(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取服务返回的结果
                    List<ProEnum> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProEnumVo> returnList = resultList.stream()
                            .map(proEnum -> {
                                ProEnumVo proEnumvo = new ProEnumVo();
                                BeanUtils.copyProperties(proEnum,proEnumvo);
                                proEnumvo.setCreateTime(DateUtil.getyyMMddHHmmss(proEnum.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proEnumvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    //@GlobalTransactional
    @SentinelResource(value = "proEnum/save")
    @Log(name = "枚举表", value = "保存", source = "admin-app")
    public ServiceResponse<ProEnumVo> save(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<ProEnumVo>()
                .run(serviceResponse -> {

                    // 获取返回结果 包括数据库插入id
                    ProEnum proEnum = proEnumService.save(new ProParameter<>(request))
                            .beginTransaction().checkState()
                            .getObj();
                    ProEnumVo proEnumVo = new ProEnumVo();
                    BeanUtils.copyProperties(proEnum,proEnumVo);
                    return proEnumVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    //@GlobalTransactional
    @SentinelResource(value = "proEnum/idsDelete")
    @Log(name = "枚举表", value = "批量删除", source = "admin-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setEnumId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proEnumService.idsDelete(new ProParameter<>(request));
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
    @SentinelResource(value = "proEnum/delete")
    @Log(name = "枚举表", value = "删除", source = "admin-app")
    public ServiceResponse<Integer> delete(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proEnumService.delete(new ProParameter<>(request));
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
    @SentinelResource(value = "proEnum/update")
    @Log(name = "枚举表", value = "修改", source = "admin-app")
    public ServiceResponse<Integer> update(@RequestBody ProEnumRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proEnumService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}

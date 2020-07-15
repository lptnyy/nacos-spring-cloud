package com.nacos.xiaoshuo.controller;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.xiaoshuo.IXiaoshuoNoveltypeService;
import com.nacos.xiaoshuo.dto.XiaoshuoNoveltype;
import com.nacos.xiaoshuo.request.XiaoshuoNoveltypeRequest;
import com.nacos.xiaoshuo.vo.XiaoshuoNoveltypeVo;
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
 * @since 2020-07-15
 */
@RestController
@RequestMapping(value = "xiaoshuoNoveltype")
@Api(value = "XiaoshuoNoveltypeController", description = "")
@SuppressWarnings("unchecked")
public class XiaoshuoNoveltypeController {

    @Autowired
    IXiaoshuoNoveltypeService xiaoshuoNoveltypeService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "", value = "分页查询列表", source = "xiaoshuo-app")
    public ServiceResponse<List<XiaoshuoNoveltypeVo>> getPageList(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<List<XiaoshuoNoveltypeVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<XiaoshuoNoveltype>> response = xiaoshuoNoveltypeService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<XiaoshuoNoveltype> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<XiaoshuoNoveltypeVo> returnList = resultList.stream()
                            .map(xiaoshuoNoveltype -> {
                                XiaoshuoNoveltypeVo xiaoshuoNoveltypevo = new XiaoshuoNoveltypeVo();
                                BeanUtils.copyProperties(xiaoshuoNoveltype,xiaoshuoNoveltypevo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return xiaoshuoNoveltypevo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "", value = "获取单条信息", source = "xiaoshuo-app")
    public ServiceResponse<XiaoshuoNoveltypeVo> get(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<XiaoshuoNoveltypeVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<XiaoshuoNoveltype> response = xiaoshuoNoveltypeService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    XiaoshuoNoveltype xiaoshuoNoveltype = response.getObj();
                    XiaoshuoNoveltypeVo xiaoshuoNoveltypeVo = new XiaoshuoNoveltypeVo();
                    BeanUtils.copyProperties(xiaoshuoNoveltype,xiaoshuoNoveltypeVo);
                    return xiaoshuoNoveltypeVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @Log(name = "", value = "保存", source = "xiaoshuo-app")
    public ServiceResponse<XiaoshuoNoveltypeVo> save(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<XiaoshuoNoveltypeVo>()
                .run(serviceResponse -> {

                    // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<XiaoshuoNoveltype> response = xiaoshuoNoveltypeService.get(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    response = xiaoshuoNoveltypeService.save(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 获取返回数据
                    XiaoshuoNoveltype xiaoshuoNoveltype = response.getObj();
                    XiaoshuoNoveltypeVo xiaoshuoNoveltypeVo = new XiaoshuoNoveltypeVo();
                    BeanUtils.copyProperties(xiaoshuoNoveltype,xiaoshuoNoveltypeVo);
                    return xiaoshuoNoveltypeVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "", value = "批量删除", source = "xiaoshuo-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = xiaoshuoNoveltypeService.idsDelete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "", value = "删除", source = "xiaoshuo-app")
    public ServiceResponse<Integer> delete(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = xiaoshuoNoveltypeService.delete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "", value = "修改", source = "xiaoshuo-app")
    public ServiceResponse<Integer> update(@RequestBody XiaoshuoNoveltypeRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = xiaoshuoNoveltypeService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}

package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.backstage.vo.ProResourceFileVo;
import com.nacos.common.annotation.Log;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.oss.IProResourceFileService;
import com.nacos.oss.dto.ProResourceFile;
import com.nacos.oss.request.ProResourceFileRequest;
import io.seata.spring.annotation.GlobalTransactional;
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
    * 系统资源文件表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@RestController
@RequestMapping(value = "proResourceFile")
@Api(value = "ProResourceFileController", description = "系统资源文件表 ")
@SuppressWarnings("unchecked")
public class ProResourceFileController {

    @Autowired
    IProResourceFileService proResourceFileService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "系统资源文件表", value = "分页查询列表", source = "admin-app")
    @SentinelResource(value = "proResourceFile/getPageList")
    public ServiceResponse<List<ProResourceFileVo>> getPageList(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<List<ProResourceFileVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProResourceFile>> response = proResourceFileService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProResourceFile> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProResourceFileVo> returnList = resultList.stream()
                            .map(proResourceFile -> {
                                ProResourceFileVo proResourceFilevo = new ProResourceFileVo();
                                BeanUtils.copyProperties(proResourceFile,proResourceFilevo);
                                proResourceFilevo.setUploadTime(DateUtil.getyyMMddHHmmss(proResourceFile.getUploadTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proResourceFilevo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "系统资源文件表", value = "获取单条信息", source = "admin-app")
    @SentinelResource(value = "proResourceFile/get")
    public ServiceResponse<ProResourceFileVo> get(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<ProResourceFileVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProResourceFile> response = proResourceFileService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProResourceFile proResourceFile = response.getObj();
                    ProResourceFileVo proResourceFileVo = new ProResourceFileVo();
                    BeanUtils.copyProperties(proResourceFile,proResourceFileVo);
                    return proResourceFileVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proResourceFile/save")
    @Log(name = "系统资源文件表", value = "保存", source = "admin-app")
    public ServiceResponse<ProResourceFileVo> save(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<ProResourceFileVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProResourceFile> response = proResourceFileService.get(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回结果 包括数据库插入id
                    ProResourceFile proResourceFile = proResourceFileService.save(new ProParameter<>(request))
                            .beginTransaction()
                            .checkState()
                            .getObj();

                    ProResourceFileVo proResourceFileVo = new ProResourceFileVo();
                    BeanUtils.copyProperties(proResourceFile,proResourceFileVo);
                    return proResourceFileVo;
                })
                .exec();
    }

    @PostMapping(value = "/saveBatch")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @SentinelResource(value = "proResourceFile/saveBatch")
    @Log(name = "系统资源文件表", value = "保存", source = "admin-app")
    public ServiceResponse<List<ProResourceFile>> saveBatch(@RequestBody List<ProResourceFileRequest> request) {
        return new ServiceResponse<List<ProResourceFile>>()
                .run(serviceResponse -> {

                    // 获取返回结果 包括数据库插入id
                    List<ProResourceFile> proResourceFiles = proResourceFileService.batchSave(new ProParameter<>(request))
                            .beginTransaction()
                            .checkState()
                            .getObj();
                    return proResourceFiles;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @GlobalTransactional
    @SentinelResource(value = "proResourceFile/idsDelete")
    @Log(name = "系统资源文件表", value = "批量删除", source = "admin-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过fileId批量删除
                    request.setFileId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proResourceFileService.idsDelete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @GlobalTransactional
    @SentinelResource(value = "proResourceFile/delete")
    @Log(name = "系统资源文件表", value = "删除", source = "admin-app")
    public ServiceResponse<Integer> delete(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proResourceFileService.delete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @GlobalTransactional
    @SentinelResource(value = "proResourceFile/update")
    @Log(name = "系统资源文件表", value = "修改", source = "admin-app")
    public ServiceResponse<Integer> update(@RequestBody ProResourceFileRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proResourceFileService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}

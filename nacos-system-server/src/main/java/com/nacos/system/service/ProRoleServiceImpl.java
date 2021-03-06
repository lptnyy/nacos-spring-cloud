package com.nacos.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProRoleService;
import com.nacos.system.dto.ProRole;
import com.nacos.system.mapper.ProRoleMapper;
import com.nacos.system.request.ProRoleRequest;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 系统角色表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@RestController
@Api(value = "ProRoleServiceImpl", description = "系统角色表 ")
@SuppressWarnings("unchecked")
public class ProRoleServiceImpl implements IProRoleService {

    @Resource
    ProRoleMapper mapper;

    @Override
    public ServiceResponse<ProRole> get(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<ProRole>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleRequest request = proParameter.getObj();
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRole::getRoleId,request.getRoleId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProRole::getName,request.getName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRole::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRole>> getList(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRole>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleRequest request = proParameter.getObj();
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRole::getRoleId,request.getRoleId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProRole::getName,request.getName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRole::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRole>> getPageList(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRole>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleRequest request = proParameter.getObj();
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRole::getRoleId,request.getRoleId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProRole::getName,request.getName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRole::getCreateTime);
                    Page<ProRole> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProRole> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProRole>> findIdsList(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRole>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRole> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.orderByDesc(ProRole::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProRole bean = new ProRole();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProRole> save(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<ProRole>()
                .run(serviceResponse -> {
                    ProRole bean = new ProRole();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProRole>> batchSave(ProParameter<List<ProRoleRequest>> proParameter) throws Exception {
        return new ServiceResponse<List<ProRole>>()
                .run(serviceResponse -> {
                    List<ProRole> roles = proParameter.getObj()
                            .stream()
                            .map(proRoleRequest -> {
                                ProRole proRole = new ProRole();
                                BeanUtils.copyProperties(proRoleRequest, proRole);
                                mapper.insert(proRole);
                                return proRole;
                            }).collect(Collectors.toList());
                    return roles;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleRequest request = proParameter.getObj();
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRole::getRoleId,request.getRoleId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProRole::getName,request.getName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRole::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProRoleRequest request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}

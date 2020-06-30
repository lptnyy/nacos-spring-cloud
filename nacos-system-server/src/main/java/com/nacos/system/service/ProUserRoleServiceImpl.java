package com.nacos.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProUserRoleService;
import com.nacos.system.dto.ProUserRole;
import com.nacos.system.mapper.ProUserRoleMapper;
import com.nacos.system.request.ProUserRoleRequest;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 用户角色关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@RestController
@Api(value = "ProUserRoleServiceImpl", description = "用户角色关系表 ")
@SuppressWarnings("unchecked")
public class ProUserRoleServiceImpl implements IProUserRoleService {

    @Resource
    ProUserRoleMapper mapper;

    @Override
    public ServiceResponse<ProUserRole> get(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<ProUserRole>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProUserRoleRequest request = proParameter.getObj();
                    if(request.getUrId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUrId,request.getUrId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getRoleId,request.getRoleId());
                    }
                    if(request.getUserId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUserId,request.getUserId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProUserRole::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUserRole>> getList(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProUserRole>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProUserRoleRequest request = proParameter.getObj();
                    if(request.getUrId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUrId,request.getUrId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getRoleId,request.getRoleId());
                    }
                    if(request.getUserId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUserId,request.getUserId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProUserRole::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUserRole>> getPageList(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProUserRole>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProUserRoleRequest request = proParameter.getObj();
                    if(request.getUrId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUrId,request.getUrId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getRoleId,request.getRoleId());
                    }
                    if(request.getUserId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUserId,request.getUserId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProUserRole::getCreateTime);
                    Page<ProUserRole> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProUserRole> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProUserRole>> findIdsList(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProUserRole>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProUserRole> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.in(ProUserRole::getUserId,proParameter.getObj().getIds());
                    queryWrapper.orderByDesc(ProUserRole::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> update(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProUserRole bean = new ProUserRole();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<ProUserRole> save(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<ProUserRole>()
                .run(serviceResponse -> {
                    ProUserRole bean = new ProUserRole();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<List<ProUserRole>> batchSave(ProParameter<List<ProUserRoleRequest>> proParameter) throws Exception {
       return new ServiceResponse<List<ProUserRole>>()
               .run(serviceResponse -> {
                   List<ProUserRole> roles = proParameter.getObj()
                       .stream()
                       .map(proUserRoleRequest -> {
                            ProUserRole proUserRole = new ProUserRole();
                            BeanUtils.copyProperties(proUserRoleRequest, proUserRole);
                            mapper.insert(proUserRole);
                            return proUserRole;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> delete(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProUserRoleRequest request = proParameter.getObj();
                    if(request.getUrId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUrId,request.getUrId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getRoleId,request.getRoleId());
                    }
                    if(request.getUserId() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getUserId,request.getUserId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProUserRole::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProUserRoleRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProUserRoleRequest request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}

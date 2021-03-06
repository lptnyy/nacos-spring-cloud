package com.nacos.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProRoleMenuService;
import com.nacos.system.dto.ProRoleMenu;
import com.nacos.system.mapper.ProRoleMenuMapper;
import com.nacos.system.request.ProRoleMenuRequest;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-04
 */
@RestController
@Api(value = "ProRoleMenuServiceImpl", description = "角色菜单关系表")
@SuppressWarnings("unchecked")
public class ProRoleMenuServiceImpl implements IProRoleMenuService {

    @Resource
    ProRoleMenuMapper mapper;

    @Override
    public ServiceResponse<ProRoleMenu> get(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<ProRoleMenu>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> getList(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> getPageList(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    Page<ProRoleMenu> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProRoleMenu> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> findIdsList(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        queryWrapper.in(ProRoleMenu::getRmId,request.getIds());
                    }
                    if(request.getRoleId() != null){
                        queryWrapper.in(ProRoleMenu::getRoleId,request.getIds());
                    }
                    if(request.getMenuId() != null){
                        queryWrapper.in(ProRoleMenu::getMenuId,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProRoleMenu::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProRoleMenu bean = new ProRoleMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProRoleMenu> save(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<ProRoleMenu>()
                .run(serviceResponse -> {
                    ProRoleMenu bean = new ProRoleMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> batchSave(ProParameter<List<ProRoleMenuRequest>> proParameter) throws Exception {
       return new ServiceResponse<Integer>()
               .run(serviceResponse -> {
                   List<ProRoleMenuRequest> roles = proParameter.getObj();
                   List<ProRoleMenu> proRoleMenus = new ArrayList<>();
                   for(ProRoleMenuRequest proRoleMenuRequest: roles) {
                       ProRoleMenu proRoleMenu = new ProRoleMenu();
                       BeanUtils.copyProperties(proRoleMenuRequest, proRoleMenu);
                       proRoleMenus.add(proRoleMenu);
                       this.mapper.insert(proRoleMenu);
                   }
                   return proRoleMenus.size();
               }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProRoleMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
                     ProRoleMenuRequest request = proParameter.getObj();
                     if(request.getRmId() != null){
                         queryWrapper.in(ProRoleMenu::getRmId,request.getIds());
                     }
                     if(request.getRoleId() != null){
                         queryWrapper.in(ProRoleMenu::getRoleId,request.getIds());
                     }
                     if(request.getMenuId() != null){
                         queryWrapper.in(ProRoleMenu::getMenuId,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                         queryWrapper.in(ProRoleMenu::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}

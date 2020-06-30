package com.nacos.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.UserService;
import com.nacos.system.dto.ProUser;
import com.nacos.system.mapper.ProUserMapper;
import com.nacos.system.request.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户接口")
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {

    @Resource
    ProUserMapper proUserMapper;

    @Override
    @ApiOperation(value = "获取用户信息", notes = "通过属性查询相对应的数据")
    public ServiceResponse<ProUser> userNameGetUser(ProParameter<User> proParameter) throws Exception {
       return new ServiceResponse<ProUser>()
                .run((serviceResponse) -> {
                    return proUserMapper.selectOne(
                            new LambdaQueryWrapper<ProUser>()
                                    .eq(ProUser::getUserName,proParameter.getObj().getUserName()));
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> getList(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<List<ProUser>>()
                .run((serviceResponse) -> {
                    return proUserMapper.selectList(
                            new LambdaQueryWrapper<ProUser>()
                                    .eq(ProUser::getUserName,proParameter.getObj()));
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> getPageList(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<List<ProUser>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProUser> queryWrapper = new LambdaQueryWrapper<>();
                    if(StringUtils.isNotEmpty(proParameter.getObj().getUserName())){
                        queryWrapper.eq(ProUser::getUserName,proParameter.getObj().getUserName());
                    }
                    Page<ProUser> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProUser> pageResult = proUserMapper.selectPage(page, queryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                           .setPageSize(proParameter.getRequestPage().getPageSize())
                           .setCount(pageResult.getTotal())
                           .setPages(pageResult.getPages());
                   return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> findIdsList(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<List<ProUser>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProUser> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.in(ProUser::getUserId, proParameter.getObj().getIds());
                    return proUserMapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> update(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProUser proUser = new ProUser();
                    BeanUtils.copyProperties(proParameter.getObj(),proUser);
                    LambdaQueryWrapper<ProUser> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(ProUser::getUserId,proParameter.getObj().getUserId());
                    return proUserMapper.update(proUser,queryWrapper);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> save(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProUser proUser = new ProUser();
                    BeanUtils.copyProperties(proParameter.getObj(),proUser);
                    return proUserMapper.insert(proUser);
                }).exec();
    }

    @Override
    //@GlobalTransactional
    public ServiceResponse<Integer> delete(ProParameter<User> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProUser> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(ProUser::getUserId,proParameter.getObj().getUserId());
                    return proUserMapper.delete(queryWrapper);
                }).exec();
    }
}

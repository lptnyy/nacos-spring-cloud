package com.nacos.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import io.seata.core.context.RootContext;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.nacos.system.dto.ProApp;
import com.nacos.system.request.ProAppRequest;
import com.nacos.system.IProAppService;
import com.nacos.system.mapper.ProAppMapper;

/**
 * <p>
    * 应用管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-19
 */
@RestController
@Api(value = "ProAppServiceImpl", description = "应用管理")
@SuppressWarnings("unchecked")
public class ProAppServiceImpl implements IProAppService {

    @Resource
    ProAppMapper mapper;

    @Override
    public ServiceResponse<ProApp> get(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<ProApp>()
          .run((serviceResponse) -> {
             LambdaQueryWrapper<ProApp> lambdaQueryWrapper = new LambdaQueryWrapper<>();
             ProAppRequest request = proParameter.getObj();
             if(request.getId() != null){
               lambdaQueryWrapper.eq(ProApp::getId,request.getId());
             }
             if(!StringUtils.isEmpty(request.getName())){
               lambdaQueryWrapper.eq(ProApp::getName,request.getName());
             }
             if(!StringUtils.isEmpty(request.getAppKey())){
               lambdaQueryWrapper.eq(ProApp::getAppKey,request.getAppKey());
             }
             if(!StringUtils.isEmpty(request.getAppSecret())){
               lambdaQueryWrapper.eq(ProApp::getAppSecret,request.getAppSecret());
             }
             if(request.getStat() != null){
               lambdaQueryWrapper.eq(ProApp::getStat,request.getStat());
             }
             if(request.getCreateTime() != null){
               lambdaQueryWrapper.eq(ProApp::getCreateTime,request.getCreateTime());
             }
             return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProApp>> getList(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<List<ProApp>>()
          .run((serviceResponse) -> {
             LambdaQueryWrapper<ProApp> lambdaQueryWrapper = new LambdaQueryWrapper<>();
             ProAppRequest request = proParameter.getObj();
             if(request.getId() != null){
               lambdaQueryWrapper.eq(ProApp::getId,request.getId());
             }
             if(!StringUtils.isEmpty(request.getName())){
               lambdaQueryWrapper.like(ProApp::getName,request.getName());
             }
             if(!StringUtils.isEmpty(request.getAppKey())){
               lambdaQueryWrapper.like(ProApp::getAppKey,request.getAppKey());
             }
             if(!StringUtils.isEmpty(request.getAppSecret())){
               lambdaQueryWrapper.eq(ProApp::getAppSecret,request.getAppSecret());
             }
             if(request.getStat() != null){
               lambdaQueryWrapper.eq(ProApp::getStat,request.getStat());
             }
             if(request.getCreateTime() != null){
               lambdaQueryWrapper.eq(ProApp::getCreateTime,request.getCreateTime());
             }
             lambdaQueryWrapper.orderByDesc(ProApp::getCreateTime);
             return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProApp>> getPageList(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<List<ProApp>>()
          .run((serviceResponse -> {
             LambdaQueryWrapper<ProApp> lambdaQueryWrapper = new LambdaQueryWrapper<>();
             ProAppRequest request = proParameter.getObj();
             if(request.getId() != null){
               lambdaQueryWrapper.eq(ProApp::getId,request.getId());
             }
             if(!StringUtils.isEmpty(request.getName())){
               lambdaQueryWrapper.like(ProApp::getName,request.getName());
             }
             if(!StringUtils.isEmpty(request.getAppKey())){
               lambdaQueryWrapper.like(ProApp::getAppKey,request.getAppKey());
             }
             if(!StringUtils.isEmpty(request.getAppSecret())){
               lambdaQueryWrapper.eq(ProApp::getAppSecret,request.getAppSecret());
             }
             if(request.getStat() != null){
               lambdaQueryWrapper.eq(ProApp::getStat,request.getStat());
             }
             if(request.getCreateTime() != null){
               lambdaQueryWrapper.eq(ProApp::getCreateTime,request.getCreateTime());
             }
             lambdaQueryWrapper.orderByDesc(ProApp::getCreateTime);
             Page<ProApp> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
             IPage<ProApp> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
             serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                .setPageSize(proParameter.getRequestPage().getPageSize())
                .setCount(pageResult.getTotal())
                .setPages(pageResult.getPages());
             return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProApp>> findIdsList(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<List<ProApp>>()
        .run(serviceResponse -> {
           LambdaQueryWrapper<ProApp> queryWrapper = new LambdaQueryWrapper<>();
           ProAppRequest request = proParameter.getObj();
           if(request.getId() != null){
             queryWrapper.in(ProApp::getId,request.getIds());
           }
           if(!StringUtils.isEmpty(request.getName())){
             queryWrapper.in(ProApp::getName,request.getIds());
           }
           if(!StringUtils.isEmpty(request.getAppKey())){
             queryWrapper.in(ProApp::getAppKey,request.getIds());
           }
           if(!StringUtils.isEmpty(request.getAppSecret())){
             queryWrapper.in(ProApp::getAppSecret,request.getIds());
           }
           if(request.getStat() != null){
             queryWrapper.in(ProApp::getStat,request.getIds());
           }
           if(request.getCreateTime() != null){
             queryWrapper.in(ProApp::getCreateTime,request.getIds());
           }
           queryWrapper.orderByDesc(ProApp::getCreateTime);
           return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<Integer>()
              .beginTransaction()
          .run(serviceResponse -> {
             ProApp bean = new ProApp();
             BeanUtils.copyProperties(proParameter.getObj(),bean);
             return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProApp> save(ProParameter<ProAppRequest> proParameter) {
        return new ServiceResponse<ProApp>()
                .beginTransaction()
            .run(serviceResponse -> {
               ProApp bean = new ProApp();
               BeanUtils.copyProperties(proParameter.getObj(),bean);
               mapper.insert(bean);
               return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProApp>> batchSave(ProParameter<List<ProAppRequest>> proParameter) {
       return new ServiceResponse<List<ProApp>>()
               .beginTransaction()
            .run(serviceResponse -> {
                List<ProApp> roles = proParameter.getObj()
                  .stream()
                  .map(proAppRequest -> {
                     ProApp proApp = new ProApp();
                     BeanUtils.copyProperties(proAppRequest, proApp);
                     mapper.insert(proApp);
                     return proApp;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<Integer>()
              .beginTransaction()
          .run(serviceResponse -> {
             LambdaQueryWrapper<ProApp> lambdaQueryWrapper = new LambdaQueryWrapper<>();
             ProAppRequest request = proParameter.getObj();
             if(request.getId() != null){
               lambdaQueryWrapper.eq(ProApp::getId,request.getId());
             }
             if(!StringUtils.isEmpty(request.getName())){
               lambdaQueryWrapper.eq(ProApp::getName,request.getName());
             }
             if(!StringUtils.isEmpty(request.getAppKey())){
               lambdaQueryWrapper.eq(ProApp::getAppKey,request.getAppKey());
             }
             if(!StringUtils.isEmpty(request.getAppSecret())){
               lambdaQueryWrapper.eq(ProApp::getAppSecret,request.getAppSecret());
             }
             if(request.getStat() != null){
               lambdaQueryWrapper.eq(ProApp::getStat,request.getStat());
             }
             if(request.getCreateTime() != null){
               lambdaQueryWrapper.eq(ProApp::getCreateTime,request.getCreateTime());
             }
             return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProAppRequest> proParameter) {
      return new ServiceResponse<Integer>()
              .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProApp> queryWrapper = new LambdaQueryWrapper<>();
              ProAppRequest request = proParameter.getObj();
              if(request.getId() != null){
                 queryWrapper.in(ProApp::getId,request.getIds());
              }
              if(!StringUtils.isEmpty(request.getName())){
                 queryWrapper.in(ProApp::getName,request.getIds());
              }
              if(!StringUtils.isEmpty(request.getAppKey())){
                 queryWrapper.in(ProApp::getAppKey,request.getIds());
              }
              if(!StringUtils.isEmpty(request.getAppSecret())){
                 queryWrapper.in(ProApp::getAppSecret,request.getIds());
              }
              if(request.getStat() != null){
                 queryWrapper.in(ProApp::getStat,request.getIds());
              }
              if(request.getCreateTime() != null){
                 queryWrapper.in(ProApp::getCreateTime,request.getIds());
              }
             return mapper.delete(queryWrapper);
          }).exec();
    }
}

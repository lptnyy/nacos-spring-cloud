package com.nacos.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.nacos.system.dto.ProApi;
import com.nacos.system.request.ProApiRequest;
import com.nacos.system.IProApiService;
import com.nacos.system.mapper.ProApiMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * api管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@RestController
@Api(value = "ProApiServiceImpl", description = "api管理")
@SuppressWarnings("unchecked")
public class ProApiServiceImpl implements IProApiService {

    @Resource
    ProApiMapper mapper;

    @Override
    public ServiceResponse<ProApi> get(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<ProApi>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProApi> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProApiRequest request = proParameter.getObj();
              if(request.getApiId() != null){
                lambdaQueryWrapper.eq(ProApi::getApiId,request.getApiId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProApi::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getNameAs())){
                lambdaQueryWrapper.eq(ProApi::getNameAs,request.getNameAs());
              }
              if(!StringUtils.isEmpty(request.getApi())){
                lambdaQueryWrapper.eq(ProApi::getApi,request.getApi());
              }
              if(request.getStat() != null){
                lambdaQueryWrapper.eq(ProApi::getStat,request.getStat());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProApi::getCreateTime,request.getCreateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProApi>> getList(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<List<ProApi>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProApi> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProApiRequest request = proParameter.getObj();
              if(request.getApiId() != null){
                lambdaQueryWrapper.eq(ProApi::getApiId,request.getApiId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProApi::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getNameAs())){
                lambdaQueryWrapper.like(ProApi::getNameAs,request.getNameAs());
              }
              if(!StringUtils.isEmpty(request.getApi())){
                lambdaQueryWrapper.eq(ProApi::getApi,request.getApi());
              }
              if(request.getStat() != null){
                lambdaQueryWrapper.eq(ProApi::getStat,request.getStat());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProApi::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProApi::getCreateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProApi>> getPageList(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<List<ProApi>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProApi> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProApiRequest request = proParameter.getObj();
              if(request.getApiId() != null){
                lambdaQueryWrapper.eq(ProApi::getApiId,request.getApiId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProApi::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getNameAs())){
                lambdaQueryWrapper.like(ProApi::getNameAs,request.getNameAs());
              }
              if(!StringUtils.isEmpty(request.getApi())){
                lambdaQueryWrapper.eq(ProApi::getApi,request.getApi());
              }
              if(request.getStat() != null){
                lambdaQueryWrapper.eq(ProApi::getStat,request.getStat());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProApi::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProApi::getCreateTime);
              Page<ProApi> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProApi> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProApi>> findIdsList(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<List<ProApi>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProApi> queryWrapper = new LambdaQueryWrapper<>();
            ProApiRequest request = proParameter.getObj();
            if(request.getApiId() != null){
               queryWrapper.in(ProApi::getApiId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProApi::getName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getNameAs())){
               queryWrapper.in(ProApi::getNameAs,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getApi())){
               queryWrapper.in(ProApi::getApi,request.getIds());
            }
            if(request.getStat() != null){
               queryWrapper.in(ProApi::getStat,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProApi::getCreateTime,request.getIds());
            }
            queryWrapper.orderByDesc(ProApi::getCreateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProApi bean = new ProApi();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProApi> save(ProParameter<ProApiRequest> proParameter) {
        return new ServiceResponse<ProApi>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProApi bean = new ProApi();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProApi>> batchSave(ProParameter<List<ProApiRequest>> proParameter) {
       return new ServiceResponse<List<ProApi>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProApi> roles = proParameter.getObj()
                   .stream()
                   .map(proApiRequest -> {
                       ProApi proApi = new ProApi();
                       BeanUtils.copyProperties(proApiRequest, proApi);
                       mapper.insert(proApi);
                       return proApi;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProApi> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProApiRequest request = proParameter.getObj();
              if(request.getApiId() != null){
                lambdaQueryWrapper.eq(ProApi::getApiId,request.getApiId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProApi::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getNameAs())){
                lambdaQueryWrapper.eq(ProApi::getNameAs,request.getNameAs());
              }
              if(!StringUtils.isEmpty(request.getApi())){
                lambdaQueryWrapper.eq(ProApi::getApi,request.getApi());
              }
              if(request.getStat() != null){
                lambdaQueryWrapper.eq(ProApi::getStat,request.getStat());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProApi::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProApiRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProApi> queryWrapper = new LambdaQueryWrapper<>();
               ProApiRequest request = proParameter.getObj();
               if(request.getApiId() != null){
                  queryWrapper.in(ProApi::getApiId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProApi::getName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getNameAs())){
                  queryWrapper.in(ProApi::getNameAs,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getApi())){
                  queryWrapper.in(ProApi::getApi,request.getIds());
               }
               if(request.getStat() != null){
                  queryWrapper.in(ProApi::getStat,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProApi::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

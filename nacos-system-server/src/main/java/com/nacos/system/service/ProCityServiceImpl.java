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
import com.nacos.system.dto.ProCity;
import com.nacos.system.request.ProCityRequest;
import com.nacos.system.IProCityService;
import com.nacos.system.mapper.ProCityMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@RestController
@Api(value = "ProCityServiceImpl", description = "")
@SuppressWarnings("unchecked")
public class ProCityServiceImpl implements IProCityService {

    @Resource
    ProCityMapper mapper;

    @Override
    public ServiceResponse<ProCity> get(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<ProCity>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProCity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProCityRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProCity::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProCity::getCityId,request.getCityId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProCity::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProCity::getProvince,request.getProvince());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProCity>> getList(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<List<ProCity>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProCity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProCityRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProCity::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProCity::getCityId,request.getCityId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProCity::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProCity::getProvince,request.getProvince());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProCity>> getPageList(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<List<ProCity>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProCity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProCityRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProCity::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProCity::getCityId,request.getCityId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProCity::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProCity::getProvince,request.getProvince());
              }
              Page<ProCity> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProCity> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProCity>> findIdsList(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<List<ProCity>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProCity> queryWrapper = new LambdaQueryWrapper<>();
            ProCityRequest request = proParameter.getObj();
            if(request.getId() != null){
               queryWrapper.in(ProCity::getId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getCityId())){
               queryWrapper.in(ProCity::getCityId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProCity::getName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getProvince())){
               queryWrapper.in(ProCity::getProvince,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProCity bean = new ProCity();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProCity> save(ProParameter<ProCityRequest> proParameter) {
        return new ServiceResponse<ProCity>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProCity bean = new ProCity();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProCity>> batchSave(ProParameter<List<ProCityRequest>> proParameter) {
       return new ServiceResponse<List<ProCity>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProCity> roles = proParameter.getObj()
                   .stream()
                   .map(proCityRequest -> {
                       ProCity proCity = new ProCity();
                       BeanUtils.copyProperties(proCityRequest, proCity);
                       mapper.insert(proCity);
                       return proCity;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProCity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProCityRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProCity::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProCity::getCityId,request.getCityId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProCity::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProCity::getProvince,request.getProvince());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProCityRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProCity> queryWrapper = new LambdaQueryWrapper<>();
               ProCityRequest request = proParameter.getObj();
               if(request.getId() != null){
                  queryWrapper.in(ProCity::getId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getCityId())){
                  queryWrapper.in(ProCity::getCityId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProCity::getName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getProvince())){
                  queryWrapper.in(ProCity::getProvince,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

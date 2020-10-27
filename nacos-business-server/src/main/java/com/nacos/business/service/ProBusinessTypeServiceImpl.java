package com.nacos.business.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.nacos.business.dto.ProBusinessType;
import com.nacos.business.request.ProBusinessTypeRequest;
import com.nacos.business.IProBusinessTypeService;
import com.nacos.business.mapper.ProBusinessTypeMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 商家类型
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@RestController
@Api(value = "ProBusinessTypeServiceImpl", description = "商家类型 ")
@SuppressWarnings("unchecked")
public class ProBusinessTypeServiceImpl implements IProBusinessTypeService {

    @Resource
    ProBusinessTypeMapper mapper;

    @Override
    public ServiceResponse<ProBusinessType> get(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<ProBusinessType>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProBusinessType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProBusinessType::getName,request.getName());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getCreateTime,request.getCreateTime());
              }
              if(request.getIsDel() != null) {
                lambdaQueryWrapper.eq(ProBusinessType::getIsDel,request.getIsDel());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProBusinessType>> getList(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<List<ProBusinessType>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProBusinessType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProBusinessType::getName,request.getName());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getCreateTime,request.getCreateTime());
              }
              if(request.getIsDel() != null) {
                lambdaQueryWrapper.eq(ProBusinessType::getIsDel,request.getIsDel());
              }
              lambdaQueryWrapper.orderByDesc(ProBusinessType::getCreateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProBusinessType>> getPageList(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<List<ProBusinessType>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProBusinessType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProBusinessType::getName,request.getName());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getCreateTime,request.getCreateTime());
              }
              if(request.getIsDel() != null) {
                lambdaQueryWrapper.eq(ProBusinessType::getIsDel,request.getIsDel());
              }
              lambdaQueryWrapper.orderByDesc(ProBusinessType::getCreateTime);
              Page<ProBusinessType> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProBusinessType> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProBusinessType>> findIdsList(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<List<ProBusinessType>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProBusinessType> queryWrapper = new LambdaQueryWrapper<>();
            ProBusinessTypeRequest request = proParameter.getObj();
            if(request.getTypeId() != null){
               queryWrapper.in(ProBusinessType::getTypeId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProBusinessType::getName,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProBusinessType::getCreateTime,request.getIds());
            }
            queryWrapper.orderByDesc(ProBusinessType::getCreateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProBusinessType bean = new ProBusinessType();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProBusinessType> save(ProParameter<ProBusinessTypeRequest> proParameter) {
        return new ServiceResponse<ProBusinessType>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProBusinessType bean = new ProBusinessType();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProBusinessType>> batchSave(ProParameter<List<ProBusinessTypeRequest>> proParameter) {
       return new ServiceResponse<List<ProBusinessType>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProBusinessType> roles = proParameter.getObj()
                   .stream()
                   .map(proBusinessTypeRequest -> {
                       ProBusinessType proBusinessType = new ProBusinessType();
                       BeanUtils.copyProperties(proBusinessTypeRequest, proBusinessType);
                       mapper.insert(proBusinessType);
                       return proBusinessType;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<List<ProBusinessType>> batchUpdate(ProParameter<List<ProBusinessTypeRequest>> proParameter) {
      return new ServiceResponse<List<ProBusinessType>>()
          .beginTransaction()
          .run(serviceResponse -> {
            List<ProBusinessType> roles = proParameter.getObj()
                .stream()
                .map(proBusinessTypeRequest -> {
                  ProBusinessType proBusinessType = new ProBusinessType();
                  BeanUtils.copyProperties(proBusinessTypeRequest, proBusinessType);
                  mapper.updateById(proBusinessType);
                  return proBusinessType;
                }).collect(Collectors.toList());
            return roles;
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProBusinessType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProBusinessType::getName,request.getName());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusinessType::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProBusinessTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProBusinessType> queryWrapper = new LambdaQueryWrapper<>();
               ProBusinessTypeRequest request = proParameter.getObj();
               if(request.getTypeId() != null){
                  queryWrapper.in(ProBusinessType::getTypeId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProBusinessType::getName,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProBusinessType::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

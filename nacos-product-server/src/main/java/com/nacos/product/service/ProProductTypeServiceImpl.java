package com.nacos.product.service;
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
import com.nacos.product.dto.ProProductType;
import com.nacos.product.request.ProProductTypeRequest;
import com.nacos.product.IProProductTypeService;
import com.nacos.product.mapper.ProProductTypeMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@RestController
@Api(value = "ProProductTypeServiceImpl", description = "产品分类 ")
@SuppressWarnings("unchecked")
public class ProProductTypeServiceImpl implements IProProductTypeService {

    @Resource
    ProProductTypeMapper mapper;

    @Override
    public ServiceResponse<ProProductType> get(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<ProProductType>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProductType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProductType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProductType::getName,request.getName());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProductType::getSort,request.getSort());
              }
              if(request.getParentId() != null){
                lambdaQueryWrapper.eq(ProProductType::getParentId,request.getParentId());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductType::getCreateTime,request.getCreateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProductType>> getList(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<List<ProProductType>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProductType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProductType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProProductType::getName,request.getName());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProductType::getSort,request.getSort());
              }
              if(request.getParentId() != null){
                lambdaQueryWrapper.eq(ProProductType::getParentId,request.getParentId());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductType::getCreateTime,request.getCreateTime());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProductType>> getPageList(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<List<ProProductType>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProProductType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProductType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProProductType::getName,request.getName());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProductType::getSort,request.getSort());
              }
              if(request.getParentId() != null){
                lambdaQueryWrapper.eq(ProProductType::getParentId,request.getParentId());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductType::getCreateTime,request.getCreateTime());
              }
              Page<ProProductType> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProProductType> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProProductType>> findIdsList(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<List<ProProductType>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProProductType> queryWrapper = new LambdaQueryWrapper<>();
            ProProductTypeRequest request = proParameter.getObj();
            if(request.getTypeId() != null){
               queryWrapper.in(ProProductType::getTypeId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProProductType::getName,request.getIds());
            }
            if(request.getSort() != null){
               queryWrapper.in(ProProductType::getSort,request.getIds());
            }
            if(request.getParentId() != null){
               queryWrapper.in(ProProductType::getParentId,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProProductType::getCreateTime,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProProductType bean = new ProProductType();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProProductType> save(ProParameter<ProProductTypeRequest> proParameter) {
        return new ServiceResponse<ProProductType>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProProductType bean = new ProProductType();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProProductType>> batchSave(ProParameter<List<ProProductTypeRequest>> proParameter) {
       return new ServiceResponse<List<ProProductType>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProProductType> roles = proParameter.getObj()
                   .stream()
                   .map(proProductTypeRequest -> {
                       ProProductType proProductType = new ProProductType();
                       BeanUtils.copyProperties(proProductTypeRequest, proProductType);
                       mapper.insert(proProductType);
                       return proProductType;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProProductType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductTypeRequest request = proParameter.getObj();
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProductType::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProductType::getName,request.getName());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProductType::getSort,request.getSort());
              }
              if(request.getParentId() != null){
                lambdaQueryWrapper.eq(ProProductType::getParentId,request.getParentId());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductType::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProductTypeRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProProductType> queryWrapper = new LambdaQueryWrapper<>();
               ProProductTypeRequest request = proParameter.getObj();
               if(request.getTypeId() != null){
                  queryWrapper.in(ProProductType::getTypeId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProProductType::getName,request.getIds());
               }
               if(request.getSort() != null){
                  queryWrapper.in(ProProductType::getSort,request.getIds());
               }
               if(request.getParentId() != null){
                  queryWrapper.in(ProProductType::getParentId,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProProductType::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

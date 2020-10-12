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
import com.nacos.system.dto.ProProvince;
import com.nacos.system.request.ProProvinceRequest;
import com.nacos.system.IProProvinceService;
import com.nacos.system.mapper.ProProvinceMapper;
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
@Api(value = "ProProvinceServiceImpl", description = "")
@SuppressWarnings("unchecked")
public class ProProvinceServiceImpl implements IProProvinceService {

    @Resource
    ProProvinceMapper mapper;

    @Override
    public ServiceResponse<ProProvince> get(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<ProProvince>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProvince> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProvinceRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProProvince::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getProvinceId())){
                lambdaQueryWrapper.eq(ProProvince::getProvinceId,request.getProvinceId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProvince::getName,request.getName());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProvince>> getList(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<List<ProProvince>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProvince> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProvinceRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProProvince::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getProvinceId())){
                lambdaQueryWrapper.eq(ProProvince::getProvinceId,request.getProvinceId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProvince::getName,request.getName());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProvince>> getPageList(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<List<ProProvince>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProProvince> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProvinceRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProProvince::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getProvinceId())){
                lambdaQueryWrapper.eq(ProProvince::getProvinceId,request.getProvinceId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProvince::getName,request.getName());
              }
              Page<ProProvince> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProProvince> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProProvince>> findIdsList(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<List<ProProvince>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProProvince> queryWrapper = new LambdaQueryWrapper<>();
            ProProvinceRequest request = proParameter.getObj();
            if(request.getId() != null){
               queryWrapper.in(ProProvince::getId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getProvinceId())){
               queryWrapper.in(ProProvince::getProvinceId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProProvince::getName,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProProvince bean = new ProProvince();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProProvince> save(ProParameter<ProProvinceRequest> proParameter) {
        return new ServiceResponse<ProProvince>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProProvince bean = new ProProvince();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProProvince>> batchSave(ProParameter<List<ProProvinceRequest>> proParameter) {
       return new ServiceResponse<List<ProProvince>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProProvince> roles = proParameter.getObj()
                   .stream()
                   .map(proProvinceRequest -> {
                       ProProvince proProvince = new ProProvince();
                       BeanUtils.copyProperties(proProvinceRequest, proProvince);
                       mapper.insert(proProvince);
                       return proProvince;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProProvince> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProvinceRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProProvince::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getProvinceId())){
                lambdaQueryWrapper.eq(ProProvince::getProvinceId,request.getProvinceId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProProvince::getName,request.getName());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProvinceRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProProvince> queryWrapper = new LambdaQueryWrapper<>();
               ProProvinceRequest request = proParameter.getObj();
               if(request.getId() != null){
                  queryWrapper.in(ProProvince::getId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getProvinceId())){
                  queryWrapper.in(ProProvince::getProvinceId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProProvince::getName,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

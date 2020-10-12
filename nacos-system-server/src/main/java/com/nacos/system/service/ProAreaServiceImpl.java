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
import com.nacos.system.dto.ProArea;
import com.nacos.system.request.ProAreaRequest;
import com.nacos.system.IProAreaService;
import com.nacos.system.mapper.ProAreaMapper;
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
@Api(value = "ProAreaServiceImpl", description = "")
@SuppressWarnings("unchecked")
public class ProAreaServiceImpl implements IProAreaService {

    @Resource
    ProAreaMapper mapper;

    @Override
    public ServiceResponse<ProArea> get(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<ProArea>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProArea> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProAreaRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProArea::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProArea::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProArea::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProArea::getCityId,request.getCityId());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProArea>> getList(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<List<ProArea>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProArea> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProAreaRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProArea::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProArea::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProArea::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProArea::getCityId,request.getCityId());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProArea>> getPageList(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<List<ProArea>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProArea> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProAreaRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProArea::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProArea::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProArea::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProArea::getCityId,request.getCityId());
              }
              Page<ProArea> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProArea> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProArea>> findIdsList(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<List<ProArea>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProArea> queryWrapper = new LambdaQueryWrapper<>();
            ProAreaRequest request = proParameter.getObj();
            if(request.getId() != null){
               queryWrapper.in(ProArea::getId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAreaId())){
               queryWrapper.in(ProArea::getAreaId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProArea::getName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getCityId())){
               queryWrapper.in(ProArea::getCityId,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProArea bean = new ProArea();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProArea> save(ProParameter<ProAreaRequest> proParameter) {
        return new ServiceResponse<ProArea>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProArea bean = new ProArea();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProArea>> batchSave(ProParameter<List<ProAreaRequest>> proParameter) {
       return new ServiceResponse<List<ProArea>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProArea> roles = proParameter.getObj()
                   .stream()
                   .map(proAreaRequest -> {
                       ProArea proArea = new ProArea();
                       BeanUtils.copyProperties(proAreaRequest, proArea);
                       mapper.insert(proArea);
                       return proArea;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProArea> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProAreaRequest request = proParameter.getObj();
              if(request.getId() != null){
                lambdaQueryWrapper.eq(ProArea::getId,request.getId());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProArea::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProArea::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getCityId())){
                lambdaQueryWrapper.eq(ProArea::getCityId,request.getCityId());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProAreaRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProArea> queryWrapper = new LambdaQueryWrapper<>();
               ProAreaRequest request = proParameter.getObj();
               if(request.getId() != null){
                  queryWrapper.in(ProArea::getId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAreaId())){
                  queryWrapper.in(ProArea::getAreaId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProArea::getName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getCityId())){
                  queryWrapper.in(ProArea::getCityId,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

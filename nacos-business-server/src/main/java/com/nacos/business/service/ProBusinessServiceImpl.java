package com.nacos.business.service;
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
import com.nacos.business.dto.ProBusiness;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.business.IProBusinessService;
import com.nacos.business.mapper.ProBusinessMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 商家信息表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-29
 */
@RestController
@Api(value = "ProBusinessServiceImpl", description = "商家信息表 ")
@SuppressWarnings("unchecked")
public class ProBusinessServiceImpl implements IProBusinessService {

    @Resource
    ProBusinessMapper mapper;

    @Override
    public ServiceResponse<ProBusiness> get(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<ProBusiness>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProBusiness> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessRequest request = proParameter.getObj();
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getBusinessId,request.getBusinessId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProBusiness::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getAbbreviation())){
                lambdaQueryWrapper.eq(ProBusiness::getAbbreviation,request.getAbbreviation());
              }
              if(!StringUtils.isEmpty(request.getLogo())){
                lambdaQueryWrapper.eq(ProBusiness::getLogo,request.getLogo());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProBusiness::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProBusiness::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProBusiness::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getAddress())){
                lambdaQueryWrapper.eq(ProBusiness::getAddress,request.getAddress());
              }
              if(!StringUtils.isEmpty(request.getLongitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLongitude,request.getLongitude());
              }
              if(!StringUtils.isEmpty(request.getLatitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLatitude,request.getLatitude());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProBusiness::getIntroduce,request.getIntroduce());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getTypeId,request.getTypeId());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProBusiness::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProBusiness::getImgs,request.getImgs());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getUpdateTime,request.getUpdateTime());
              }
              if(request.getIsDel() != null){
                lambdaQueryWrapper.eq(ProBusiness::getIsDel,request.getIsDel());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProBusiness>> getList(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<List<ProBusiness>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProBusiness> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessRequest request = proParameter.getObj();
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getBusinessId,request.getBusinessId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProBusiness::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getAbbreviation())){
                lambdaQueryWrapper.like(ProBusiness::getAbbreviation,request.getAbbreviation());
              }
              if(!StringUtils.isEmpty(request.getLogo())){
                lambdaQueryWrapper.eq(ProBusiness::getLogo,request.getLogo());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProBusiness::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProBusiness::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProBusiness::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getAddress())){
                lambdaQueryWrapper.eq(ProBusiness::getAddress,request.getAddress());
              }
              if(!StringUtils.isEmpty(request.getLongitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLongitude,request.getLongitude());
              }
              if(!StringUtils.isEmpty(request.getLatitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLatitude,request.getLatitude());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProBusiness::getIntroduce,request.getIntroduce());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getTypeId,request.getTypeId());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProBusiness::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProBusiness::getImgs,request.getImgs());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getUpdateTime,request.getUpdateTime());
              }
              if(request.getIsDel() != null){
                lambdaQueryWrapper.eq(ProBusiness::getIsDel,request.getIsDel());
              }
              lambdaQueryWrapper.orderByDesc(ProBusiness::getCreateTime);
              lambdaQueryWrapper.orderByDesc(ProBusiness::getUpdateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProBusiness>> getPageList(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<List<ProBusiness>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProBusiness> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessRequest request = proParameter.getObj();
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getBusinessId,request.getBusinessId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.like(ProBusiness::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getAbbreviation())){
                lambdaQueryWrapper.like(ProBusiness::getAbbreviation,request.getAbbreviation());
              }
              if(!StringUtils.isEmpty(request.getLogo())){
                lambdaQueryWrapper.eq(ProBusiness::getLogo,request.getLogo());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProBusiness::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProBusiness::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProBusiness::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getAddress())){
                lambdaQueryWrapper.eq(ProBusiness::getAddress,request.getAddress());
              }
              if(!StringUtils.isEmpty(request.getLongitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLongitude,request.getLongitude());
              }
              if(!StringUtils.isEmpty(request.getLatitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLatitude,request.getLatitude());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProBusiness::getIntroduce,request.getIntroduce());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getTypeId,request.getTypeId());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProBusiness::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProBusiness::getImgs,request.getImgs());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getUpdateTime,request.getUpdateTime());
              }
              if(request.getIsDel() != null){
                lambdaQueryWrapper.eq(ProBusiness::getIsDel,request.getIsDel());
              }
              lambdaQueryWrapper.orderByDesc(ProBusiness::getCreateTime);
              lambdaQueryWrapper.orderByDesc(ProBusiness::getUpdateTime);
              Page<ProBusiness> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProBusiness> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProBusiness>> findIdsList(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<List<ProBusiness>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProBusiness> queryWrapper = new LambdaQueryWrapper<>();
            ProBusinessRequest request = proParameter.getObj();
            if(request.getBusinessId() != null){
               queryWrapper.in(ProBusiness::getBusinessId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getName())){
               queryWrapper.in(ProBusiness::getName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAbbreviation())){
               queryWrapper.in(ProBusiness::getAbbreviation,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getLogo())){
               queryWrapper.in(ProBusiness::getLogo,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getProvince())){
               queryWrapper.in(ProBusiness::getProvince,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getCity())){
               queryWrapper.in(ProBusiness::getCity,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getArea())){
               queryWrapper.in(ProBusiness::getArea,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAddress())){
               queryWrapper.in(ProBusiness::getAddress,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getLongitude())){
               queryWrapper.in(ProBusiness::getLongitude,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getLatitude())){
               queryWrapper.in(ProBusiness::getLatitude,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getIntroduce())){
               queryWrapper.in(ProBusiness::getIntroduce,request.getIds());
            }
            if(request.getTypeId() != null){
               queryWrapper.in(ProBusiness::getTypeId,request.getIds());
            }
            if(request.getState() != null){
               queryWrapper.in(ProBusiness::getState,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getImgs())){
               queryWrapper.in(ProBusiness::getImgs,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProBusiness::getCreateTime,request.getIds());
            }
            if(request.getUpdateTime() != null){
               queryWrapper.in(ProBusiness::getUpdateTime,request.getIds());
            }
            if(request.getIsDel() != null){
               queryWrapper.in(ProBusiness::getIsDel,request.getIds());
            }
            queryWrapper.orderByDesc(ProBusiness::getCreateTime);
            queryWrapper.orderByDesc(ProBusiness::getUpdateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProBusiness bean = new ProBusiness();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProBusiness> save(ProParameter<ProBusinessRequest> proParameter) {
        return new ServiceResponse<ProBusiness>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProBusiness bean = new ProBusiness();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProBusiness>> batchSave(ProParameter<List<ProBusinessRequest>> proParameter) {
       return new ServiceResponse<List<ProBusiness>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProBusiness> list = proParameter.getObj()
                   .stream()
                   .map(proBusinessRequest -> {
                       ProBusiness proBusiness = new ProBusiness();
                       BeanUtils.copyProperties(proBusinessRequest, proBusiness);
                       mapper.insert(proBusiness);
                       return proBusiness;
                  }).collect(Collectors.toList());
               return list;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<List<ProBusiness>> batchUpdate(ProParameter<List<ProBusinessRequest>> proParameter) {
       return new ServiceResponse<List<ProBusiness>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProBusiness> list = proParameter.getObj()
                   .stream()
                   .map(proBusinessRequest -> {
                       ProBusiness proBusiness = new ProBusiness();
                       BeanUtils.copyProperties(proBusinessRequest, proBusiness);
                       mapper.updateById(proBusiness);
                       return proBusiness;
                  }).collect(Collectors.toList());
               return list;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProBusiness> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProBusinessRequest request = proParameter.getObj();
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getBusinessId,request.getBusinessId());
              }
              if(!StringUtils.isEmpty(request.getName())){
                lambdaQueryWrapper.eq(ProBusiness::getName,request.getName());
              }
              if(!StringUtils.isEmpty(request.getAbbreviation())){
                lambdaQueryWrapper.eq(ProBusiness::getAbbreviation,request.getAbbreviation());
              }
              if(!StringUtils.isEmpty(request.getLogo())){
                lambdaQueryWrapper.eq(ProBusiness::getLogo,request.getLogo());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProBusiness::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProBusiness::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProBusiness::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getAddress())){
                lambdaQueryWrapper.eq(ProBusiness::getAddress,request.getAddress());
              }
              if(!StringUtils.isEmpty(request.getLongitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLongitude,request.getLongitude());
              }
              if(!StringUtils.isEmpty(request.getLatitude())){
                lambdaQueryWrapper.eq(ProBusiness::getLatitude,request.getLatitude());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProBusiness::getIntroduce,request.getIntroduce());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProBusiness::getTypeId,request.getTypeId());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProBusiness::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProBusiness::getImgs,request.getImgs());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProBusiness::getUpdateTime,request.getUpdateTime());
              }
              if(request.getIsDel() != null){
                lambdaQueryWrapper.eq(ProBusiness::getIsDel,request.getIsDel());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProBusinessRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProBusiness> queryWrapper = new LambdaQueryWrapper<>();
               ProBusinessRequest request = proParameter.getObj();
               if(request.getBusinessId() != null){
                  queryWrapper.in(ProBusiness::getBusinessId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getName())){
                  queryWrapper.in(ProBusiness::getName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAbbreviation())){
                  queryWrapper.in(ProBusiness::getAbbreviation,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getLogo())){
                  queryWrapper.in(ProBusiness::getLogo,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getProvince())){
                  queryWrapper.in(ProBusiness::getProvince,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getCity())){
                  queryWrapper.in(ProBusiness::getCity,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getArea())){
                  queryWrapper.in(ProBusiness::getArea,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAddress())){
                  queryWrapper.in(ProBusiness::getAddress,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getLongitude())){
                  queryWrapper.in(ProBusiness::getLongitude,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getLatitude())){
                  queryWrapper.in(ProBusiness::getLatitude,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getIntroduce())){
                  queryWrapper.in(ProBusiness::getIntroduce,request.getIds());
               }
               if(request.getTypeId() != null){
                  queryWrapper.in(ProBusiness::getTypeId,request.getIds());
               }
               if(request.getState() != null){
                  queryWrapper.in(ProBusiness::getState,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getImgs())){
                  queryWrapper.in(ProBusiness::getImgs,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProBusiness::getCreateTime,request.getIds());
               }
               if(request.getUpdateTime() != null){
                  queryWrapper.in(ProBusiness::getUpdateTime,request.getIds());
               }
               if(request.getIsDel() != null){
                  queryWrapper.in(ProBusiness::getIsDel,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

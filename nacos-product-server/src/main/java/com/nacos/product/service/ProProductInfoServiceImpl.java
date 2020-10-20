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
import com.nacos.product.dto.ProProductInfo;
import com.nacos.product.request.ProProductInfoRequest;
import com.nacos.product.IProProductInfoService;
import com.nacos.product.mapper.ProProductInfoMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 产品详情 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@RestController
@Api(value = "ProProductInfoServiceImpl", description = "产品详情 ")
@SuppressWarnings("unchecked")
public class ProProductInfoServiceImpl implements IProProductInfoService {

    @Resource
    ProProductInfoMapper mapper;

    @Override
    public ServiceResponse<ProProductInfo> get(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<ProProductInfo>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProductInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductInfoRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getProductId,request.getProductId());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProProductInfo::getImgs,request.getImgs());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProProductInfo::getIntroduce,request.getIntroduce());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getCreateTime,request.getCreateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProductInfo>> getList(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<List<ProProductInfo>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProductInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductInfoRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getProductId,request.getProductId());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProProductInfo::getImgs,request.getImgs());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProProductInfo::getIntroduce,request.getIntroduce());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getCreateTime,request.getCreateTime());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProductInfo>> getPageList(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<List<ProProductInfo>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProProductInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductInfoRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getProductId,request.getProductId());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProProductInfo::getImgs,request.getImgs());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProProductInfo::getIntroduce,request.getIntroduce());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getCreateTime,request.getCreateTime());
              }
              Page<ProProductInfo> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProProductInfo> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProProductInfo>> findIdsList(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<List<ProProductInfo>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProProductInfo> queryWrapper = new LambdaQueryWrapper<>();
            ProProductInfoRequest request = proParameter.getObj();
            if(request.getProductId() != null){
               queryWrapper.in(ProProductInfo::getProductId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getImgs())){
               queryWrapper.in(ProProductInfo::getImgs,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getIntroduce())){
               queryWrapper.in(ProProductInfo::getIntroduce,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProProductInfo::getCreateTime,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProProductInfo bean = new ProProductInfo();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProProductInfo> save(ProParameter<ProProductInfoRequest> proParameter) {
        return new ServiceResponse<ProProductInfo>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProProductInfo bean = new ProProductInfo();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProProductInfo>> batchSave(ProParameter<List<ProProductInfoRequest>> proParameter) {
       return new ServiceResponse<List<ProProductInfo>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProProductInfo> roles = proParameter.getObj()
                   .stream()
                   .map(proProductInfoRequest -> {
                       ProProductInfo proProductInfo = new ProProductInfo();
                       BeanUtils.copyProperties(proProductInfoRequest, proProductInfo);
                       mapper.insert(proProductInfo);
                       return proProductInfo;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProProductInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductInfoRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getProductId,request.getProductId());
              }
              if(!StringUtils.isEmpty(request.getImgs())){
                lambdaQueryWrapper.eq(ProProductInfo::getImgs,request.getImgs());
              }
              if(!StringUtils.isEmpty(request.getIntroduce())){
                lambdaQueryWrapper.eq(ProProductInfo::getIntroduce,request.getIntroduce());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProductInfo::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProductInfoRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProProductInfo> queryWrapper = new LambdaQueryWrapper<>();
               ProProductInfoRequest request = proParameter.getObj();
               if(request.getProductId() != null){
                  queryWrapper.in(ProProductInfo::getProductId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getImgs())){
                  queryWrapper.in(ProProductInfo::getImgs,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getIntroduce())){
                  queryWrapper.in(ProProductInfo::getIntroduce,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProProductInfo::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

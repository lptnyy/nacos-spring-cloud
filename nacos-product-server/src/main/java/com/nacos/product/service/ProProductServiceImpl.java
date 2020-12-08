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
import com.nacos.product.dto.ProProduct;
import com.nacos.product.request.ProProductRequest;
import com.nacos.product.IProProductService;
import com.nacos.product.mapper.ProProductMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 产品管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@RestController
@Api(value = "ProProductServiceImpl", description = "产品管理")
@SuppressWarnings("unchecked")
public class ProProductServiceImpl implements IProProductService {

    @Resource
    ProProductMapper mapper;

    @Override
    public ServiceResponse<ProProduct> get(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<ProProduct>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProduct> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProduct::getProductId,request.getProductId());
              }
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProProduct::getBusinessId,request.getBusinessId());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProduct::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getTitle())){
                lambdaQueryWrapper.eq(ProProduct::getTitle,request.getTitle());
              }
              if(!StringUtils.isEmpty(request.getSubtitle())){
                lambdaQueryWrapper.eq(ProProduct::getSubtitle,request.getSubtitle());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProProduct::getImage,request.getImage());
              }
              if(request.getFabulousNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getFabulousNum,request.getFabulousNum());
              }
              if(request.getCommentNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getCommentNum,request.getCommentNum());
              }
              if(request.getSalesNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getSalesNum,request.getSalesNum());
              }
              if(request.getShareNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getShareNum,request.getShareNum());
              }
              if(request.getDiscountSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getDiscountSts,request.getDiscountSts());
              }
              if(request.getIntegralSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getIntegralSts,request.getIntegralSts());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProProduct::getState,request.getState());
              }
              if(request.getFreightId() != null){
                lambdaQueryWrapper.eq(ProProduct::getFreightId,request.getFreightId());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProduct::getSort,request.getSort());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getUpdateTime,request.getUpdateTime());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getCreateTime,request.getCreateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProduct>> getList(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<List<ProProduct>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProProduct> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProduct::getProductId,request.getProductId());
              }
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProProduct::getBusinessId,request.getBusinessId());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProduct::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getTitle())){
                lambdaQueryWrapper.like(ProProduct::getTitle,request.getTitle());
              }
              if(!StringUtils.isEmpty(request.getSubtitle())){
                lambdaQueryWrapper.eq(ProProduct::getSubtitle,request.getSubtitle());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProProduct::getImage,request.getImage());
              }
              if(request.getFabulousNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getFabulousNum,request.getFabulousNum());
              }
              if(request.getCommentNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getCommentNum,request.getCommentNum());
              }
              if(request.getSalesNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getSalesNum,request.getSalesNum());
              }
              if(request.getShareNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getShareNum,request.getShareNum());
              }
              if(request.getDiscountSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getDiscountSts,request.getDiscountSts());
              }
              if(request.getIntegralSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getIntegralSts,request.getIntegralSts());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProProduct::getState,request.getState());
              }
              if(request.getFreightId() != null){
                lambdaQueryWrapper.eq(ProProduct::getFreightId,request.getFreightId());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProduct::getSort,request.getSort());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getUpdateTime,request.getUpdateTime());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProProduct::getUpdateTime);
              lambdaQueryWrapper.orderByDesc(ProProduct::getCreateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProProduct>> getPageList(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<List<ProProduct>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProProduct> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProduct::getProductId,request.getProductId());
              }
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProProduct::getBusinessId,request.getBusinessId());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProduct::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getTitle())){
                lambdaQueryWrapper.like(ProProduct::getTitle,request.getTitle());
              }
              if(!StringUtils.isEmpty(request.getSubtitle())){
                lambdaQueryWrapper.eq(ProProduct::getSubtitle,request.getSubtitle());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProProduct::getImage,request.getImage());
              }
              if(request.getFabulousNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getFabulousNum,request.getFabulousNum());
              }
              if(request.getCommentNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getCommentNum,request.getCommentNum());
              }
              if(request.getSalesNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getSalesNum,request.getSalesNum());
              }
              if(request.getShareNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getShareNum,request.getShareNum());
              }
              if(request.getDiscountSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getDiscountSts,request.getDiscountSts());
              }
              if(request.getIntegralSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getIntegralSts,request.getIntegralSts());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProProduct::getState,request.getState());
              }
              if(request.getFreightId() != null){
                lambdaQueryWrapper.eq(ProProduct::getFreightId,request.getFreightId());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProduct::getSort,request.getSort());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getUpdateTime,request.getUpdateTime());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProProduct::getUpdateTime);
              lambdaQueryWrapper.orderByDesc(ProProduct::getCreateTime);
              Page<ProProduct> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProProduct> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProProduct>> findIdsList(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<List<ProProduct>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProProduct> queryWrapper = new LambdaQueryWrapper<>();
            ProProductRequest request = proParameter.getObj();
            if(request.getProductId() != null){
               queryWrapper.in(ProProduct::getProductId,request.getIds());
            }
            if(request.getBusinessId() != null){
               queryWrapper.in(ProProduct::getBusinessId,request.getIds());
            }
            if(request.getTypeId() != null){
               queryWrapper.in(ProProduct::getTypeId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getTitle())){
               queryWrapper.in(ProProduct::getTitle,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getSubtitle())){
               queryWrapper.in(ProProduct::getSubtitle,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getImage())){
               queryWrapper.in(ProProduct::getImage,request.getIds());
            }
            if(request.getFabulousNum() != null){
               queryWrapper.in(ProProduct::getFabulousNum,request.getIds());
            }
            if(request.getCommentNum() != null){
               queryWrapper.in(ProProduct::getCommentNum,request.getIds());
            }
            if(request.getSalesNum() != null){
               queryWrapper.in(ProProduct::getSalesNum,request.getIds());
            }
            if(request.getShareNum() != null){
               queryWrapper.in(ProProduct::getShareNum,request.getIds());
            }
            if(request.getDiscountSts() != null){
               queryWrapper.in(ProProduct::getDiscountSts,request.getIds());
            }
            if(request.getIntegralSts() != null){
               queryWrapper.in(ProProduct::getIntegralSts,request.getIds());
            }
            if(request.getState() != null){
               queryWrapper.in(ProProduct::getState,request.getIds());
            }
            if(request.getFreightId() != null){
               queryWrapper.in(ProProduct::getFreightId,request.getIds());
            }
            if(request.getSort() != null){
               queryWrapper.in(ProProduct::getSort,request.getIds());
            }
            if(request.getUpdateTime() != null){
               queryWrapper.in(ProProduct::getUpdateTime,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProProduct::getCreateTime,request.getIds());
            }
            queryWrapper.orderByDesc(ProProduct::getUpdateTime);
            queryWrapper.orderByDesc(ProProduct::getCreateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProProduct bean = new ProProduct();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProProduct> save(ProParameter<ProProductRequest> proParameter) {
        return new ServiceResponse<ProProduct>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProProduct bean = new ProProduct();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProProduct>> batchSave(ProParameter<List<ProProductRequest>> proParameter) {
       return new ServiceResponse<List<ProProduct>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProProduct> roles = proParameter.getObj()
                   .stream()
                   .map(proProductRequest -> {
                       ProProduct proProduct = new ProProduct();
                       BeanUtils.copyProperties(proProductRequest, proProduct);
                       mapper.insert(proProduct);
                       return proProduct;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProProduct> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProProductRequest request = proParameter.getObj();
              if(request.getProductId() != null){
                lambdaQueryWrapper.eq(ProProduct::getProductId,request.getProductId());
              }
              if(request.getBusinessId() != null){
                lambdaQueryWrapper.eq(ProProduct::getBusinessId,request.getBusinessId());
              }
              if(request.getTypeId() != null){
                lambdaQueryWrapper.eq(ProProduct::getTypeId,request.getTypeId());
              }
              if(!StringUtils.isEmpty(request.getTitle())){
                lambdaQueryWrapper.eq(ProProduct::getTitle,request.getTitle());
              }
              if(!StringUtils.isEmpty(request.getSubtitle())){
                lambdaQueryWrapper.eq(ProProduct::getSubtitle,request.getSubtitle());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProProduct::getImage,request.getImage());
              }
              if(request.getFabulousNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getFabulousNum,request.getFabulousNum());
              }
              if(request.getCommentNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getCommentNum,request.getCommentNum());
              }
              if(request.getSalesNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getSalesNum,request.getSalesNum());
              }
              if(request.getShareNum() != null){
                lambdaQueryWrapper.eq(ProProduct::getShareNum,request.getShareNum());
              }
              if(request.getDiscountSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getDiscountSts,request.getDiscountSts());
              }
              if(request.getIntegralSts() != null){
                lambdaQueryWrapper.eq(ProProduct::getIntegralSts,request.getIntegralSts());
              }
              if(request.getState() != null){
                lambdaQueryWrapper.eq(ProProduct::getState,request.getState());
              }
              if(request.getFreightId() != null){
                lambdaQueryWrapper.eq(ProProduct::getFreightId,request.getFreightId());
              }
              if(request.getSort() != null){
                lambdaQueryWrapper.eq(ProProduct::getSort,request.getSort());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getUpdateTime,request.getUpdateTime());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProProduct::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProductRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProProduct> queryWrapper = new LambdaQueryWrapper<>();
               ProProductRequest request = proParameter.getObj();
               if(request.getProductId() != null){
                  queryWrapper.in(ProProduct::getProductId,request.getIds());
               }
               if(request.getBusinessId() != null){
                  queryWrapper.in(ProProduct::getBusinessId,request.getIds());
               }
               if(request.getTypeId() != null){
                  queryWrapper.in(ProProduct::getTypeId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getTitle())){
                  queryWrapper.in(ProProduct::getTitle,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getSubtitle())){
                  queryWrapper.in(ProProduct::getSubtitle,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getImage())){
                  queryWrapper.in(ProProduct::getImage,request.getIds());
               }
               if(request.getFabulousNum() != null){
                  queryWrapper.in(ProProduct::getFabulousNum,request.getIds());
               }
               if(request.getCommentNum() != null){
                  queryWrapper.in(ProProduct::getCommentNum,request.getIds());
               }
               if(request.getSalesNum() != null){
                  queryWrapper.in(ProProduct::getSalesNum,request.getIds());
               }
               if(request.getShareNum() != null){
                  queryWrapper.in(ProProduct::getShareNum,request.getIds());
               }
               if(request.getDiscountSts() != null){
                  queryWrapper.in(ProProduct::getDiscountSts,request.getIds());
               }
               if(request.getIntegralSts() != null){
                  queryWrapper.in(ProProduct::getIntegralSts,request.getIds());
               }
               if(request.getState() != null){
                  queryWrapper.in(ProProduct::getState,request.getIds());
               }
               if(request.getFreightId() != null){
                  queryWrapper.in(ProProduct::getFreightId,request.getIds());
               }
               if(request.getSort() != null){
                  queryWrapper.in(ProProduct::getSort,request.getIds());
               }
               if(request.getUpdateTime() != null){
                  queryWrapper.in(ProProduct::getUpdateTime,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProProduct::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

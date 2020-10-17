package com.nacos.member.service;
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
import com.nacos.member.dto.ProLevel;
import com.nacos.member.request.ProLevelRequest;
import com.nacos.member.IProLevelService;
import com.nacos.member.mapper.ProLevelMapper;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
    * 会员等级 会员等级
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@RestController
@Api(value = "ProLevelServiceImpl", description = "会员等级 会员等级")
@SuppressWarnings("unchecked")
public class ProLevelServiceImpl implements IProLevelService {

    @Resource
    ProLevelMapper mapper;

    @Override
    public ServiceResponse<ProLevel> get(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<ProLevel>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProLevel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProLevelRequest request = proParameter.getObj();
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProLevel::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getLevelName())){
                lambdaQueryWrapper.eq(ProLevel::getLevelName,request.getLevelName());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProLevel::getImage,request.getImage());
              }
              if(request.getIntegral() != null){
                lambdaQueryWrapper.eq(ProLevel::getIntegral,request.getIntegral());
              }
              if(request.getPrice() != null){
                lambdaQueryWrapper.eq(ProLevel::getPrice,request.getPrice());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProLevel::getCreateTime,request.getCreateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProLevel>> getList(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<List<ProLevel>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProLevel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProLevelRequest request = proParameter.getObj();
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProLevel::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getLevelName())){
                lambdaQueryWrapper.like(ProLevel::getLevelName,request.getLevelName());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProLevel::getImage,request.getImage());
              }
              if(request.getIntegral() != null){
                lambdaQueryWrapper.eq(ProLevel::getIntegral,request.getIntegral());
              }
              if(request.getPrice() != null){
                lambdaQueryWrapper.eq(ProLevel::getPrice,request.getPrice());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProLevel::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProLevel::getCreateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProLevel>> getPageList(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<List<ProLevel>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProLevel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProLevelRequest request = proParameter.getObj();
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProLevel::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getLevelName())){
                lambdaQueryWrapper.like(ProLevel::getLevelName,request.getLevelName());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProLevel::getImage,request.getImage());
              }
              if(request.getIntegral() != null){
                lambdaQueryWrapper.eq(ProLevel::getIntegral,request.getIntegral());
              }
              if(request.getPrice() != null){
                lambdaQueryWrapper.eq(ProLevel::getPrice,request.getPrice());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProLevel::getCreateTime,request.getCreateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProLevel::getCreateTime);
              Page<ProLevel> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProLevel> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProLevel>> findIdsList(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<List<ProLevel>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProLevel> queryWrapper = new LambdaQueryWrapper<>();
            ProLevelRequest request = proParameter.getObj();
            if(request.getLevelId() != null){
               queryWrapper.in(ProLevel::getLevelId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getLevelName())){
               queryWrapper.in(ProLevel::getLevelName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getImage())){
               queryWrapper.in(ProLevel::getImage,request.getIds());
            }
            if(request.getIntegral() != null){
               queryWrapper.in(ProLevel::getIntegral,request.getIds());
            }
            if(request.getPrice() != null){
               queryWrapper.in(ProLevel::getPrice,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProLevel::getCreateTime,request.getIds());
            }
            queryWrapper.orderByDesc(ProLevel::getCreateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProLevel bean = new ProLevel();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProLevel> save(ProParameter<ProLevelRequest> proParameter) {
        return new ServiceResponse<ProLevel>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProLevel bean = new ProLevel();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProLevel>> batchSave(ProParameter<List<ProLevelRequest>> proParameter) {
       return new ServiceResponse<List<ProLevel>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProLevel> roles = proParameter.getObj()
                   .stream()
                   .map(proLevelRequest -> {
                       ProLevel proLevel = new ProLevel();
                       BeanUtils.copyProperties(proLevelRequest, proLevel);
                       mapper.insert(proLevel);
                       return proLevel;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProLevel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProLevelRequest request = proParameter.getObj();
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProLevel::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getLevelName())){
                lambdaQueryWrapper.eq(ProLevel::getLevelName,request.getLevelName());
              }
              if(!StringUtils.isEmpty(request.getImage())){
                lambdaQueryWrapper.eq(ProLevel::getImage,request.getImage());
              }
              if(request.getIntegral() != null){
                lambdaQueryWrapper.eq(ProLevel::getIntegral,request.getIntegral());
              }
              if(request.getPrice() != null){
                lambdaQueryWrapper.eq(ProLevel::getPrice,request.getPrice());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProLevel::getCreateTime,request.getCreateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProLevelRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProLevel> queryWrapper = new LambdaQueryWrapper<>();
               ProLevelRequest request = proParameter.getObj();
               if(request.getLevelId() != null){
                  queryWrapper.in(ProLevel::getLevelId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getLevelName())){
                  queryWrapper.in(ProLevel::getLevelName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getImage())){
                  queryWrapper.in(ProLevel::getImage,request.getIds());
               }
               if(request.getIntegral() != null){
                  queryWrapper.in(ProLevel::getIntegral,request.getIds());
               }
               if(request.getPrice() != null){
                  queryWrapper.in(ProLevel::getPrice,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProLevel::getCreateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

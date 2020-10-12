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
import com.nacos.system.dto.ProSchool;
import com.nacos.system.request.ProSchoolRequest;
import com.nacos.system.IProSchoolService;
import com.nacos.system.mapper.ProSchoolMapper;
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
@Api(value = "ProSchoolServiceImpl", description = "")
@SuppressWarnings("unchecked")
public class ProSchoolServiceImpl implements IProSchoolService {

    @Resource
    ProSchoolMapper mapper;

    @Override
    public ServiceResponse<ProSchool> get(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<ProSchool>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProSchool> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProSchoolRequest request = proParameter.getObj();
              if(request.getSchoolId() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolId,request.getSchoolId());
              }
              if(!StringUtils.isEmpty(request.getSchoolName())){
                lambdaQueryWrapper.eq(ProSchool::getSchoolName,request.getSchoolName());
              }
              if(request.getSchoolType() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolType,request.getSchoolType());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProSchool::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getAreaName())){
                lambdaQueryWrapper.eq(ProSchool::getAreaName,request.getAreaName());
              }
              if(request.getDisplayOrder() != null){
                lambdaQueryWrapper.eq(ProSchool::getDisplayOrder,request.getDisplayOrder());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProSchool>> getList(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<List<ProSchool>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProSchool> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProSchoolRequest request = proParameter.getObj();
              if(request.getSchoolId() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolId,request.getSchoolId());
              }
              if(!StringUtils.isEmpty(request.getSchoolName())){
                lambdaQueryWrapper.eq(ProSchool::getSchoolName,request.getSchoolName());
              }
              if(request.getSchoolType() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolType,request.getSchoolType());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProSchool::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getAreaName())){
                lambdaQueryWrapper.eq(ProSchool::getAreaName,request.getAreaName());
              }
              if(request.getDisplayOrder() != null){
                lambdaQueryWrapper.eq(ProSchool::getDisplayOrder,request.getDisplayOrder());
              }
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProSchool>> getPageList(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<List<ProSchool>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProSchool> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProSchoolRequest request = proParameter.getObj();
              if(request.getSchoolId() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolId,request.getSchoolId());
              }
              if(!StringUtils.isEmpty(request.getSchoolName())){
                lambdaQueryWrapper.eq(ProSchool::getSchoolName,request.getSchoolName());
              }
              if(request.getSchoolType() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolType,request.getSchoolType());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProSchool::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getAreaName())){
                lambdaQueryWrapper.eq(ProSchool::getAreaName,request.getAreaName());
              }
              if(request.getDisplayOrder() != null){
                lambdaQueryWrapper.eq(ProSchool::getDisplayOrder,request.getDisplayOrder());
              }
              Page<ProSchool> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProSchool> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProSchool>> findIdsList(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<List<ProSchool>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProSchool> queryWrapper = new LambdaQueryWrapper<>();
            ProSchoolRequest request = proParameter.getObj();
            if(request.getSchoolId() != null){
               queryWrapper.in(ProSchool::getSchoolId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getSchoolName())){
               queryWrapper.in(ProSchool::getSchoolName,request.getIds());
            }
            if(request.getSchoolType() != null){
               queryWrapper.in(ProSchool::getSchoolType,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAreaId())){
               queryWrapper.in(ProSchool::getAreaId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAreaName())){
               queryWrapper.in(ProSchool::getAreaName,request.getIds());
            }
            if(request.getDisplayOrder() != null){
               queryWrapper.in(ProSchool::getDisplayOrder,request.getIds());
            }
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProSchool bean = new ProSchool();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProSchool> save(ProParameter<ProSchoolRequest> proParameter) {
        return new ServiceResponse<ProSchool>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProSchool bean = new ProSchool();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProSchool>> batchSave(ProParameter<List<ProSchoolRequest>> proParameter) {
       return new ServiceResponse<List<ProSchool>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProSchool> roles = proParameter.getObj()
                   .stream()
                   .map(proSchoolRequest -> {
                       ProSchool proSchool = new ProSchool();
                       BeanUtils.copyProperties(proSchoolRequest, proSchool);
                       mapper.insert(proSchool);
                       return proSchool;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProSchool> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProSchoolRequest request = proParameter.getObj();
              if(request.getSchoolId() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolId,request.getSchoolId());
              }
              if(!StringUtils.isEmpty(request.getSchoolName())){
                lambdaQueryWrapper.eq(ProSchool::getSchoolName,request.getSchoolName());
              }
              if(request.getSchoolType() != null){
                lambdaQueryWrapper.eq(ProSchool::getSchoolType,request.getSchoolType());
              }
              if(!StringUtils.isEmpty(request.getAreaId())){
                lambdaQueryWrapper.eq(ProSchool::getAreaId,request.getAreaId());
              }
              if(!StringUtils.isEmpty(request.getAreaName())){
                lambdaQueryWrapper.eq(ProSchool::getAreaName,request.getAreaName());
              }
              if(request.getDisplayOrder() != null){
                lambdaQueryWrapper.eq(ProSchool::getDisplayOrder,request.getDisplayOrder());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProSchoolRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProSchool> queryWrapper = new LambdaQueryWrapper<>();
               ProSchoolRequest request = proParameter.getObj();
               if(request.getSchoolId() != null){
                  queryWrapper.in(ProSchool::getSchoolId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getSchoolName())){
                  queryWrapper.in(ProSchool::getSchoolName,request.getIds());
               }
               if(request.getSchoolType() != null){
                  queryWrapper.in(ProSchool::getSchoolType,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAreaId())){
                  queryWrapper.in(ProSchool::getAreaId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAreaName())){
                  queryWrapper.in(ProSchool::getAreaName,request.getIds());
               }
               if(request.getDisplayOrder() != null){
                  queryWrapper.in(ProSchool::getDisplayOrder,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

package com.nacos.member.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.nacos.member.dto.ProMember;
import com.nacos.member.request.ProMemberRequest;
import com.nacos.member.IProMemberService;
import com.nacos.member.mapper.ProMemberMapper;

/**
 * <p>
    * 会员表 会员
    * </p>
 *
 * @author 王振宇
 * @since 2020-09-15
 */
@RestController
@Api(value = "ProMemberServiceImpl", description = "会员表 会员")
@SuppressWarnings("unchecked")
public class ProMemberServiceImpl implements IProMemberService {

    @Resource
    ProMemberMapper mapper;

    @Override
    public ServiceResponse<ProMember> get(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<ProMember>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProMemberRequest request = proParameter.getObj();
              if(request.getMemberId() != null){
                lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
              }
              if(!StringUtils.isEmpty(request.getMemberNo())){
                lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
              }
              if(!StringUtils.isEmpty(request.getNickName())){
                lambdaQueryWrapper.eq(ProMember::getNickName,request.getNickName());
              }
              if(!StringUtils.isEmpty(request.getUserName())){
                lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
              }
              if(!StringUtils.isEmpty(request.getPassWord())){
                lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
              }
              if(!StringUtils.isEmpty(request.getHeadPortrait())){
                lambdaQueryWrapper.eq(ProMember::getHeadPortrait,request.getHeadPortrait());
              }
              if(!StringUtils.isEmpty(request.getNtroduction())){
                lambdaQueryWrapper.eq(ProMember::getNtroduction,request.getNtroduction());
              }
              if(!StringUtils.isEmpty(request.getSex())){
                lambdaQueryWrapper.eq(ProMember::getSex,request.getSex());
              }
              if(!StringUtils.isEmpty(request.getAge())){
                lambdaQueryWrapper.eq(ProMember::getAge,request.getAge());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getSchool())){
                lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
              }
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProMember::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getState())){
                lambdaQueryWrapper.eq(ProMember::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getPayPassword())){
                lambdaQueryWrapper.eq(ProMember::getPayPassword,request.getPayPassword());
              }
              if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
                lambdaQueryWrapper.eq(ProMember::getWithdrawalPassword,request.getWithdrawalPassword());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getUpdateTime,request.getUpdateTime());
              }
              return mapper.selectOne(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> getList(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<List<ProMember>>()
          .run((serviceResponse) -> {
              LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProMemberRequest request = proParameter.getObj();
              if(request.getMemberId() != null){
                lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
              }
              if(!StringUtils.isEmpty(request.getMemberNo())){
                lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
              }
              if(!StringUtils.isEmpty(request.getNickName())){
                lambdaQueryWrapper.eq(ProMember::getNickName,request.getNickName());
              }
              if(!StringUtils.isEmpty(request.getUserName())){
                lambdaQueryWrapper.like(ProMember::getUserName,request.getUserName());
              }
              if(!StringUtils.isEmpty(request.getPassWord())){
                lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
              }
              if(!StringUtils.isEmpty(request.getHeadPortrait())){
                lambdaQueryWrapper.eq(ProMember::getHeadPortrait,request.getHeadPortrait());
              }
              if(!StringUtils.isEmpty(request.getNtroduction())){
                lambdaQueryWrapper.eq(ProMember::getNtroduction,request.getNtroduction());
              }
              if(!StringUtils.isEmpty(request.getSex())){
                lambdaQueryWrapper.eq(ProMember::getSex,request.getSex());
              }
              if(!StringUtils.isEmpty(request.getAge())){
                lambdaQueryWrapper.eq(ProMember::getAge,request.getAge());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getSchool())){
                lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
              }
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProMember::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getState())){
                lambdaQueryWrapper.eq(ProMember::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getPayPassword())){
                lambdaQueryWrapper.eq(ProMember::getPayPassword,request.getPayPassword());
              }
              if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
                lambdaQueryWrapper.eq(ProMember::getWithdrawalPassword,request.getWithdrawalPassword());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getUpdateTime,request.getUpdateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProMember::getCreateTime);
              return mapper.selectList(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> getPageList(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<List<ProMember>>()
          .run((serviceResponse -> {
              LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProMemberRequest request = proParameter.getObj();
              if(request.getMemberId() != null){
                lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
              }
              if(!StringUtils.isEmpty(request.getMemberNo())){
                lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
              }
              if(!StringUtils.isEmpty(request.getNickName())){
                lambdaQueryWrapper.eq(ProMember::getNickName,request.getNickName());
              }
              if(!StringUtils.isEmpty(request.getUserName())){
                lambdaQueryWrapper.like(ProMember::getUserName,request.getUserName());
              }
              if(!StringUtils.isEmpty(request.getPassWord())){
                lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
              }
              if(!StringUtils.isEmpty(request.getHeadPortrait())){
                lambdaQueryWrapper.eq(ProMember::getHeadPortrait,request.getHeadPortrait());
              }
              if(!StringUtils.isEmpty(request.getNtroduction())){
                lambdaQueryWrapper.eq(ProMember::getNtroduction,request.getNtroduction());
              }
              if(!StringUtils.isEmpty(request.getSex())){
                lambdaQueryWrapper.eq(ProMember::getSex,request.getSex());
              }
              if(!StringUtils.isEmpty(request.getAge())){
                lambdaQueryWrapper.eq(ProMember::getAge,request.getAge());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getSchool())){
                lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
              }
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProMember::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getState())){
                lambdaQueryWrapper.eq(ProMember::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getPayPassword())){
                lambdaQueryWrapper.eq(ProMember::getPayPassword,request.getPayPassword());
              }
              if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
                lambdaQueryWrapper.eq(ProMember::getWithdrawalPassword,request.getWithdrawalPassword());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getUpdateTime,request.getUpdateTime());
              }
              lambdaQueryWrapper.orderByDesc(ProMember::getCreateTime);
              Page<ProMember> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
              IPage<ProMember> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
              serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                 .setPageSize(proParameter.getRequestPage().getPageSize())
                 .setCount(pageResult.getTotal())
                 .setPages(pageResult.getPages());
              return pageResult.getRecords();
          })).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> findIdsList(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<List<ProMember>>()
        .run(serviceResponse -> {
            LambdaQueryWrapper<ProMember> queryWrapper = new LambdaQueryWrapper<>();
            ProMemberRequest request = proParameter.getObj();
            if(request.getMemberId() != null){
               queryWrapper.in(ProMember::getMemberId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getMemberNo())){
               queryWrapper.in(ProMember::getMemberNo,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getNickName())){
               queryWrapper.in(ProMember::getNickName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getUserName())){
               queryWrapper.in(ProMember::getUserName,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getPassWord())){
               queryWrapper.in(ProMember::getPassWord,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getHeadPortrait())){
               queryWrapper.in(ProMember::getHeadPortrait,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getNtroduction())){
               queryWrapper.in(ProMember::getNtroduction,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getSex())){
               queryWrapper.in(ProMember::getSex,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getAge())){
               queryWrapper.in(ProMember::getAge,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getProvince())){
               queryWrapper.in(ProMember::getProvince,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getCity())){
               queryWrapper.in(ProMember::getCity,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getArea())){
               queryWrapper.in(ProMember::getArea,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getSchool())){
               queryWrapper.in(ProMember::getSchool,request.getIds());
            }
            if(request.getLevelId() != null){
               queryWrapper.in(ProMember::getLevelId,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getState())){
               queryWrapper.in(ProMember::getState,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getPayPassword())){
               queryWrapper.in(ProMember::getPayPassword,request.getIds());
            }
            if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
               queryWrapper.in(ProMember::getWithdrawalPassword,request.getIds());
            }
            if(request.getCreateTime() != null){
               queryWrapper.in(ProMember::getCreateTime,request.getIds());
            }
            if(request.getUpdateTime() != null){
               queryWrapper.in(ProMember::getUpdateTime,request.getIds());
            }
            queryWrapper.orderByDesc(ProMember::getCreateTime);
            return mapper.selectList(queryWrapper);
        }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              ProMember bean = new ProMember();
              BeanUtils.copyProperties(proParameter.getObj(),bean);
              return mapper.updateById(bean);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProMember> save(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<ProMember>()
            .beginTransaction()
            .run(serviceResponse -> {
                ProMember bean = new ProMember();
                BeanUtils.copyProperties(proParameter.getObj(),bean);
                mapper.insert(bean);
                return bean;
            }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProMember>> batchSave(ProParameter<List<ProMemberRequest>> proParameter) {
       return new ServiceResponse<List<ProMember>>()
            .beginTransaction()
            .run(serviceResponse -> {
                List<ProMember> roles = proParameter.getObj()
                   .stream()
                   .map(proMemberRequest -> {
                       ProMember proMember = new ProMember();
                       BeanUtils.copyProperties(proMemberRequest, proMember);
                       mapper.insert(proMember);
                       return proMember;
                  }).collect(Collectors.toList());
               return roles;
            }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
              ProMemberRequest request = proParameter.getObj();
              if(request.getMemberId() != null){
                lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
              }
              if(!StringUtils.isEmpty(request.getMemberNo())){
                lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
              }
              if(!StringUtils.isEmpty(request.getNickName())){
                lambdaQueryWrapper.eq(ProMember::getNickName,request.getNickName());
              }
              if(!StringUtils.isEmpty(request.getUserName())){
                lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
              }
              if(!StringUtils.isEmpty(request.getPassWord())){
                lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
              }
              if(!StringUtils.isEmpty(request.getHeadPortrait())){
                lambdaQueryWrapper.eq(ProMember::getHeadPortrait,request.getHeadPortrait());
              }
              if(!StringUtils.isEmpty(request.getNtroduction())){
                lambdaQueryWrapper.eq(ProMember::getNtroduction,request.getNtroduction());
              }
              if(!StringUtils.isEmpty(request.getSex())){
                lambdaQueryWrapper.eq(ProMember::getSex,request.getSex());
              }
              if(!StringUtils.isEmpty(request.getAge())){
                lambdaQueryWrapper.eq(ProMember::getAge,request.getAge());
              }
              if(!StringUtils.isEmpty(request.getProvince())){
                lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
              }
              if(!StringUtils.isEmpty(request.getCity())){
                lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
              }
              if(!StringUtils.isEmpty(request.getArea())){
                lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
              }
              if(!StringUtils.isEmpty(request.getSchool())){
                lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
              }
              if(request.getLevelId() != null){
                lambdaQueryWrapper.eq(ProMember::getLevelId,request.getLevelId());
              }
              if(!StringUtils.isEmpty(request.getState())){
                lambdaQueryWrapper.eq(ProMember::getState,request.getState());
              }
              if(!StringUtils.isEmpty(request.getPayPassword())){
                lambdaQueryWrapper.eq(ProMember::getPayPassword,request.getPayPassword());
              }
              if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
                lambdaQueryWrapper.eq(ProMember::getWithdrawalPassword,request.getWithdrawalPassword());
              }
              if(request.getCreateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
              }
              if(request.getUpdateTime() != null){
                lambdaQueryWrapper.eq(ProMember::getUpdateTime,request.getUpdateTime());
              }
              return mapper.delete(lambdaQueryWrapper);
          }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMemberRequest> proParameter) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
               LambdaQueryWrapper<ProMember> queryWrapper = new LambdaQueryWrapper<>();
               ProMemberRequest request = proParameter.getObj();
               if(request.getMemberId() != null){
                  queryWrapper.in(ProMember::getMemberId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getMemberNo())){
                  queryWrapper.in(ProMember::getMemberNo,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getNickName())){
                  queryWrapper.in(ProMember::getNickName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getUserName())){
                  queryWrapper.in(ProMember::getUserName,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getPassWord())){
                  queryWrapper.in(ProMember::getPassWord,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getHeadPortrait())){
                  queryWrapper.in(ProMember::getHeadPortrait,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getNtroduction())){
                  queryWrapper.in(ProMember::getNtroduction,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getSex())){
                  queryWrapper.in(ProMember::getSex,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getAge())){
                  queryWrapper.in(ProMember::getAge,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getProvince())){
                  queryWrapper.in(ProMember::getProvince,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getCity())){
                  queryWrapper.in(ProMember::getCity,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getArea())){
                  queryWrapper.in(ProMember::getArea,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getSchool())){
                  queryWrapper.in(ProMember::getSchool,request.getIds());
               }
               if(request.getLevelId() != null){
                  queryWrapper.in(ProMember::getLevelId,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getState())){
                  queryWrapper.in(ProMember::getState,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getPayPassword())){
                  queryWrapper.in(ProMember::getPayPassword,request.getIds());
               }
               if(!StringUtils.isEmpty(request.getWithdrawalPassword())){
                  queryWrapper.in(ProMember::getWithdrawalPassword,request.getIds());
               }
               if(request.getCreateTime() != null){
                  queryWrapper.in(ProMember::getCreateTime,request.getIds());
               }
               if(request.getUpdateTime() != null){
                  queryWrapper.in(ProMember::getUpdateTime,request.getIds());
               }
              return mapper.delete(queryWrapper);
          }).exec();
    }
}

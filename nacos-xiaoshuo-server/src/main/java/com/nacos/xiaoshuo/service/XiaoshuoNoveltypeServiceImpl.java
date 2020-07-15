package com.nacos.xiaoshuo.service;
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
import com.nacos.xiaoshuo.dto.XiaoshuoNoveltype;
import com.nacos.xiaoshuo.request.XiaoshuoNoveltypeRequest;
import com.nacos.xiaoshuo.IXiaoshuoNoveltypeService;
import com.nacos.xiaoshuo.mapper.XiaoshuoNoveltypeMapper;

/**
 * <p>
    *
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-15
 */
@RestController
@Api(value = "XiaoshuoNoveltypeServiceImpl", description = "")
@SuppressWarnings("unchecked")
public class XiaoshuoNoveltypeServiceImpl implements IXiaoshuoNoveltypeService {

    @Resource
    XiaoshuoNoveltypeMapper mapper;

    @Override
    public ServiceResponse<XiaoshuoNoveltype> get(
        ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<XiaoshuoNoveltype>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<XiaoshuoNoveltype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    XiaoshuoNoveltypeRequest request = proParameter.getObj();
                    if(request.getId() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getId,request.getId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getName,request.getName());
                    }
                    if(request.getSort() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getSort,request.getSort());
                    }
                    if(request.getCreateTime() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getCreateTime,request.getCreateTime());
                    }
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<XiaoshuoNoveltype>> getList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<List<XiaoshuoNoveltype>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<XiaoshuoNoveltype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    XiaoshuoNoveltypeRequest request = proParameter.getObj();
                    if(request.getId() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getId,request.getId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                      lambdaQueryWrapper.like(XiaoshuoNoveltype::getName,request.getName());
                    }
                    if(request.getSort() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getSort,request.getSort());
                    }
                    if(request.getCreateTime() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(XiaoshuoNoveltype::getSort);
                    lambdaQueryWrapper.orderByDesc(XiaoshuoNoveltype::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<XiaoshuoNoveltype>> getPageList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<List<XiaoshuoNoveltype>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<XiaoshuoNoveltype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    XiaoshuoNoveltypeRequest request = proParameter.getObj();
                    if(request.getId() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getId,request.getId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                      lambdaQueryWrapper.like(XiaoshuoNoveltype::getName,request.getName());
                    }
                    if(request.getSort() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getSort,request.getSort());
                    }
                    if(request.getCreateTime() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(XiaoshuoNoveltype::getSort);
                    lambdaQueryWrapper.orderByDesc(XiaoshuoNoveltype::getCreateTime);
                    Page<XiaoshuoNoveltype> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<XiaoshuoNoveltype> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<XiaoshuoNoveltype>> findIdsList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<List<XiaoshuoNoveltype>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<XiaoshuoNoveltype> queryWrapper = new LambdaQueryWrapper<>();
                    XiaoshuoNoveltypeRequest request = proParameter.getObj();
                    if(request.getId() != null){
                      queryWrapper.in(XiaoshuoNoveltype::getId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                      queryWrapper.in(XiaoshuoNoveltype::getName,request.getIds());
                    }
                    if(request.getSort() != null){
                      queryWrapper.in(XiaoshuoNoveltype::getSort,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                      queryWrapper.in(XiaoshuoNoveltype::getCreateTime,request.getIds());
                    }
                      queryWrapper.orderByDesc(XiaoshuoNoveltype::getSort);
                      queryWrapper.orderByDesc(XiaoshuoNoveltype::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    XiaoshuoNoveltype bean = new XiaoshuoNoveltype();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<XiaoshuoNoveltype> save(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<XiaoshuoNoveltype>()
                .run(serviceResponse -> {
                    XiaoshuoNoveltype bean = new XiaoshuoNoveltype();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<XiaoshuoNoveltype>> batchSave(ProParameter<List<XiaoshuoNoveltypeRequest>> proParameter) {
       return new ServiceResponse<List<XiaoshuoNoveltype>>()
               .run(serviceResponse -> {
                   List<XiaoshuoNoveltype> roles = proParameter.getObj()
                       .stream()
                       .map(xiaoshuoNoveltypeRequest -> {
                            XiaoshuoNoveltype xiaoshuoNoveltype = new XiaoshuoNoveltype();
                            BeanUtils.copyProperties(xiaoshuoNoveltypeRequest, xiaoshuoNoveltype);
                            mapper.insert(xiaoshuoNoveltype);
                            return xiaoshuoNoveltype;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<XiaoshuoNoveltype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    XiaoshuoNoveltypeRequest request = proParameter.getObj();
                    if(request.getId() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getId,request.getId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getName,request.getName());
                    }
                    if(request.getSort() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getSort,request.getSort());
                    }
                    if(request.getCreateTime() != null){
                      lambdaQueryWrapper.eq(XiaoshuoNoveltype::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<XiaoshuoNoveltype> queryWrapper = new LambdaQueryWrapper<>();
                     XiaoshuoNoveltypeRequest request = proParameter.getObj();
                     if(request.getId() != null){
                        queryWrapper.in(XiaoshuoNoveltype::getId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getName())){
                        queryWrapper.in(XiaoshuoNoveltype::getName,request.getIds());
                     }
                     if(request.getSort() != null){
                        queryWrapper.in(XiaoshuoNoveltype::getSort,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                        queryWrapper.in(XiaoshuoNoveltype::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}

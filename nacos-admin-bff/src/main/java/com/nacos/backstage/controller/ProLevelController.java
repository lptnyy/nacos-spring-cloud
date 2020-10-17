package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.member.IProLevelService;
import com.nacos.member.dto.ProLevel;
import com.nacos.member.request.ProLevelRequest;
import com.nacos.backstage.vo.ProLevelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.seata.spring.annotation.GlobalTransactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
    * 会员等级 会员等级
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@RestController
@RequestMapping(value = "proLevel")
@Api(value = "ProLevelController", description = "会员等级 会员等级")
@SuppressWarnings("unchecked")
public class ProLevelController {

    @Autowired
    IProLevelService proLevelService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "会员等级 会员等级", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"level_select"})
    @SentinelResource(value = "proLevel/getPageList")
    public ServiceResponse<List<ProLevelVo>> getPageList(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<List<ProLevelVo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<ProLevel> resultList = proLevelService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProLevelVo> returnList = resultList.stream()
                .map(proLevel -> {
                    ProLevelVo proLevelvo = new ProLevelVo();
                    BeanUtils.copyProperties(proLevel,proLevelvo);
                    proLevelvo.setCreateTime(DateUtil.getyyMMddHHmmss(proLevel.getCreateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proLevelvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "会员等级 会员等级", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"level_select"})
    @SentinelResource(value = "proLevel/get")
    public ServiceResponse<ProLevelVo> get(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<ProLevelVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProLevel proLevel = proLevelService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProLevelVo proLevelVo = new ProLevelVo();
              BeanUtils.copyProperties(proLevel,proLevelVo);
              return proLevelVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "会员等级 会员等级", value = "保存", source = "admin-app")
    @Authority(values = {"level_add"})
    @SentinelResource(value = "proLevel/save")
    public ServiceResponse<ProLevelVo> save(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<ProLevelVo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProLevel proLevel = proLevelService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ProLevelVo proLevelVo = new ProLevelVo();
              BeanUtils.copyProperties(proLevel,proLevelVo);
              return proLevelVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "会员等级 会员等级", value = "批量删除", source = "admin-app")
    @Authority(values = {"level_del"})
    @SentinelResource(value = "proLevel/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.setLevelId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proLevelService
                  .idsDelete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "会员等级 会员等级", value = "删除", source = "admin-app")
    @Authority(values = {"level_del"})
    @SentinelResource(value = "proLevel/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proLevelService
                  .delete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "会员等级 会员等级", value = "修改", source = "admin-app")
    @Authority(values = {"level_update"})
    @SentinelResource(value = "proLevel/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProLevelRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proLevelService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}

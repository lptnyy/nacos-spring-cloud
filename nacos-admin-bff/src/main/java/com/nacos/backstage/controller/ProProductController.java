package com.nacos.backstage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.DateUtil;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import com.nacos.product.IProProductInfoService;
import com.nacos.product.IProProductService;
import com.nacos.product.IProProductTypeService;
import com.nacos.product.dto.ProProduct;
import com.nacos.product.dto.ProProductInfo;
import com.nacos.product.request.ProProductInfoRequest;
import com.nacos.product.request.ProProductRequest;
import com.nacos.backstage.vo.ProProductVo;
import com.nacos.product.request.ProProductTypeRequest;
import com.nacos.system.IProEnumService;
import com.nacos.system.request.ProEnumRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
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
    * 产品管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@RestController
@RequestMapping(value = "proProduct")
@Api(value = "ProProductController", description = "产品管理")
@SuppressWarnings("unchecked")
public class ProProductController {

    @Autowired
    IProProductService proProductService;

    @Autowired
    IProProductInfoService proProductInfoService;

    @Autowired
    IProEnumService proEnumService;

    @Autowired
    IProProductTypeService proProductTypeService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "产品管理", value = "分页查询列表", source = "admin-app")
    @Authority(values = {"product_select"})
    @SentinelResource(value = "proProduct/getPageList")
    public ServiceResponse<List<ProProductVo>> getPageList(@RequestBody ProProductRequest request) {
      return new ServiceResponse<List<ProProductVo>>()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<ProProduct> resultList = proProductService.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse)
                  .getObj();

              // 查询所有分类信息
              Map<Integer, String> types = new HashMap<>();
              List<Integer> ids = resultList.stream()
                  .map(proProduct -> {
                    return proProduct.getTypeId();
                  })
                  .distinct()
                  .collect(Collectors.toList());

              if (ids.size() > 0) {
                ProProductTypeRequest proProductTypeRequest = new ProProductTypeRequest();
                proProductTypeRequest.setTypeId(1);
                proProductTypeRequest.setIds(ids);
                proProductTypeService.findIdsList(new ProParameter<>(proProductTypeRequest))
                    .checkState()
                    .getObj()
                    .forEach(proProductType -> {
                      types.put(proProductType.getTypeId(), proProductType.getName());
                    });
              }

              // 获取产品状态枚举
              Map<Integer, String> productSts = new HashMap<>();
              ProEnumRequest proEnumRequest = new ProEnumRequest();
              proEnumRequest.setType("product_state");
              proEnumService.getList(new ProParameter<>(proEnumRequest))
                  .checkState()
                  .getObj()
                  .forEach(proEnum -> {
                    productSts.put(Integer.valueOf(proEnum.getValuestr()), proEnum.getKeystr());
                  });

              // 获取知否打折枚举
              Map<Integer, String> discountSts = new HashMap<>();
              proEnumRequest = new ProEnumRequest();
              proEnumRequest.setType("discount_sts");
              proEnumService.getList(new ProParameter<>(proEnumRequest))
                  .checkState()
                  .getObj()
                  .forEach(proEnum -> {
                    discountSts.put(Integer.valueOf(proEnum.getValuestr()), proEnum.getKeystr());
                  });

              // 获取是否积分兑换枚举
              Map<Integer, String> integralSts = new HashMap<>();
              proEnumRequest = new ProEnumRequest();
              proEnumRequest.setType("integral_sts");

              proEnumService.getList(new ProParameter<>(proEnumRequest))
                  .checkState()
                  .getObj()
                  .forEach(proEnum -> {
                    integralSts.put(Integer.valueOf(proEnum.getValuestr()), proEnum.getKeystr());
                  });

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<ProProductVo> returnList = resultList.stream()
                .map(proProduct -> {
                    ProProductVo proProductvo = new ProProductVo();
                    BeanUtils.copyProperties(proProduct,proProductvo);
                    proProductvo.setTypeName(types.get(proProductvo.getTypeId()));
                    proProductvo.setDiscountStsStr(discountSts.get(proProductvo.getDiscountSts()));
                    proProductvo.setStateStr(productSts.get(proProductvo.getState()));
                    proProductvo.setIntegralStsStr(integralSts.get(proProductvo.getIntegralSts()));
                    proProductvo.setCreateTime(DateUtil.getyyMMddHHmmss(proProduct.getCreateTime()));
                    proProductvo.setUpdateTime(DateUtil.getyyMMddHHmmss(proProduct.getUpdateTime()));
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return proProductvo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "产品管理", value = "获取单条信息", source = "admin-app")
    @Authority(values = {"product_select"})
    @SentinelResource(value = "proProduct/get")
    public ServiceResponse<ProProductVo> get(@RequestBody ProProductRequest request) {
      return new ServiceResponse<ProProductVo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ProProduct proProduct = proProductService
                  .get(new ProParameter<>(request))
                  .checkState()
                  .getObj();

              // 获取详情信息
              ProProductInfoRequest proProductInfoRequest = new ProProductInfoRequest();
              proProductInfoRequest.setProductId(proProduct.getProductId());
              ProProductInfo proProductInfo = proProductInfoService.get(new ProParameter<>(proProductInfoRequest))
                  .checkState()
                  .getObj();

              // 组装返回的vo
              ProProductVo proProductVo = new ProProductVo();
              proProductVo.setIntroduce(proProductInfo.getIntroduce());
              proProductVo.setImages(proProductInfo.getImgs());
              BeanUtils.copyProperties(proProduct,proProductVo);
              return proProductVo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "产品管理", value = "保存", source = "admin-app")
    @Authority(values = {"product_add"})
    @SentinelResource(value = "proProduct/save")
    public ServiceResponse<ProProductVo> save(@RequestBody ProProductRequest request) {
      return new ServiceResponse<ProProductVo>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ProProduct proProduct = proProductService
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 保存详情数据
              ProProductInfoRequest proProductInfoRequest = new ProProductInfoRequest();
              proProductInfoRequest.setImgs(request.getImages());
              proProductInfoRequest.setProductId(proProduct.getProductId());
              proProductInfoRequest.setIntroduce(request.getIntroduce());
              proProductInfoService.save(new ProParameter<>(proProductInfoRequest))
                  .checkState();

              // 获取返回数据9
              ProProductVo proProductVo = new ProProductVo();
              BeanUtils.copyProperties(proProduct,proProductVo);
              return proProductVo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "产品管理", value = "批量删除", source = "admin-app")
    @Authority(values = {"product_del"})
    @SentinelResource(value = "proProduct/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProProductRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 标记通过enumid删除
              request.setProductId(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proProductService
                  .idsDelete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "产品管理", value = "删除", source = "admin-app")
    @Authority(values = {"product_del"})
    @SentinelResource(value = "proProduct/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProProductRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return proProductService
                  .delete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "产品管理", value = "修改", source = "admin-app")
    @Authority(values = {"product_update"})
    @SentinelResource(value = "proProduct/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProProductRequest request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              Integer resultNum = proProductService
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 保存详情数据
              ProProductInfoRequest proProductInfoRequest = new ProProductInfoRequest();
              proProductInfoRequest.setImgs(request.getImages());
              proProductInfoRequest.setProductId(request.getProductId());
              proProductInfoRequest.setIntroduce(request.getIntroduce());
              proProductInfoService.update(new ProParameter<>(proProductInfoRequest))
                  .checkState();

              return resultNum;
          })
          .exec();
    }

  @PostMapping(value = "/updateState")
  @ApiOperation(value = "修改")
  @Log(name = "产品管理", value = "修改", source = "admin-app")
  @Authority(values = {"product_update"})
  @SentinelResource(value = "proProduct/updateState")
  @GlobalTransactional
  public ServiceResponse<Integer> updateState(@RequestBody ProProductRequest request) {
    return new ServiceResponse<Integer>()
        .beginTransaction()
        .run(serviceResponse -> {

          // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
          Integer resultNum = proProductService
              .update(new ProParameter<>(request))
              .beginTransaction()
              .checkState()
              .getObj();
          return resultNum;
        })
        .exec();
  }
}

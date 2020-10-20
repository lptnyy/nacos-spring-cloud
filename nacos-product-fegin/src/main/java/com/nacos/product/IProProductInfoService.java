package com.nacos.product;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.nacos.product.dto.ProProductInfo;
import com.nacos.product.request.ProProductInfoRequest;
import com.nacos.product.hystrix.ProProductInfoServiceHystrix;

/**
 * <p>
    * 产品详情
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@FeignClient(value = "product-service", configuration = FeignRequestInterceptor.class,fallback = ProProductInfoServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProProductInfoService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/getUser", method = RequestMethod.POST)
    ServiceResponse<ProProductInfo> get(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductInfo>> getList(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductInfo>> getPageList(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductInfo>> findIdsList(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/save", method = RequestMethod.POST)
    ServiceResponse<ProProductInfo> save(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductInfo/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(
        @RequestBody ProParameter<ProProductInfoRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProProductInfo/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProProductInfo>> batchSave(
        @RequestBody ProParameter<List<ProProductInfoRequest>> proParameter);
}

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
import com.nacos.product.dto.ProProductType;
import com.nacos.product.request.ProProductTypeRequest;
import com.nacos.product.hystrix.ProProductTypeServiceHystrix;

/**
 * <p>
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@FeignClient(value = "product-service", configuration = FeignRequestInterceptor.class,fallback = ProProductTypeServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProProductTypeService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProProductType/getUser", method = RequestMethod.POST)
    ServiceResponse<ProProductType> get(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProProductType/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductType>> getList(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProProductType/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductType>> getPageList(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProProductType/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProProductType>> findIdsList(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductType/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductType/save", method = RequestMethod.POST)
    ServiceResponse<ProProductType> save(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductType/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProductType/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(
        @RequestBody ProParameter<ProProductTypeRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProProductType/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProProductType>> batchSave(
        @RequestBody ProParameter<List<ProProductTypeRequest>> proParameter);
}

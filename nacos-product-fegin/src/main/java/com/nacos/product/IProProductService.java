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
import com.nacos.product.dto.ProProduct;
import com.nacos.product.request.ProProductRequest;
import com.nacos.product.hystrix.ProProductServiceHystrix;

/**
 * <p>
    * 产品管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@FeignClient(value = "product-service", configuration = FeignRequestInterceptor.class,fallback = ProProductServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProProductService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProProduct/getUser", method = RequestMethod.POST)
    ServiceResponse<ProProduct> get(@RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProProduct/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProProduct>> getList(
        @RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProProduct/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProProduct>> getPageList(
        @RequestBody ProParameter<ProProductRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProProduct/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProProduct>> findIdsList(
        @RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProduct/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProduct/save", method = RequestMethod.POST)
    ServiceResponse<ProProduct> save(@RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProduct/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProduct/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProProductRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProProduct/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProProduct>> batchSave(
        @RequestBody ProParameter<List<ProProductRequest>> proParameter);
}

package com.nacos.system;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.nacos.system.dto.ProProvince;
import com.nacos.system.request.ProProvinceRequest;
import com.nacos.system.hystrix.ProProvinceServiceHystrix;

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProProvinceServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProProvinceService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProProvince/getUser", method = RequestMethod.POST)
    ServiceResponse<ProProvince> get(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProProvince/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProProvince>> getList(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProProvince/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProProvince>> getPageList(@RequestBody ProParameter<ProProvinceRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProProvince/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProProvince>> findIdsList(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProvince/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProvince/save", method = RequestMethod.POST)
    ServiceResponse<ProProvince> save(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProvince/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProProvince/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProProvinceRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProProvince/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProProvince>> batchSave(@RequestBody ProParameter<List<ProProvinceRequest>> proParameter);
}

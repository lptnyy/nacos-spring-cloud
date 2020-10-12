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
import com.nacos.system.dto.ProCity;
import com.nacos.system.request.ProCityRequest;
import com.nacos.system.hystrix.ProCityServiceHystrix;

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProCityServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProCityService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProCity/getUser", method = RequestMethod.POST)
    ServiceResponse<ProCity> get(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProCity/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProCity>> getList(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProCity/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProCity>> getPageList(@RequestBody ProParameter<ProCityRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProCity/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProCity>> findIdsList(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProCity/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProCity/save", method = RequestMethod.POST)
    ServiceResponse<ProCity> save(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProCity/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProCity/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProCityRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProCity/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProCity>> batchSave(@RequestBody ProParameter<List<ProCityRequest>> proParameter);
}

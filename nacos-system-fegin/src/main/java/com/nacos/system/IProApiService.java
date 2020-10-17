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
import com.nacos.system.dto.ProApi;
import com.nacos.system.request.ProApiRequest;
import com.nacos.system.hystrix.ProApiServiceHystrix;

/**
 * <p>
    * api管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProApiServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProApiService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProApi/getUser", method = RequestMethod.POST)
    ServiceResponse<ProApi> get(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProApi/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProApi>> getList(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProApi/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProApi>> getPageList(@RequestBody ProParameter<ProApiRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProApi/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProApi>> findIdsList(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApi/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApi/save", method = RequestMethod.POST)
    ServiceResponse<ProApi> save(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApi/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApi/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProApiRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProApi/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProApi>> batchSave(
        @RequestBody ProParameter<List<ProApiRequest>> proParameter);
}

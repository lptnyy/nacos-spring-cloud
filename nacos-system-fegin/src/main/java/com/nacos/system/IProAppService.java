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
import com.nacos.system.dto.ProApp;
import com.nacos.system.request.ProAppRequest;
import com.nacos.system.hystrix.ProAppServiceHystrix;

/**
 * <p>
    * 应用管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-19
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProAppServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProAppService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProApp/getUser", method = RequestMethod.POST)
    ServiceResponse<ProApp> get(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProApp/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProApp>> getList(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProApp/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProApp>> getPageList(@RequestBody ProParameter<ProAppRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProApp/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProApp>> findIdsList(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApp/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApp/save", method = RequestMethod.POST)
    ServiceResponse<ProApp> save(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApp/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProApp/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProAppRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProApp/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProApp>> batchSave(@RequestBody ProParameter<List<ProAppRequest>> proParameter);
}

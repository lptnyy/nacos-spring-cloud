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
import com.nacos.system.dto.ProArea;
import com.nacos.system.request.ProAreaRequest;
import com.nacos.system.hystrix.ProAreaServiceHystrix;

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProAreaServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProAreaService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProArea/getUser", method = RequestMethod.POST)
    ServiceResponse<ProArea> get(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProArea/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProArea>> getList(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProArea/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProArea>> getPageList(@RequestBody ProParameter<ProAreaRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProArea/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProArea>> findIdsList(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProArea/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProArea/save", method = RequestMethod.POST)
    ServiceResponse<ProArea> save(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProArea/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProArea/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProAreaRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProArea/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProArea>> batchSave(@RequestBody ProParameter<List<ProAreaRequest>> proParameter);
}

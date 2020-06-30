package com.nacos.system;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.dto.ProEnum;
import com.nacos.system.hystrix.ProEnumServiceHystrix;
import com.nacos.system.request.ProEnumRequest;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
    * 枚举表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProEnumServiceHystrix.class)
public interface IProEnumService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProEnum/getUser", method = RequestMethod.POST)
    ServiceResponse<ProEnum> get(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> getList(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> getPageList(
        @RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> findIdsList(
        @RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/save", method = RequestMethod.POST)
    ServiceResponse<ProEnum> save(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProEnumRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProEnum/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> batchSave(
        @RequestBody ProParameter<List<ProEnumRequest>> proParameter) throws Exception;
}

package com.nacos.business;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.nacos.business.dto.ProBusinessType;
import com.nacos.business.request.ProBusinessTypeRequest;
import com.nacos.business.hystrix.ProBusinessTypeServiceHystrix;

/**
 * <p>
    * 商家类型
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@FeignClient(value = "business-service", configuration = FeignRequestInterceptor.class,fallback = ProBusinessTypeServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProBusinessTypeService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/getUser", method = RequestMethod.POST)
    ServiceResponse<ProBusinessType> get(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusinessType>> getList(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusinessType>> getPageList(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusinessType>> findIdsList(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 批量修改
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/batchUpdate", method = RequestMethod.POST)
    ServiceResponse<List<ProBusinessType>> batchUpdate(@RequestBody ProParameter<List<ProBusinessTypeRequest>> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/save", method = RequestMethod.POST)
    ServiceResponse<ProBusinessType> save(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusinessType/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(
        @RequestBody ProParameter<ProBusinessTypeRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProBusinessType/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProBusinessType>> batchSave(
        @RequestBody ProParameter<List<ProBusinessTypeRequest>> proParameter);
}

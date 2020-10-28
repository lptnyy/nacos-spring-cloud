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
import com.nacos.business.dto.ProBusiness;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.business.hystrix.ProBusinessServiceHystrix;

/**
 * <p>
    * 商家信息表
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-29
 */
@FeignClient(value = "business-service", configuration = FeignRequestInterceptor.class,fallback = ProBusinessServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProBusinessService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProBusiness/getUser", method = RequestMethod.POST)
    ServiceResponse<ProBusiness> get(@RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProBusiness/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusiness>> getList(
        @RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProBusiness/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusiness>> getPageList(
        @RequestBody ProParameter<ProBusinessRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProBusiness/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProBusiness>> findIdsList(
        @RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusiness/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 批量修改数据
     * @param proParameter
     * @return
     */
     @RequestMapping(path = "/ProBusiness/batchUpdate", method = RequestMethod.POST)
     ServiceResponse<List<ProBusiness>> batchUpdate(
         @RequestBody ProParameter<List<ProBusinessRequest>> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusiness/save", method = RequestMethod.POST)
    ServiceResponse<ProBusiness> save(@RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusiness/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProBusiness/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProBusinessRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProBusiness/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProBusiness>> batchSave(
        @RequestBody ProParameter<List<ProBusinessRequest>> proParameter);
}

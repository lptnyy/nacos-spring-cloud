package com.nacos.system;

import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.dto.ProMenu;
import com.nacos.system.hystrix.ProMenuServiceHystrix;
import com.nacos.system.request.ProMenuRequest;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
    * 菜单表
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-04
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProMenuServiceHystrix.class)
public interface IProMenuService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProMenu/getUser", method = RequestMethod.POST)
    ServiceResponse<ProMenu> get(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProMenu/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProMenu>> getList(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProMenu/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProMenu>> getPageList(
        @RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProMenu/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProMenu>> findIdsList(
        @RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMenu/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMenu/save", method = RequestMethod.POST)
    ServiceResponse<ProMenu> save(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMenu/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMenu/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProMenuRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProMenu/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProMenu>> batchSave(
        @RequestBody ProParameter<List<ProMenuRequest>> proParameter) throws Exception;
}

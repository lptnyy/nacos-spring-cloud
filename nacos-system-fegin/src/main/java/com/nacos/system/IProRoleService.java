package com.nacos.system;

import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.dto.ProRole;
import com.nacos.system.hystrix.ProRoleServiceHystrix;
import com.nacos.system.request.ProRoleRequest;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
    * 系统角色表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProRoleServiceHystrix.class)
public interface IProRoleService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProRole/getUser", method = RequestMethod.POST)
    ServiceResponse<ProRole> get(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProRole/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProRole>> getList(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProRole/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProRole>> getPageList(
        @RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProRole/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProRole>> findIdsList(
        @RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRole/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRole/save", method = RequestMethod.POST)
    ServiceResponse<ProRole> save(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRole/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRole/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProRoleRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRole/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProRole>> batchSave(ProParameter<List<ProRoleRequest>> proParameter) throws Exception;
}

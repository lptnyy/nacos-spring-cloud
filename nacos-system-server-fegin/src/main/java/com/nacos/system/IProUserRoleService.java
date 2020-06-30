package com.nacos.system;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.dto.ProUserRole;
import com.nacos.system.hystrix.ProUserRoleServiceHystrix;
import com.nacos.system.request.ProUserRoleRequest;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
    * 用户角色关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProUserRoleServiceHystrix.class)
public interface IProUserRoleService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getUser", method = RequestMethod.POST)
    ServiceResponse<ProUserRole> get(@RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> getList(
        @RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> getPageList(
        @RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> findIdsList(
        @RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/save", method = RequestMethod.POST)
    ServiceResponse<ProUserRole> save(@RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProUserRoleRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProUserRole/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> batchSave(
        @RequestBody ProParameter<List<ProUserRoleRequest>> proParameter) throws Exception;
}

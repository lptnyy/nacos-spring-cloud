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
import com.nacos.system.dto.ProSchool;
import com.nacos.system.request.ProSchoolRequest;
import com.nacos.system.hystrix.ProSchoolServiceHystrix;

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProSchoolServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProSchoolService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProSchool/getUser", method = RequestMethod.POST)
    ServiceResponse<ProSchool> get(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProSchool/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProSchool>> getList(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProSchool/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProSchool>> getPageList(@RequestBody ProParameter<ProSchoolRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProSchool/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProSchool>> findIdsList(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProSchool/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProSchool/save", method = RequestMethod.POST)
    ServiceResponse<ProSchool> save(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProSchool/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProSchool/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProSchoolRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProSchool/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProSchool>> batchSave(@RequestBody ProParameter<List<ProSchoolRequest>> proParameter);
}

package com.nacos.member;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.nacos.member.dto.ProLevel;
import com.nacos.member.request.ProLevelRequest;
import com.nacos.member.hystrix.ProLevelServiceHystrix;

/**
 * <p>
    * 会员等级 会员等级
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@FeignClient(value = "member-service", configuration = FeignRequestInterceptor.class,fallback = ProLevelServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IProLevelService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProLevel/getUser", method = RequestMethod.POST)
    ServiceResponse<ProLevel> get(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProLevel/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProLevel>> getList(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProLevel/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProLevel>> getPageList(
        @RequestBody ProParameter<ProLevelRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProLevel/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProLevel>> findIdsList(
        @RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLevel/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLevel/save", method = RequestMethod.POST)
    ServiceResponse<ProLevel> save(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLevel/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLevel/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProLevelRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProLevel/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProLevel>> batchSave(
        @RequestBody ProParameter<List<ProLevelRequest>> proParameter);
}

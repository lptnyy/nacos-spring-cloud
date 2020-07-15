package com.nacos.xiaoshuo;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.nacos.xiaoshuo.dto.XiaoshuoNoveltype;
import com.nacos.xiaoshuo.request.XiaoshuoNoveltypeRequest;
import com.nacos.xiaoshuo.hystrix.XiaoshuoNoveltypeServiceHystrix;

/**
 * <p>
    *
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-15
 */
@FeignClient(value = "xiaoshuo-service", configuration = FeignRequestInterceptor.class,fallback = XiaoshuoNoveltypeServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface IXiaoshuoNoveltypeService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/getUser", method = RequestMethod.POST)
    ServiceResponse<XiaoshuoNoveltype> get(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/getList", method = RequestMethod.POST)
    ServiceResponse<List<XiaoshuoNoveltype>> getList(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<XiaoshuoNoveltype>> getPageList(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<XiaoshuoNoveltype>> findIdsList(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/save", method = RequestMethod.POST)
    ServiceResponse<XiaoshuoNoveltype> save(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/XiaoshuoNoveltype/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(
        @RequestBody ProParameter<XiaoshuoNoveltypeRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/XiaoshuoNoveltype/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<XiaoshuoNoveltype>> batchSave(
        @RequestBody ProParameter<List<XiaoshuoNoveltypeRequest>> proParameter);
}

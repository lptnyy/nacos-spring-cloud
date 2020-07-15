package com.nacos.xiaoshuo.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.xiaoshuo.dto.XiaoshuoNoveltype;
import com.nacos.xiaoshuo.request.XiaoshuoNoveltypeRequest;
import com.nacos.xiaoshuo.IXiaoshuoNoveltypeService;

/**
 * <p>
    *
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-15
 */
@Component
@SuppressWarnings("unchecked")
public class XiaoshuoNoveltypeServiceHystrix implements IXiaoshuoNoveltypeService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<XiaoshuoNoveltype> get(
        ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<XiaoshuoNoveltype>> getList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<XiaoshuoNoveltype>> getPageList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<XiaoshuoNoveltype>> findIdsList(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<XiaoshuoNoveltype> save(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<XiaoshuoNoveltypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<XiaoshuoNoveltype>> batchSave(ProParameter<List<XiaoshuoNoveltypeRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

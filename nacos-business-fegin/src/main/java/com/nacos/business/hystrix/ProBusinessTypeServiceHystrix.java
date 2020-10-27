package com.nacos.business.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.business.dto.ProBusinessType;
import com.nacos.business.request.ProBusinessTypeRequest;
import com.nacos.business.IProBusinessTypeService;

/**
 * <p>
    * 商家类型
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@Component
@SuppressWarnings("unchecked")
public class ProBusinessTypeServiceHystrix implements IProBusinessTypeService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProBusinessType> get(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProBusinessType>> getList(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProBusinessType>> getPageList(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProBusinessType>> findIdsList(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProBusinessType>> batchUpdate(
        ProParameter<List<ProBusinessTypeRequest>> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProBusinessType> save(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProBusinessTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProBusinessType>> batchSave(ProParameter<List<ProBusinessTypeRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

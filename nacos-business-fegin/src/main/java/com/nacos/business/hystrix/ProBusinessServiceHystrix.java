package com.nacos.business.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.business.dto.ProBusiness;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.business.IProBusinessService;

/**
 * <p>
    * 商家信息表
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-29
 */
@Component
@SuppressWarnings("unchecked")
public class ProBusinessServiceHystrix implements IProBusinessService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProBusiness> get(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProBusiness>> getList(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProBusiness>> getPageList(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProBusiness>> findIdsList(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<List<ProBusiness>> batchUpdate(
        ProParameter<List<ProBusinessRequest>> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProBusiness> save(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProBusinessRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProBusiness>> batchSave(ProParameter<List<ProBusinessRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

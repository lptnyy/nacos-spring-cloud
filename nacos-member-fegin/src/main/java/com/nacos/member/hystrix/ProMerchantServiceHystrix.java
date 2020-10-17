package com.nacos.member.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.member.dto.ProMerchant;
import com.nacos.member.request.ProMerchantRequest;
import com.nacos.member.IProMerchantService;

/**
 * <p>
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@Component
@SuppressWarnings("unchecked")
public class ProMerchantServiceHystrix implements IProMerchantService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProMerchant> get(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> getList(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> getPageList(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> findIdsList(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProMerchant> save(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMerchantRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProMerchant>> batchSave(ProParameter<List<ProMerchantRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

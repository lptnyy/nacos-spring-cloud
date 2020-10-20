package com.nacos.product.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.product.dto.ProProductType;
import com.nacos.product.request.ProProductTypeRequest;
import com.nacos.product.IProProductTypeService;

/**
 * <p>
    * 产品分类 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Component
@SuppressWarnings("unchecked")
public class ProProductTypeServiceHystrix implements IProProductTypeService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProProductType> get(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProProductType>> getList(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProProductType>> getPageList(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProProductType>> findIdsList(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProProductType> save(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProductTypeRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProProductType>> batchSave(ProParameter<List<ProProductTypeRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.system.dto.ProProvince;
import com.nacos.system.request.ProProvinceRequest;
import com.nacos.system.IProProvinceService;

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@Component
@SuppressWarnings("unchecked")
public class ProProvinceServiceHystrix implements IProProvinceService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProProvince> get(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProProvince>> getList(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProProvince>> getPageList(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProProvince>> findIdsList(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProProvince> save(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProProvinceRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProProvince>> batchSave(ProParameter<List<ProProvinceRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

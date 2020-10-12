package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.system.dto.ProArea;
import com.nacos.system.request.ProAreaRequest;
import com.nacos.system.IProAreaService;

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
public class ProAreaServiceHystrix implements IProAreaService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProArea> get(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProArea>> getList(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProArea>> getPageList(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProArea>> findIdsList(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProArea> save(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProAreaRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProArea>> batchSave(ProParameter<List<ProAreaRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProLogService;
import com.nacos.system.dto.ProLog;
import com.nacos.system.request.ProLogRequest;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <p>
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-07
 */
@Component
public class ProLogServiceHystrix implements IProLogService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProLog> get(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProLog>> getList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProLog>> getPageList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProLog>> findIdsList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProLog> save(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProLogRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProLog>> batchSave(ProParameter<List<ProLogRequest>> proParameter) throws Exception {
         return ServiceResponse.getFAIL();
     }
}

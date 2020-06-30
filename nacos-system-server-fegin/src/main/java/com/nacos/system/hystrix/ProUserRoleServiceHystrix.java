package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProUserRoleService;
import com.nacos.system.dto.ProUserRole;
import com.nacos.system.request.ProUserRoleRequest;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <p>
    * 用户角色关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@Component
public class ProUserRoleServiceHystrix implements IProUserRoleService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProUserRole> get(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProUserRole>> getList(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProUserRole>> getPageList(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProUserRole>> findIdsList(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProUserRole> save(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProUserRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProUserRole>> batchSave(ProParameter<List<ProUserRoleRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProRoleService;
import com.nacos.system.dto.ProRole;
import com.nacos.system.request.ProRoleRequest;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <p>
    * 系统角色表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@Component
public class ProRoleServiceHystrix implements IProRoleService {

    /**
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProRole> get(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProRole>> getList(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProRole>> getPageList(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProRole>> findIdsList(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProRole> save(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProRoleRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
    public ServiceResponse<List<ProRole>> batchSave(ProParameter<List<ProRoleRequest>> proParameter) {
        return ServiceResponse.getFAIL();
    }
}

package com.nacos.system.hystrix;

import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProRoleMenuService;
import com.nacos.system.dto.ProRoleMenu;
import com.nacos.system.request.ProRoleMenuRequest;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-19
 */
@Component
public class ProRoleMenuServiceHystrix implements IProRoleMenuService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProRoleMenu> get(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProRoleMenu>> getList(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProRoleMenu>> getPageList(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProRoleMenu>> findIdsList(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProRoleMenu> save(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProRoleMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<Integer> batchSave(ProParameter<List<ProRoleMenuRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

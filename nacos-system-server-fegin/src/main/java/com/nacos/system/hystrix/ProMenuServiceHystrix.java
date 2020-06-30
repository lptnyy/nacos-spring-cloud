package com.nacos.system.hystrix;

import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProMenuService;
import com.nacos.system.dto.ProMenu;
import com.nacos.system.request.ProMenuRequest;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * <p>
    * 菜单表
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-04
 */
@Component
public class ProMenuServiceHystrix implements IProMenuService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProMenu> get(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProMenu>> getList(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProMenu>> getPageList(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProMenu>> findIdsList(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProMenu> save(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMenuRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProMenu>> batchSave(ProParameter<List<ProMenuRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

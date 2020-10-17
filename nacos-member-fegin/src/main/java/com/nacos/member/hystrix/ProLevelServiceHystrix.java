package com.nacos.member.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.member.dto.ProLevel;
import com.nacos.member.request.ProLevelRequest;
import com.nacos.member.IProLevelService;

/**
 * <p>
    * 会员等级 会员等级
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@Component
@SuppressWarnings("unchecked")
public class ProLevelServiceHystrix implements IProLevelService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProLevel> get(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProLevel>> getList(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProLevel>> getPageList(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProLevel>> findIdsList(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProLevel> save(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProLevelRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProLevel>> batchSave(ProParameter<List<ProLevelRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

package com.nacos.member.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.nacos.member.dto.ProMember;
import com.nacos.member.request.ProMemberRequest;
import com.nacos.member.IProMemberService;

/**
 * <p>
    * 会员表 会员
    * </p>
 *
 * @author 王振宇
 * @since 2020-09-15
 */
@Component
@SuppressWarnings("unchecked")
public class ProMemberServiceHystrix implements IProMemberService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProMember> get(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProMember>> getList(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProMember>> getPageList(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProMember>> findIdsList(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProMember> save(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMemberRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProMember>> batchSave(ProParameter<List<ProMemberRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}

package com.nacos.system.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.UserService;
import com.nacos.system.dto.ProUser;
import com.nacos.system.request.User;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public ServiceResponse<ProUser> userNameGetUser(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getPageList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> findIdsList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> save(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }
}

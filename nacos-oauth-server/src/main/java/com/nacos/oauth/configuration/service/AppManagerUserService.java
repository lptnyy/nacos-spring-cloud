package com.nacos.oauth.configuration.service;
import com.nacos.common.method.ProParameter;
import com.nacos.common.oauth.VaRole;
import com.nacos.common.oauth.VaUser;
import com.nacos.common.util.ServiceResponse;
import com.nacos.system.IProAppService;
import com.nacos.system.dto.ProApp;
import com.nacos.system.request.ProAppRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service(value = "appManagerUserService")
@Slf4j
public class AppManagerUserService implements UserDetailsService {

    @Autowired
    IProAppService proAppService;

    @Override
    public UserDetails loadUserByUsername(String appKey) throws UsernameNotFoundException {
        try {
            ProAppRequest appRequest = new ProAppRequest();
            appRequest.setAppKey(appKey);
            ServiceResponse<ProApp> response = proAppService.get(new ProParameter<>(appRequest));
            response.checkState();
            ProApp proApp = response.getObj();
            VaUser vaUser = new VaUser(proApp.getAppKey());
            vaUser.setPassword(proApp.getAppSecret());
            List<VaRole> roleList = new ArrayList();
            VaRole vaRole = new VaRole();
            vaRole.setId(1);
            vaRole.setName("admin");
            roleList.add(vaRole);
            vaUser.setRoles(roleList);
            return vaUser;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}

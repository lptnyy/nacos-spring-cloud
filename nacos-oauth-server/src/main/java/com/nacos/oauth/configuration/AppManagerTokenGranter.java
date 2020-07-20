package com.nacos.oauth.configuration;
import com.nacos.oauth.configuration.exception.ProOAuth2Exception;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import java.util.LinkedHashMap;
import java.util.Map;

public class AppManagerTokenGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = "app_code";

    private final AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    public AppManagerTokenGranter(
            AuthenticationManager authenticationManager,
            AuthorizationServerTokenServices tokenServices,
            ClientDetailsService clientDetailsService,
            OAuth2RequestFactory requestFactory,
            UserDetailsService userDetailsService) {
        this(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.userDetailsService = userDetailsService;
    }

    protected AppManagerTokenGranter(
            AuthenticationManager authenticationManager,
            AuthorizationServerTokenServices tokenServices,
            ClientDetailsService clientDetailsService,
            OAuth2RequestFactory requestFactory,
            String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());
        String appKey = parameters.get("appKey");
        String appSecret = parameters.get("appSecret");
        parameters.remove("appSecret");
        UserDetails userDetails = userDetailsService.loadUserByUsername(appKey);
        if (userDetails == null) {
            throw new ProOAuth2Exception("此appKey不存在");
        }
        if (!userDetails.getPassword().equals(appSecret)) {
            throw new ProOAuth2Exception("appSecret错误");
        }
        Authentication userAuth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, userAuth);
    }
}

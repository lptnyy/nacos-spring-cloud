package com.nacos.oss.base;
import com.nacos.oss.configuration.OssConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OssFactory {

    @Autowired
    OssConfiguration ossConfiguration;

    /**
     * 通过spring 自定装配
     * @return
     */
    @Bean
    public Oss createOss() {
        Oss oss = null;
        switch (ossConfiguration.getType()) {
            case "ali":
                oss = new AliOss();
                oss.setConfiguration(ossConfiguration);
                break;
            case "file":
                oss = new FileOss();
                oss.setConfiguration(ossConfiguration);
                break;
            case "tx":
                oss = new TxOss();
                oss.setConfiguration(ossConfiguration);
                break;
            default:
                log.error("type字段配置错误，无法初始化。");
        }
        return oss;
    }
}

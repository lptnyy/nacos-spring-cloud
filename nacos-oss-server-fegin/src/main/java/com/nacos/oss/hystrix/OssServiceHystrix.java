package com.nacos.oss.hystrix;
import com.nacos.common.util.ServiceResponse;
import com.nacos.oss.OssService;
import com.nacos.oss.dto.FIleVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class OssServiceHystrix implements OssService {

    @Override
    public ServiceResponse<FIleVo> uploadMultipartFile(MultipartFile file) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ResponseEntity<byte[]> download(String path) {
        return null;
    }
}

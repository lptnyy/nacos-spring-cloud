package com.nacos.oss;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.util.ServiceResponse;
import com.nacos.oss.dto.FIleVo;
import com.nacos.oss.hystrix.OssServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "oss-service", configuration = FeignRequestInterceptor.class, fallback = OssServiceHystrix.class)
public interface OssService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(path = "/file/uploadMultipartFile", method = RequestMethod.POST)
    ServiceResponse<FIleVo> uploadMultipartFile(
        @RequestPart(value = "file", required = false) MultipartFile file) throws Exception;

    /**
     * 下载文件
     * @param path
     * @return
     */
    @RequestMapping(path = "/file/download", method = RequestMethod.GET)
    ResponseEntity<byte[]> download(@RequestParam(value = "path") String path) throws Exception;
}

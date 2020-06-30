package com.nacos.oss.base;
import com.nacos.oss.configuration.OssConfiguration;
import com.nacos.oss.dto.FIleVo;
import org.springframework.web.multipart.MultipartFile;

public interface Oss {

    /**
     * 上传配置
     */
    void setConfiguration(OssConfiguration ossConfiguration);

    /**
     * 上传文件
     * @return
     */
    FIleVo upload(MultipartFile file);

    /**
     * 上传文件
     * @return
     */
    FIleVo upload(byte[] fileBytes, String fileName);

    /**
     * 读取文件
     * @param fIleVo
     * @return
     */
    FIleVo readFile(FIleVo fIleVo);
}

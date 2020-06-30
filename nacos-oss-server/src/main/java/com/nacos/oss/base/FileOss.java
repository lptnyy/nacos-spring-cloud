package com.nacos.oss.base;
import com.nacos.oss.base.util.FIleUtil;
import com.nacos.oss.configuration.OssConfiguration;
import com.nacos.oss.dto.FIleVo;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 本地缓存实现
 */
public class FileOss implements Oss {
    FIleUtil fileUtil;
    OssConfiguration ossConfiguration;

    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        fileUtil = new FIleUtil();
        fileUtil.setOssConfiguration(ossConfiguration);
        this.ossConfiguration = ossConfiguration;
    }

    @Override
    public FIleVo upload(MultipartFile file) {
        return fileUtil.saveFileCache(file);
    }

    @Override
    public FIleVo upload(byte[] fileBytes, String fileName) {
        return null;
    }

    @Override
    public FIleVo readFile(FIleVo fIleVo) {
        try {
            return fileUtil.readFileCache(fIleVo.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

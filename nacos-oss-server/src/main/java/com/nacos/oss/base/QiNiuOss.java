package com.nacos.oss.base;
import com.nacos.common.util.Md5Util;
import com.nacos.common.util.RandomUtil;
import com.nacos.common.util.StringUtil;
import com.nacos.oss.configuration.OssConfiguration;
import com.nacos.oss.dto.FIleVo;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QiNiuOss implements Oss{
    String endpoint = "";
    String accessKeyId = "";
    String accessKeySecret = "";
    String bucket = "";
    String upToken = "";

    @Autowired
    OssConfiguration ossConfiguration;


    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        this.endpoint = ossConfiguration.getEndpoint();
        this.accessKeyId = ossConfiguration.getAccessKeyId();
        this.accessKeySecret = ossConfiguration.getAccessKeySecret();
        this.bucket = ossConfiguration.getBucketName();
    }

    /**
     * 初始化map
     */
    public final static Map<String,Object> regionMaps = new HashMap<String,Object>(){
        {
            put("华东",Region.region0());
            put("华北",Region.region1());
            put("华南",Region.region2());
            put("北美",Region.regionNa0());
            put("东南亚",Region.regionAs0());
        }
    };

    public static UploadManager uploadManager;

    /**
     * 初始化七牛对象储存
     * @return
     */
    public UploadManager getUploadManager(){
        if (uploadManager == null) {
            synchronized (QiNiuOss.class) {
                if (uploadManager == null) {
                    //构造一个带指定 Region 对象的配置类
                    Configuration cfg = new Configuration((Region) regionMaps.get(this.endpoint));
                    //...其他参数参考类注释
                    uploadManager = new UploadManager(cfg);
                    Auth auth = Auth.create(accessKeyId, accessKeySecret);
                    this.upToken = auth.uploadToken(bucket);
                    return uploadManager;
                }
            }
        }
        return uploadManager;
    }


    @Override
    public FIleVo upload(MultipartFile file) {
        FIleVo fileVo = new FIleVo();
        fileVo.setSuffix(StringUtil.getFileSuffix(file.getOriginalFilename()));
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setMd5(Md5Util.getMd5(file));
        String randomFileName = fileVo.getSuffix()+"/"+ RandomUtil.getOrderNum()+"."+fileVo.getSuffix();
        fileVo.setPath(randomFileName);
        fileVo.setRandomFileName(randomFileName);
        fileVo.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        fileVo.setSourceType("qiniu");
        fileVo.setFileSize(file.getSize());
        fileVo.setFileDns(ossConfiguration.getFileDnsUrl());
        try {
            UploadManager uploadManager = getUploadManager();
            byte[] imgBytes = file.getBytes();
            Response response = uploadManager.put(imgBytes, fileVo.getRandomFileName(), this.upToken);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return fileVo;
    }

    @Override
    public FIleVo upload(byte[] fileBytes, String fileName) {
        return null;
    }

    @Override
    public FIleVo readFile(FIleVo fIleVo) {
        return null;
    }
}

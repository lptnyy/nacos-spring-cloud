package com.nacos.oss.base;
import com.nacos.common.util.Md5Util;
import com.nacos.common.util.RandomUtil;
import com.nacos.common.util.StringUtil;
import com.nacos.oss.configuration.OssConfiguration;
import com.nacos.oss.dto.FIleVo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 腾讯对象储存接入
 */
public class TxOss implements Oss{
    OssConfiguration ossConfiguration;
    String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    String accessKeyId = "<yourAccessKeyId>";
    String accessKeySecret = "<yourAccessKeySecret>";
    String region = "";
    String bauckName = "";

    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        this.ossConfiguration = ossConfiguration;
        endpoint = ossConfiguration.getEndpoint();
        accessKeyId = ossConfiguration.getAccessKeyId();
        accessKeySecret = ossConfiguration.getAccessKeySecret();
        region = ossConfiguration.getRegion();
        bauckName = ossConfiguration.getBucketName();
    }

    /**
     * 初始化腾讯oss
     * @return
     */
    public COSClient getClient(){
        COSCredentials cred = new BasicCOSCredentials(accessKeyId, accessKeySecret);
        Region region = new Region(this.region);
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    @Override
    public FIleVo upload(MultipartFile file) {
        FIleVo fileVo = new FIleVo();
        fileVo.setSuffix(StringUtil.getFileSuffix(file.getOriginalFilename()));
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setMd5(Md5Util.getMd5(file));
        String randomFileName = fileVo.getSuffix()+"/"+RandomUtil.getOrderNum()+"."+fileVo.getSuffix();
        fileVo.setPath(randomFileName);
        fileVo.setRandomFileName(randomFileName);
        fileVo.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        fileVo.setSourceType("tx");
        fileVo.setFileSize(file.getSize());
        fileVo.setFileDns(ossConfiguration.getFileDnsUrl());
        InputStream inputStream = null;
        COSClient cosClient = null;
        try {
            cosClient = getClient();
            byte[] imgBytes = file.getBytes();
            inputStream = new ByteArrayInputStream(imgBytes);
            PutObjectRequest putObjectRequest = new PutObjectRequest(this.bauckName,fileVo.getRandomFileName(),inputStream,null);
            cosClient.putObject(putObjectRequest);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {

                }
            }
            if (cosClient != null) {
                cosClient.shutdown();
            }
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

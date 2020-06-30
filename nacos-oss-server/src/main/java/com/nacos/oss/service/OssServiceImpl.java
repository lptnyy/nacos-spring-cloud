package com.nacos.oss.service;
import com.nacos.common.util.ServiceResponse;
import com.nacos.oss.OssService;
import com.nacos.oss.base.Oss;
import com.nacos.oss.dto.FIleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OssServiceImpl implements OssService {

    @Autowired
    Oss oss;

    @Override
    public ServiceResponse<FIleVo> uploadMultipartFile(MultipartFile file)  throws Exception {
        return new ServiceResponse<FIleVo>()
                .run(serviceResponse -> {
                    return oss.upload(file);
                })
                .exec();
    }

    @Override
    public ResponseEntity<byte[]> download(String path) {
        FIleVo fIleVo = new FIleVo();
        fIleVo.setPath(path);
        return returnFile(oss.readFile(fIleVo).getFileDatas(), path.substring(path.lastIndexOf("/")+1));
    }

    /**
     * 下载文件
     * @param fileDatas
     * @return
     */
    public ResponseEntity<byte[]> returnFile(byte[] fileDatas, String fileName) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);
            ResponseEntity<byte[]> files = new ResponseEntity<byte[]>(fileDatas,
                    headers, HttpStatus.CREATED);
            return files;
        } catch (Exception e) {
        }
        return  null;
    }
}

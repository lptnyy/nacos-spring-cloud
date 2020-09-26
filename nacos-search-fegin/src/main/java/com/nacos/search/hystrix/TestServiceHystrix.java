package com.nacos.search.hystrix;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.search.ITestService;
import com.nacos.search.dto.DocBean;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TestServiceHystrix implements ITestService {

    @Override
    public ServiceResponse<Boolean> createIndex(String index) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Boolean> deleteIndex(String index) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Boolean> save(ProParameter<DocBean> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Boolean> saveAll(ProParameter<List<DocBean>> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Iterator<DocBean>> findAll() {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Page<DocBean>> findByContent(String content) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Page<DocBean>> findByFirstCode(String firstCode) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Page<DocBean>> findBySecordCode(String secordCode) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Page<DocBean>> query(String key) {
        return ServiceResponse.getFAIL();
    }
}

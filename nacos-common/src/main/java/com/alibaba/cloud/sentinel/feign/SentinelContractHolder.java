package com.alibaba.cloud.sentinel.feign;
import feign.Contract;
import feign.MethodMetadata;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解决sentine 报错的问题
 */
public class SentinelContractHolder implements Contract {

    private final Contract delegate;

    public static final Map<String, MethodMetadata> METADATA_MAP = new HashMap();

    public SentinelContractHolder(Contract delegate) {
        this.delegate = delegate;
    }

    public List<MethodMetadata> parseAndValidateMetadata(Class<?> targetType) {
        List<MethodMetadata> metadatas = this.delegate.parseAndValidatateMetadata(targetType);
        metadatas.forEach((metadata) -> {
            MethodMetadata var10000 = (MethodMetadata)METADATA_MAP.put(targetType.getName() + metadata.configKey(), metadata);
        });
        return metadatas;
    }

    @Override
    public List<MethodMetadata> parseAndValidatateMetadata(Class<?> aClass) {
        List<MethodMetadata> metadatas = this.delegate.parseAndValidatateMetadata(aClass);
        metadatas.forEach((metadata) -> {
            MethodMetadata var10000 = (MethodMetadata)METADATA_MAP.put(aClass.getName() + metadata.configKey(), metadata);
        });
        return metadatas;
    }
}

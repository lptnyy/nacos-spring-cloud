package com.nacos.common.cache;

import lombok.Data;

@Data
public class Token {
    String token;
    long  expires_in;
}

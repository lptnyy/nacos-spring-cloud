package com.nacos.common.page;

import lombok.Data;

@Data
public class RequestPage {
    int pageNum = 1;
    int pageSize = 10;
}

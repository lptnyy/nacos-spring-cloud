package com.nacos.common.respones;

import java.util.List;
import lombok.Data;

@Data
public class MessageBody<T> {
    Integer code;
    String message;
    T data;
    List<T> datas;
    Integer pageSize;
    Integer pageNo;
    Integer datasCount;
}

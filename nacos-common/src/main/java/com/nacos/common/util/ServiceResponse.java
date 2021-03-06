package com.nacos.common.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import java.io.Serializable;

/**
 * 服务之间数据响应载体
 * @param <T>
 */
public class ServiceResponse<T> implements Serializable {
    T obj;
    int code = 200;
    String msg = "";
    long count;
    int pageSize;
    int pageNo;
    long pages;
    int insertLastId;
    public T getObj() {
        return obj;
    }
    boolean transaction = false;
    ObjectMapper mapper = new ObjectMapper();

    public ServiceResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ServiceResponse() {

    }

    final static ServiceResponse SUCCESSServiceResponse = new ServiceResponse(MessageType.SUCCESS.getValue(),"ok");
    final static ServiceResponse FAILServiceResponse = new ServiceResponse(MessageType.FAIL.getValue(),"服务器异常");
    final static ServiceResponse AuthFAILServiceResponse = new ServiceResponse(MessageType.AUTHFAIL.getValue(), "没有相关权限");
    final static ServiceResponse BEBUSYFAILServiceResponse = new ServiceResponse(MessageType.BEBUSYFAIL.getValue(),"服务器忙碌");

    public static ServiceResponse getFAIL(){
        return FAILServiceResponse;
    }

    public static ServiceResponse getAuthFAIL(){
        return AuthFAILServiceResponse;
    }

    public static ServiceResponse getBEBUSYFAIL(){
        return BEBUSYFAILServiceResponse;
    }

    public static ServiceResponse getSUCCESS(){
        return SUCCESSServiceResponse;
    }

    public ServiceResponse<T> copyPage(ServiceResponse serviceResponse){
        serviceResponse.count = this.count;
        serviceResponse.pageSize = this.pageSize;
        serviceResponse.pageNo = this.pageNo;
        serviceResponse.pages = this.pages;
        return this;
    }

    public ServiceResponse<T> copyState(ServiceResponse serviceResponse) {
        serviceResponse.setCode(this.getCode());
        serviceResponse.setMsg(this.getMsg());
        return this;
    }

    public ServiceResponse<T> run(Exceutor<T> exceutor) {
        this.exceutor = exceutor;
        return this;
    }

    public long getCount() {
        return count;
    }

    public ServiceResponse setCount(long count) {
        this.count = count;
        return this;
    }

    public ServiceResponse setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ServiceResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ServiceResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    Exceutor<T> exceutor;
    public ServiceResponse exec() {
        try{
            this.obj = exceutor.run(this);
        } catch (Exception e){
            this.setMsg(e.getMessage());
            this.setCode(MessageType.FAIL.getValue());
            if (transaction) {
                try {
                    rollback();
                } catch (TransactionException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return this;
    }

    public interface Exceutor<T>{
        public T run(ServiceResponse<T> serviceResponse) throws Exception;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ServiceResponse setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public ServiceResponse setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public ServiceResponse setPages(long pages) {
        this.pages = pages;
        return this;
    }

    public int getInsertLastId() {
        return insertLastId;
    }

    public ServiceResponse setInsertLastId(int insertLastId) {
        this.insertLastId = insertLastId;
        return this;
    }

    // 服务调用验证如果开启事务 回滚事务
    public ServiceResponse<T> checkState() throws Exception {
        if (this.code != MessageType.SUCCESS.getValue()) {
            if (transaction) {
               GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            }
            if (this.msg == null && this.msg.equals(""))
                throw new Exception("服务器调用异常");
            else
                throw new Exception(this.msg);
        }
        return this;
    }

    public void setErrorMsg(String msg){
        this.msg = msg;
        this.code = MessageType.VERIFICATION.getValue();
    }

    /**
     * 标记开启事务
     */
    public ServiceResponse<T> beginTransaction() {
        this.transaction = true;
        return this;
    }

    // 事务回滚
    public ServiceResponse<T> rollback() throws TransactionException {
        GlobalTransactionContext.reload(RootContext.getXID()).rollback();
        return this;
    }

    public T toObjClass(Class srClass) {
        return (T) mapper.convertValue(getObj(), srClass);
    }
}

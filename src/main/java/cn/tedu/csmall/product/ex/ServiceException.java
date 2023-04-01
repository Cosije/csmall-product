package cn.tedu.csmall.product.ex;

import cn.tedu.csmall.product.web.ServiceCode;

/**
 * 业务异常
 */
public class ServiceException extends RuntimeException{
    private ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }
}

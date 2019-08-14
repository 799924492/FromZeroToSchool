package com.imook.exception;
//跟店铺相关的异常
public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 913784880816230176L;

    public ShopOperationException(String msg) {
        super(msg);
    }
}

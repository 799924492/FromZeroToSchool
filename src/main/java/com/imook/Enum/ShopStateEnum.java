package com.imook.Enum;

public enum ShopStateEnum {
    CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),

    NULL_SHOPID(-1002,"Shopid为空"),NULL_SHOP(-1003,"shop信息为空");

    private int state;
    private String stateInfo;

     ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    //依据传入的state 返回 相应的值
    public static ShopStateEnum stateof(int state) {

        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
            return null;
    }


}

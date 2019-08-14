package com.imook.dto;

import com.imook.Enum.ShopStateEnum;
import com.imook.entry.Shop;

import java.util.List;
// 实行
//为了完成商铺注册，简单的entity类并不能满足我们的需求。我们需要对其扩展
public class ShopExecution {

    //结果状态
    private int state;
    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;
    //操作的店铺（c增删改店铺时候用到）
    private Shop shop;
    //Shop列表（查询店铺列表的时候时候用到）
    private List<Shop> shopList;

    public ShopExecution() {
    }

    // 店铺操作失败时候使用的失败的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();

    }

    // 店铺操作成功时候使用的成功的构造器
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    // 店铺操作成功时候使用的成功的构造器
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shop;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}

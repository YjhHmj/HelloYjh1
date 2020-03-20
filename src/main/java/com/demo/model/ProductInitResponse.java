package com.demo.model;

import java.io.Serializable;

/**
 * @author yjh
 * @date 2020-02-04 14:33
 */
//deprecated 产品初始化出参
public class ProductInitResponse implements Serializable {

    private static final long serialVersionUID = 149769090848297L;

    //产品名字
    private String productName;

    //单个瓦数
    private String watts;

    //单个电压
    private String voltage;

    //最小宽
    private String minWidth;

    //最小长
    private String minLength;

    //最小高
    private String minHeight;

    //单位长度
    private String unitLength;

    //深度最小值
    private String minDepth;

    //深度最大值
    private String maxDepth;

    //模组到发光字/灯箱边缘的距离
    private String linearSpacing;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWatts() {
        return watts;
    }

    public void setWatts(String watts) {
        this.watts = watts;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(String minWidth) {
        this.minWidth = minWidth;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(String minHeight) {
        this.minHeight = minHeight;
    }

    public String getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(String unitLength) {
        this.unitLength = unitLength;
    }

    public String getMinDepth() {
        return minDepth;
    }

    public void setMinDepth(String minDepth) {
        this.minDepth = minDepth;
    }

    public String getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(String maxDepth) {
        this.maxDepth = maxDepth;
    }

    public String getLinearSpacing() {
        return linearSpacing;
    }

    public void setLinearSpacing(String linearSpacing) {
        this.linearSpacing = linearSpacing;
    }
}

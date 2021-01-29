package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("mountain_yn")
    @Expose
    private String mountainYn;
    @SerializedName("region_3depth_name")
    @Expose
    private String region3depthName;
    @SerializedName("main_address_no")
    @Expose
    private String mainAddressNo;
    @SerializedName("sub_address_no")
    @Expose
    private String subAddressNo;
    @SerializedName("address_name")
    @Expose
    private String addressName;
    @SerializedName("region_2depth_name")
    @Expose
    private String region2depthName;
    @SerializedName("region_1depth_name")
    @Expose
    private String region1depthName;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;

    public String getMountainYn() {
        return mountainYn;
    }

    public void setMountainYn(String mountainYn) {
        this.mountainYn = mountainYn;
    }

    public String getRegion3depthName() {
        return region3depthName;
    }

    public void setRegion3depthName(String region3depthName) {
        this.region3depthName = region3depthName;
    }

    public String getMainAddressNo() {
        return mainAddressNo;
    }

    public void setMainAddressNo(String mainAddressNo) {
        this.mainAddressNo = mainAddressNo;
    }

    public String getSubAddressNo() {
        return subAddressNo;
    }

    public void setSubAddressNo(String subAddressNo) {
        this.subAddressNo = subAddressNo;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getRegion2depthName() {
        return region2depthName;
    }

    public void setRegion2depthName(String region2depthName) {
        this.region2depthName = region2depthName;
    }

    public String getRegion1depthName() {
        return region1depthName;
    }

    public void setRegion1depthName(String region1depthName) {
        this.region1depthName = region1depthName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}

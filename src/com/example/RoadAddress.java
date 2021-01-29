package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoadAddress {

    @SerializedName("road_name")
    @Expose
    private String roadName;
    @SerializedName("main_building_no")
    @Expose
    private String mainBuildingNo;
    @SerializedName("building_name")
    @Expose
    private String buildingName;
    @SerializedName("region_3depth_name")
    @Expose
    private String region3depthName;
    @SerializedName("underground_yn")
    @Expose
    private String undergroundYn;
    @SerializedName("sub_building_no")
    @Expose
    private String subBuildingNo;
    @SerializedName("address_name")
    @Expose
    private String addressName;
    @SerializedName("region_2depth_name")
    @Expose
    private String region2depthName;
    @SerializedName("zone_no")
    @Expose
    private String zoneNo;
    @SerializedName("region_1depth_name")
    @Expose
    private String region1depthName;

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getMainBuildingNo() {
        return mainBuildingNo;
    }

    public void setMainBuildingNo(String mainBuildingNo) {
        this.mainBuildingNo = mainBuildingNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRegion3depthName() {
        return region3depthName;
    }

    public void setRegion3depthName(String region3depthName) {
        this.region3depthName = region3depthName;
    }

    public String getUndergroundYn() {
        return undergroundYn;
    }

    public void setUndergroundYn(String undergroundYn) {
        this.undergroundYn = undergroundYn;
    }

    public String getSubBuildingNo() {
        return subBuildingNo;
    }

    public void setSubBuildingNo(String subBuildingNo) {
        this.subBuildingNo = subBuildingNo;
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

    public String getZoneNo() {
        return zoneNo;
    }

    public void setZoneNo(String zoneNo) {
        this.zoneNo = zoneNo;
    }

    public String getRegion1depthName() {
        return region1depthName;
    }

    public void setRegion1depthName(String region1depthName) {
        this.region1depthName = region1depthName;
    }

    public static void main(String[] args) {
        System.out.println(addressName);
    }
}

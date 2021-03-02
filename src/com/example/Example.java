package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example{

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("road_address")
    @Expose
    private RoadAddress roadAddress;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public RoadAddress getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(RoadAddress roadAddress) {
        this.roadAddress = roadAddress;
    }

}
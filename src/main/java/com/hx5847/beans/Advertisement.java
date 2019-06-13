package com.hx5847.beans;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.SQLData;
import java.sql.Timestamp;

public class Advertisement {

  private Integer advId;
  private String url;
  private String picUrl;
  private java.sql.Timestamp lastMdfTime;
  private String location;

  public Advertisement() {
  }

  public Advertisement(String location) {
    this.location = location;
  }



  public Advertisement(Integer advId, String url, String picUrl, String location) {
    this.advId = advId;
    this.url = url;
    this.picUrl = picUrl;
    this.location = location;
  }

  public Advertisement(Integer advId, String url, String picUrl, Timestamp lastMdfTime, String location) {
    this.advId = advId;
    this.url = url;
    this.picUrl = picUrl;
    this.lastMdfTime = lastMdfTime;
    this.location = location;
  }

  public Advertisement(Integer advId, String url, String location) {
    this.advId = advId;
    this.url = url;
    this.location = location;
  }

  public Integer getAdvId() {
    return advId;
  }

  public void setAdvId(Integer advId) {
    this.advId = advId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public Timestamp getLastMdfTime() {
    return lastMdfTime;
  }

  public void setLastMdfTime(Timestamp lastMdfTime) {
    this.lastMdfTime = lastMdfTime;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public String toString() {
    return "Advertisement{" +
            "advId=" + advId +
            ", url='" + url + '\'' +
            ", picUrl='" + picUrl + '\'' +
            ", lastMdfTime=" + lastMdfTime +
            ", location='" + location + '\'' +
            '}';
  }
}

package com.hx5847.dao;

import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface AdvertisementMapper {
    @Select("select adv_id as advId,url,pic_url as picUrl ,last_mdf_time as lastMdfTime, location from advertisement where adv_id=#{id}")
    public Advertisement getAdvertisementById(Integer id);


    @Select("select adv_id as advId,url,pic_url as picUrl ,last_mdf_time as lastMdfTime, location from advertisement")
    public List<Advertisement> getAll();



//    @Update("update advertisement set url=#{url},pic_url=#{picUrl},location=#{location} WHERE (adv_id=#{advId})")
    @UpdateProvider(type = AdvertiseProvider.class,method = "updateAdvertisement")
    public void updateAdvertisement(Advertisement advertisement);

    @Select("select * from advertisement where location=#{location}")
    public List<Advertisement> getAdvertisementByLocation(String location);

    @Insert("insert into advertisement (url,pic_url,location) values (#{url},#{picUrl},#{location})")
    public void insertAdvertisement(Advertisement advertisement);

    @Delete("delete from advertisement where adv_id=#{id}")
    public void delAdvertise(Integer id);
}

package com.hx5847.dao;

import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface AdvertisementMapper {
    @Select("select anno_id as annoId ,title,upload_time as uploadTime,type,content from announcement where anno_id=#{id}")
    public Advertisement getAdvertisementById(Integer id);


    @Select("select adv_id as advId,url,pic_url as picUrl ,last_mdf_time as lastMdfTime, location, live_time as liveTime from advertisement")
    public List<Advertisement> getAll();

    @Insert("insert into announcement (title,type,content) values (#{title},#{type},#{content})")
    public void insertAnnouncement(Advertisement announcement);

    @Update("update announcement set title=#{title},type=#{type},content=#{content} WHERE (anno_id=#{annoId})")
    public void updateAnnouncement(Advertisement announcement);
}

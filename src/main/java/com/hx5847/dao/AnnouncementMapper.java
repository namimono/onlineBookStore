package com.hx5847.dao;

import com.hx5847.beans.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface AnnouncementMapper {
    @Select("select title,upload_time,type from announcement where anno_id=#{id}")
    public Announcement getAnnounceById(Integer id);


    @Select("select anno_id as annoId,title,upload_time as uploadTime,type from announcement")
    public List<Announcement> getAll();


}

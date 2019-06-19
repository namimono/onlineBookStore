package com.hx5847.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface testMapper {


    @Update("update books set type=#{type} where book_id=#{id}")
    public void updateBooks(@Param("type") String type, @Param("id") Integer id);

    @Insert("insert into tb_type (book_id,type) values(#{id},#{type})")
    public void insertType(@Param("type") String type, @Param("id") Integer id);
}

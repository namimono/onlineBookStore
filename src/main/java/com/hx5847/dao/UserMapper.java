package com.hx5847.dao;

import com.hx5847.beans.Announcement;
import com.hx5847.beans.Book;
import com.hx5847.beans.Usersmessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper {

    //-- 查询用户感兴趣的类型
    @Select("select DISTINCT type from tb_type where book_id in (select book_id from ratings where user_id=#{id} and rating=5)")
    public List<String> getUserIntrestById(Integer id);

    //  -- 查询用户名称
    @Select("select nickname from usersmessage where id= #{id}")
    public String getUserNameById(Integer id);

    //-- 查询用户推荐列表中书的信息
    @Select("select book_id,title,author from books where book_id in(select book_id from recommend where user_id=#{id})")
    public List<Book> getUserRecListById(Integer id);

//    根据用户兴趣获取10本可能感兴趣的书。
//    @Select("select book_id from books LEFT JOIN tb_type on books.book_id=tb_type.book_id where type='科幻' or type='军事' ORDER BY RAND() LIMIT 0,10")
//    @SelectProvider(type = UserProvider.class,method = "getUserIntrestBooks")
//    public List<Book> getBooksByTypes(@Param("types") List<String> types);

    @Insert("insert into recommend (user_id,book_id) values(#{id},#{book})")
    public void insertUserRecommendById(@Param("id") Integer id, @Param("book") Integer bookId);

    @Delete("delete from recommend where user_id=#{id}")
    public void delRecommendById(Integer id);
}

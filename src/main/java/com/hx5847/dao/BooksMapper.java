package com.hx5847.dao;

import com.hx5847.beans.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface BooksMapper {

//    SELECT * FROM books WHERE book_id IN
//    (SELECT book_id FROM tb_type where type='军事' or type='魔幻' or type='都市' GROUP BY book_id)
//    ORDER BY click DESC;

    /**
     *
     * @param types String[]
     * @param condition String
     * @return 返回Book 的List集合
     */
    @SelectProvider(type=BooksProvider.class,method ="getBookRank")
    public List<Book> getRank(@Param("types") String[] types, @Param("condition") String condition);
}

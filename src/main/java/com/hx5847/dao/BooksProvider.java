package com.hx5847.dao;

import com.hx5847.beans.Advertisement;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BooksProvider {

//    public String getBookRank(final String[] types,final String condition){
    public String getBookRank(Map<String, Object> para){
        final String[] types= (String[]) para.get("types");
        final String condition= (String) para.get("condition");
        StringBuffer sql=new StringBuffer();
        String childSql=new SQL(){
            {
                SELECT("book_id");
                FROM("tb_type");
                for (int i = 0; i < types.length; i++) {
//                当条件索引是随后一个索引时不加or
                    if (i == types.length - 1) {
                        WHERE("type='" + types[i]+"'");
                    } else {
                        WHERE("type='" + types[i]+"'");
                        OR();
                    }
                }
                GROUP_BY("book_id");
            }}.toString();
        sql.append("SELECT * FROM books WHERE book_id IN(");
        sql.append(childSql+")");
        sql.append(" ORDER BY "+condition+" DESC");
        System.out.println(sql);
//        sql.append("SELECT * FROM books WHERE book_id IN");
//
//        childSql.append("(SELECT book_id FROM tb_type where");
//        for (String type :types ){
//            childSql.append("type='"+type+"'")
//        }
//    SELECT * FROM books WHERE book_id IN
//    (SELECT book_id FROM tb_type where type='军事' or type='魔幻' or type='都市' GROUP BY book_id)
//    ORDER BY click DESC;
//        return new SQL(){{
//            SELECT("*");
//            FROM("books");
//            WHERE("book_id=");
//            SELECT("book_id");
//            FROM("tb_type");
//
//            WHERE()
//        }}.toString();
        return sql.toString();
    }
}

package com.hx5847.config;

import com.hx5847.beans.Announcement;
import com.hx5847.beans.Book;
import com.hx5847.dao.AnnouncementMapper;
import com.hx5847.dao.BooksMapper;
import com.hx5847.dao.UserMapper;
import com.hx5847.dao.testMapper;
import org.apache.ibatis.jdbc.SQL;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class ConfigIOCTest {
    private ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigIOC.class);
    @Test
    public void test() {

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void testSelect(){
        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        Announcement announce = announcementMapper.getAnnounceById(1);
        System.out.println(announce);

    }

    @Test
    public void testGetAllAnnoucenments(){
        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        List<Announcement> all = announcementMapper.getAll();
        System.out.println(all);

    }
    @Test
    public void testupdateBookType() throws SQLException {
        testMapper testMapper = applicationContext.getBean(testMapper.class);
        HashMap<Integer,String> map=new HashMap<Integer, String>();

        map.put(1,"魔幻");
        map.put(2,"科幻");
        map.put(3,"都市");
        map.put(4,"军事");
        map.put(5,"游戏");
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        System.out.println(keys[0]);

        Random random = new Random();
        for (int i = 1; i <9747 ; i++) {
            Integer randomKey = keys[random.nextInt(keys.length)];
            String randomValue = map.get(randomKey);
            System.out.println(randomValue);
            testMapper.insertType(randomValue,i);
//            testMapper.updateBooks(randomValue,i);
        }
//        Integer randomKey = keys[random.nextInt(keys.length)];
//        String randomValue = map.get(randomKey);
//        System.out.println(randomValue);





//        testMapper.updateBooks();

    }
    @Test
    public void testsql(){
        final String[] types=new String[]{"a","b"};
        final String condition="click";
        StringBuffer sql=new StringBuffer();
        String childSql=new SQL(){
            {
                SELECT("book_id");
                FROM("tb_type");
                for (int i = 0; i < types.length; i++) {
//                当条件索引是随后一个索引时不加or
                    if (i == types.length - 1) {
                        WHERE("type=" + types[i]);
                    } else {
                        WHERE("type=" + types[i]);
                        OR();
                    }
                }
                GROUP_BY("book_id");
            }}.toString();
        sql.append("SELECT * FROM books WHERE book_id IN(");
        sql.append(childSql+")");
        sql.append(" ORDER BY "+condition+" DESC");
//        sql.append(" limit 0,100");
        System.out.println(sql);
    }
    @Test
    public void testGetRank(){
        BooksMapper booksMapper = applicationContext.getBean(BooksMapper.class);
        String[] types=new String[]{"都市","魔幻"};
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("types",types);
        map.put("condition","click");
        types= (String[]) map.get("types");
        String condition= (String) map.get("condition");
        System.out.println(types);
        System.out.println(condition);
//        System.out.println(map);

//        String[] types=new String[]{};
//        String condition="click";
        List<Book> books = booksMapper.getRank(types, condition);
        System.out.println(books);


    }
    @Test
    public void getBooksByTypes(){
        BooksMapper booksMapper = applicationContext.getBean(BooksMapper.class);
        List<String> list=new ArrayList<String>();
        list.add("魔幻");
        list.add("军事");
        List<Integer> booksIdByTypes = booksMapper.getBooksIdByTypes(list);
        System.out.println(booksIdByTypes);

    }
}

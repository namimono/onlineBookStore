package com.hx5847.service;

import com.hx5847.beans.Book;
import com.hx5847.dao.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RankService {

    @Autowired
    private BooksMapper booksMapper;

    public List<Book> getRankBooks(String[] types,String condition){
        List<Book> books = booksMapper.getRank(types,condition);

        return books;
    }
}

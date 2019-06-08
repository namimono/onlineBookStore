package com.hx5847.config;

import com.hx5847.beans.Announcement;
import com.hx5847.dao.AnnouncementMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
}
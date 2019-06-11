package com.hx5847.config;

import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import com.hx5847.dao.AdvertisementMapper;
import com.hx5847.dao.AnnouncementMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class testAdvertise {
    private ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigIOC.class);


    @Test
    public void testSelectAdvertise(){
        AdvertisementMapper advertisementMapper = applicationContext.getBean(AdvertisementMapper.class);
        List<Advertisement> all = advertisementMapper.getAll();
        System.out.println(all);

    }
}
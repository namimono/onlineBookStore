package com.hx5847.config;

import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import com.hx5847.dao.AdvertisementMapper;
import com.hx5847.dao.AnnouncementMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testAdvertise {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigIOC.class);


    @Test
    public void testSelectAdvertise() {
        AdvertisementMapper advertisementMapper = applicationContext.getBean(AdvertisementMapper.class);
        List<Advertisement> all = advertisementMapper.getAll();
        System.out.println(all);

    }

    @Test
    public void testGetById() {
        AdvertisementMapper advertisementMapper = applicationContext.getBean(AdvertisementMapper.class);
        Advertisement advertisementById = advertisementMapper.getAdvertisementById(1);
        System.out.println(advertisementById);

    }

    @Test
    public void testUpdateAdvertise() {
        AdvertisementMapper advertisementMapper = applicationContext.getBean(AdvertisementMapper.class);
        Advertisement advertisement = new Advertisement(4, null, "static/advSpring.jpg", "tail");
        advertisementMapper.updateAdvertisement(advertisement);
    }

    @Test
    public void testUpdateAdvertise2() {
        Advertisement a = new Advertisement(1, "a", "a", "a");
        Advertisement b = new Advertisement(1, "a","b");
        Map<Integer, Advertisement> map = new HashMap<Integer, Advertisement>();
//        System.out.println(a.);
//        map.put(a.getAdvId(), a);
//        map.put(b.getAdvId(), b);
        System.out.println(map.get(b.getAdvId()));
//        advertiseService.updateAdvertise(map.get(advertisement.getAdvId()));
    }
}
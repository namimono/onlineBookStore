package com.hx5847.config;

import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import com.hx5847.dao.AdvertisementMapper;
import com.hx5847.dao.AnnouncementMapper;
import com.hx5847.exceptions.UpdateException;
import com.hx5847.service.AdvertiseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testAdvertise {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigIOC.class);
//    @Autowired
//    private AdvertiseService advertiseService;

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
    @Test
    public void testgetMiddleAdvertise() {
//        AdvertisementMapper advertisementMapper = applicationContext.getBean(AdvertisementMapper.class);
        AdvertiseService advertiseService = applicationContext.getBean(AdvertiseService.class);
//        List<Advertisement> list = advertisementMapper.getAdvertisementByLocation(new Advertisement("middle"));
        Advertisement middle = new Advertisement(3,"aaa","carousel");
        String ms = null;
        try {
            ms = advertiseService.updateAdvertise(middle);
        } catch (UpdateException e) {
            ms="fail";
        }
        System.out.println(ms);
    }
    @Test
    public void testInsertAdvertise() {
        AdvertiseService advertiseService = applicationContext.getBean(AdvertiseService.class);
        Advertisement middle = new Advertisement(null,"aaa","sssss","middle");
        String s = advertiseService.insertAdvertise(middle);
        System.out.println(s);
    }
}
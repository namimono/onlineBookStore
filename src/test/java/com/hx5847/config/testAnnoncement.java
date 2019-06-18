package com.hx5847.config;

import com.hx5847.beans.Announcement;
import com.hx5847.dao.AnnouncementMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class testAnnoncement {
    private ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigIOC.class);

    @Test
    public void testGetAllAnnoucenments(){
        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        List<Announcement> all = announcementMapper.getAll();
        System.out.println(all);

    }
    @Test
    public void testGetAnnounceById(){
        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        Announcement announce = announcementMapper.getAnnounceById(1);
        System.out.println(announce);

    }

    @Test
    public void testInsertAnnouncement(){


        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        announcementMapper.insertAnnouncement(new Announcement("表题","type","content"));


    }
    @Test
    public void testUpdateAnnouncement(){


        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        Announcement announcement = new Announcement(8, "表题", "type", "content");
        announcementMapper.updateAnnouncement(announcement);


    }
    @Test
    public void testDelAnnouncement(){


        AnnouncementMapper announcementMapper = applicationContext.getBean(AnnouncementMapper.class);
        announcementMapper.delAnnouncement(11);


    }
}
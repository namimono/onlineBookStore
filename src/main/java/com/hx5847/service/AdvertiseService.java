package com.hx5847.service;


import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import com.hx5847.dao.AdvertisementMapper;
import com.hx5847.dao.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiseService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisements(){
        List<Advertisement> list = advertisementMapper.getAll();
        return list;
    }

}

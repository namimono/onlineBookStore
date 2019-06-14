package com.hx5847.service;


import com.hx5847.beans.Advertisement;
import com.hx5847.beans.Announcement;
import com.hx5847.dao.AdvertisementMapper;
import com.hx5847.dao.AnnouncementMapper;
import com.hx5847.exceptions.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {UpdateException.class})
@Service
public class AdvertiseService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisements(){
        List<Advertisement> list = advertisementMapper.getAll();
        return list;
    }

    public Advertisement getAdvertise(Integer id) {
        return advertisementMapper.getAdvertisementById(id);
    }

    public String  insertAdvertise(Advertisement advertisement){
        if (advertisement.getLocation().equals("middle")||advertisement.getLocation().equals("tail")){
            List<Advertisement> list = advertisementMapper.getAdvertisementByLocation(advertisement.getLocation());
            if (list.size()>0){
                return "fail";
            } 
        }
        advertisementMapper.insertAdvertisement(advertisement);
        return "success";

    }

    public String  updateAdvertise(Advertisement advertisement) throws UpdateException {
        advertisementMapper.updateAdvertisement(advertisement);

        if (advertisementMapper.getAdvertisementByLocation("middle").size()>1){
            throw new UpdateException("update fail");
        }
        if (advertisementMapper.getAdvertisementByLocation("tail").size()>1){
            throw new UpdateException("update fail");
        }
//        if (advertisement.getLocation().equals("middle")||advertisement.getLocation().equals("tail")){
//            List<Advertisement> list = advertisementMapper.getAdvertisementByLocation(advertisement);
//            if (list.size()>0){
//                return "fail";
//            }
//        }
        return "success";
    }
}

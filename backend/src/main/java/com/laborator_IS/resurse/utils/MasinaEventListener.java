package com.laborator_IS.resurse.utils;

import com.laborator_IS.resurse.model.Car;

import javax.persistence.PostPersist;

public class MasinaEventListener {

//    @Autowired
//    private NotificationService notificationService;

    @PostPersist
    public void notifyCreation(Car car){
        System.out.println("Created car " + car.getMaker());

//        notificationService.sendNotify(..);
    }
}

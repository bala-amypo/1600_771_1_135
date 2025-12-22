package com.example.demo.config.service;

import com.example.demo.config.entity.Broadcast;
import java.util.List;

public interface BroadcastService {

    Broadcast createBroadcast(Broadcast broadcast);

    List<Broadcast> getBroadcastsByEventId(Long eventId);
}

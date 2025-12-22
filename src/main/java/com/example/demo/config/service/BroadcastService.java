package com.example.demo.config.service;

import com.example.demo.config.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {

    BroadcastLog createBroadcastLog(BroadcastLog broadcastLog);

    List<BroadcastLog> getBroadcastLogsByEventId(Long eventId);
}

package com.example.demo.config.service;

import com.example.demo.config.entity.BroadcastLog;
import java.util.List;

public interface BroadcastService {

    void triggerBroadcast(Long updateId);

    List<BroadcastLog> getLogsForUpdate(Long updateId);
}

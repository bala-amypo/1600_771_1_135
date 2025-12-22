package com.example.demo.repository;

import com.example.demo.config.entity.BroadcastLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BroadcastLogRepository extends JpaRepository<BroadcastLog, Long> {

    List<BroadcastLog> findByEventId(Long eventId);
}

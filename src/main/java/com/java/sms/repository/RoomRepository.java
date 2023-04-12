package com.java.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.sms.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}

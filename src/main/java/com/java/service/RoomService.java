package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.sms.entity.Room;


@Service
public interface RoomService {

	List<Room> getAllRooms();

	Room saveRoom(Room room);

	Room getRoomById(Long id);

	Room updateRoom(Room room);

	void deleteRoomById(Long id);
}

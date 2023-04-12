package com.java.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.service.RoomService;
import com.java.sms.entity.Room;
import com.java.sms.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

private RoomRepository roomRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(Long id) {
		return roomRepository.findById(id).get();
	}

	@Override
	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public void deleteRoomById(Long id) {
		roomRepository.deleteById(id);	
	}
}

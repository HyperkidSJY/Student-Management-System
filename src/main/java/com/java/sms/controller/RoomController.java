

package com.java.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.CourseService;
import com.java.service.RoomService;
import com.java.sms.entity.Course;
import com.java.sms.entity.Room;


@Controller
public class RoomController {
	
	private RoomService roomService;
	private CourseService courseService;
	
	public RoomController(RoomService roomService , CourseService courseService ) {
		super();
		this.roomService = roomService;
		this.courseService =  courseService;
	}
	
	
	@GetMapping("/rooms")
	public String listRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "rooms";
	}
	
	@GetMapping("/rooms/new")
	public String createRoomForm(Model model) {
		
		// create room object to hold room form data
		Room room = new Room();
		List<Course> course = courseService.getAllCourse();
		model.addAttribute("room", room);
		model.addAttribute("course", course);
		return "create_room";
		
	}
	
	@PostMapping("/rooms")
	public String saveRoom(@ModelAttribute("room") Room room) {
		roomService.saveRoom(room);
		return "redirect:/rooms";
	}
	
	@GetMapping("/rooms/edit/{id}")
	public String editRoomForm(@PathVariable Long id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		List<Course> course = courseService.getAllCourse();
		model.addAttribute("course", course);
		return "edit_room";
	}

	@PostMapping("/rooms/{id}")
	public String updateRoom(@PathVariable Long id,
			@ModelAttribute("room") Room room,
			Model model) {
		
		// get room from database by id
		Room existingRoom = roomService.getRoomById(id);
		existingRoom.setId(id);
		existingRoom.setCourse(room.getCourse());
		
		// save updated room object
		roomService.updateRoom(existingRoom);
		return "redirect:/rooms";		
	}
	
	// handler method to handle delete room request
	
	@GetMapping("/rooms/{id}")
	public String deleteRoom(@PathVariable Long id) {
		roomService.deleteRoomById(id);
		return "redirect:/rooms";
	}
	
}

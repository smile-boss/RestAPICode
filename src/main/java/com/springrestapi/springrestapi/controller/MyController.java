package com.springrestapi.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrestapi.entities.Course;
import com.springrestapi.springrestapi.services.CourseService;

@RestController
public class MyController {
    @Autowired
	private CourseService courseService;
	
    @GetMapping("/home")
	public String home(){
		return "This is my first Rest API";
	}
    
	@GetMapping("/Courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/Courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/Courses")
	public Course addCourse(@RequestBody Course course){
		return this.courseService.addCourse(course);
		
	}
	
	@PutMapping("/Courses")
	public String updateCourse(@RequestBody Course course){
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/Courses")
	public String deleteCourse(@RequestBody Course course){
		return this.courseService.deleteCourse(course);
	}
}

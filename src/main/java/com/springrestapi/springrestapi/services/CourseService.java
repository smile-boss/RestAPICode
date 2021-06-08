package com.springrestapi.springrestapi.services;

import java.util.List;

import com.springrestapi.springrestapi.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public String updateCourse(Course course);
	public String deleteCourse(Course course);
}

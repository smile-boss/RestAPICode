package com.springrestapi.springrestapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrestapi.springrestapi.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl(){
		list = new ArrayList<>();
		list.add(new Course(145,"Java Course", "Course Contains Java details"));
		list.add(new Course(245,"Spring boot Course", "Course Contains Spring boot details"));
	}
	@Override
	public List<Course> getCourses() {
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for (Course course : list) {
			if(course.getId()==courseId){
				c = course;
				break;
			}
		}
		return c;
	}
	
	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	
	@Override
	public String updateCourse(Course course) {
		int counter=0, flag=0;
		for(Course c: list){
			if(c.getId()== course.getId()){
				list.set(counter, course);
				flag=1;
				break;
			}
			counter++;
		}
		if(flag==1)
			return "Record Updated Successfully";
		else
			return "Record Not Found";
	}
	@Override
	public String deleteCourse(Course course) {
		int counter=0, flag=0;
		for(Course c: list){
			if(c.getId()== course.getId()){
				list.remove(counter);
				flag=1;
				break;
			}
			counter++;
		}
		if(flag==1)
			return "Record Deleted Successfully";
		else
			return "Record Not Found";
	}

}

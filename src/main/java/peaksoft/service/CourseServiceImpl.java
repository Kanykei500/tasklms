package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.CourseRepositoryImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String saveCourse(Course course) {
        courseRepository.saveCourse(course);
        return "Successfully saved";
    }

    @Override
    public Course getCourseById(Long courseId) {
       return courseRepository.getCourseById(courseId);


    }



    @Override
    public List<Course> getAllCoursesSortByCreateAt(String ascOrDesc) {
        return courseRepository.getAllCoursesSortByCreateAt(ascOrDesc);


    }

    @Override
    public Course updateCourse(Long courseId, Course newCourse) {

        return courseRepository.updateCourse(courseId,newCourse);
    }

    @Override
    public String deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
        return "Successfully deleted";
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }
}

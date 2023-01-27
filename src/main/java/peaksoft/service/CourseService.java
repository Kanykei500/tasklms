package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<Course> getAllCoursesSortByCreateAt(String ascOrDesc);
    Course updateCourse(Long courseId,Course newCourse);
    String deleteCourseById(Long id);
    // (курсту очургондо, курска assign болгон инструктор очпошу керек, курсун ичиндеги сабактар очуш керек)
    Course  getCourseByName(String name);
}

package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long instructorId,Instructor newInstructor);
    Instructor getInstructorById(Long id);
    List<Instructor> getInstructorsByCourseId(Long courseId);
    String deleteInstructorById(Long id);
    //  (инструктор очкондо, инструкторго тиешелуу курс очпошу керек)
    void assignInstructorToCourse(Long instructorId,Long courseId);

}

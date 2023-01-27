package peaksoft.repository;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorRepository {

    String saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long instructorId,Instructor newInstructor);
    Instructor getInstructorById(Long id);
    List<Instructor>getInstructorsByCourseId(Long courseId);
    String deleteInstructorById(Long id);
   void assignInstructorToCourse(Long instructorId,Long courseId);




}

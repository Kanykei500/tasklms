package peaksoft.service;

import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.InstructorRepositoryImpl;

import java.util.List;

public class InstructorServiceImpl  implements InstructorService{
    InstructorRepository instructorRepository=new InstructorRepositoryImpl();

    @Override
    public String saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
        return "Successfully saved";
    }

    @Override
    public Instructor updateInstructor(Long instructorId, Instructor newInstructor) {

        return instructorRepository.updateInstructor(instructorId, newInstructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        return instructorRepository.getInstructorsByCourseId(courseId);
    }

    @Override
    public String deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);
        return "Successfully deleted";
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId,courseId);

    }
}

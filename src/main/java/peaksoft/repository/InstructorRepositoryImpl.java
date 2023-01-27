package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.configuration.DatabaseConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository,AutoCloseable {
    private final EntityManager entityManager= DatabaseConfig.getEntityManager();

    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getFirstName()+"is successfully saved";
    }

    @Override
    public Instructor updateInstructor(Long instructorId, Instructor newInstructor) {
        entityManager.getTransaction().begin();
        Instructor reference = entityManager.getReference(Instructor.class, instructorId);
        reference.setFirstName(newInstructor.getFirstName());
        reference.setLastName(newInstructor.getLastName());
        reference.setPhoneNumber(newInstructor.getPhoneNumber());
        reference.setEmail(newInstructor.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
        return reference;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor result = entityManager.createQuery("select i from  Instructor i where i.id=:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
        return result;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Instructor> resultList = entityManager.createQuery(" select i from Instructor i join Course c on \n" +
                        "                i.id = c.id  where c.id=:id", Instructor.class)
                .setParameter("id", courseId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();


        return resultList;
    }

    @Override
    public String deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getFirstName()+"is successfully deleted";
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        List<Instructor> instructorList = new ArrayList<>(Arrays.asList(instructor));
        List<Course> courseList = new ArrayList<>(Arrays.asList(course));
        course.setInstructors(instructorList);
        instructor.setCourses(courseList);
        entityManager.merge(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void close() throws Exception {

    }
}

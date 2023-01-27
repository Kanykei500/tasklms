package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.configuration.DatabaseConfig;
import peaksoft.entity.Course;

import java.util.List;

public class CourseRepositoryImpl  implements CourseRepository,AutoCloseable{
    private final EntityManager entityManager= DatabaseConfig.getEntityManager();

    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName()+"is successfully saved";
    }

    @Override
    public Course getCourseById(Long courseId) {
        entityManager.getTransaction().begin();
        Course result = entityManager.createQuery("select c from Course c where c.id=:id", Course.class).
                setParameter("id", courseId).
                getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result ;
    }

    @Override
    public List<Course> getAllCoursesSortByCreateAt(String ascOrDesc) {
        entityManager.getTransaction().begin();

        switch (ascOrDesc) {
            case "asc" -> {
                return entityManager.createQuery("select c from Course c order by createAt").getResultList();
            }
            case "desc" -> {
                return entityManager.createQuery("select c from Course  c order by createAt desc ").getResultList();
            }
        }
            entityManager.getTransaction().commit();
            entityManager.close();


        return null;
    }

    @Override
    public Course updateCourse(Long courseId, Course newCourse) {
        entityManager.getTransaction().begin();
        Course reference = entityManager.getReference(Course.class, courseId);
        reference.setCourseName(newCourse.getCourseName());
        reference.setDescription(newCourse.getDescription());
        reference.setDuration(newCourse.getDuration());
        reference.setCreateAt(newCourse.getCreateAt());
        reference.setImageLink(newCourse.getImageLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        return reference;
    }

    @Override
    public String deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();

        return course.getCourseName()+"is successfully deleted";
    }

    @Override
    public Course getCourseByName(String name) {
        entityManager.getTransaction().begin();
        Course courseName = entityManager.createQuery("select c from Course  c where c.courseName=:courseName", Course.class)
                .setParameter("courseName", name)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseName;
    }

    @Override
    public void close() throws Exception {

    }
}

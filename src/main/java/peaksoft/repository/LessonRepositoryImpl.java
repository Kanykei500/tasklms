package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.configuration.DatabaseConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl implements LessonRepository, AutoCloseable {
    private final EntityManager entityManager = DatabaseConfig.getEntityManager();

    @Override
    public String saveLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson + "successfully saved";
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.getReference(Lesson.class, id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();

        return lesson1;
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        entityManager.getTransaction().begin();
        Lesson result = entityManager.createQuery("select l from Lesson l where l.id=:id", Lesson.class)
                .setParameter("id", lessonId)
                .getSingleResult();
        return result;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Lesson> lessonList = entityManager.createQuery("select l from Lesson l join Course c" +
                        " on l.id=c.id where c.id=:id", Lesson.class)
                .setParameter("id", courseId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessonList;
    }

    @Override
    public void close() throws Exception {

    }
}

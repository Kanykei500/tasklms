package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.configuration.DatabaseConfig;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository,AutoCloseable {
    private final EntityManager entityManager= DatabaseConfig.getEntityManager();


    @Override
    public String saveTask(Long id,Task task) {
        entityManager.getTransaction().begin();
        List<Task>tasks=new ArrayList<>();
        Lesson lesson = entityManager.find(Lesson.class, id);
        tasks.addAll(lesson.getTasks());
        tasks.add(task);
        lesson.setTasks(tasks);

        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task+"Successfully saved";
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        entityManager.getTransaction().begin();
        Task reference = entityManager.getReference(Task.class, id);
        reference.setTask(newTask.getTask());
        reference.setDeadLine(newTask.getDeadLine());
        entityManager.getTransaction().commit();

        return reference;
    }

    @Override
    public List<Task> getAllTasksByLessonId(Long lessonId) {
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.createQuery("select t from Task  t join Lesson  l on " +
                        "t.id=l.id where l.id=:id", Task.class)
                .setParameter("id", lessonId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @Override
    public String deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
        return task+"is successfully deleted";
    }

    @Override
    public void close() throws Exception {

    }
}

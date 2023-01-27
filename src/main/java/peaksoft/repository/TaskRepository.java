package peaksoft.repository;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskRepository {
    String saveTask(Long id,Task task);
    Task updateTask(Long id,Task newTask);
    List<Task>getAllTasksByLessonId(Long lessonId);
    String deleteTaskById(Long id);
}

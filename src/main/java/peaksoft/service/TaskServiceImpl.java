package peaksoft.service;

import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository=new TaskRepositoryImpl();

    @Override
    public String saveTask(Long id,Task task) {
        taskRepository.saveTask(id, task);
        return "Successfully saved";
    }

    @Override
    public Task updateTask(Long id, Task newTask) {

        return taskRepository.updateTask(id, newTask);
    }

    @Override
    public List<Task> getAllTasksByLessonId(Long lessonId) {
        return taskRepository.getAllTasksByLessonId(lessonId);
    }

    @Override
    public String deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
        return "Successfully deleted";
    }
}

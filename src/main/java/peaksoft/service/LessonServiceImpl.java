package peaksoft.service;

import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.LessonRepositoryImpl;

import java.util.List;

public class LessonServiceImpl implements LessonService{
    LessonRepository lessonRepository=new LessonRepositoryImpl();

    @Override
    public String saveLesson(Long id,Lesson lesson) {
        lessonRepository.saveLesson(id, lesson);
        return "Successfully saved";
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {

        return lessonRepository.updateLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.getLessonById(lessonId);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        return lessonRepository.getLessonsByCourseId(courseId);
    }



}

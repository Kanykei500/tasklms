package peaksoft.repository;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonRepository {
  String   saveLesson(Long id,Lesson lesson);
  Lesson updateLesson(Long id,Lesson lesson);
  Lesson getLessonById(Long lessonId);
  List<Lesson>getLessonsByCourseId(Long courseId);


}

package pro.sky.second.course.work.service;

import org.springframework.stereotype.Service;
import pro.sky.second.course.work.domain.Question;

import java.util.Collection;

@Service
public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}

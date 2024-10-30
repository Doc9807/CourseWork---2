package pro.sky.second.course.work.service;

import org.springframework.stereotype.Service;
import pro.sky.second.course.work.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();

    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        boolean add = questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size());
        ArrayList<Question> result = new ArrayList<>(questions);
        return result.get(index);
    }
}

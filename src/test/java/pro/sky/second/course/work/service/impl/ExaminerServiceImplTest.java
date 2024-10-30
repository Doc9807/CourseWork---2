package pro.sky.second.course.work.service.impl;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.second.course.work.domain.Question;
import pro.sky.second.course.work.exception.BadQuestionException;
import pro.sky.second.course.work.service.QuestionService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {

    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    private Faker faker;

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
        faker = new Faker();
    }

    @Test
    void testGetQuestions_Success() {
        // check
        int amount = 2;
        Question question1 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        Question question2 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        when(questionService.getAll()).thenReturn(Arrays.asList(question1, question2));
        when(questionService.getRandomQuestion()).thenReturn(question1, question2);

        // test
        Collection<Question> result = examinerService.getQuestions(amount);

        // check
        assertEquals(amount, result.size());
        assertTrue(result.contains(question1));
        assertTrue(result.contains(question2));
    }

    @Test
    void testGetQuestions_InsufficientQuestions() {
        // check
        int amount = 3;
        Question question1 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        when(questionService.getAll()).thenReturn(List.of(question1));

        // test
        assertThrows(BadQuestionException.class, () -> {
            examinerService.getQuestions(amount);
        });
    }

    @Test
    void testGetQuestions_ZeroAmount() {
        // test
        assertThrows(BadQuestionException.class, () -> {
            examinerService.getQuestions(0);
        });
    }
}
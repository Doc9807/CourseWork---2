package pro.sky.second.course.work.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.second.course.work.domain.Question;

import java.util.Collection;
import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private Faker faker;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        faker = new Faker();
    }

    @Test
    void testAddQuestion_WithStringParameters() {
        String questionText = faker.lorem().sentence();
        String answerText = faker.lorem().sentence();

        // Check
        Question addedQuestion = javaQuestionService.add(questionText, answerText);

        // Test
        assertNotNull(addedQuestion);
        assertEquals(questionText, addedQuestion.getQuestion());
        assertEquals(answerText, addedQuestion.getAnswer());
        assertTrue(javaQuestionService.getAll().contains(addedQuestion));
    }

    @Test
    void testAddQuestion_WithQuestionObject() {
        Question question = new Question(faker.lorem().sentence(), faker.lorem().sentence());

        // Check
        Question addedQuestion = javaQuestionService.add(question);

        // Test
        assertNotNull(addedQuestion);
        assertTrue(javaQuestionService.getAll().contains(addedQuestion));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        javaQuestionService.add(question);

        // Check
        Question removedQuestion = javaQuestionService.remove(question);

        // Test
        assertNotNull(removedQuestion);
        assertFalse(javaQuestionService.getAll().contains(removedQuestion));
    }

    @Test
    void testGetAllQuestions() {
        Question question1 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        Question question2 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        // Check
        Collection<Question> questions = javaQuestionService.getAll();

        // Test
        assertEquals(2, questions.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }

    @Test
    void testGetRandomQuestion() {
        Question question1 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        Question question2 = new Question(faker.lorem().sentence(), faker.lorem().sentence());
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        // Check
        Question randomQuestion = javaQuestionService.getRandomQuestion();

        // Test
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }
}

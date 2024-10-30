package pro.sky.second.course.work.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.second.course.work.domain.Question;
import pro.sky.second.course.work.service.JavaQuestionService;

import java.util.Collection;

@RestController
@ResponseStatus
@RequestMapping("/exam")
public class JavaQuestionController {

    public final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    public Question getAddQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}

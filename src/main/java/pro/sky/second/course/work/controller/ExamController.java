package pro.sky.second.course.work.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.second.course.work.domain.Question;
import pro.sky.second.course.work.service.ExaminerService;

import java.util.Collection;

@RestController
@ResponseStatus
@RequestMapping("/exam")
public class ExamController {

    public final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getNumberAmountQuestion(@PathVariable("amount") int amountQuestion) {
        return examinerService.getQuestions(amountQuestion);
    }

}

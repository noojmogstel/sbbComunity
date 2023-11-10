package mjComunity.com.project.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mjComunity.com.project.user.SiteUser;
import mjComunity.com.project.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import mjComunity.com.project.answer.AnswerForm;

import java.security.Principal;
import java.util.List;
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id,AnswerForm answerForm){

        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(),siteUser);
        return "redirect:/question/list";
    }
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page",defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";

    }
}

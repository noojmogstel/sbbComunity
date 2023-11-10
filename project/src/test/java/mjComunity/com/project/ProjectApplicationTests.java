package mjComunity.com.project;

import mjComunity.com.project.question.Question;
import mjComunity.com.project.question.QuestionRepository;
import mjComunity.com.project.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa(){
		for(int i=0;i<=300;i++){
			String subject = String.format("테스트 데이터입니다:[%03d]",i);
			String content = "Test Content";
			this.questionService.create(subject,content,null);
		}
	}

}

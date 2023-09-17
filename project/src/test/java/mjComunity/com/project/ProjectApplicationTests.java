package mjComunity.com.project;

import mjComunity.com.project.question.Question;
import mjComunity.com.project.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa(){
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}

}

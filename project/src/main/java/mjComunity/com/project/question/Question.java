package mjComunity.com.project.question;

import mjComunity.com.project.answer.Answer;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import mjComunity.com.project.user.SiteUser;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity /*JPA가 엔티티로 인식하게 함.*/
public class Question {
    @Id /*속성을 기본 키로 지정한다. */
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*속성에 값을 세팅하지 않아도 1씩 자동 증가되어 저장됨. startegy는 고유번호를 생성하는 옵션*/
    private Integer id;

    @Column(length=200)
    private String subject;

    @Column(columnDefinition ="TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

}

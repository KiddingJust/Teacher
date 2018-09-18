package domain;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionVO {
   private Integer qno, limittime;
   private String question;
   private Date regdate;
   
}
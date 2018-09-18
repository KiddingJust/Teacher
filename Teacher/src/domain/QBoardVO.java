package domain;

import java.util.Date;

import lombok.Data;

@Data
public class QBoardVO {

   private Integer mno, bno;
   private String title, cnt, answer, addfile;
   private Date regdate, updatedate; 
}

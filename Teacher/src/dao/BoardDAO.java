package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.PageDTO;
import domain.QBoardVO;
import domain.QuestionVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAO {

	  	   
	private static  final String LIST = "select *\n" + 
			"from(select\n" + 
			"/*+ INDEX_DESC (tbl_question pk_question) */\n" + 
			"ROWNUM rn, qno, question, regdate\n" + 
			"from tbl_question\n" + 
			"where qno > 0 and ROWNUM <= (? * ?))\n" + 
			"where rn > (?-1)*?;";

	private static final String QUESTION = "insert into tbl_QUESTION (QNO, QUESTION, REGDATE, WRITER) " +
            "values(seq_board.nextval,?,?,?)";
	
    private static final String RESULT = "select * from tbl_Question where qno = ?";
    
	private static  final String BOARD = "select *\n" +
            "from (select\n" +
            "             /*+ INDEX_DESC (tbl_board pk_board) */\n" +
            "          ROWNUM rn, mno, question, regdate, ? \n" +
            "      from TBL_QBoardVO\n" +
            "      where qno > 0\n" +
            "        and ROWNUM <= (? * ?))\n" +
            "where rn > (?-1) * ?";

    public List<QuestionVO> getList() throws Exception{
        List<QuestionVO> list = new ArrayList<>();

        log.debug(LIST);

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(LIST);
                int i = 1;
                stmt.setInt(i++,pageDTO.getPage());
                stmt.setInt(i++,pageDTO.getSize());
                stmt.setInt(i++,pageDTO.getPage());
                stmt.setInt(i++,pageDTO.getSize());
                rs = stmt.executeQuery();

                while(rs.next()){
                	QuestionVO vo = new QuestionVO();
                    int idx = 2;

                    //而щ읆紐낅낫�떎 �씤�뜳�뒪踰덊샇媛� 鍮좊Ⅴ�떎.
                    vo.setQno(rs.getInt(idx++));
                    vo.setQuestion(rs.getString(idx++));
                    vo.setRegdate(rs.getDate(idx++));
                    vo.set?????????(rs.getDate(idx++));
                    list.add(vo);
                }

            }
        }.executeAll();

        return list;
    }
    
    
    
    public QuestionVO getResult(Integer bno, boolean updateable) throws Exception{
    	QuestionVO vo = new QuestionVO();

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
              
                stmt = con.prepareStatement(RESULT);
                stmt.setInt(1,bno);
                rs = stmt.executeQuery();
                while(rs.next()){
                    vo.setQno(rs.getInt("qno"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setViewcnt(rs.getInt("viewcnt"));
                    vo.setRegdate(rs.getDate("regdate"));
                    vo.setUpdatedate(rs.getDate("updatedate"));
                }
            }
        }.executeAll();
        log.info(vo);
        return vo;
    }
    
    
    public List<QBoardVO> getBoard(PageDTO pageDTO)throws Exception{
        List<QBoardVO> list = new ArrayList<>();
        
        log.debug(pageDTO);
        log.debug(BOARD);

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(BOARD);
                int i = 1;
                stmt.setInt(i++,pageDTO.getPage());
                stmt.setInt(i++,pageDTO.getSize());
                stmt.setInt(i++,pageDTO.getPage());
                stmt.setInt(i++,pageDTO.getSize());
                rs = stmt.executeQuery();

                while(rs.next()){
                	QBoardVO vo = new QBoardVO();
                    int idx = 2;

                    //而щ읆紐낅낫�떎 �씤�뜳�뒪踰덊샇媛� 鍮좊Ⅴ�떎.
                    vo.setQno(rs.getInt(idx++));
                    vo.setQuestion(rs.getString(idx++));
                    vo.setRegdate(rs.getDate(idx++));
                    vo.set?????????(rs.getDate(idx++));
                    list.add(vo);
                }

            }
        }.executeAll();

        return list;
    }
    
}
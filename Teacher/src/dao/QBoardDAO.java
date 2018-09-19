package dao;

import domain.QBoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class QBoardDAO {
	
	private String prefix = "mapper.boardMapper";
	
	public void getList(QBoardVO vo) {
		
		try (SqlSession session = MyBatisLoader.sqlSession ) {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

	
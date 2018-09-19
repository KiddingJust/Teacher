package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import domain.PageDTO;
import domain.QBoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class QBoardDAO {
	
	private String prefix = "mapper.boardMapper";
	
	public List<QBoardVO> getList(PageDTO pageDTO) {
		
		log.debug(pageDTO);
		
		List<QBoardVO> list = new ArrayList<>();
		QBoardVO vo = new QBoardVO();
		
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true) ) {
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("page", 1);
			paramMap.put("size", 10);
		
			
			list = session.selectList(prefix + ".list",vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;	
	}
}

	
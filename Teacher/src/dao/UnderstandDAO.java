package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.QuestionVO;

public class UnderstandDAO {
	
	public List<QuestionVO> getList() {
		
	try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){	
		List<QuestionVO> list = session.selectList("mapper.UnderstandMapper.selectList");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
}

	
}

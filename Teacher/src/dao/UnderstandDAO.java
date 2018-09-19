package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.QuestionVO;
import domain.ResponseVO;

public class UnderstandDAO {
	
	public List<QuestionVO> getList() {
		List<QuestionVO> list = new ArrayList<>();
	try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){	
		list = session.selectList("mapper.UnderstandMapper.list");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
	}

	public void write(QuestionVO vo) {
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){	
			session.insert("QuestionMapper.write", vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<ResponseVO> getResult() {
		List<ResponseVO> list = new ArrayList<>();
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){	
			list = session.selectList("mapper.UnderstandMapper.result");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}
	


	

}
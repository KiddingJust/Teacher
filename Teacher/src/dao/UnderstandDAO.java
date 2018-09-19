package dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.PageDTO;
import domain.QuestionVO;
import domain.ResponseVO;

public class UnderstandDAO {

	private String preFix =  "mapper.UnderstandMapper";
	
	static SqlSessionFactory sqlSessionFactory;

	static{
		try {
			String resource = "mybatis-config.xml";
	         InputStream inputStream = Resources.getResourceAsStream(resource);
	          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public List<QuestionVO> getList(PageDTO dto) {
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			return session.selectList(preFix + ".qlist", dto.getPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(QuestionVO vo) {
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			session.insert(preFix + ".write", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ResponseVO> getResult() {
		List<ResponseVO> list = new ArrayList<>();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			return session.selectList(preFix + ".result");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
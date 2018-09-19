package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UnderstandDAO;
import domain.PageDTO;
import domain.PageMaker;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/question/*")
public class QuestionController extends AbstractController{

	UnderstandDAO dao = new UnderstandDAO();

	//list
	 public String qlistGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 	System.out.println("qlistget.....");
	        PageDTO dto = PageDTO.of()
	                .setPage(Converter.getInt(req.getParameter("page"), 1))
	                .setSize(Converter.getInt(req.getParameter("size"), 10));

	        int total = 320;
	        PageMaker pageMaker = new PageMaker(total, dto);

	        req.setAttribute("pageMaker", pageMaker);
	        req.setAttribute("qlist", dao.getList(dto));

	        return "qlist";
	    }

	 public String resultGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
	        System.out.println("resultGET...........................");

	        String qnoStr = req.getParameter("qno");
	        System.out.println("==================qnoStr:" + qnoStr);
	        int qno = Converter.getInt(qnoStr,-1);
	        System.out.println("==================qno:" + qno);

	        int page = Converter.getInt(req.getParameter("page"),-1);
	        
	        req.setAttribute("page", page);
	        req.setAttribute("board",dao.getResult(qno));

	        return "result";
	    }
	 
	 //result
	 
/*	    public String readGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	        String bnoStr = req.getParameter("bno");
	        int bno = Converter.getInt(bnoStr, -1);
	        String pageStr = req.getParameter("page");
	        int page = Converter.getInt(pageStr, -1);
	        boolean updateable = false;
	        if (bno == -1) {
	            throw new Exception("invalid data");
	        }
	
	        return "read";
	    }*/

	    public String getBasic() {
	        return "/admin/question/";
	    }
}
package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QBoardDAO;
import domain.PageDTO;
import domain.PageMaker;
import lombok.extern.log4j.Log4j;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/board/*")
@Log4j
public class BoardController extends AbstractController {

	private QBoardDAO dao = new QBoardDAO();
	
	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("listGET............");
		
		PageDTO dto = PageDTO.of().setPage(Converter.getInt(req.getParameter("page"),1))
				.setSize(Converter.getInt(req.getParameter("size"),10));
		
		int total = 320;
		PageMaker pageMaker = new PageMaker(total, dto);
		
		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("list", dao.getList(dto));
		
		return "boardlist";
	}

	@Override
	public String getBasic() {
	
		return "admin/board/";
	}

	
}
package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.QBoardDAO;
import domain.PageDTO;
import domain.PageMaker;
import domain.QBoardVO;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/qna/*")

public class BoardController extends AbstractController {

	private QBoardDAO dao = new QBoardDAO();
	private static final long serialVersionUID = 1L;
	
	public String boardGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("BoardGET............");
		
		PageDTO dto = PageDTO.of().setPage(Converter.getInt(req.getParameter("page"),1))
				.setSize(Converter.getInt(req.getParameter("size"),10));
		
		int total = dao.countList();
		
		System.out.println(total);
		PageMaker pageMaker = new PageMaker(total, dto);
		
		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("list", dao.getList(dto));
		
		return "board";
	}

	 public String bwriteGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
	        System.out.println("writeGET..................");

	        return "bwrite";

	    }
	
	public String bwritePOST (HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("writePOST..................");
		
		req.setCharacterEncoding("UTF-8");
		QBoardVO vo = new QBoardVO();
		
		int page = Converter.getInt(req.getParameter("page"),-1);
		req.setAttribute("page",page);
	
		
		String title = req.getParameter("title");
		String writer = req.getParameter("name");
		String content = req.getParameter("content");
		
		
		vo.setTitle(title);
		vo.setName(writer);
		vo.setCnt(content);
		
		
		
		dao.create(vo);
		
		
		return "redirect/board";
	}
	
	public String breadGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{

		System.out.println("readGET............");
		QBoardDAO dao = new QBoardDAO();
		QBoardVO vo = dao.read(Converter.getInt(req.getParameter("bno"), -1));
		System.out.println(vo);
		req.setAttribute("board", vo);
		
		return "bread";
		
	}

	public String bremovePOST (HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("removePOST...........");
		
		int bno = Converter.getInt(req.getParameter("bno"),-1);
		
		dao.remove(bno);
		
		System.out.println("removeEND.....");
		return "redirect/board";
	}

	public String bmodifyGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		System.out.println("modifyGET...........");
		
		int bno = Converter.getInt(req.getParameter("bno"), -1);
		String pageStr = req.getParameter("page");
		
		req.setAttribute("board", dao.read(bno));
		req.setAttribute("page", pageStr);
		
		
		return "bmodify";
	}
	
	public String bmodifyPOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		
		req.setCharacterEncoding("UTF-8");
        System.out.println("modifyPOST..............");

        QBoardVO vo = new QBoardVO();
        int bno = Converter.getInt(req.getParameter("bno"),-1);

        vo.setBno(bno);
        vo.setTitle(req.getParameter("title"));
        vo.setCnt(req.getParameter("content"));

        dao.modify(vo);


        req.setAttribute("board",dao.read(bno));

        int page = Converter.getInt(req.getParameter("page"),-1);
        req.setAttribute("page",page);
       
        
        return "redirect/board";
	}
	
	
	@Override
	public String getBasic() {
	
		return "/admin/qna/";
	}

	
}
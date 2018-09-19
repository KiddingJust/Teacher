//package web;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.QBoardDAO;
//import domain.PageDTO;
//import domain.PageMaker;
//import domain.QBoardVO;
//import web.util.Converter;
//
//@WebServlet(urlPatterns = "/admin/*")
//public class BoardController extends AbstractController {
//
//	private QBoardDAO dao = new QBoardDAO();
//	private QBoardVO vo = new QBoardVO();
//	
//	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
//		System.out.println("BoardGET............");
//		
//		PageDTO dto = PageDTO.of().setPage(Converter.getInt(req.getParameter("page"),1))
//				.setSize(Converter.getInt(req.getParameter("size"),10));
//		
//		int total = 320;
//		PageMaker pageMaker = new PageMaker(total, dto);
//		
//		req.setAttribute("pageMaker", pageMaker);
//		req.setAttribute("list", dao.getList(dto));
//		
//		return "board";
//	}
//
//	 public String bwriteGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
//	        System.out.println("writeGET..................");
//
//	        return "bwrite";
//
//	    }
//	
//	private String bwritePOST (HttpServletRequest req, HttpServletResponse resp) throws Exception{
//		System.out.println("writePOST..................");
//		
//		req.setCharacterEncoding("UTF-8");
//		
//		String title = req.getParameter("title");
//		String writer = req.getParameter("name");
//		String content = req.getParameter("content");
//		
//		vo.setTitle(title);
//		vo.setName(writer);
//		vo.setCnt(content);
//		
//		dao.create(vo);
//		
//		int page = Converter.getInt(req.getParameter("page"),-1);
//		req.setAttribute("page",page);
//		
//		
//		return "board";
//	}
//	
//	@Override
//	public String getBasic() {
//	
//		return "/admin/";
//	}
//
//	
//}
//=======
////package web;
////
////import org.apache.log4j.Logger;
////
////import dao.QBoardDAO;
////
////public class BoardController {
////
////	QBoardDAO dao = new QBoardDAO();
////
////	
////}
//>>>>>>> refs/remotes/origin/master

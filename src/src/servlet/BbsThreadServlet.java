package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentsDAO;
import dao.ThreadsDAO;
import dao.UsersDAO;
import model.Bbs_thread;
import model.Comments;
import model.LoginUser;
import model.Result;

/**
 * Servlet implementation class BbsThreadServlet
 */
@WebServlet("/BbsThreadServlet")
public class BbsThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}
//		LoginUser loginuser = (LoginUser)session.getAttribute("username");
//		String username = loginuser.getUsername();

		//bbs_thread.jspからスレッドのidをもらう
		String thread_bbs = request.getParameter("thread_no");
		ThreadsDAO thDao = new ThreadsDAO();
		String threadTitle = thDao.to_thread(thread_bbs);
		String threadID = thDao.getThread_id(thread_bbs);
		CommentsDAO cDAO=new CommentsDAO();
		List<Comments> comment_bbs= cDAO.to_thread(threadID);

		session.setAttribute("comments",new Bbs_thread(threadTitle,threadID,comment_bbs));



		// jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_thread.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		投稿されたユーザIDを取ってくる
		HttpSession session = request.getSession();
		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();
		UsersDAO iDao = new UsersDAO();
		String userId= iDao.getUser_id(username);
//		投稿スレッドIDを取ってくる
		request.setCharacterEncoding("UTF-8");
		String threadId = request.getParameter("getThreadId");
//		投稿された内容を取ってくる
		String content = request.getParameter("post1");
//		投稿時間を取ってくる
		Date now = new Date();//現在時刻
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);//DateをStringに変換
		CommentsDAO cDao = new CommentsDAO();
		if (cDao.insert(new Comments(threadId,null, userId, content, time))) {	// 登録成功
			if (cDao.insert_update()) {	// 登録成功
				// メニューサーブレットにリダイレクトする
//				response.sendRedirect("/WEB-INF/jsp/bbs_thread.jsp");
				//response.sendRedirect("/BbsThreadServlet");
//				doGet(request,response);
				request.setAttribute("result",
				new Result("登録成功！", "コメントを登録することができました。"));
			}
			else {									// 登録失敗
				//  （要変更？）リクエストスコープに、タイトル、メッセージ、戻り先を格納する★保留
				request.setAttribute("result",
				new Result("登録失敗！", "コメントを登録することができませんでした。"));
			}


			//bbs_thread.jspからスレッドのidをもらう
			String thread_bbs = request.getParameter("thread_no");
			ThreadsDAO thDao = new ThreadsDAO();
			String threadTitle = thDao.to_thread(thread_bbs);
			String threadID = thDao.getThread_id(thread_bbs);
			CommentsDAO cDAO=new CommentsDAO();
			List<Comments> comment_bbs= cDAO.to_thread(threadID);

			session.setAttribute("comments",new Bbs_thread(threadTitle,threadID,comment_bbs));

				//  （要変更？）結果ページにフォワードする★保留
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_thread.jsp");
				dispatcher.forward(request, response);
				return;

			}


	}}

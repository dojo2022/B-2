package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThreadsDAO;
import model.Result;
import model.Threads;

/**
 * Servlet implementation class BbsNewServlet
 */
@WebServlet("/BbsNewServlet")
public class BbsNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
	/*	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		} */

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_newthread.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		} */

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String number = request.getParameter("number");
		String content_bbs = request.getParameter("content_bbs");
		String thread_bbs = request.getParameter("thread_bbs");
		String category_bbs = request.getParameter("select");
//thread_bbs,category_bbsで新しいthreadsテーブルに追加
		//上の条件で自動で追加されたthread_idを取得する
		//追加したthread_idとcontentbbsとuser_idを使ってcommentテーブルに追加

		// 登録処理を行う
		ThreadsDAO tDao = new ThreadsDAO();
		if (tDao.insert(new Threads( /*thread_id,*/ thread_bbs, category_bbs, content_bbs))) {
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_thread.jsp");
			dispatcher.forward(request, response);
		}
		else {// リクエストスコープに、失敗したよというタイトルとメッセージを送る。
			request.setAttribute("result",
			new Result("false", "正常に作成ができませんでした"));
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_newthread.jsp");
			dispatcher.forward(request, response);
		}

	}
}

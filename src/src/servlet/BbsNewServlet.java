package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThreadsDAO;
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
		String thread_id = request.getParameter("thread_id");
		String thread_bbs = request.getParameter("thread_bbs");
		String category_bbs = request.getParameter("category_bbs");


		// 登録処理を行う
		ThreadsDAO tDao = new ThreadsDAO();
		if (tDao.insert(new Threads( thread_id, thread_bbs, category_bbs ))) {	// 登録成功
			request.setAttribute("msgOK", "");
		}
		else { // 既に使用されているスレッド名だった場合の処理
			request.setAttribute("msgNG", "※スレッド名が既に利用されています");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BbsThreadServlet");
		dispatcher.forward(request, response);
	}
}

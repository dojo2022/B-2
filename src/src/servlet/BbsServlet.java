

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ThreadsDAO;
import model.LoginUser;
import model.Threads;


@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
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

		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();
		// 登録済みの全スレッド検索
		ThreadsDAO tDao = new ThreadsDAO();
		List<Threads> threadList = tDao.select_threads(new Threads(null));

		// 検索結果をリクエストスコープに格納する ☆カテゴリ、難易度を踏まえて資格名、カテゴリ、難易度を格納
		request.setAttribute("threadList", threadList);

		// jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// カテゴリー検索
		// リクエストパラメータを取得する ☆カテゴリ
		request.setCharacterEncoding("UTF-8");
		String category_bbs = request.getParameter("select_bbsCategory"); //カテゴリ
		ThreadsDAO tDao = new ThreadsDAO();
		List<Threads> threadList = tDao.select_threads(new Threads(category_bbs));

		// 検索結果をリクエストスコープに格納する ☆カテゴリ、難易度を踏まえて資格名、カテゴリ、難易度を格納
		request.setAttribute("threadList", threadList);

		// jspへ結果を返す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp");
		dispatcher.forward(request, response);
//		スレタイを押されたらタイトル、コメント、時間を持ってきてスコープに入れる

	}

}
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

import dao.CertificationsDAO;
import model.Certifications;

/**
 * Servlet implementation class Matching2Servlet
 */
@WebServlet("/Matching2Servlet")
public class Matching2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("username") == null) {
//					response.sendRedirect("/tasuma/LoginServlet");
//					return;
//					}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/matching2.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}



		// リクエストパラメータを取得する ☆カテゴリ、難易度
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category"); //カテゴリ
		String level = request.getParameter("level"); //レベル

		// 検索処理を行う　☆カテゴリ、難易度
		CertificationsDAO cDao = new CertificationsDAO();
		List<Certifications> cardList = cDao.select_level(new Certifications(category,level));

		// 検索結果をリクエストスコープに格納する ☆カテゴリ、難易度を踏まえて資格名、カテゴリ、難易度を格納
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/matching3.jsp");
		dispatcher.forward(request, response);
	}
}


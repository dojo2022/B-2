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
 * Servlet implementation class Matching1Servlet
 */
@WebServlet("/Matching1Servlet")
public class Matching1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}
		// jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/matching1.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する ☆名前、カテゴリ、★難易度
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category"); //カテゴリ

		// 検索処理を行う　☆名前、カテゴリ、★難易度
		CertificationsDAO cDao = new CertificationsDAO();
		List<Certifications> cardList = cDao.select(new Certifications( category));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/matching2.jsp");
		dispatcher.forward(request, response);
	}
}

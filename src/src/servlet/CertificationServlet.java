package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginUser;

/**
 * Servlet implementation class CertificationServlet
 */
@WebServlet("/CertificationServlet")
public class CertificationServlet extends HttpServlet {
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

		// My資格ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification.jsp");
				dispatcher.forward(request, response);


		// リクエストパラメータを取得する
		// ユーザ名をスコープから取得→取得したユーザ名をもとに各種データをデータベースから取得＋スコープに保存
		// 登録した資格のデータを持ってくる？
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("USERNAME");
		String certification = request.getParameter("CERTIFICATION");

		// セッションスコープにIDを格納する
		HttpSession session = request.getSession();
		session.setAttribute("username", new LoginUser(username));
   }

}

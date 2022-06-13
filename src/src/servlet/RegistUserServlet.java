package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.LoginUser;
import model.Users;
//import model.LoginUser;
//import model.Result;

/**
 * Servlet implementation class RegistUserServlet
 */
@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使わない？
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("USERNAME");
		String password = request.getParameter("PASSWORD");
		String mail = request.getParameter("MAIL");

		// ユーザー登録処理

		UsersDAO iDao = new UsersDAO();
		if (iDao.insert(new Users(username, password, mail))) {	// 登録成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("username", new LoginUser(username));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/tasuma/MenuServlet");
		}
		else {									// 登録失敗
			//  （要変更？）リクエストスコープに、タイトル、メッセージ、戻り先を格納する★保留
//			request.setAttribute("result",
//			new Result("登録失敗！", "IDを変えてもう一度やり直してください。", "/simpleBC/LoginServlet"));

			//  （要変更？）結果ページにフォワードする★保留
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//			dispatcher.forward(request, response);
		}
	}

	}



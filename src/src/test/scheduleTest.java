package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.LoginUser;
import model.Result;
import model.Users;

/**
 * Servlet implementation class scheduleTest
 */
@WebServlet("/scheduleTest")
public class scheduleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//scheduleServlet,jsp確認用のファイル
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String username = "太郎山田";
				String password = "password";

				// ログイン処理を行う
				UsersDAO uDao = new UsersDAO();
				if (uDao.isLoginOK(new Users(username, password))) {	// ログイン成功
					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					session.setAttribute("username", new LoginUser(username));

					//スケジュールテストページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/scheduleTest.jsp");
					dispatcher.forward(request, response);
				}
				else {									// ログイン失敗
					// リクエストスコープに、失敗したよというタイトルとメッセージを送る。
					request.setAttribute("result",
					new Result("false", "IDまたはPWに間違いがあります。"));

					//	もう一度ログインjspにフォワード（？）する
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
				}


//		//スケジュールテストページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/scheduleTest.jsp");
//		dispatcher.forward(request, response);


//		//schedule.jsp確認用のファイル
//		// スケジュールページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule.jsp");
//		dispatcher.forward(request, response);
	}
}

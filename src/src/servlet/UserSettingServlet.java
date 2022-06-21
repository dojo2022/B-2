package servlet;

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
 * Servlet implementation class UserSettingServlet
 */
@WebServlet("/UserSettingServlet")
public class UserSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSettingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
		response.sendRedirect("/tasuma/LoginServlet");
			return;
		}

		// ユーザー設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_setting.jsp");
		dispatcher.forward(request, response);


	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");



			//セッションスコープからインスタンスを取り出す
			HttpSession session = request.getSession();
			LoginUser old_username_obj = (LoginUser)session.getAttribute("username");
			String old_username = old_username_obj.getUsername();
			//old_usernameからold_mail,old_pwを取るselect DAOを作成する
			
			//変数oldpw,oldmailに代入する

			// 更新を行う
			UsersDAO iDao = new UsersDAO();
			if (iDao.update(new Users(old_username,username, password, mail))) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "登録情報を変更しました"));

//				もう一度ユーザー設定jspにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_setting.jsp");
				dispatcher.forward(request, response);
			}else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "変更に失敗しました"));
//				もう一度ユーザ設定jspにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_setting.jsp");
				dispatcher.forward(request, response);
			}
	}
}


package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.UserSetting;
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

	//	// もしもログインしていなかったらログインサーブレットにリダイレクトする
	//	HttpSession session = request.getSession();
	//	if (session.getAttribute("username") == null) {
	//		response.sendRedirect("/tasuma/LoginServlet");
	//		return;
	//	}
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

			// 更新を行う
			UsersDAO iDao = new UsersDAO();
			if (request.getParameter("change_profile").equals("更新")) {
				if (iDao.update(new Users(username, password, mail))) {	// 更新成功
					request.setAttribute("UserSetting",
					new UserSetting("更新成功！", "レコードを更新しました。", "/tasuma/MenuServlet"));
				}else {												// 更新失敗
					request.setAttribute("UserSetting",
					new UserSetting("更新失敗！", "レコードを更新できませんでした。", "/tasuma/UserSettingServlet"));
				}
			}
	}
}


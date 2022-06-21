package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CertificationsDAO;
import dao.My_certificationsDAO;
import dao.UsersDAO;
import model.LoginUser;
import model.Menu_data;
import model.My_certifications;
import model.Result;

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
				if (session.getAttribute("username") == null) {
					response.sendRedirect("/tasuma/LoginServlet");
					return;
				}

				// ユーザ名の取得
				LoginUser loginuser = (LoginUser)session.getAttribute("username");
				String username = loginuser.getUsername();

				// My資格の取得
				UsersDAO uDao = new UsersDAO();
				String user_id = uDao.getUser_id(username);
				My_certificationsDAO myDao = new My_certificationsDAO();
				List<My_certifications> myList = myDao.select(new My_certifications(null, user_id, null, null));
				List<Menu_data> menu_data = new ArrayList<Menu_data>();
				CertificationsDAO cDao = new CertificationsDAO();

				// myListが空だったらフォワード
				if(myList.isEmpty()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification.jsp");
					dispatcher.forward(request, response);
					return;
				}
				for(My_certifications my :myList){

		 /* 		// 資格IDから資格名を取得 Gitが解決すれば
					String certification = cDao.getCertification(my.getCertification_id());
					menu_data.add(new Menu_data(certification, null, null, null));
		*/
				}
				// ""内は書き換える
				session.setAttribute("certification", menu_data);

				// My資格ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification.jsp");
				dispatcher.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}
*/

		// リクエストパラメータを取得する
		// 資格IDを持ってきて表示する？
		request.setCharacterEncoding("UTF-8");
		String certification_id = request.getParameter("certification_id");

   		// 削除を行う
    	My_certificationsDAO mDao = new My_certificationsDAO();
   	    if (mDao.delete(certification_id)) {	// 削除成功
		   request.setAttribute("result",
		   new Result("削除成功！", "レコードを削除しました。"));
	    }
	    else {						// 削除失敗
		   request.setAttribute("result",
		   new Result("削除失敗！", "レコードを削除できませんでした。"));
	    }

   	    // My資格ページにフォワードする
   		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification.jsp");
   		dispatcher.forward(request, response);

   	}
}

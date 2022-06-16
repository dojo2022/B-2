package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.My_certificationsDAO;
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
/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}
*/
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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}
*/

		// リクエストパラメータを取得する
		// ユーザ名とユーザIDと資格IDとテスト日程を持ってきて表示する？
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String certification = request.getParameter("certification");
		String certification_id = request.getParameter("certification_id");

   		// 削除を行う
    	My_certificationsDAO mDao = new My_certificationsDAO();
   	    if (mDao.delete(certification)) {	// 削除成功
		   request.setAttribute("result",
		   new Result("削除成功！", "レコードを削除しました。"));
	    }
	    else {						// 削除失敗
		   request.setAttribute("result",
		   new Result("削除失敗！", "レコードを削除できませんでした。"));
	    }
   	}
}

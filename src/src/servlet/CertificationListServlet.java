package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CertificationsDAO;

/* DAOが出来上がり次第起動できるのかも */

	/**
	 * Servlet implementation class SearchServlet
	 */
	@WebServlet("/CertificationListServlet")
	public class CertificationListServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("username") == null) {
				response.sendRedirect("/tasuma/LoginServlet");
				return;
			}
*/			// 資格名の情報を持ちながら遷移する処理↓↓↓(doPostからdoGetに移動させた)
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ID");
			String certification_id = request.getParameter("CERTIFICATION_ID");
			String certification = request.getParameter("CERTIFICATION");
			String category = request.getParameter("CATEGORY");

			// 検索処理を行う
			CertificationsDAO cDao = new CertificationsDAO();
	//		List<Certifications> cardList = cDao.select(new CertificationsDAO(id, null, null, null))

		    // 検索結果をリクエストスコープに格納する
	//		request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule.jsp");
	//		dispatcher.forward(request.response);

			} // 資格名の情報を持ちながら遷移する処理はここまで↑↑↑


			// カテゴリ検索の処理↓↓↓
			// リクエストパラメータを取得する
	//		request.setCharacterEncoding("UTF-8"); {
	//		String allit = request.getParameter("allit");
	//		String gengo = request.getParameter("gengo");
	//		String data = request.getParameter("data");
	//		String sec = request.getParameter("sec");
	//		String net = request.getParameter("net");
	//		String mana = request.getParameter("mana");
	//		String jimu = request.getParameter("jimu");
	//		String des = request.getParameter("des");

			// 検索処理を行う
			CertificationsDAO cDao = new CertificationsDAO();
	//		List<Certifications> cardList = cDao.select(new Certifications(allit, gengo, data, sec, net, mana, jimu, des));

			// 検索結果をリクエストスコープに格納する
	//		request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
	//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification_list.jsp");
	//		dispatcher.forward(request, response);

			// カテゴリ検索の処理はここまで↑↑↑
			}


	//		// 資格登録一覧ページにフォワードする
	//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Certification_List.jsp");
	//		dispatcher.forward(request, response);
	//	}


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		    // 資格名の情報を持ちながら遷移する処理↓↓↓
	/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { {
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/tasuma/LoginServlet");
				return;
			}
*/


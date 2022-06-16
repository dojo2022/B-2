package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CertificationsDAO;
import model.Certifications;

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
*/			// 資格名の情報を持ちながら遷移する処理↓↓↓
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ID");
			String certification_id = request.getParameter("CERTIFICATION_ID");
			String certification = request.getParameter("CERTIFICATION");
			String category = request.getParameter("CATEGORY");

			// 検索処理を行う
			CertificationsDAO cDao = new CertificationsDAO();
			List<Certifications> cardList = cDao.select(new Certifications(id, null, null, null));

		    // 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification_list.jsp");
			dispatcher.forward(request,response);

		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");

			// カテゴリ検索の処理↓↓↓
			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String allit = request.getParameter("allit");
			String gengo = request.getParameter("gengo");
			String data = request.getParameter("data");
			String sec = request.getParameter("sec");
			String net = request.getParameter("net");
			String mana = request.getParameter("mana");
			String jimu = request.getParameter("jimu");
			String des = request.getParameter("des");

			// 検索処理を行う
			// 各カテゴリをリクエストスコープに格納する
			CertificationsDAO cDao = new CertificationsDAO();
			List<Certifications> cardList_allit = cDao.select_allit();
			request.setAttribute("allit", cardList_allit);

			List<Certifications> cardList_gengo = cDao.select_gengo();
			request.setAttribute("gengo", cardList_gengo);

			List<Certifications> cardList_data = cDao.select_data();
			request.setAttribute("data", cardList_data);

			List<Certifications> cardList_sec = cDao.select_sec();
			request.setAttribute("sec", cardList_sec);

			List<Certifications> cardList_net = cDao.select_net();
			request.setAttribute("net", cardList_net);

			List<Certifications> cardList_mana = cDao.select_mana();
			request.setAttribute("mana", cardList_mana);

			List<Certifications> cardList_jimu = cDao.select_jimu();
			request.setAttribute("jimu", cardList_jimu);

			List<Certifications> cardList_des = cDao.select_des();
			request.setAttribute("des", cardList_des);



			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification_list.jsp");
			dispatcher.forward(request,response);
			}}
			// カテゴリ検索の処理ここまで↑↑↑



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


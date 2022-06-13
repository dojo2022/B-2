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

import dao.BcDAO;
import model.Bc;

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
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/tasuma/LoginServlet");
				return;
			}

			// 資格登録一覧ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Certification_List.jsp");
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
			BcDAO bDao = new BcDAO();
			List<Bc> cardList = bDao.select(new Bc(allit, gengo, data, sec, net, mana, jimu, des));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/certification_list.jsp");
			dispatcher.forward(request, response);
		}


	}


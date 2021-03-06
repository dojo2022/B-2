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
import dao.ItemsDAO;
import dao.My_certificationsDAO;
import dao.Today_targetsDAO;
import dao.UsersDAO;
import model.LoginUser;
import model.My_certifications;
import model.Targets_data;
import model.Today_targets;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {
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

		// 本日の目標(項目)とMy資格の取得
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);
		Today_targetsDAO ttDao = new Today_targetsDAO();
		My_certificationsDAO myDao = new My_certificationsDAO();
		List<My_certifications> myList = myDao.select(new My_certifications(null, user_id, null, null));

		// myListが空ならフォワード
		if(myList.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/target.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 本日の目標項目一覧itemListの定義
		ItemsDAO iDao = new ItemsDAO();
		CertificationsDAO cDao = new CertificationsDAO();
		List<Targets_data> data = new ArrayList<Targets_data>();
		for(My_certifications my :myList) {
			// 資格名の取得
			String certification = cDao.getCertification(my.getCertification_id());
			// 該当する資格の今日の目標を取得
			List<Today_targets> ttList = ttDao.select(new Today_targets(0, user_id, null, my.getCertification_id(), null));
			// ttListが空なら次のループ
			if(ttList.isEmpty()) {
				continue;
			}
			// 項目idから項目名に変換
			for(Today_targets tt :ttList) {
				String item = iDao.getItem(tt.getItem_id());
				tt.setItem_id(item);
			}
			data.add(new Targets_data(certification, ttList));
		}

		session.setAttribute("data", data);

		// 目標設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/target.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}

		// ユーザ名の取得
		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();

		// 本日の目標(項目)の取得
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// ループ回数の取得
		int count = 0;
		try {
			count = Integer.parseInt(request.getParameter("count"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		// ItemsDAOの定義
		ItemsDAO iDao = new ItemsDAO();
		// CertificationsDAOの定義
		CertificationsDAO cDao = new CertificationsDAO();
		// Today_targetsDAOの定義
		Today_targetsDAO ttDao = new Today_targetsDAO();
		// 更新できたかどうか判断する
		boolean result = true;
		for(int i = 0; i < count; i++){
		    // 項目名とチェックと資格名と資格idの値を取得
		    String item = request.getParameter("item" + i);
		    String check = request.getParameter("check" + i);
		    String certification = request.getParameter("cer" + i);
		    String certification_id = cDao.getCertification_id(certification);
		    // チェックの値が1か0か チェックが入っていなければ0 入っていれば1(jspには1)
		    if(check == null) {
		    	check = "0";
		    }
		    // 項目名から項目idを取得
		    String item_id = iDao.getItem_id(item);
		    if(ttDao.update(new Today_targets(user_id, item_id, certification_id, check)) == false) {
		    	result = false;
		    	}
		    }

		// 目標設定ページにリダイレクトする
		response.sendRedirect("/tasuma/TargetServlet");
	}

}


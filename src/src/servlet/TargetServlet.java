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

import dao.ItemsDAO;
import dao.Today_targetsDAO;
import dao.UsersDAO;
import model.LoginUser;
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

		// 本日の目標(項目)の取得
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);
		Today_targetsDAO ttDao = new Today_targetsDAO();
		List<Today_targets> ttList = ttDao.select(new Today_targets(0, user_id, null, null));

		// myListが空ならフォワード
		if(ttList.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/target.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 本日の目標項目一覧itemListの定義
		ItemsDAO iDao = new ItemsDAO();
		List<String> itemList = new ArrayList<String>();
		for(Today_targets tt :ttList){
			// 本日の目標項目idを取得して、項目名を取得しitemListに格納
			String item = iDao.getItem(tt.getItem_id());
			itemList.add(item);
		}

		session.setAttribute("itemList", itemList);

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
		// いらないかも String today_target = request.getParameter("today_target");

		// ループ回数の取得
		int count = 0;
		try {
			count = Integer.parseInt(request.getParameter("count"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		// ItemsDAOの定義
		ItemsDAO iDao = new ItemsDAO();
		// Today_targetsDAOの定義
		Today_targetsDAO ttDao = new Today_targetsDAO();
		// 更新できたかどうか判断する
		boolean result = true;
		for(int i = 0; i < count; i++){
		    // 項目名とチェックの値を取得
		    String item = request.getParameter("item" + i);
		    String check = request.getParameter("check" + i);
		    // チェックの値が1か0か チェックが入っていなければ0 入っていれば1(jspには1)
		    if(check == null) {
		    	check = "0";
		    }
		    // 項目名から項目idを取得
		    String item_id = iDao.getItem_id(item);
		    if(ttDao.update(new Today_targets(user_id, item_id, check)) == false) {
		    	result = false;
		    	}
		    }

		// 本日の目標項目一覧itemListの定義
		List<Today_targets> ttList = ttDao.select(new Today_targets(0, user_id, null, null));

		List<String> itemList = new ArrayList<String>();
		for(Today_targets tt :ttList){
			// 本日の目標項目idを取得して、項目名を取得しitemListに格納
			String item = iDao.getItem(tt.getItem_id());
			itemList.add(item);
		}

		session.setAttribute("itemList", itemList);

		// 目標設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/target.jsp");
		dispatcher.forward(request, response);
	}

}


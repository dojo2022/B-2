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

import dao.My_certificationsDAO;
import dao.Target_understandsDAO;
import dao.Test_daysDAO;
import dao.Today_targetsDAO;
import model.My_certifications;
import model.Target_understands;
import model.Test_days;
import model.Today_targets;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/tasuma/LoginServlet");
//			return;
//		}

		// リクエストパラメータ(資格名)を取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String certification_id = request.getParameter("CERTIFICATION_ID");
		String certification = request.getParameter("CERTIFICATION");
		String testdays = request.getParameter("TESTDAYS");
		String app_start = request.getParameter("APP_START");
		String app_fin = request.getParameter("APP_FIN");

		//試験日程とおすすめ参考書を検索する
		//試験日程
		Test_daysDAO tDao = new Test_daysDAO();
		List<Test_days> Test_daysList = tDao.select(new Test_days(id, certification_id,certification,testdays,app_start,app_fin));

		//参考書（あとで）
//		BcDAO bDao = new BcDAO();
//		List<Bc> Test_daysList = bDao.select(new Bc(number, name,dep,phone,email,co));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("Test_daysList", Test_daysList);

		//最後に
		// スケジュールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/schedule.jsp");
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

		//リクエストパラメータを取得する ...なんの？→ユーザ名(id)、試験名(id)、試験日程（My資格トラ）
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String certification_id = request.getParameter("CERTIFICATION_ID");
		String testdays = request.getParameter("TESTDAYS");
		//リクエストパラメータを取得する ...ユーザID(重複)、項目id、本日の目標（本日の目標トラ）
		String item_id = request.getParameter("ITEM_ID");
		String today_target = request.getParameter("TODAY_TARGET");
		//リクエストパラメータを取得する ...ユーザ名(id)(重複)、項目id(重複)、目標id、理解度（目標理解度トラ）
		String target_id = request.getParameter("TARGET_ID");



		// 登録処理を行う
		//My資格トランザクションに「ユーザid、資格id、試験日程」を追加
		My_certificationsDAO tdDao = new My_certificationsDAO();
		if (tdDao.insert(new My_certifications(user_id, certification_id,testdays))) {	// 登録成功


			//本日の目標トランザクションに「ユーザID、項目id、本日の目標」を登録する
			Today_targetsDAO ttDao = new Today_targetsDAO();
			if (ttDao.insert(new Today_targets(user_id, item_id,today_target))) {	// 登録成功

				//目標理解度トランザクションにユーザ名(id)、項目id、目標id、理解度
				Target_understandsDAO tuDao = new Target_understandsDAO();
				if (tuDao.insert(new Target_understands(target_id, item_id,user_id))) {	// 登録成功

					// メニューサーブレット？ページ？にフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/tasuma/MenuServlet");
					dispatcher.forward(request, response);
		}}}
	}

}

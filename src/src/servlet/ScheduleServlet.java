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
import model.LoginUser;
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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String certification = request.getParameter("selectCertification");

		//試験日程とおすすめ参考書を検索する
		//試験日程...	資格名から日程を検索
		Test_daysDAO tDao = new Test_daysDAO();
		List<Test_days> Test_daysList = tDao.select(new Test_days(certification));

		//参考書（あとで）
//		BcDAO bDao = new BcDAO();
//		List<Bc> Test_daysList = bDao.select(new Bc(number, name,dep,phone,email,co));



		// 検索結果（資格名）をセッションスコープに格納する
		HttpSession session_cer = request.getSession();
		session_cer.setAttribute("certification", certification);

		// 検索結果（試験日）をリクエストスコープに格納する
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
//		if (session.getAttribute("username") == null) {
//			response.sendRedirect("/tasuma/LoginServlet");
//			return;
//		}

		//リクエストパラメータから試験日程を取得する
		request.setCharacterEncoding("UTF-8");
		String testdays = request.getParameter("select_schedule");


		//セッションパラメータから資格名を取得する
		HttpSession session_cer = request.getSession();
		String certification = (String) session_cer.getAttribute("certification");

		//セッションパラメータからユーザ名を取得する
		LoginUser u=(LoginUser)session.getAttribute("username");
		String username = (String) u.getUsername();

		// 登録処理を行う
		//My資格トランザクションに「ユーザid、資格id、試験日程」を追加
	//完成済み
		My_certificationsDAO tdDao = new My_certificationsDAO();
		if (tdDao.insert(new My_certifications(username, certification,testdays))) {	// 登録成功
		}


			//本日の目標トランザクションに「ユーザID、項目id」を登録する
	//作業中:２回登録されてしまう
			//1.項目id一覧を検索 リストに入れる List<> =...
			Today_targetsDAO tt_sDao = new Today_targetsDAO();
			List<Today_targets> resultList_tts = tt_sDao.insert_select(new Today_targets(certification));

			//2.拡張for文でループ
			for(Today_targets y:resultList_tts) {

			//3.ユーザid+リストを登録する
				//検索結果リストresultListにユーザ名を追加
				y.setUsername(username);

				Today_targetsDAO ttDao = new Today_targetsDAO();
			if (ttDao.insert(y)){	// 登録成功
				System.out.println("本日の目標を登録しました");
			}
			//4.ループを閉じる
			}


				//目標理解度トランザクションにユーザ名(id)、項目id、目標id
	//完成済み
				//1.目標一覧を検索 リストに入れる List<> =...
				Target_understandsDAO tu_sDao = new Target_understandsDAO();
				List<Target_understands> resultList = tu_sDao.insert_select(new Target_understands(certification));

				//2.拡張for文でループ
				for(Target_understands x:resultList) {

				//3.ユーザid+リストを登録する
					//検索結果リストresultListにユーザ名を追加
					x.setUsername(username);

				Target_understandsDAO tuDao = new Target_understandsDAO();
				if (tuDao.insert(x)){	// 登録成功
				}
				//4.ループを閉じる
				}

		//セッションスコープ（資格名）を破棄する
		session_cer.invalidate();

		// メニューサーブレットにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MenuServlet");
		dispatcher.forward(request, response);
	}
}
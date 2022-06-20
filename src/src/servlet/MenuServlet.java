package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import model.Menu_data;
import model.My_certifications;
import model.Today_targets;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
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

		//ユーザ名の取得
		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();

		//各種データを取得しスコープに保存
		//My資格を持ってくる
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);
		My_certificationsDAO myDao = new My_certificationsDAO();
		List<My_certifications> myList = myDao.select(new My_certifications(null, user_id, null, null));
		List<Menu_data> menu_data = new ArrayList<Menu_data>();
		Today_targetsDAO ttDao = new Today_targetsDAO();
		ItemsDAO iDao = new ItemsDAO();
		CertificationsDAO cDao = new CertificationsDAO();
		if(myList.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//My資格ごとに必要なデータの抽出及び格納
		for(My_certifications my :myList) {
			//資格IDから資格名を取得
			String certification = cDao.getCertification(my.getCertification_id());

			//現在時刻と試験日程を取得し、残り日数を計算
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	        Date now = new Date();//現在時刻
	        Date testday = null;
	        Date now_date = null;//今日の日付
	        try {
	            testday = sdf.parse(my.getTestdays());//ここでエラー
	            now_date = sdf.parse(sdf.format(now));
	        }catch (ParseException e) {
	            e.printStackTrace();
	        }
	        long day1 = testday.getTime();
	        long day2 = now_date.getTime();
	        long dayDiff = (day1 - day2) / (1000 * 60 * 60 * 24);
	        String remainingDays = Integer.toString((int)dayDiff);

			//今日の目標の内、該当する資格の項目をリストに格納
			List<Today_targets> ttList = ttDao.select(new Today_targets(0, user_id, null, "1"));
			if(ttList.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
				dispatcher.forward(request, response);
				return;
			}
			List<String> itemList = new ArrayList<String>();
			for(Today_targets tt :ttList){
				//本日の目標項目idを取得して、項目名を取得しitemListに格納
				String item = iDao.getItem(tt.getItem_id());
				itemList.add(item);
			}

			//JavaScript用試験日データ
	        String testday_js = new SimpleDateFormat("yyyy/M/d").format(testday);

			//My資格の内、資格名、残り日数、本日の目標項目一覧を格納（資格ごとにリストに追加）
			menu_data.add(new Menu_data(certification, remainingDays, testday_js, itemList));
		}
		session.setAttribute("menu_data", menu_data);


		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);

	}

	//おそらく必要ない→確定したら削除する
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//よくわからん
		//postされたらつかってください
	}

}

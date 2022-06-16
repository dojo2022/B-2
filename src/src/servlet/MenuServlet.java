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
import model.LoginUser;
import model.My_certifications;

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
		LoginUser loginuser = (LoginUser)session.getAttribute("id");
		String username = loginuser.getUsername();

		//各種データを取得しスコープに保存
		//My資格を持ってくる
		My_certificationsDAO myDao = new My_certificationsDAO();
		List<My_certifications> myList = myDao.select(new My_certifications(null, username, null, null));
		//List<Menu_data> menu_data = new ArrayList<Menu_data>();
		//今日の目標を持ってくる(テーブル及びDAO等が完成するまで保留)

		//My資格ごとに必要なデータの抽出及び格納
		for(My_certifications my :myList) {
			//メニュー画面に必要なデータを取得し格納
			//資格IDから資格名を取得
			//my.getCertification_id();
			//String certification = ;

			//現在時刻と試験日程を取得し、残り日数を計算
			//Date now = new Date();
			//Date testday = my.getTestdays();
			//String remainingDays = testday - now; //残り日数の計算（イメージ）
			//今日の目標の内、該当する資格の項目をリストに格納
			//List<String> itemList = new ArrayList<String>();
			/*//
			for(){
				//本日の目標項目idを取得して、項目名を取得しitemListに格納
			}
			*/
			//My資格の内、資格名、残り日数、本日の目標項目一覧を格納（資格ごとにリストに追加）
			//menu_data.add(new Menu_data(certification, remainingDays, itemList));
		}
		//カレンダーの日程を持ってくる(現在時刻を取得し試験までの残り日数を計算)

		//自分用コメント
		//メニューに必要なデータを格納するmodelを用意Menu(試験名, 残り日数, 目標項目一覧(リスト))


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

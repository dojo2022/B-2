package servlet;

import java.io.IOException;
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
import dao.Target_understandsDAO;
import dao.TargetsDAO;
import dao.Today_targetsDAO;
import dao.UsersDAO;
import model.Items;
import model.LoginUser;
import model.My_certifications;
import model.Percent;
import model.Target_understands;
import model.Today_targets;
import model.Understands;
import model.Understands_result;

/**
 * Servlet implementation class UnderstandServlet
 */
@WebServlet("/UnderstandServlet")
public class UnderstandServlet extends HttpServlet {
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


		request.setCharacterEncoding("UTF-8");
		//ユーザ名の取得
		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();

		//ユーザIDの取得
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);

		//各種DAOの定義
		Target_understandsDAO tuDao = new Target_understandsDAO();
		TargetsDAO tDao = new TargetsDAO();
		ItemsDAO iDao = new ItemsDAO();
		CertificationsDAO cDao = new CertificationsDAO();
		Today_targetsDAO ttDao = new Today_targetsDAO();
		My_certificationsDAO myDao = new My_certificationsDAO();

		//スコープ格納用データ
		List<Understands> uList_scope = new ArrayList<Understands>();
		List<Target_understands> tuList_scope = new ArrayList<Target_understands>();
		List<Target_understands> ttList_scope = new ArrayList<Target_understands>();

		//My資格の取得
		List<My_certifications> myList = myDao.select(new My_certifications(null, user_id, null, null));

		//myListが空ならフォワード
		if(myList.isEmpty()) {
			session.setAttribute("understands", uList_scope);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/understand.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//目標達成度の取得
		List<Target_understands> tuList = tuDao.select(new Target_understands(0, null, null, user_id, null, null));

		//tuListが空ならフォワード
		if(tuList.isEmpty()) {
			session.setAttribute("understands", uList_scope);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/understand.jsp");
			dispatcher.forward(request, response);
			return;
		}

		List<Today_targets> ttList = ttDao.select(new Today_targets(user_id, null, "1"));

		//ttListが空ならフォワード
		if(ttList.isEmpty()) {
			session.setAttribute("understands", uList_scope);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/understand.jsp");
			dispatcher.forward(request, response);
			return;
		}

		for(My_certifications my :myList) {
			//資格名の取得
			String certification = cDao.getCertification(my.getCertification_id());
			List<Items> iList = iDao.select(new Items(my.getCertification_id(), null, null, 0));
			if(iList.isEmpty()) break;
			for(Target_understands tu :tuList) {
				for(Items i :iList) {
					//item_idが一致しなかったら、次のループへ
					if(!tu.getItem_id().equals(i.getItem_id())) continue;
					//目標名の取得
					String target = tDao.getTarget(tu.getTarget_id());
					//項目名の取得
					String item = iDao.getItem(tu.getItem_id());
					//達成日の取得
					String day = tu.getDay();
					//理解度の取得
					String target_understand = tu.getTarget_understand();

					//(null,目標名,項目名,null,達成日(最終更新日),理解度(0, 1, 2, 3))
					tuList_scope.add(new Target_understands(0, target, item, user_id, day, target_understand));
					break;
				}
			}
			for(Today_targets tt :ttList) {
				for(Target_understands tu :tuList) {
					if(!tt.getItem_id().equals(tu.getItem_id())) continue;
					for(Items i :iList) {
						//item_idが一致しなかったら、次のループへ
						if(!tu.getItem_id().equals(i.getItem_id())) continue;
						//目標名の取得
						String target = tDao.getTarget(tu.getTarget_id());
						//項目名の取得
						String item = iDao.getItem(tu.getItem_id());
						//達成日の取得
						String day = tu.getDay();
						//理解度の取得
						String target_understand = tu.getTarget_understand();
						//(null,目標名,項目名,null,達成日(最終更新日),理解度(0, 1, 2, 3))
						ttList_scope.add(new Target_understands(0, target, item, null, day, target_understand));
						break;
					}
				}
			}
			uList_scope.add(new Understands(certification, tuList_scope, ttList_scope));
		}

		session.setAttribute("understands", uList_scope);

		// 理解度報告ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/understand.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 理解度報告ー結果を登録する
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("/tasuma/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		//ユーザ名の取得
		LoginUser loginuser = (LoginUser)session.getAttribute("username");
		String username = loginuser.getUsername();

		//ユーザIDの取得
		UsersDAO uDao = new UsersDAO();
		String user_id = uDao.getUser_id(username);

		//資格名の取得
		String certification = request.getParameter("certification");

		TargetsDAO tDao = new TargetsDAO();
		Target_understandsDAO tuDao = new Target_understandsDAO();
		Today_targetsDAO ttDao = new Today_targetsDAO();
		Date now = new Date();
		String nowStr = new SimpleDateFormat("yyyy/MM/dd").format(now);

		int count = 0;
		try {
			count = Integer.parseInt(request.getParameter("count"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < count; i++) {
			String target_understands = request.getParameter("tu" + i);
			String target = request.getParameter("t" + i);
			String target_id = tDao.getTarget_id(target);

			tuDao.update(new Target_understands(0, target_id, null, user_id, nowStr, target_understands));
		}

		List<Percent> percents = new ArrayList<Percent>();
		CertificationsDAO cDao = new CertificationsDAO();
		ItemsDAO iDao = new ItemsDAO();

		//資格idを取得し、項目一覧を取得
		String certification_id = cDao.getCertification_id(certification);
		List<Items> iList = iDao.select(new Items(certification_id, null, null, 0));

		for(Items i :iList) {
			//項目数取得
			int itemCount = tuDao.getCount(new Target_understands(0, null, i.getItem_id(), user_id, null, null));

			//達成項目数取得
			int itemCount1 = tuDao.getCount(new Target_understands(0, null, i.getItem_id(), user_id, null, "2"));
			int itemCount2 = tuDao.getCount(new Target_understands(0, null, i.getItem_id(), user_id, null, "3"));

			//達成度計算
			double percent = 0;
			if(itemCount == itemCount1 + itemCount2) {
				if(itemCount1 != 0 & itemCount2 != 0) {
					ttDao.update(new Today_targets(user_id, i.getItem_id(), "2"));
				}
			}
			if(itemCount > 0) {
				percent = (itemCount1 + itemCount2 / itemCount) * 100;
			}

			//percent(達成度)とi.getItem(項目名)をpercentsに追加
			percents.add(new Percent(percent, i.getItem()));
		}

		//必要なデータ：資格名、項目毎の達成度
		session.setAttribute("understands_result", new Understands_result(certification, percents));

		// 理解度報告結果ページにリダイレクトする
		response.sendRedirect("/tasuma/UnderstandResultServlet");
	}

}

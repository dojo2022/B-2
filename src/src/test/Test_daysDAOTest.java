package test;
import java.util.List;

import dao.Test_daysDAO;
import model.Test_days;

public class Test_daysDAOTest{
	public static void main(String[] args) {
	Test_daysDAO dao = new Test_daysDAO();

	// select()のテスト
	System.out.println("---------- select()のテスト ----------");
	List<Test_days> cardList2 = dao.select(new Test_days("", "","ITパスポート","","",""));
	for (Test_days card : cardList2) {
		System.out.println("試験日程：" + card.getTestdays());

	}

}
}

package test;
import java.util.List;

import dao.Target_understandsDAO;
import model.Target_understands;

public class Target_understandDAOTest{
	public static void main(String[] args) {
	Target_understandsDAO dao = new Target_understandsDAO();

	// insert_select()のテスト
	System.out.println("---------- insert_select()のテスト ----------");
	List<Target_understands> cardList2 = dao.insert_select(new Target_understands("ITパスポート"));
	for (Target_understands card : cardList2) {
		System.out.println("item_id：" + card.getItem_id());
		System.out.println("target_id：" + card.getTarget_id());

	}

//	// insert()のテスト
//	System.out.println("---------- insert_select()のテスト ----------");
//	List<Target_understands> x =
//			Target_understands days = new Target_understands(
//					"b1",
//					"c1",
//					"u1"
//					);
//					resultList.add(days);
//	List<Target_understands> cardList3 = dao.insert(x);
//	for (Target_understands card : cardList3) {
//		System.out.println("item_id：" + card.getItem_id());
//		System.out.println("target_id：" + card.getTarget_id());
//
//	}

}
}
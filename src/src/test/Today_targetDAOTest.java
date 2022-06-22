package test;
import java.util.List;

import dao.Today_targetsDAO;
import model.Today_targets;

public class Today_targetDAOTest{
	public static void main(String[] args) {
		Today_targetsDAO dao = new Today_targetsDAO();

		// insert_select()のテスト
		System.out.println("---------- insert_select()のテスト ----------");
		List<Today_targets> cardList2 = dao.insert_select(new Today_targets("ITパスポート"));
		for (Today_targets card : cardList2) {
			System.out.println("item_id：" + card.getItem_id());
			System.out.println("CER：" + card.getCertification());

		}
	}
	}
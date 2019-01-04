package jp.github.ushi.main.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics01 {

	// ----

	public static void main(String[] args) {

		// type1
		// Number型の具体は追加できる
		List<Number> l1 = new ArrayList<Number>();
		l1.add(Integer.valueOf(3));
		l1.add(Long.valueOf(3));

		// type2 
		// エラー: 
		// List<Number> l1 = new ArrayList<Integer>();

	}

}

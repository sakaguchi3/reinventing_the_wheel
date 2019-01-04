package jp.github.ushi.main.genericsa;

import java.util.ArrayList;
import java.util.List;

public class Generics02 {

	// ----

	public static void main(String[] args) {

		// addはNG、getはOK
		List<? extends Number> l2 = new ArrayList<Integer>();
		// エラー
		// l2.add(new Number(3));
		// l2.add(Integer.valueOf(3));
		Number n = l2.get(0);

		// addはOK，getはObject
		List<? super Number> l3 = new ArrayList<Number>();
		l3.add(n);
		l3.add(Long.valueOf(42));
		l3.add(Integer.valueOf(45));
		Object o = l3.get(0);

	}

}

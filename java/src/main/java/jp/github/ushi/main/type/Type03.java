package jp.github.ushi.main.type;

public class Type03<T extends Number> {

	private T t;

	/**
	 * @return the t2
	 */
	public T getT() {
		return t;
	}

	/**
	 * @param t2
	 *            the t2 to set
	 */
	public void setT2(T t2) {
		this.t = t2;
	}

	// ----

	public static void main(String[] args) {

		Type03<Integer> t = new Type03<>();
		t.setT2(97);
		System.out.println(t.getT());

		Number n1 = t.getT();
		Integer i1 = t.getT();

		// NG
		// Type03<String> s = new Type03<>();

	}

}

package jp.github.ushi.main.type;

public class Type02<T> {

	private T t2;

	/**
	 * @return the t2
	 */
	public T getT2() {
		return t2;
	}

	/**
	 * @param t2
	 *            the t2 to set
	 */
	public void setT2(T t2) {
		this.t2 = t2;
	}

	// ----

	public static void main(String[] args) {

		Type02<Integer> t01 = new Type02<>();
		t01.setT2(97);

		System.out.println(t01.getT2());
	}

}

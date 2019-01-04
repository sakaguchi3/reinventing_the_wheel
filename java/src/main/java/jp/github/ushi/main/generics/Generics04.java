package jp.github.ushi.main.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Generics04<T> {

	final List<T> stack = new ArrayList<T>();

	public void push(T e) {
		stack.add(e);
	}

	public T pop() {
		final int index = stack.size() - 1;
		return stack.remove(index);
	}

	private boolean isEmpty() {
		return stack.size() == 0;
	}

	/**
	 * producer: 引数を取り出す
	 */
	public void produce(final List<? extends T> src) {
		for (T e : src) {
			stack.add(e);
		}
	}

	/**
	 * consumer: 引数に値を入れる
	 * 
	 * @param dst
	 */
	public void consume(final List<? super T> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	// ----

	/**
	 * ワイルドカード付きジェネリクスの使用例
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final Generics04<TypeC> gen = new Generics04<>();

		// -- produce 

		final List<TypeD> producer = new ArrayList<>();

		IntStream.range(0, 10)//
				.mapToObj(TypeD::new)//
				.forEach(gen::push);

		gen.produce(producer);

		// -- consume

		final List<TypeB> consumer = new ArrayList<>();
		gen.consume(consumer);

		// -- result

		System.out.println("------------- 実行結果 -------------");

		consumer.stream()//
				.map(v -> v.a)//
				.forEach(System.out::println);

	}

}

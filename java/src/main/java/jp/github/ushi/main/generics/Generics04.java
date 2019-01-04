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

	public boolean isEmpty() {
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

		final Generics04<TypeC> stack = new Generics04<>();

		// -- produce 

		final List<TypeD> producer = new ArrayList<>();

		IntStream.range(0, 10)//
				.mapToObj(TypeD::new)//
				.forEach(producer::add);

		System.out.println("Q1: Is stack empty ?");
		System.out.println("A: " + stack.isEmpty());

		stack.produce(producer);

		System.out.println("Q2: Is stack empty ?");
		System.out.println("A: " + stack.isEmpty());


		// -- consume

		final List<TypeB> consumer = new ArrayList<>();
		stack.consume(consumer);

		// -- result

		System.out.println("");

		consumer.stream()//
				.map(v -> v.a)//
				.forEach(System.out::println);

	}

}

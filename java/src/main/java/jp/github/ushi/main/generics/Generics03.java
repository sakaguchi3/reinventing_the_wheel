package jp.github.ushi.main.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics03<T> {

	List<T> stack = new ArrayList<T>();

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
	 * produecr: 引数を使用する
	 */
	public void producer(List<? extends T> src) {
		for (T e : src) {
			stack.add(e);
		}
	}

	/**
	 * consumer: 引数に値を入れる
	 * 
	 * @param dst
	 */
	public void consumer(List<? super T> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	// ----

	public static void main(String[] args) {

		//継承関係: D->C->B->A

		// ---------------------------------
		// 共変(producer), getはOK
		// ---------------------------------

		// -- 普通のジェネリクス1

		List<TypeC> l050 = new ArrayList<>();

		// (T extends C)は追加可能
		// l050.add(new TypeA(3)); // エラー
		// l050.add(new TypeB(3)); // エラー
		l050.add(new TypeC(3));
		l050.add(new TypeD(3));

		// (T super C)はget可能
		TypeA e050_01 = l050.get(0);
		TypeB e050_02 = l050.get(0);
		TypeC e050_03 = l050.get(0);
		// TypeD e050_04 = l050.get(0); // エラー

		// -- 共変

		//右側に来るのは List<B, C, D, …> のインスタンス
		List<? extends TypeB> l100 = l050;

		// 共変はaddするとエラーが起きる
		// l100.add(new TypeA(3)); // エラー
		// l100.add(new TypeD(3)); // エラー
		l100.add(null);


		// (T super B)はget可能
		TypeA e100_01 = l100.get(0);
		TypeB e100_02 = l100.get(0);
		// TypeC e100_03 = l100.get(0);
		// TypeD e4 = l100.get(0); // エラー

		// -- producer
		Generics03<TypeB> g100_01 = new Generics03<>();
		g100_01.producer(l100);

		
		// ---------------------------------
		// コンシューマ, addはOK
		// ---------------------------------

		// -- 普通のジェネリクス2

		List<TypeB> l200 = new ArrayList<>();

		// l200.add(new TypeA(3)); // エラー
		l200.add(new TypeB(3));
		l200.add(new TypeC(3));
		l200.add(new TypeD(3));
		
		// (T super B)はget可能
		TypeA e200_01 = l200.get(0);
		TypeB e200_02 = l200.get(0);
		// TypeC e200_03 = l200.get(0); // エラー
		// TypeD e200_04 = l200.get(0); // エラー

		// -- 反変

		// 右側に来るのは List<C, B, A, …> のインスタンス
		List<? super TypeC> l300 = l200;
		

		// (T extends C)はadd可能
		// l300.add(new TypeA(3)); // エラー
		// l300.add(new TypeB(3)); // エラー
		l300.add(new TypeC(3));
		l300.add(new TypeD(3));

		// addはObjectのみOK．それ以外はNG．
		Object e300_01 = l300.get(0);
		// TypeA e300_02 = l300.get(0); // エラー
		// TypeB e300_03 = l300.get(0); // エラー
		// TypeC e300_04 = l300.get(0); // エラー
		// TypeD e300_05 = l300.get(0); // エラー
		
		// -- consumer
		Generics03<TypeC> g200_01 = new Generics03<>();
		g200_01.consumer(l300);


	}

}

package jp.github.ushi.func;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;

public class Zip01 {

	public static void main(String[] args) {

		new Zip01().exec();
	}

	void exec() {

		var names = ImmutableList.of("Alice", "Bob", "Charles", "Dragon");
		var ages = ImmutableList.of(42, 27, 31);

		var tuples = Streams //
				.zip(names.stream(), ages.stream(), ImmutablePair::new) // (String, Int) -> Pair
				.collect(ImmutableList.toImmutableList()) // Pair -> (reduction) -> List<Pair>
		;

		tuples.stream() //
				.map(ImmutablePair::toString) // Pair -> String
				.forEach(System.out::println) //
		;

	}

}

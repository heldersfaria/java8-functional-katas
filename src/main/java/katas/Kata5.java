package katas;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static Double execute() {
		return DataUtil.getMovies().stream().reduce(BinaryOperator.maxBy(comparator())).orElse(new Movie()).getRating();
	}

	private static Comparator<Movie> comparator() {
		return (x, y) -> x.getRating().compareTo(y.getRating());
	}
}

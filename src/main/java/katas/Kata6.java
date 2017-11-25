package katas;

import java.util.function.BinaryOperator;

import model.BoxArt;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/

public class Kata6 {

	public static String execute() {
		return DataUtil.getMovies().stream().flatMap(u -> u.getBoxarts().stream()).reduce(getBinaryOperatorBoxArts())
				.orElse(new BoxArt()).getUrl();
	}

	private static BinaryOperator<BoxArt> getBinaryOperatorBoxArts() {
		return BinaryOperator.maxBy((x, y) -> x.getWidth().compareTo(y.getWidth()));
	}
}

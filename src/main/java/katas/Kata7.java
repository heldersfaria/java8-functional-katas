package katas;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
	public static List<Map> execute() {

		return DataUtil.getMovies().stream().map(
				entity -> ImmutableMap.of("id", entity.getId(), "title", entity.getTitle(), "boxart",
						getBoxArt(entity)	))
				.collect(Collectors.toList());
	}

	private static BoxArt getBoxArt(Movie entity) {
		return entity.getBoxarts().stream()
				.reduce(BinaryOperator.minBy((x, y) -> x.getUrl().length() - y.getUrl().length())).orElse(new BoxArt());
	}
	
//	private static Function<Movie, BoxArt>  getBoxArt() {
//		return entity -> entity.getBoxarts().stream()
//				.reduce(BinaryOperator.minBy((x, y) -> x.getUrl().length() - y.getUrl().length())).orElse(new BoxArt());
//	}
}

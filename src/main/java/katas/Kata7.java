package katas;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

	public static List<Map> execute() {

		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
				.map(functionMovieToImmutableMap()).collect(Collectors.toList());

	}

	public static Function<Movie, ImmutableMap<String, Object>> functionMovieToImmutableMap() {
		return movieInternal -> ImmutableMap.of("id", movieInternal.getId(), "title", movieInternal.getTitle(),
				"boxart",
				movieInternal.getBoxarts().stream().reduce(getSmallestBoxArt()).map(BoxArt::getUrl).orElse(""));
	}

	public static BinaryOperator<BoxArt> getSmallestBoxArt() {
		return (boxart1, boxart2) -> boxart1.getHeight() * boxart1.getWidth() < boxart2.getHeight() * boxart2.getWidth()
				? boxart1
				: boxart2;
	}

}

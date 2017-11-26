package katas;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
				.map(functionMovieToImmutableMap()).collect(Collectors.toList());
	}

	public static Function<Movie, ImmutableMap<String, Object>> functionMovieToImmutableMap() {
		return movie ->

		ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "time", movie.getInterestingMoments()
				.get(IntStream.range(0, movie.getInterestingMoments().size())
						.filter(n -> n > movie.getInterestingMoments().size() / 2).findFirst().orElse(0))
				.getTime(), "boxart",
				movie.getBoxarts().stream().reduce(smallestBoxArt()).map(BoxArt::getUrl).orElse(""));

	}

	private static BinaryOperator<BoxArt> smallestBoxArt() {
		return (boxart1, boxart2) -> boxart1.getHeight() * boxart1.getWidth() < boxart2.getHeight() * boxart2.getWidth()
				? boxart1
				: boxart2;
	}
}
package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:
    We have 2 arrays each containing lists, and VIDEOS respectively.
    Each v"id"eo has a list"id" field indicating its parent list.
    We want to build an array of list objects, each with a "name" and a VIDEOS array.
    The VIDEOS array will contain the v"id"eo's "id" and "title".
    In other words we want to build the following structure:
    [
        {
            ""name"": "New Releases",
            "VIDEOS": [
                {
                    ""id"": 65432445,
                    ""title"": "The Chamber"
                },
                {
                    ""id"": 675465,
                    ""title"": "Fracture"
                }
            ]
        },
        {
            ""name"": "Thrillers",
            "VIDEOS": [
                {
                    ""id"": 70111470,
                    ""title"": "Die Hard"
                },
                {
                    ""id"": 654356453,
                    ""title"": "Bad Boys"
                }
            ]
        }
    ]
    DataSource: DataUtil.getLists(), DataUtil.getVIDEOS()
    Output: the given datastructure
*/
public class Kata10 {

	public static List<Map> execute() {

		List<Map> lists = DataUtil.getLists();
		List<Map> videos = DataUtil.getVideos();

		return lists.stream().map(getFuctionMap(videos)).collect(Collectors.toList());
	}

	public static Function<Map, ImmutableMap<String, Object>> getFuctionMap(List<Map> videos) {
		return list -> ImmutableMap.of("name", list.get("name"), "videos",

				videos.stream().filter(predicateVideoListIdEqualsListId(list)).map(getfunctionVideo())
						.collect(Collectors.toList()));
	}

	public static Predicate<Map> predicateVideoListIdEqualsListId(Map list) {
		return video -> video.get("listId").equals(list.get("id"));
	}

	public static Function<Map, ImmutableMap<String, Object>> getfunctionVideo() {
		return video -> ImmutableMap.of("id", video.get("id"), "title", video.get("title"));
	}

}
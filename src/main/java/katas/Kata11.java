package katas;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
Goal: Create a datastructure from the given data:
This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
Each object has a parent id, indicating its parent.
We want to build an array of list objects, each with a name and a videos array.
The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
In other words we want to build the following structure:
[
    {
        "name": "New Releases",
        "videos": [
            {
                "id": 65432445,
                "title": "The Chamber",
                "time": 32432,
                "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
            },
            {
                "id": 675465,
                "title": "Fracture",
                "time": 3534543,
                "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
            }
        ]
    },
    {
        "name": "Thrillers",
        "videos": [
            {
                "id": 70111470,
                "title": "Die Hard",
                "time": 645243,
                "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
            },
            {
                "id": 654356453,
                "title": "Bad Boys",
                "time": 984934,
                "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
            }
        ]
    }
]
*/
public class Kata11 {
	public static List<Map> execute() {

		return DataUtil.getLists().stream()
				.map(getMap(DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()))
				.collect(Collectors.toList());

	}

	private static Function<? super Map, ? extends ImmutableMap<String, Object>> getMap(List<Map> videos,
			List<Map> boxArts, List<Map> bookmarkList) {
		return list -> ImmutableMap	.of("name", list.get("name"), 
										"videos", videos.stream().filter(video -> video.get("listId").equals(list.get("id")))
																.map(getVideo(boxArts, bookmarkList))
																.collect(Collectors.toList()));
	}

	private static Function<? super Map, ? extends ImmutableMap<String, Object>> getVideo(List<Map> boxArts,
			List<Map> bookmarkList) {
		return video -> ImmutableMap.of("id", video.get("id"), 
										"title", video.get("title"), 
										"time", getTime(video.get("id"), bookmarkList), 
										"boxart", boxArts.stream().filter(box -> video.get("id").equals(box.get("videoId")))
																  .min(size())
																  .map(boxArt -> boxArt.get("url"))
																  .orElse(""));
	}

	private static Object getTime(Object videoId, List<Map> bookmarkList) {

		return bookmarkList.stream().filter(bookmark -> bookmark.get("videoId").equals(videoId))
				.map(bookmark -> bookmark.get("time")).findFirst().orElse(null);

	}

	private static Comparator<Map> size() {

		return (box1, box2) -> Integer.compare((Integer) box1.get("width") * (Integer) box1.get("height"),
				(Integer) box2.get("width") * (Integer) box2.get("height"));

	}

}
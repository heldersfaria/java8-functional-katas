package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata11Test {

	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String BOXART = "boxart";
	public static final String NAME = "name";
	public static final String VIDEOS = "videos";
	public static final String LIST_ID = "listId";
	public static final String TIME = "time";
	public static final String VIDEO_ID = "videoId";
	public static final String URL = "url";
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";

	@Test
	public void testExecute() {
		Assert.assertThat(Kata11.execute().size(), equalTo(2));
	}

}

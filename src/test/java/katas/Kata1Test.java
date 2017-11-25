package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata1Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata1.execute().size(), equalTo(4));
	}

	@Test
	public void testExecute1() {
		Assert.assertTrue(Kata1.execute() instanceof List);
	}

	@Test
	public void testExecute2() {
		List<Map> lista = Kata1.execute();

		lista.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap);
		});
	}

	@Test
	public void testExecute3() {
		Kata1.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("id"));
			Assert.assertTrue(map.containsKey("title"));
		});
	}

	@Test
	public void testExecute4() {
		Assert.assertThat(Kata1.execute(),
				equalTo(ImmutableList.of(ImmutableMap.of("id", 70111470, "title", "Die Hard"),
						ImmutableMap.of("id", 654356453, "title", "Bad Boys"),
						ImmutableMap.of("id", 65432445, "title", "The Chamber"),
						ImmutableMap.of("id", 675465, "title", "Fracture"))));
	}

}

package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class Kata4Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata4.execute().size(), equalTo(4));
	}


	@Test
	public void testExecute2() {
		List<Map> immutableList = Kata1.execute();
		Assert.assertTrue(immutableList instanceof List);
		
		immutableList.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap<?, ?>);
		});
	}

	@Test
	public void testExecute3() {
		Kata4.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("id"));
			Assert.assertTrue(map.containsKey("title"));
			Assert.assertTrue(map.containsKey("boxart"));
		});
	}

}

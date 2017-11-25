package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class Kata7Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata7.execute().size(), equalTo(4));
	}
	
	@Test
	public void testExecute2() {
		Kata7.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("id"));
			Assert.assertTrue(map.containsKey("title"));
			Assert.assertTrue(map.containsKey("boxart"));
		});
	}
}

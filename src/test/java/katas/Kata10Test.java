package katas;

import org.junit.Assert;
import org.junit.Test;

public class Kata10Test {

	@Test
	public void testExecute() {
		Assert.assertEquals(Kata10.execute().size(), 2);
	}
}

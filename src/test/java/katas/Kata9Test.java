package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class Kata9Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata1.execute().size(), equalTo(4));
	}

}

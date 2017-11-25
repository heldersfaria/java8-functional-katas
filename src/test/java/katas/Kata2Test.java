package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Kata2Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata2.execute().size(), equalTo(2));
	}

	@Test
	public void testExecute1() {
		Assert.assertThat(Kata2.execute().size(), equalTo(2));
	}

	@Test
	public void testExecute2() {
		Assert.assertTrue(Kata2.execute() instanceof List);
	}

	@Test
	public void testExecute3() {
		Assert.assertThat(Kata2.execute(), equalTo(ImmutableList.of(654356453, 675465)));
	}
}

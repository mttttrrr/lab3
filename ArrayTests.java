import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}

  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testRealRIP() {
    int[] input1 = { 3, 4, 5 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 5, 4, 3 }, input1);
  }

  @Test
  public void testRealRev() {
    int[] input1 = { 3, 4, 5 };
    assertArrayEquals(new int[]{ 5, 4, 3 }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAverageEmpty() {
    double[] a = {};
    double result = ArrayExamples.averageWithoutLowest(a);
    assertEquals(0, result);
  }

  @Test
  public void testAverageUnique() {
    double[] a = {1, 2, 3, 4, -5};
    double result = ArrayExamples.averageWithoutLowest(a);
    assertEquals(10, result);
  }

    @Test
  public void testAverageMany() {
    double[] a = {1, 1, 2, 3, 4};
    double result = ArrayExamples.averageWithoutLowest(a);
    assertEquals(10, result);
  }
}

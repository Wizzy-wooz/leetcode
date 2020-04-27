package leetcode_30_days_challenge.day7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingElementsTest {
    @Test
    public void test() {
        Counting_Elements countingElements = new Counting_Elements();
        assertEquals(2, countingElements.countElements(new int[]{1,2,3}));
        assertEquals(0, countingElements.countElements(new int[]{1,1,3,3,5,5,7,7}));
        assertEquals(3, countingElements.countElements(new int[]{1,3,2,3,5,0}));
        assertEquals(2, countingElements.countElements(new int[]{1,1,2,2}));
    }
}

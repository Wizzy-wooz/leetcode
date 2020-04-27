package leetcode_30_days_challenge.day1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC136SingleNumberTest {
    @Test
    public void test() {
        LC136SingleNumber instance = new LC136SingleNumber();
        assertEquals(1, instance.singleNumber(new int[]{1,2,2}));
    }
}

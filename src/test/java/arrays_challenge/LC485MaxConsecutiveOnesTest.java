package arrays_challenge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC485MaxConsecutiveOnesTest {
    @Test
    public void test() {
        LC485MaxConsecutiveOnes instance = new LC485MaxConsecutiveOnes();
        assertEquals(3, instance.findMaxConsecutiveOnes(new int[]{1,0,1,1,1,0,1,1,1}));
    }
}

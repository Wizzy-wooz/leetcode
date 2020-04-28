package leetcode_challenges.april.day28;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LCFirstUniqueTest {

    private LCFirstUnique firstUnique;
    public LCFirstUniqueTest() {
        this.firstUnique = new LCFirstUnique(new int[]{2,3,5});
    }

    @Test
    public void testFirstUnique() {
        assertEquals(firstUnique.showFirstUnique(), 2);
        firstUnique.add(5);
        assertEquals(firstUnique.showFirstUnique(), 2);
        firstUnique.add(2);
        assertEquals(firstUnique.showFirstUnique(), 3);
        firstUnique.add(3);
        assertEquals(firstUnique.showFirstUnique(), -1);
    }
}

package dp;

import java.util.HashMap;
import java.util.Map;

public class LC904FruitIntoBaskets {
    //    In a row of trees, the i-th tree produces fruit with type tree[i].
//
//    You start at any tree of your choice, then repeatedly perform the following steps:
//
//    Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
//    Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
//    Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
//
//    You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
//
//    What is the total amount of fruit you can collect with this procedure?
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> last = new HashMap<>();

        //find max subarray len with atmost 2 distinct nums
        int l = 0, r = 0, maxlen = 0, count = 0;
        while (r < tree.length) {
            while (r < tree.length && (last.size() < 2 || (last.get(tree[r]) != null && last.get(tree[r]) >= l))) {
                last.put(tree[r], r++);
                maxlen = Math.max(maxlen, r - l);
            }
            while (last.size() == 2) {
                int lastpos = last.get(tree[l]);
                if (lastpos == l)
                    last.remove(tree[l]);
                l++;
            }
        }
        return maxlen;
    }
}

package cn.com.myproject.learn.lcci;

/**
 * @author xx
 */
public class Solution0101 {
    public boolean isUnique(String str) {
        int bitMap = 0;
        for (char c : str.toCharArray()) {
            int pos = c - 'a';
            System.out.println("pos:" + pos);
            System.out.println("bitMap1:" + pos);
            System.out.println("res1:" + (bitMap & (1 << pos)));
            if ((bitMap & (1 << pos)) != 0) {
                return false;
            }
            bitMap |= (1 << pos);
            System.out.println("bitMap2:" + bitMap);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0101 solution0101 = new Solution0101();
        System.out.println(solution0101.isUnique("abc"));
    }
}

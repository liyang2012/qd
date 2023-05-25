package cn.com.myproject.learn.lcci;

/**
 *
 *@author xx
 *@date 2022/8/30 10:17
 **/
public class Solution0103 {
	public String replaceSpaces(String s, int len) {
		char[] chars = s.toCharArray();
		int j = chars.length;
		for (int i = len -1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[--j] = '0';
				chars[--j] = '2';
				chars[--j] = '%';
			} else {
				chars[--j] = chars[i];
			}
		}
		return new String(chars, j, chars.length -j);
	}

	public static void main(String[] args) {
		Solution0103 solution0103 = new Solution0103();
		String res = solution0103.replaceSpaces("               ", 5);
		System.out.println(res);
	}
}

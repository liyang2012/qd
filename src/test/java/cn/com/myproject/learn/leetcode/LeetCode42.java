package cn.com.myproject.learn.leetcode;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * */
public class LeetCode42 {
    /**
     * 栈
     * 算法
     *
     * 使用栈来存储条形块的索引下标。
     * 遍历数组：
     * 当栈非空且 height[current]>height[st.top()]
     * 意味着栈中元素可以被弹出。弹出栈顶元素 top。
     * 计算当前元素和栈顶元素的距离，准备进行填充操作
     * distance=current−st.top()−1
     * 找出界定高度
     * bounded_height=min(height[current],height[st.top()])−height[top]
     * 往答案中累加积水量ans+=distance×bounded_height
     * 将当前索引下标入栈
     * 将 current 移动到下个位置
     * */
    public int trap(int[] height) {
        int result = 0;
        if(height==null || height.length<3){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for(int i=0;i<height.length;i++){
           while(!stack.isEmpty()  && height[i]>height[stack.peek()]){
               int h = height[stack.peek()]; //取出要出栈的元素
               stack.pop(); //出栈
               if (stack.empty()) { // 栈空就出去
                   break;
               }
               int distance = i - stack.peek() - 1; //两堵墙之前的距离。
               int min = Math.min(height[stack.peek()], height[i]);
               result += distance * (min - h);
           }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode42 leetCode42 = new LeetCode42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(leetCode42.trap(height));
    }
}

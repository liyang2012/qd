package cn.com.myproject.learn.leetcodem;


/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * */
public class LeetCode13 {
    private int res;
    private boolean[][] marked;
    private int m,n,k;
    public int movingCount(int m, int n, int k) {
        marked=new boolean[m][n];  //记录哪些已经到达
        this.m=m;
        this.n=n;
        this.k=k;
        res=0;
        dfs(0,0);
        return res;
    }

    private void dfs(int i, int j) {
        if(!isArea(i,j)){
            return; //判断横纵坐标是否在合适的区间类
        }
        if(marked[i][j]) {
            return;  //判断是否已经到达过，达到过返回
        }
        if(isOk(i,j)){   //判断是否满足
            res++;
            dfs(i+1,j);   //继续查找
            dfs(i,j+1);
        }
        marked[i][j]=true;  //表示已经到达过了
    }

    private boolean isArea(int newX, int newY) {
        if(newX<0||newX>=m||newY<0||newY>=n) {
            return false;
        }
        return true;
    }

    private boolean isOk(int newX, int newY){
        return newX%10+newX/10+newY%10+newY/10<=k;
    }
}

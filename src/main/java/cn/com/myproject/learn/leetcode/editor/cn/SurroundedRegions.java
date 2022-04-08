//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SurroundedRegions{
    public static void main(String[] args) {
       Solution solution = new SurroundedRegions().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //并查集类
        class UF{
            private int[] ID;
            private int[] treeSize;
            public UF(int N){
                ID = new int[N];
                treeSize = new int[N];
                for(int i = 0; i < N; i++){
                    ID[i] = i;
                    treeSize[i] = 1;
                }
            }

            public int find(int i){
                //查找当前树的根节点
                int root = i;
                while(root != ID[root])
                    root = ID[root];

                //路径压缩
                int next;
                while(i != ID[i]){
                    next = ID[i];
                    ID[i] = root;
                    i = next;
                }
                return root;
            }

            public boolean connected(int p, int q){
                return find(p) == find(q);
            }

            public void union(int p, int q){
                if(find(p) == find(q))
                    return;
                if(treeSize[p] < treeSize[q]) //小树链接到大树上
                    ID[ID[p]] = ID[q]; //在调用find后，　路径被压缩，　因此ID[p]即为根节点, 同理ID[q]也为根节点
                else
                    ID[ID[q]] = ID[p];
            }
        }

        //将二维坐标转化为一维坐标, 便于并查集使用
        //ｘ为二维数组的一维索引，　ｙ为二维数组的二维索引
        private int flatternTowDim(int x, int y, int width){
            return x * width + y;
        }

        public void solve(char[][] board) {
            if(board.length == 0) return;
            int len = board.length;
            int width = board[0].length;
            int boardSize = len * width;
            UF uf = new UF(boardSize+1);
            //添加一个虚拟节点，所有位于边界的Ｏ节点均与该虚拟节点相连接
            int i, j;
            for(i = 0; i < board.length; i++){
                for(j = 0; j < board[0].length; j++){
                    if((i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) && board[i][j]=='O')
                        uf.union(flatternTowDim(i, j, width), boardSize);
                }
            }

            //遍历搜索相邻的Ｏ，添加到并查集中
            for(i = 0; i < board.length; i++){
                for(j = 0;j < board[0].length; j++){
                    if(board[i][j] == 'O'){
                        //将当前Ｏ点与其上下左右四个方向的Ｏ点相连接
                        if(i-1 >=0 && board[i-1][j] == 'O')
                            uf.union(flatternTowDim(i-1, j, width), flatternTowDim(i, j, width));
                        if(i+1 < board.length && board[i+1][j] == 'O')
                            uf.union(flatternTowDim(i+1, j, width), flatternTowDim(i, j, width));
                        if(j-1 >= 0 && board[i][j-1] == 'O')
                            uf.union(flatternTowDim(i, j-1, width), flatternTowDim(i, j, width));
                        if(j+1 <= board[0].length && board[i][j] == 'O')
                            uf.union(flatternTowDim(i, j+1, width), flatternTowDim(i, j, width));
                    }
                }
            }

            //将所有与边界节点不相连的＇Ｏ＇点替换为＇Ｘ＇
            for(i = 0; i < board.length; i++){
                for(j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'O' && !uf.connected(flatternTowDim(i, j, width), boardSize))
                        board[i][j] = 'X';
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
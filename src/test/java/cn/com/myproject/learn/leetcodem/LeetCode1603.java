package cn.com.myproject.learn.leetcodem;


/**
 *面试题 16.03. 交点
 *给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 *
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * 示例 2：
 *
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * 示例 3：
 *
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 *  
 *
 * 提示：
 *
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 *
 * */
public class LeetCode1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        Point p1 = new Point(start1[0], start1[1]);
        Point p2 = new Point(end1[0], end1[1]);
        // 调整p1,p2的位置，使p1在p2的左边
        ajust(p1, p2);
        Point p3 = new Point(start2[0], start2[1]);
        Point p4 = new Point(end2[0], end2[1]);
        // 调整p3,p4的位置，使p3在p4的左边
        ajust(p3, p4);

        // 判断两条线段是否平行
        if (multiplicationCross(p1, p2, p3, p4) == 0) {
            // 判断是否共线（在两条线段上分别取一点连成的向量与原来的两条线段之一做叉乘）
            if (multiplicationCross(p1, p3, p3, p4) == 0) {
                // 线段1的起点p1在线段2内
                if (isInsideSegment(p1, p3, p4)) {
                    return new double[]{p1.x, p1.y};
                }
                // 线段1的终点p2在线段2内
                if (isInsideSegment(p2, p3, p4)) {
                    return new double[]{p3.x, p3.y};
                }
                // 线段2的起点p3在线段1内
                if (isInsideSegment(p3, p1, p2)) {
                    return new double[]{p3.x, p3.y};
                }
                // 线段2的终点p4在线段1内
                if (isInsideSegment(p4, p1, p2)) {
                    return new double[]{p1.x, p1.y};
                }
            }
        } else {
            double denominator = -multiplicationCross(p1, p2, p3, p4);

            // 线段所在直线的交点坐标 (x , y)
            double x = ((p2.x - p1.x) * (p4.x - p3.x) * (p3.y - p1.y)
                    + (p2.y - p1.y) * (p4.x - p3.x) * p1.x
                    - (p4.y - p3.y) * (p2.x - p1.x) * p3.x ) / denominator ;
            double y = -((p2.y - p1.y) * (p4.y - p3.y) * (p3.x - p1.x)
                    + (p2.x - p1.x) * (p4.y - p3.y) * p1.y
                    - (p4.x - p3.x) * (p2.y - p1.y) * p3.y) / denominator;
            // 交点既在线段1上，又在线段2上
            if ((x - p1.x) * (x - p2.x) <= 0 && (y - p1.y) * (y - p2.y) <= 0
                    && (x - p3.x) * (x - p4.x) <= 0 && (y - p3.y) * (y - p4.y) <= 0) {
                // 可能会出现-0.0的情况
                return new double[]{x + 0.0, y + 0.0};
            }
        }
        return new double[]{};
    }

    // 调整p1，p2的位置，使得p1在p2的左边
    private void ajust(Point p1, Point p2) {
        if (p1.x > p2.x) {
            double temp = p1.x;
            p1.x = p2.x;
            p2.x = temp;

            temp = p1.y;
            p1.y = p2.y;
            p2.y = temp;
        }
    }

    // 判断p是否在p1和p2连成的线段上（p, p1, p2三点共线是前提条件）
    private boolean isInsideSegment(Point p, Point p1, Point p2) {
        // 如果线段与y轴平行
        if (p1.x == p2.x) {
            return Math.min(p1.y, p2.y) <= p.y && p.y <= Math.max(p1.y, p2.y);
        }
        // 由于有三点共线的条件，而且p1在p2的左边（p1.x <= p2.x）
        return p1.x <= p.x && p.x <= p2.x;
    }


    /**
     * 计算叉乘
     * @param p1 向量v1的起点
     * @param p2 向量v1的终点
     * @param p3 向量v2的起点
     * @param p4 向量v2的终点
     * @return  向量v1与v2的叉乘
     */
    private double multiplicationCross(Point p1, Point p2, Point p3, Point p4) {
        return (p2.x - p1.x) * (p4.y - p3.y) - (p4.x - p3.x) * (p2.y - p1.y);
    }

}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

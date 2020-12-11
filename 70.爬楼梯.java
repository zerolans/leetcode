/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        return climbStairs6(n);
    }

    public int climbStairs1 (int n) {
        int result = 1;
        int q=0, p=0;

        for(int i=0; i<n; ++i){
            q = p;
            p = result;
            result = q + p;
        }

        return result;
    }

    public int climbStairs2(int n) {
        int[][] tmp = new int[][]{{1, 1}, {1, 0}};

        int[][] ret = pow(tmp, n);

        return ret[0][0];
    }

    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double f = Math.pow((1 + sqrt5)/2, (n+1)) - Math.pow((1 - sqrt5)/2, (n+1));
        return (int)(f/sqrt5);
    }

    private int[][] pow(int[][] res, int n) {
        int[][] ret = {{1,0}, {0, 1}};

        while(n>0) {
            if((n & 1) == 1) {
                ret = multiply(res, ret);
            }
            n >>= 1;
            res = multiply(res, res);
        }

        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int result[][] = new int[2][2];

        for(int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                result[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return result;
    }

    //动态规划
    public int climbStairs4(int n) {
        int result = 1;
        int q = 0, p = 0;
        for(int i=0; i<n; i++) {
            q = p;
            p = result;
            result = q + p;
        }
        return result;
    }

    //矩阵乘法
    public int climbStairs5(int n) {
        int[][] res = {{1, 1}, {1, 0}};
        int[][] result = pow1(res, n);
        return result[0][0];
    }

    private int[][] pow1(int[][] res, int n) {
        int[][] result = {{1, 0}, {0, 1}};
        while(n>0) {
            if((n&1) == 1) {
                result = multiply1(result, res);
            }
            res = multiply1(res, res);
            n >>= 1;
        }
        return result;
    }

    private int[][] multiply1(int[][] a, int[][] b) {
        int[][] result = new int[2][2];

        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                result[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }

        return result;
    }
    
    //多项式
    public int climbStairs6(int n) {
        double sqrt5 = Math.sqrt(5);
        double r = Math.pow((1 + sqrt5)/2, n+1) - Math.pow((1 - sqrt5)/2, n+1);
        return (int)(r/sqrt5);
    }

}
// @lc code=end


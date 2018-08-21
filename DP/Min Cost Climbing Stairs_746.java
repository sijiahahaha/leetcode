/**

1.state f[i]表示跳到i的min cost
    int[] f     加一位开头，表示原地起点
2.function
    f[i] = min(f[i-1], f[i-2]) + f[i].cost
3.initialize
    f[0] = 0 f[1] = cost[0]
4.answer
    min(f[len-1], f[len-2])

**/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        
        if(cost == null || len == 0 || len == 1){
            return 0;
        }
        
        if(len == 2){
            return Math.min(cost[0],cost[1]);
        }
        
        //state
        int[] f = new int[len+1];
        //initialize
        f[0] = 0;
        f[1] = cost[0];
        //function
        for(int i = 2; i<f.length; i++){
            f[i] = Math.min(f[i-1], f[i-2]) +cost[i-1];
        }
        
        //answer
        return Math.min(f[f.length-1], f[f.length-2]);
        
    }
        
          
    
    
}
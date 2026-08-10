class Solution {
    static final int maxx = 100000;
    static final boolean[] dp = new boolean[maxx+1];
    static{
        for(int i=0; i<=maxx; i++){
            if(dp[i]){
                continue;
            }
            for(int j=1; j*j<=maxx-i; j++){
                dp[i+j*j] = true;
            }
        }
    }
    public boolean winnerSquareGame(int n){return dp[n];}
}
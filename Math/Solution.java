class Solution {
    public int reverse(int x) {
        int res =0;
        while (x!=0){
            int tmp = x % 10;
            if(res<-214748364 || res>214748364 ){
                return 0;
            }
            res = res*10 + tmp;
            x = x/10;
        }
        return res;
    }
}
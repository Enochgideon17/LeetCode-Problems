class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<0){
            return false;
        }
        int root=(int) Math.sqrt(num);
        if(root*root==num){
            return true;
        }
        return false;
 
    }
}
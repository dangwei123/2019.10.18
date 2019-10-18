1.
给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。

如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reordered-power-of-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean reorderedPowerOf2(int N) {
       int[] res=fun(N);
        for(int i=0;i<31;i++){
           if(Arrays.equals(res,fun(1<<i))){
               return true;
           } 
        }
        return false;
    }
    public int[] fun(int N){
         int[] arr=new int[10];
        while(N!=0){
            arr[N%10]++;
            N/=10;
        }
        return arr;
    }
}


2.
给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一
个元素加1或减1。 您可以假设数组的长度最多为10000。
class Solution {
    public int minMoves2(int[] nums) {
        int count1=0;
         int count2=0;
         int count3=0;
        Arrays.sort(nums);
        if(nums.length%2==1){
            int a=nums[nums.length/2];
            for(int i=0;i<nums.length;i++){
                 if(nums[i]<a){
                count1+=(a-nums[i]);
            }else{
                count1+=(nums[i]-a);
            }
            }
           
        }else{
           int b1=nums[nums.length/2];
            for(int i=0;i<nums.length;i++){
                if(nums[i]<b1){
                count1+=(b1-nums[i]);
            }else{
                count1+=(nums[i]-b1);
            }
            }
            
            int b2=nums[nums.length/2-1];
            for(int i=0;i<nums.length;i++){
                 if(nums[i]<b2){
                count2+=(b2-nums[i]);
            }else{
                count2+=(nums[i]-b2);
            }
            }
           
            if(count1>count2){
                count1=count2;
            }
        }
       return count1;
    }
}


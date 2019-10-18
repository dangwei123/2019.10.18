1.
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==-1&&dividend==Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        int count=0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        boolean res=(dividend^divisor)<0;
        for(int i=31;i>=0;i--){
            if((a>>i)>=b){
                count+=1<<i;
                a-=b<<i;
            }
        }
        return res?-count:count;
    }
}
 
 
2.
给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

示例 1 :

输入: 2736
输出: 7236
解释: 交换数字2和数字7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-swap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maximumSwap(int num) {
        int count=0;
        int tmp=num;
        while(tmp!=0){
            count++;
            tmp/=10;
        }
        int[] arr1=new int[count];
        int[] arr2=new int[count];
        tmp=num;
        int b=count-1;
        while(tmp!=0){
            arr1[b]=tmp%10;
            arr2[b]=tmp%10;
            tmp/=10;
            b--;
        }
        Arrays.sort(arr1);
        int left=0;
        int right=count-1;
        while(left<right){
            tmp=arr1[left];
            arr1[left++]=arr1[right];
            arr1[right--]=tmp;
        }
        int a=0;
        int c=0;
        int flag=0;
        for(int i=0;i<count;i++){
            if(arr1[i]!=arr2[i]){
                a=arr1[i];
                c=i;
                flag=1;
                break;
            }
        }
         int sum=0;
        if(flag==1){
            for(int i=count-1;i>=0;i--){
            if(arr2[i]==a){
                 tmp=arr2[i];
                 arr2[i]= arr2[c];
                arr2[c]=tmp;
                break;
            }
        }
        for(int i=0;i<count;i++){
            sum+=arr2[i]*(int)Math.pow(10,count-i-1);
        }
        return sum;
        }else{
            for(int i=0;i<count;i++){
            sum+=arr2[i]*(int)Math.pow(10,count-i-1);
        }
        return sum;
        }
        
        
    }
}

3.
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
你需要让组成和的完全平方数的个数最少。
法一：
class Solution {
    public int numSquares(int n) {
        int[] res=new int[n+1];
        for(int i=1;i<=n;i++){
            res[i]=i;
            for(int j=1;i-j*j>=0;j++){
                res[i]=Math.min(res[i],res[i-j*j]+1);
            }
        }
        return res[n];
    }
}

法二：
class Solution {
    public int numSquares(int n) {
        while(n%4==0){
            n/=4;
        }
        if(n%8==7){
            return 4;
        }
        int a=0;
        while(a*a<=n){
            int b=(int)Math.sqrt(n-a*a);
            if(a*a+b*b==n){
                if(a!=0&&b!=0){
                    return 2;
                }
                    return 1;
            }
            a++;
        }
          return 3;
    }
}
package com.lwf.homeWork.算法;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.*;

import static java.lang.Integer.max;

/**
 * @author lwf
 * @title: Question1
 * @projectName 10_14Code
 * @description: TODO
 * @date 2020/10/1411:00
 */
public class Question1 {
    public static List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<>();
        int[][] caculate=new int[A.length][26];
        int i=0;
        for(String a:A){
            for(char c:a.toCharArray()){
                caculate[i][c-'a']++;
            }
            i++;
        }
        for (int j=0;j<26;j++){
            int min=caculate[0][j];
            for(int k=1;k<A.length;k++){
                if(min>caculate[k][j]){
                    min=caculate[k][j];
                }
            }
           for(int k = 0; k<min; k++){
               res.add((char)('a'+j)+"");
           }
        }
        return res;
    }

    public static boolean isValid(String s) {
        boolean flag=false;
        int len=s.length();
        while (true){
            s=s.replaceAll("abc","");
            if(s.length()!=len){
                len=s.length();
            }else {
                if(s.trim().length()==0)
                    return true;
                else
                    return false;
            }
        }
    }
    public static int longestOnes(int[] A, int K) {
//        int[] place=new int[A.length/2];//数组折叠0/1 装重复数字个数 布尔值标注第一个位置为0|1   000111->01  place[0]=3,place=3
//        boolean flg=false;
//        int before=A[0];//记录前一个数字
//        int num=0;//记录个数
//        int size=0;//数组装个数
//        for(int i=0;i<A.length;i++){
//            if(i==0){
//                if(A[i]==0){
//
//                }else {
//                    before=1;
//                    flg=true;
//                }
//                continue;
//            }
//            if(A[i]==before){
//                num++;
//            }else {
//                place[size]=num;
//                size++;
//                num=0;
//            }
//        }
//        int[] locate=new int[size/2];//连续1位置数组
//        int[] loca=new int[size/2];
//        int le=0;
//        for(int i=flg?1:0; i<size/2; i++){
//            locate[le]=place[i];
//            loca[le]=i;
//            le++;
//        }
//        int[] rember=locate.clone();
//        Arrays.sort(locate);
//        int max=0;
//        for (int i =le;i>=0;i--){
//            for(int j=0;j<le;j++){
//                if(locate[i]==rember[j]){
//                    if(K>=place[loca[j]-1]+place[loca[j]+1]){
//                        return place[loca[j]-1]+place[loca[j]+1]+place[loca[j]-2]+place[loca[j]+2]+place[loca[j]];
//                    }else if(K>=place[loca[j]-1]){
//                        return place[loca[j]-2]+place[loca[j]]+K;
//                    }else if(K>=place[loca[j]+1]){
//                        return place[loca[j]+2]+place[loca[j]]+K;
//                    }else {
//                        return place[loca[j]]+K;
//                    }
//                }
//            }
//        }
//        return -1;
        //count用来统计窗口中0的个数
        return 1;
    }
    public  int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int index=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]<=0){
                index++;
            }else {
                break;
            }
        }
        if(index==-1){
            if(K%2==0){
                return sum(A);
            }else {
                return sum(A)-2*A[0];
            }
        }else if((index+1)<=K){
            if((K-index-1)%2==0){
                return sum(A);
            }else {
                return sum(A)+2*A[index];
            }
        }else {
            if((index+1-K)==1)
                return sum(A)+2*A[index];
            int[] a=new int[index+1-K];
            for(int i=K;i<index+1-K;i++){
                a[i]=A[i];
            }
            return sum(A)-2*sum(a);
        }
    }
    public   int sum(int[] a){
        int res=0;
        for(int i:a){
            res+=Math.abs(i);
        }
        return res;
    }

    public static int clumsy(int N) {
        int back=0;
        int res=N/4;
        int tmp=N%4;
        int cur=0;
        for(int i=0;i<res;i++){
            if(i==0)
               back+=(N-cur)*(N-cur-1)/(N-cur-2)+(N-cur-3);
            else
                back=back-(N-cur)*(N-cur-1)/(N-cur-2)+(N-cur-3);
            cur+=4;
        }
        switch (tmp){
            case 1:back-=tmp;break;
            case 2:back-=tmp*(tmp-1);break;
            case 3:back-=tmp*(tmp-1)/(tmp-2);
        }
        return back;
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int[] counter = new int[6];
        for (int i = 0; i < A.length; i++){
            counter[A[i] - 1]++;
            counter[B[i] - 1]++;
        }
        //若想形成同列一致，则这个相同数的个数必须大于等于A数组的长度
        int selectNum = -1;
        for (int i = 0; i < counter.length; i++){
            if (counter[i] >= A.length)
                selectNum = i + 1;
        }
        if (selectNum == -1)
            return -1;
        int counterA = 0,
                counterB = 0;
        //得到相同数后还需保证交换后能保证一列全等，遍历同时记录次数。
        for (int i = 0; i < A.length; i++){
            if (A[i] != selectNum && B[i] != selectNum)
                return -1;
            if (A[i] == selectNum)
                counterA++;
            if (B[i] == selectNum)
                counterB++;
        }
        //相同数越多的数组需要交换的次数即为最少
        return A.length - Math.max(counterA, counterB);

    }
    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head=new TreeNode(preorder[0]);
        Stack<TreeNode> stack=new Stack<>();
        TreeNode now=head;
        for(int i=1;i<preorder.length;i++){
            TreeNode treeNode=new TreeNode();
            if(now.val>=preorder[i]){
                treeNode.val=preorder[i];
                now.left=treeNode;
                stack.push(now);
                now=treeNode;
            }else {
                if((!stack.isEmpty())&&stack.peek().val<=preorder[i]){
                    now=stack.pop();
                    i--;
                }
                else{
                    treeNode.val=preorder[i];
                    if(now.right!=null){
                        stack.push(now);
                        now=now.right;
                        i--;
                    }
                    else { now.right=treeNode;
                    stack.push(now);
                    now=treeNode;
                }
                }
            }
        }
        return head;
    }
   public static void print(TreeNode treeNode){
       System.out.println(treeNode.val);
       print(treeNode.left);
       print(treeNode.right);
   }
    public static void main(String[] args) {
        //System.out.println(clumsy(10));
        //System.out.println(minDominoRotations(new int[]{2, 2, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        TreeNode treeNode = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12
        });
       print(treeNode);
    }
}

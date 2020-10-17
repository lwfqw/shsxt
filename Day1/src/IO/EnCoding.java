package IO;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/29
 * 加密
 * 数字：
 * 如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
 * 如果是0的数字，变成9
 * 字母字符：
 * 如果是非a字符，向左移动一个，比如e变成d, H变成G
 * 如果是a，a->z, A-Z。
 * 字符需要保留大小写
 * 非字母字符：
 * 比如',&^ 保留不变，中文也保留不变
 */
public class EnCoding {
    /**
     * 输出文件
     * @param file  被输出文件
     * @throws IOException
     */
    public void output(File file) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(file)) ;
        char[] res=new char[1024];
        int lem=0;
        while ((lem=reader.read(res))!=-1){
            System.out.println(res);
        }
        reader.close();
    }
    /**
     * 加密方法
     * @param source 被加密文件
     * @param destin  加密结果
     * @throws IOException
     */
    public void enCoding(File source,File destin) throws IOException {
        Reader reader = new FileReader(source);
        Writer writer = new FileWriter(destin);
        int len = -1;
        char[] c = new char[1024];
        while ((len = reader.read(c)) != -1) {//加密
            String tmp = "";
            for (char c1 : c) {//加密
                if (c1 == '0') {
                    tmp += '9';
                } else if (c1 >= '1' && c1 <= '9') {
                    tmp += (char) (c1 - 1);
                } else if (c1 == 'A' || c1 == 'a') {
                    tmp += (char) (c1 + 25);
                } else if ((c1 > 'a' && c1 <= 'z') || (c1 > 'A' && c1 <= 'Z')) {
                    tmp += (char) (c1 - 1);
                } else {
                    tmp += c1;
                }

            }
            writer.write(tmp.toCharArray());
        }
        writer.close();
        reader.close();
    }
    /**
     * 解密文件
     * @param source 被解密文件
     * @param destin 解密结果
     * @throws IOException
     */
    public void deCoding(File source,File destin) throws IOException {
        Reader reader=new FileReader(source);
        Writer writer=new FileWriter(destin);
        int len=-1;
        char[] c=new char[1024];
        while ((len=reader.read(c))!=-1){//加密
            String tmp="";
            for(char c1:c){//加密
                if(c1=='9'){
                    tmp+='0';
                }else if(c1>='0'&&c1<='8'){
                    tmp+=(char)(c1+1);
                }else if(c1=='Z'||c1=='z'){
                    tmp+=(char)(c1-25);
                }else if((c1>='a'&&c1<'z')||(c1>='A'&&c1<'Z')){
                    tmp+=(char)(c1+1);
                }else {
                    tmp+=c1;
                }

            }
            writer.write(tmp.toCharArray());
        }
        writer.close();
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        File s=new File("file/原码");
        File d=new File("file/解码");
        File r=new File("file/密文解码");
        EnCoding enCoding=new EnCoding();
        System.out.println("原码");
        enCoding.output(s);
        System.out.println("加密");
        enCoding.enCoding(s,d);
        System.out.println("密文");
        enCoding.output(d);
        System.out.println("解密");
        enCoding.deCoding(d,r);
        System.out.println("解密后");
        enCoding.output(r);
//        System.out.println((char)('a'+1));
//        System.out.println("qwee".toCharArray());
    }
}

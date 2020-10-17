package IO;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/21
 */
public class Input {
    public static void read(String locate) throws IOException {
        BufferedInputStream reader=new BufferedInputStream(new FileInputStream(locate));
        byte[] res=new byte[1024];
        int lem=-1;
        while ((lem=reader.read(res))!=-1){
            System.out.println(res);
        }
        reader.close();
    }

    public static void readChar(String locate) throws IOException {
       BufferedReader reader=new BufferedReader(new FileReader(locate)) ;
       char[] res=new char[1024];
        int lem=0;
        while ((lem=reader.read(res))!=-1){
            System.out.println(res);
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        Input.read("C:\\Users\\lwf\\Desktop\\任务卡\\罗卫飞9_30任务卡.docx");
        Input.readChar("C:\\Users\\lwf\\Desktop\\任务卡\\罗卫飞9_30任务卡.docx");
    }
}

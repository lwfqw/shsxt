package IO;

import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/21
 */
public class Out {
    public static void copyBite(String start,String end) throws IOException {
        BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(start));
        BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(end));
        int len=-1;
        byte[] cus=new byte[1024];
        while ((len=inputStream.read(cus))!=-1){
            outputStream.write(cus);
        }
        outputStream.close();
        inputStream.close();
    }
    public static void copyChar(String start,String end) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(start));
        BufferedWriter writer=new BufferedWriter(new FileWriter(end));
        int len=-1;
        char[] cus=new char[1024];
        while ((len=reader.read(cus))!=-1){
            writer.write(cus);
        }
        reader.close();
        writer.close();
    }
    public static void write(String file) throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(file));
        Scanner scanner=new Scanner(System.in);
        int len=-1;
        String context;
        context=scanner.next();
        writer.write(context);
        scanner.close();
        writer.close();
    }
    public static void main(String[] args) throws IOException {
//        Out.copyBite("file/6.txt","file/3.txt");
//        Out.copyChar("file/6.txt","file/4.txt");
        Out.write("file/3.txt");
    }
}

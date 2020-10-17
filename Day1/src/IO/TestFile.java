package IO;

import java.io.*;

/**
 * @author lwf
 * @title: TestFile
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1120:13
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file=new File("file/9.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.renameTo(new File("19.txt")));
        if(file.exists()){
            System.out.println("exist");
        }else {
            file.createNewFile();
        }
        System.out.println("exist"+file.exists());
        System.out.println(file.canRead()+","+file.canWrite()+","+file.canExecute());
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        writer.write("罗");
        writer.close();
    }
}

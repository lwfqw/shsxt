package IO;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/21
 */
public class File1 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\IDEA Workspace\\Day1\\file","9.txt");
        System.out.println(file.getAbsolutePath());
        file.createNewFile();
        System.out.println(file.exists());
        file.delete();
    }
}

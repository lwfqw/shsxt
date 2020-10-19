package com.lwf.homeWork;

import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lwf
 * @title: TestThree
 * @projectName 10_19Code
 * @description: 3.使用多线程实现多文
 * 件的拷贝(一个线程用来拷贝一个文件),并同时在控制台输出拷
 * 贝进度,比如: xxx文件已拷贝10% ,20%,30%...
 * @date 2020/10/1919:42
 */
public class TestThree implements Callable {
    public static void main(String[] args) throws IOException {
        TestThree testThree=new TestThree("resources/九黎如嫣 - 忘川彼岸 (抖音热搜版).mp3","resources/1.mp3");
        ExecutorService ex= Executors.newFixedThreadPool(2);
        ex.submit(testThree);
        ex.shutdown();
    }
    private File file;
    private int all;
    private File des;
    private int length=0;
     BufferedInputStream reader;
     BufferedOutputStream writer;
    public TestThree(String src,String des) {
        this.file = new File(src);
        this.des=new File(src);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            reader = new BufferedInputStream(inputStream);
            all=inputStream.available();
            writer=new BufferedOutputStream(new FileOutputStream(des));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
        e.printStackTrace();
    }
    }

    @Override
    public Object call() throws Exception {
        synchronized (TestThree.class) {
            byte[]  buf=new byte[1024*8];
            int line=-1;
            while (-1!= (line = reader.read(buf))) {
                writer.write(buf,0,line);
                writer.flush();
                length+=line;
                double range=(1.0*length / all);
                System.out.println(file.getName() + "已经复制：" + (range* 100)+ "%");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
        return null;
    }

}

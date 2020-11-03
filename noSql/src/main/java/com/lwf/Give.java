package com.lwf;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author lwf
 * @title: Give
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2815:54
 */
public class Give implements Runnable{
    private Socket socket;
    private DataOutputStream write;
    private Scanner scanner=new Scanner(System.in);
    public Give(Socket socket) throws IOException {
        this.socket = socket;
        write=new DataOutputStream(this.socket.getOutputStream());
    }

    @Override
    public void run() {
        synchronized (socket) {
            while (true) {
                try {
                    String buf=scanner.next();
                    write.writeUTF(buf);
                    write.flush();
                    Thread.sleep(200);
                    if(buf.equals("bye")){
                        System.out.println("bye");
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

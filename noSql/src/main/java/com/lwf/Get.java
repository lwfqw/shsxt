package com.lwf;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author lwf
 * @title: Get
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2815:54
 */
public class Get implements Runnable{
    private Socket socket;
    private DataInputStream read;
    public Get(Socket socket) throws IOException {
        this.socket = socket;
        read=new DataInputStream(this.socket.getInputStream());
    }

    @Override
    public void run() {
        synchronized (socket) {
            while (true) {
                try {
                    String buf = read.readUTF();
                    if (buf.equals("bye")) {
                        System.out.println("bye");
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

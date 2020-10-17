package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author lwf
 * @title: Reciver
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1121:09
 */
public class Reciver extends Thread {
    private Socket socket;

    public Reciver(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
      while (true){
          try {
              System.out.println("客户端发，服务端读");
              reader();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }
    public void reader() throws IOException {
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        while (true){
            System.out.println(inputStream.readUTF());
        }
    }
}

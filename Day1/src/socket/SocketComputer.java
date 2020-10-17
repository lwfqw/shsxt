package socket;

import java.io.*;
import java.net.ServerSocket;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/22
 */
public class SocketComputer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket=new ServerSocket(8848);
        InputStream inputStream =serverSocket.accept().getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        Thread.sleep(1000);
        System.out.println(dataInputStream.readUTF());
        System.out.println("收到来自"+serverSocket.getInetAddress()+serverSocket.getLocalPort()+"的信息");
        System.out.println("延迟是"+serverSocket.getSoTimeout()+"ms");
        DataOutputStream outputStream=new DataOutputStream(serverSocket.accept().getOutputStream());
        outputStream.writeUTF("你好客户端，我已收到你的信息。");
        outputStream.close();
        dataInputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}

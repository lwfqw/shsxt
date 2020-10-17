package socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/22
 */
public class Customer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket=new Socket("127.0.0.1",8848);
        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("服务器,我是客户端");
        Thread.sleep(2000);
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        System.out.println("收到回复"+dataInputStream.readUTF());
        System.out.println("来自:"+socket.getLocalSocketAddress());
        socket.close();
    }
}

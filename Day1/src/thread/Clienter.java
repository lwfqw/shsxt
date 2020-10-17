package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lwf
 * @title: Clienter
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1121:11
 */
public class Clienter {
    public Clienter() {
    }
    Socket socket;
    {
        try {
            socket=new Socket("127.0.0.1",9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

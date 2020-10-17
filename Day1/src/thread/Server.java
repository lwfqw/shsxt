package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Scanner;

/**
 * @author lwf
 * @title: Server
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1120:55
 */
public class Server {
    public Server(){}
    Socket socket;
    {
        try {
            ServerSocket serverSocket=new ServerSocket(9999);

            socket=serverSocket.accept();
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

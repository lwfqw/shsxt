package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author lwf
 * @title: Send
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1121:06
 */
public class Send extends Thread {
    private Socket socket;
    public Send(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true){
        try {
            writer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
    public void writer() throws IOException {
        DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
        Scanner scanner=new Scanner(System.in);
        while (true){
            outputStream.writeUTF(scanner.nextLine());
        }
    }
}

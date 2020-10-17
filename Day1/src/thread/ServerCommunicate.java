package thread;

/**
 * @author lwf
 * @title: ServerCommunicate
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1121:53
 */
public class ServerCommunicate {
    public static void main(String[] args) {
        Server clienter=new Server();
        Reciver reciver=new Reciver(clienter.getSocket());
        Send send=new Send(clienter.getSocket());
        reciver.start();
        send.start();
    }
}

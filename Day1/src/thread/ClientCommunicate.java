package thread;

/**
 * @author lwf
 * @title: CommunicateApp
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1121:39
 */
public class ClientCommunicate {
    public static void main(String[] args) {
        Clienter clienter=new Clienter();
        Send send=new Send(clienter.getSocket());
        Reciver reciver=new Reciver(clienter.getSocket());
        send.start();
        reciver.start();
    }
}

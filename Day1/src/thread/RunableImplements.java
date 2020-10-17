package thread;

/**
 * @author lwf
 * @title: RunableImplements
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/920:40
 */
public class RunableImplements implements Runnable {
    @Override
    public void run() {
        int i=0;
        while (true){
            System.out.println(i+"runable线程在运行");
            i++;
            if(i==30)
                //break;
                return;
        }
    }

    public static void main(String[] args) {
        Thread thread =new Thread(new RunableImplements());
        thread.start();
    }
}

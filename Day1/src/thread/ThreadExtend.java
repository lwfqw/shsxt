package thread;

/**
 * @author lwf
 * @title: ThreadExtend
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/920:34
 */
public class ThreadExtend extends Thread{
    int num=0;
    int sum=0;
    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        while (num++<=10){
            sum+=num;
            System.out.println("sum="+sum);
            System.out.println(this.getId());
            System.out.println(this.getState());
        }
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public State getState() {
        return super.getState();
    }

    public static void main(String[] args) {
        ThreadExtend threadExtend=new ThreadExtend();
        threadExtend.start();
    }
}

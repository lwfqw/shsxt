package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lwf
 * @title: TestSyn
 * @projectName Day1
 * @description: 线程安全
 * @date 2020/10/920:49
 */
public class TestSyn {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        List arrayList1= Collections.synchronizedList(arrayList);
        //两个线程对象对线程安全列表加入
        Change change=new Change("a",arrayList1);
        Change change1=new Change("b",arrayList1);
        change.start();
        change1.start();
        //System.out.println("---------------------------------");
        //System.out.println(arrayList1.size());
    }
}
class Change extends Thread{
  List arrayList;
    public Change(String a, List arrayList) {
        super();
        this.arrayList=arrayList;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        for (int i=0;i<30;i++){
            arrayList.add(1);
            System.out.println(getId()+"   "+getName());
            System.out.println(arrayList);
        }
    }

    @Override
    public long getId() {
        return super.getId();
    }
}
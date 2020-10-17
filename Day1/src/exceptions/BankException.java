package exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/29
 */
public class BankException {
    public static void main(String[] args)  {
        Bank bank=new Bank();
        System.out.println(bank.deposit(100));
        System.out.println(bank.getBalance());
        try {
            System.out.println(bank.withdraw(110));
        } catch (DeficitException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();

        }finally {
            System.out.println(bank.getBalance());
        }

    }
}
//异常类
class DeficitException extends Exception{
    public DeficitException(){}
    public DeficitException(String str){
        super(str);
    }
}
//银行，业务
class Bank{
   private int  balance;
   public int getBalance(){
       return balance;
   }
   public boolean deposit(int in){
       balance+=in;
       return true;
   }
   public boolean withdraw(int out) throws DeficitException {
       if(out>balance){
           throw new DeficitException("金额不够");
       }else {
           balance-=out;
           return true;
       }
   }
}
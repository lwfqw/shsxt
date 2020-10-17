package work;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 */
public class Square {
    public static void shixing(){
        char[][] square=new char[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                square[i][j]='*';
            }
        }
        for(int i=0;i<10;i++){
            System.out.println(square[i][0]+""+square[i][1]+""+square[i][2]+""+square[i][3]+""+square[i][4]+""+square[i][5]+""+square[i][6]+""+square[i][7]+""+square[i][8]+""+square[i][9]);
        }
    }
    public static void konxing(){
        char[][] square=new char[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(i==0||i==9){
                    square[i][j]='*';
                }else{
                if(j==0||j==9)
                  square[i][j]='*';
                else
                    square[i][j]=' ';
                }
            }
        }
        for(int i=0;i<10;i++){
            System.out.println(square[i][0]+""+square[i][1]+""+square[i][2]+""+square[i][3]+""+square[i][4]+""+square[i][5]+""+square[i][6]+""+square[i][7]+""+square[i][8]+""+square[i][9]);
        }
    }
    public static void main(String[] args) {
        System.out.println("实心");
        shixing();
        System.out.println("空心");
        konxing();
    }
}

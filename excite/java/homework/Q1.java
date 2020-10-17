package homework;

/**
 * Created by IntelliJ IDEA.
 * User: lwf-pc
 * Auther: 罗卫飞
 * Date: 2020/9/28
 * 成绩评定
 */
public class Q1 {
    //静态类存放成绩等信息
    public static class Student {
        public int grade;//成绩
        public String name;//名字
        public char comment;//评定
        public Student(String name,int grade){
            this.name=name;
            this.grade=grade;
            if(grade>=90){
                this.comment='A';
            }else if(grade<=89&&grade>=60){
                this.comment='B';
            }else if(grade<60&&grade>=0){
                this.comment='C';
            }else {
                System.out.println("无效输入，成绩默认C");
            }
        }

        public String toString(){
            return "姓名:"+name+",成绩:"+grade+",评定:"+comment;
        }
    }

    public static void main(String[] args) {
        Student student=new Student("罗卫飞",99);
        System.out.println(student.toString());
    }
}

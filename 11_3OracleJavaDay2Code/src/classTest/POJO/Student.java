package classTest.POJO;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author lwf
 * @title: Student
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/217:45
 */
public class Student {
    private String sno;
    private String sname;
    private Integer sage;
    private String sdept;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field=Student.class.getDeclaredField("sno");
        System.out.println(field.getName());
    }
    public String getSno() {
        return sno;
    }

    public void setSno(Object sno) {
        this.sno = (String) sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(Object sname) {
        this.sname = (String)sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(Object sage) {
        this.sage = ((BigDecimal) sage).intValue();
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(Object sdept) {
        this.sdept = (String)sdept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sdept='" + sdept + '\'' +
                '}';
    }
}

package Fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: Test
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/920:25
 */
public class Test {
    public static void main(String[] args) {
        List<ShaDiao> list=new ArrayList<>();
        list.add(new ShaDiao());
        System.out.println(list);
    }
    static class ShaDiao{
        private String name="沙雕";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ShaDiao{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

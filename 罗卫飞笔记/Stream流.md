# Stream**流**

Java8 API添加了一个新的抽象称为流 Stream ，可以让

你以一种声明的方式处理数据。

Stream 使用一种类似用 SQL 语句从数据库查询数据的直

观方式来提供一种**对** Java **集合运算和表达的高阶抽**

**象**。Stream API可以极大提高Java程序员的生产力，让

程序员写出高效率、干净、简洁的代码。这种风格将要

处理的元素集合看作一种流， 流在管道中传输， 并且可

以在管道的节点上进行处理， 比如筛选， 排序，聚合

等。

元素流在管道中经过中间操作（intermediate 

operation）的处理，最后由最终操作(terminal 

operation)得到前面处理的结果。

Stream（流）是一个来自数据源的元素队列并支持聚合

操作

元素是特定类型的对象，形成一个队列。 Java**中的**

Stream**并不会存储元素，而是按需计算**。

**数据源** 流的来源。 可以是集合，数组等。

**聚合操作** 类似SQL语句一样的操作， 比如filter, map, 

reduce, find, match, sorted等。Java 8 中的 Stream 是对集合（Collection）对象功能的

增强，它专注于对集合对象进行各种非常便利、高效的

聚合操作（aggregate operation），或者大批量数据操作

(bulk data operation)。

# 获取流

1. 可以通过Conllection系列集合提供的顺序 

   流stream()或并行流parallelStream()

   ```
   public class TestStreamAPI1 { 
   // 创建
   Stream public void test1() { 
   // 1、可以通过Conllection系列集合提供的顺序 流stream()或并行流parallelStream() 
   List<String> list = new ArrayList<>(); Stream<String> stream1 = list.stream(); 
   stream1 = list.parallelStream(); 
   // 2、通过Arrays中的静态方法stream()获取数 据流 Integer ints[] = new Integer[10]; Stream<Integer> stream2 = Arrays.stream(ints); // 3、通过Stream类中的静态方法of() 
   Stream<String> stream3 = Stream.of("aa", "bb", "cc"); 
   String str[] = new String[10]; Stream<String> stream4 = Stream.of(str) } }
   ```

   

2. 通过Arrays中的静态方法stream()获取数 

   据流 

   > ```
   > package com.lwf.homeWork;
   > 
   > import java.util.Arrays;
   > 
   > /**
   >  * @author lwf
   >  * @title: StreamWork
   >  * @projectName 10_24Code
   >  * @description: TODO
   >  * @date 2020/10/2515:35
   >  */
   > public class StreamWork {
   >     public static void main(String[] args) {
   >         printAbs(new int[]{2,-5,6,-2,0,-6});
   >         printPow(new int[]{2,-5,6,-2,0,-6});
   >     }
   >     //打印绝对值
   >     public static void printAbs(int[] num){
   >         Arrays.stream(num).map(n->Math.abs(n)).forEach(System.out::println);
   >     }
   >     //打印平方
   >     public static void printPow(int[] num){
   >         Arrays.stream(num).map(n->n*n).forEach(System.out::println);
   >     }
   > }
   > 
   > ```

   

3. 通过Stream类中的静态方法of() 

   ![未加载](https://raw.githubusercontent.com/lwfqw/shsxt/master/10_24Code/img/image-20201025162946815.png)

# 过滤流

## fiter过滤

传入一个转化为流的容器存放对象，返回一个布尔值判断是否加入流

```
package com.lwf.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lwf
 * @title: Demo1
 * @projectName 10_24Code
 * @description: 流过滤懒执行：获取结果时才执行
 * @date 2020/10/2411:10
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Panda> list=new ArrayList<>();
        list.add(new Panda(1,"jxa","cd"));
        list.add(new Panda(2,"jxs","cd"));
        list.add(new Panda(3,"jxd","sh"));
        list.add(new Panda(4,"jxf","cd"));
        list.stream().filter(r->r.getLocate().equals("cd")).limit(3).skip(0).forEach(c-> System.out.println(c));
        System.out.println(list.parallelStream().findAny().get());
    }
}

```

## limit（n）

指定流前n条数据

## skip（n）

跳过前n条数据

## distinct（）

去重复

## map（）

传入一个方法接口，接口处理接收对象提取对象特定信息加入新的流

## foreach（System.out::println)

遍历打印流

## count（）流长度
##  排序 sorted(Comparable)-自然排序
      sorted(Comparator)-定制排序：传入一个继承了Comparable接口的比较器
## 终止操作 

## 收集（了解）
收集-将流转换为其他形式，接收一个Collertor接口的实现，用于给Stream中元素做
汇总的方法
```
Optional<Double> op4 = emps.stream() .map(Employee::getSalary) .min(Double::compare); System.out.println(op4.get()); }
   // 需求：获取当前公司所有员工的姓名添加到集合中 
   // List-把流中所有元素收集到List中 
   List<String> list = emps.stream() .map(Employee::getName) .collect(Collectors.toList()); 
   list.forEach(System.out::println); 
   // Set-把流中所有元素收集到Set中，删除重复项 
   Set<String> set = emps.stream() .map(Employee::getName) .collect(Collectors.toSet()); 
   set.forEach(System.out::println); 
   // Map-把流中所有元素收集到Map中，当出现相同的key时会抛异常 
   Map<String, Integer> map = emps.stream() .collect(Collectors.toMap(Employee::getName, Employee::getAge)); 
   System.out.println(map); 
   // 员工总数 
   Long count = emps.stream().collect(Collectors.counting()); System.out.println(count);
   // 工资平均数 
   Double avg = emps.stream() .collect(Collectors.averagingDouble(Employee::getSalary)); 
   System.out.println(avg); 
   // 工资总和 
   Double sum = emps.stream() .collect(Collectors.summingDouble(Employee::getSalary)); 
   System.out.println(sum); 
   // 工资最大值的员工 
   Optional<Employee> op = emps.stream() .collect(Collectors.maxBy((e1, e2) ->
Double.compare(e1.getSalary(), e2.getSalary()))); System.out.println(op.get());
```
注意：
1、Stream自己不会存储元素· 2、Stream不会改变源对象。相反，会返回一个持有结果的新Stream。 3、Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。

```
package com.lwf.homeWork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwf
 * @title: Goods
 * @projectName 10_24Code
 * @description: TODO
 * @date 2020/10/2515:48
 */
public class Goods {
    public static void main(String[] args) {
        List<Goods> list=new ArrayList<>();
        list.add(new Choes(12, "adidas", Type.choes));
        list.add(new Phone(43, "huawei", Type.phone));
        list.add(new Phone(66, "chenguang", Type.pen));
        list.add(new Choes(19, "nike", Type.choes));
        list.add(new Choes(18, "nike", Type.choes));
        list.add(new Phone(49, "xiaomi", Type.phone));
        list.add(new Choes(34, "huili", Type.choes));
        list.add(new Phone(36, "meizu", Type.phone));
        list.add(new Choes(7, "hailan", Type.choes));
        //鞋子销量排行
        list.stream().filter(g->g.getType()==Type.choes).sorted((o,a)->{
            return Integer.compare(o.getSell(), a.getSell());
        }).forEach(System.out::println);
        //手机产品
        list.stream().filter(g->g.getType()==Type.phone).forEach(System.out::println);
        //几种鞋子
        System.out.println(list.stream().filter(g -> g.getType() == Type.choes).map(g -> g.getName()).distinct().count());
    }
    private int sell;
    private String name;
    private Type type;

    public Goods(int sell, String name, Type type) {
        this.sell = sell;
        this.name = name;
        this.type = type;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        Goods goods = (Goods)obj;
        return this.getName().equals(goods.getName());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sell=" + sell +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
enum Type{
    phone,choes,pen;
}
class Phone extends Goods{
    public Phone(int sell, String name, Type type) {
        super(sell, name, type);
    }
}
class Choes extends Goods{
    public Choes(int sell, String name, Type type) {
        super(sell, name, type);
    }
}
class Pen extends Goods{
    public Pen(int sell, String name, Type type) {
        super(sell, name, type);
    }
}
```



# 流是懒加载，所以对流无论进行多少次操作都会取结果时一起打印·（foreach和count,或转化为集合操作时）


```
public class StreamTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("lwf");
        list.add("lwf");
        list.add("ppl");
        list.add("xly");
        list.add("hjx");
        System.out.println(list.stream().collect(Collectors.toSet()));
        Set<Integer> collect = list.stream().map(s -> s.hashCode()).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect.stream().collect(Collectors.averagingDouble(s -> s)));
        System.out.println(list.stream().distinct().collect(Collectors.toMap(s -> s, s1 -> s1.length())));
    }
}
```



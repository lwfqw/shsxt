# FreeMarker

> FreeMarker 是一款 模板引擎： 即一种基于模板和要改变的数据， 并用来生成输出文本(HTML网页，电 子邮件，配置文件，源代码等)的通用工具。 是一个Java类库。 FreeMarker 被设计用来生成 HTML Web 页面，特别是基于 MVC 模式的应用程序，将视图从业务逻辑中 抽离处理，业务中不再包括视图的展示，而是将视图交给 FreeMarker 来输出。虽然 FreeMarker 具有一 些编程的能力，但通常由 Java 程序准备要显示的数据，由 FreeMarker 生成页面，通过模板显示准备的 数据（如下图）:
>
> ![image-20201120212011935](FreeMarker.assets/image-20201120212011935.png)
>
> FreeMarker不是一个Web应用框架，而适合作为Web应用框架一个组件。 FreeMarker与容器无关，因为它并不知道HTTP或Servlet。FreeMarker同样可以应用 于非Web应用程序环境。 FreeMarker更适合作为Model2框架（如Struts）的视图组件，你也可以在模板中使用 JSP标记库。

## 特性

### 通用目标 

能够生成各种文本：HTML、XML、RTF、Java 源代码等等 易于嵌入到你的产品中：轻量级；不需要 Servlet 环境 插件式模板载入器：可以从任何源载入模板，如本地文件、数据库等等 你可以按你所需生成文本：保存到本地文件；作为 Email 发送；从 Web 应用程序发送它返回给 Web 浏览器 

### 强大的模板语言 

所有常用的指令：include、if/elseif/else、循环结构 在模板中创建和改变变量 几乎在任何地方都可以使用复杂表达式来指定值 命名的宏，可以具有位置参数和嵌套内容 名字空间有助于建立和维护可重用的宏库，或将大工程分成模块，而不必担心名字冲突 输出转换块：在嵌套模板片段生成输出时，转换HTML转义、压缩、语法高亮等等；你可以定义自己的 转换 

###  通用数据模型 

FreeMarker不是直接反射到Java对象，Java对象通过插件式对象封装，以变量方式在模板中显示 你可以使用抽象（接口）方式表示对象（JavaBean、XML文档、SQL查询结果集等等），告诉模板开发 者使用方法，使其不受技术细节的打扰 



### 为Web准备

 在模板语言中内建处理典型Web相关任务（如HTML转义）的结构 能够集成到Model2 Web应用框架中作为JSP的替代 支持JSP标记库 为MVC模式设计：分离可视化设计和应用程序逻辑；分离页面设计员和程序员 

### 智能的国际化和本地化 

字符集智能化（内部使用UNICODE） 数字格式本地化敏感 日期和时间格式本地化敏感 非US字符集可以用作标识（如变量名） 多种不同语言的相同模板 

### 强大的XML处理能力 

<#recurse> 和 <#visit> 指令（2.3版本）用于递归遍历XML树。在模板中清楚和直接的访问XML对象模 型。开源论坛 JForum 就是使用了 FreeMarker 做为页面模板。

## 引入FreeMarker

```
 这里用servlet转发给freemarker页面
 <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.freemarker/freemarker -->
    <dependency>
      <groupId>org.freemarker</groupId>
      <artifactId>freemarker</artifactId>
      <version>2.3.28</version>
    </dependency>
```

设置web.xml

```
<servlet>
    <servlet-name>freemarker</servlet-name>
    <servlet-class>freemarker.ext.servlet.FreemarkerServlet</servlet-class>
    <init-param>
      <!-- 模板路径 -->
      <param-name>TemplatePath</param-name>
      <!-- 默认在webapp目录下查找对应的模板文件 -->
      <param-value>/</param-value>
    </init-param>
    <init-param>
      <!-- 模板默认的编码：UTF-8 -->
      <param-name>default_encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </servlet>
  <!-- 处理所有以.ftl结尾的文件；ftl是freemarker默认的文件后缀 -->
  <servlet-mapping>
    <servlet-name>freemarker</servlet-name>
    <url-pattern>*.ftl</url-pattern>
  </servlet-mapping>
```

页面

```
<#if list??>
        <table>
            <tr><th>编号</th><th>姓名</th><th>年龄</th></tr>
        <#list list as user>
          <tr><td>${user.id}</td><td>${user.name}</td><td>${user.age}</td></tr>
        </#list>
        </table>
    </#if>
```

servlet

```
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        List<User> list= UserMapperImpl.all();
        req.setAttribute("list", list);
        req.getRequestDispatcher("userTable.ftl").forward(req, resp);
    }
}
```



## FreeMarker 数据类型

Freemarker 模板中的数据类型由如下几种： 

> 布尔型：等价于 Java 的 Boolean 类型，不同的是不能直接输出，可转换为字符串输出 
>
> 日期型：等价于 java 的 Date 类型，不同的是不能直接输出，需要转换成字符串再输出 
>
> 数值型：等价于 java 中的 int,float,double 等数值类型 有三种显示形式：数值型(默认)、货币型、百分比型 
>
> 字符型：等价于 java 中的字符串，有很多内置函数 
>
> sequence 类型：等价于 java 中的数组，list，set 等集合类型 hash 类型：等价于 java 中的 Map 类型

### 布尔

```
// 布尔类型
request.setAttribute("flag", true);
```



```
<#--
数据类型：布尔类型
在freemarker中布尔类型不能直接输出；如果输出要先转成字符串
方式一：?c
方式二：?string 或 ?string("true时的文本","false时的文本")
-->
${flag?c} <br>
${flag?string} <br>
${flag?string("yes","no")} <br>

```

###  日期

```
// 日期类型
request.setAttribute("createDate",new Date());

```



```
<#--
数据类型：日期类型
在freemarker中日期类型不能直接输出；如果输出要先转成日期型或字符串
1. 年月日 ?date
2. 时分秒 ?time
3. 年月日时分秒 ?datetime
4. 指定格式 ?string("自定义格式")
y：年 M：月 d：日
H：时 m：分 s：秒
-->
<#-- 输出日期格式 -->
${createDate?date} <br>
<#-- 输出时间格式 -->
${createDate?time} <br>
<#-- 输出日期时间格式 -->
${createDate?datetime} <br>
<#-- 输出格式化日期格式 -->
${createDate?string("yyyy年MM月dd日 HH:mm:ss")} <br>

```

### 数据

```
// 数值类型
request.setAttribute("age",18); // 数值型
request.setAttribute("salary",10000); // 数值型
request.setAttribute("avg",0.545); // 浮点型

```



```
<#-- 直接输出数值型 -->
${age} <br>
${salary} <br>
<#-- 将数值转换成字符串输出 -->
${salary?c} <br>
<#-- 将数值转换成货币类型的字符串输出 -->
${salary?string.currency} <br>
<#-- 将数值转换成百分比类型的字符串输出 -->
${avg?string.percent} <br>
<#-- 将浮点型数值保留指定小数位输出 （##表示保留两位小数） -->
${avg?string["0.##"]} <br>

```

### 字符串

```
// 字符串类型
request.setAttribute("msg","Hello ");
request.setAttribute("msg2","freemarker");

```



```
<#--
数据类型：字符串类型
在freemarker中字符串类型可以直接输出；
1. 截取字符串（左闭右开） ?substring(start,end)
2. 首字母小写输出 ?uncap_first
3. 首字母大写输出 ?cap_first
4. 字母转小写输出 ?lower_case
5. 字母转大写输出 ?upper_case
6. 获取字符串长度 ?length
7. 是否以指定字符开头（boolean类型） ?starts_with("xx")?string
8. 是否以指定字符结尾（boolean类型） ?ends_with("xx")?string
9. 获取指定字符的索引 ?index_of("xx")
10. 去除字符串前后空格 ?trim
11. 替换指定字符串 ?replace("xx","xx")
-->
<#-- 直接输出 -->
${msg} - ${msg2} <br>
${msg?string} - ${msg2?string} <br>
<#-- 1. 截取字符串（左闭右开） ?substring(start,end) -->
${msg2?substring(1,4)} <br>
<#-- 2. 首字母小写输出 ?uncap_first -->
${msg?uncap_first} <br>
<#-- 3. 首字母大写输出 ?cap_first -->
${msg2?cap_first} <br>
<#-- 4. 字母转小写输出 ?lower_case -->
${msg?lower_case} <br>
<#-- 5. 字母转大写输出 ?upper_case -->
${msg?upper_case} <br>
<#-- 6. 获取字符串长度 ?length -->
${msg?length} <br>
<#-- 7. 是否以指定字符开头（boolean类型） ?starts_with("xx")?string -->
${msg?starts_with("H")?string} <br>
<#-- 8. 是否以指定字符结尾（boolean类型） ?ends_with("xx")?string -->
${msg?ends_with("h")?string} <br>
<#-- 9. 获取指定字符的索引 ?index_of("xxx") -->
${msg?index_of("e")} <br>
<#-- 10. 去除字符串前后空格 ?trim -->
${msg?trim?length} <br>
<#-- 11. 替换指定字符串 ?replace("xx","xxx") -->
${msg?replace("o","a")}<br>
```

***字符串空值情况处理***

>  FreeMarker 的变量必须赋值，否则就会抛出异常。而对于 FreeMarker 来说，null 值和不存在的变量是 完全一样的，因为 FreeMarker 无法理解 null 值。 FreeMarker 提供两个运算符来避免空值：
>
>  ① ! ：指定缺失变量的默认值 ${value!}：如果value值为空，则默认值是空字符串 ${value!"默认值"}：如果value值为空，则默认值是字符串"默认值" 
>
> ② ?? ：判断变量是否存在 如果变量存在，返回 true，否则返回 false ${(value??)?string}

```
<#-- 如果值不存在，直接输出会报错 -->
<#--${str}-->
<#-- 使用!，当值不存在时，默认显示空字符串 -->
${str!}<br>
<#-- 使用!"xx"，当值不存在时，默认显示指定字符串 -->
${str!"这是一个默认值"}<br>
<#-- 使用??，判断字符串是否为空；返回布尔类型。如果想要输出，需要将布尔类型转换成字符串 -->
${(str??)?string}<br>
```

### 集合（数组，列表，hash）

```
// 序列类型 （数组、List、Set）
// 数组操作
String[] stars = new String[]{"周杰伦","林俊杰","陈奕迅","五月天"};
request.setAttribute("stars",stars);
// List操作
List<String> citys = Arrays.asList("上海","北京","杭州","深圳");
request.setAttribute("cityList",citys);
// JavaBean集合
List<User> userList = new ArrayList<>();
userList.add(new User(1,"zhangsan",22));
userList.add(new User(2,"lisi",18));
userList.add(new User(3,"wangwu",20));
request.setAttribute("userList",userList);

// Map操作
Map<String,String> cityMap = new HashMap<>();
cityMap.put("sh","上海");
cityMap.put("bj","北京");
cityMap.put("sz","深圳");
request.setAttribute("cityMap",cityMap);
```



```
<#--
数据类型：序列类型 （数组、List、Set）
通过list指令输出序列
<#list 序列名 as 元素名>
${名称}
</#list>
获取序列的长度 ${序列名?size}
获取序列元素的下标 ${元素名?index}
获取第一个元素 ${序列名?first}
获取最后一个元素 ${序列名?last}
倒序输出 序列名?reverse
升序输出 序列名?sort
降序输出 序列名?sort?reverse
指定字段名排序 序列名?sort_by("字段名")
注：一般是JavaBean集合，对应的字段名需要提供get方法
-->
<#-- 数组操作 -->
<#list stars as star>
下标：${star?index} -- 名字：${star} <br>
</#list>
数组的长度：${stars?size} <br>
<#-- 获取第一个元素 -->
第一个元素：${stars?first} <br>
<#-- 获取最后一个元素 -->
最后一个元素：${stars?last} <br>
<hr>
<#-- List操作 -->
<#list cityList as city >
${city} <br>
</#list>
List的size：${cityList?size} <br>
<#-- 倒序输出 -->
<#list cityList?reverse as city >
${city} -
</#list>
<br>
<#-- 升序输出 -->
<#list cityList?sort as city >
${city} -
</#list>
<br>
<#-- 降序输出 -->
<#list cityList?sort?reverse as city >
${city} -
</#list>
<hr>
<#-- JavaBean集合 -->
<#list userList as user>
编号：${user.userId}&nbsp;&nbsp;
姓名：${user.uname}&nbsp;&nbsp;
年龄：${user.uage}&nbsp;&nbsp;
<br>
</#list>
<#-- 按照指定字段名排序 -->
<#list userList?sort_by("uage") as user>
${user.uname} |
</#list>


<#--
数据类型：hash类型
key遍历输出
<#list hash?keys as key>
${key} -- ${hash[key]}
</#list>
value遍历输出
<#list hash?values as value>
${value}
</#list>
-->
<#-- key遍历输出 -->
<#list cityMap?keys as key>
${key} -- ${cityMap[key]} <br>
</#list>
<#-- value遍历输出 -->
<#list cityMap?values as value>
${value} |
</#list>
```

## 常见指令

**使用 assign 指令你可以创建一个新的变量， 或者替换一个已经存在的变量。**

```
<#--
assign 自定义变量指令
语法：
<#assign 变量名=值>
<#assign 变量名=值 变量名=值> （定义多个变量）
-->
<#assign str="hello">
${str} <br>
<#assign num=1 names=["zhangsan","lisi","wangwu"] >
${num} -- ${names?join(",")}
```

**可以使用 if ， elseif 和 else 指令来条件判断是否满足某些条件。**

```
<#--
if, else, elseif 逻辑判断指令
格式：
<#if condition>
...
<#elseif condition2>
...
<#elseif condition3>
...
<#else>
...
</#if>
注：
1. condition, condition2等：将被计算成布尔值的表达式。
2. elseif 和 else 指令 是可选的。
-->
<#assign score = 80>
<#if score < 60>
你个小渣渣！
<#elseif score == 60>
分不在高，及格就行！
<#elseif score gt 60 && score lt 80>
哎哟不错哦！
<#else>
你很棒棒哦！
</#if>
<br>
<#-- 判断数据是否存在 -->
<#assign list="">
<#if list??>
数据存在
<#else>
数据不存在
</#if>
```

**可以使用 list 指令来对序列进行遍历**。

```
<#--
list指令
格式1：
<#list sequence as item>
</#list>
格式2：
<#list sequence as item>
<#else>
当没有选项时，执行else指令
</#list>
注：
1. else 部分是可选的
2. sequence： 想要迭代的项，可以是序列或集合的表达式
3. item： 循环变量 的名称
4. 当没有迭代项时，才使用 else 指令， 可以输出一些特殊的内容而不只是空在那里
-->
<#assign users = ["张三","李四","王五"]>
<#-- 遍历序列 -->
<#list users as user>
${user}
</#list>
<br>
<#--判断数据不为空，再执行遍历 （如果序列不存在，直接遍历会报错）-->
<#if users2??>
<#list users2 as user>
${user}
</#list>
</#if>
<br>
<#assign users3 = []>
<#-- 当序列没有数据项时，使用默认信息 -->
<#list users3 as user>
${user}
<#else>
当前没有数据！
</#list>

```

**可以使用 macro 指令来自定义一些自定义指令**

```
<#--字符串转get-->
<#macro get str>
   <#if str??>
       get${str?substring(0,1)?upper_case}${str?substring(1)}
       <#else >
          <h2>没有内容</h2>
   </#if>
</#macro>
<#--遍历-->
<#macro forEach items>
    <#if items??>
        <#list items as item>
            ${item}&nbsp;
        </#list>
        <#else >
        <h2>列表为空</h2>
    </#if>
</#macro>
<#macro chose val>
    <#switch val>
        <#case 1>1
        <#case 2>2
        <#case 3>3
        <#case 4>4
        <#case 5>5
        <#default >非1-5
    </#switch>
</#macro>

<@chose 2>



<#-- 定义基本的自定义指令 -->
<#macro address>
© 1999–2015 The FreeMarker Project. All rights reserved.
</#macro>
<#-- 使用指令 -->
<@address></@address> <br>
<@address></@address>
<hr>
<#-- 定义有参数的自定义指令 -->
<#macro queryUserByName uname>
通过用户名查询用户信息 - ${uname}
</#macro>
<#-- 使用指令，并传递参数 -->
<@queryUserByName uname="admin"></@queryUserByName> <br>
<#-- 定义有多个参数的自定义指令 -->
<#macro queryUserByParams uname uage>
通过多个餐宿查询用户信息 - ${uname} - ${uage}
</#macro>
<#-- 使用指令，并传递多个参数 -->
<@queryUserByParams uname="admin" uage=18></@queryUserByParams> <br>
<hr>
<#-- 自定义指令中包含内置指令 -->
<#macro cfb>
<#list 1..9 as i>
<#list 1..i as j>
${j}*${i}=${j*i}&nbsp;
</#list>
<br>
</#list>
</#macro>
<@cfb></@cfb>
<@cfb></@cfb>
<#-- 动态数据 -->
<#macro cfb2 num>
<#list 1..num as i>
<#list 1..i as j>
${j}*${i}=${j*i}&nbsp;
</#list>
<br>
</#list>
</#macro>
```

**import指令引入**

导入ftl文件

```
<#import "freemark/function.ftl" as fun>
<#assign list=["qw","as","po"]>
<@fun.get "name"></@fun.get>
<@fun.forEach list></@fun.forEach>
<@fun.chose 7></@fun.chose>
```

**include静态引入**

```
<#include"freemark/function.ftl">
```

## 生成静态页面

模板页面

```
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style type="text/css">
        p{
            text-indent: 2em;
            text-align: justify;
        }
    </style>
</head>
<body>
<h1>${title}</h1>
<div>
    <div style="float: left">
       价格： ${price}&nbsp;销量：${sell}
    </div>
    <div style="float: right">
        发货地： ${city}
    </div>
</div>
<div>
   <p>
       ${content}
   </p>
    <p>
        ${shenming}
    </p>
    <img src="${url}" width="60%"/>
</div>
</body>
</html>
```

servlet

```
@WebServlet("/sell")
public class SellPageGet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //freemark配置类
        Configuration configuration=new Configuration();
      //模板文件根路径和上下文路径  configuration.setServletContextForTemplateLoading(getServletContext(), "/template");
      //编码
        configuration.setDefaultEncoding("utf-8");
        //获取通过配置类，传入模板文件名获得模板引擎
        Template template=configuration.getTemplate("taobao.ftl");
        //封装Map数据，key要与模板文件的el取值{}里的值对应（相同）
        Map<String,Object> map=new HashMap<>();
        map.put("title", "杞里香枸杞子宁夏特级500g正宗免洗大颗粒纪构杞茶男肾红苟杞黑干");
        map.put("price", 99);
        map.put("sell", 888);
        map.put("city", "杭州");
        map.put("content","年到中年不得已，保温杯里泡枸杞。");
        map.put("shenming", "产品参数：\n" +
                "\n" +
                "生产许可证编号：SC11464010500015产品标准号：GB/T18672厂名：宁夏果果老爹食品有限公司厂址：宁夏银川市西夏区平吉堡奶牛场粮油加工厂院内厂家联系方式：400-870-0951配料表：宁夏枸杞储藏方法：请置于阴凉干燥处保质期：365 天食品添加剂：无品牌: 杞里香系列: 五星枸杞规格: 250g*2产地: 中国大陆省份: 宁夏回族自治区城市: 银川市净含量: 500g包装方式: 包装特产品类: 宁夏枸杞适用对象: 全部适用滋补品大小: 特级370粒/50g成分原料: 枸杞子 ");
        map.put("url", "https://detail.tmall.com/item.htm?spm=a220o.1000855.0.0.3f5a4bd6uHewB7&id=6956495372");
        //获取生成静态文件名，确定很难重复的
        String fileName=System.currentTimeMillis()+".html";
        //获取静态文件字符输出流
        FileWriter writer=new FileWriter(new File(getServletContext().getRealPath("/")+"/staticPage/"+fileName));
        //设置servlet返回为html
        resp.setContentType("text/html;charset=utf-8");
        try {
        //生成静态html
            template.process(map, writer);
            resp.sendRedirect("staticPage/"+fileName);
        } catch (TemplateException e) {
            PrintWriter writer1 = resp.getWriter();
            writer1.write("生成失败");
            writer1.flush();
            writer1.close();
        }finally {
            writer.close();
        }
    }
}
```


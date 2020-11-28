# javascript

> JS需要和HTML⼀起使⽤才有效果，我们可以通过直接或间接的⽅式将JS代码嵌⼊在HTML⻚⾯中。
>
>  ⾏内JS : 写在标签内部的js代码
>
> ```
> <button onclick="alert('you clicked hered!!!')">click here</button> 
> ```
>
>  内部JS : 定义在script标签内部的js代码
>
> ```
> 
> 
> <script type="text/javascript" charset="utf-8">
> 
>  alert('this is inner js code')
> 
> </script>
> 
> alert('this is a outter js document');
> ```
>
>  外部JS : 单独的js⽂件，在HTML中通过script标签引⼊
>
> ```
> <script src="js/hello.js" type="text/javascript" charset="utf-8"></script>
> ```
>
> 我们可以将JavaScript代码放在html⽂件中任何位置，但是我们⼀般放在⽹⻚的head或者body部分。由于⻚⾯的加载⽅式是从上往下依次加载的，⽽这个对我们放置的js代码运⾏是有影响的。
>
> 放在部分，最常⽤的⽅式是在⻚⾯中head部分放置元素，浏览器解析head部分就会执⾏这个代码，然后才解析⻚⾯的其余部分。



## 注释

> JavaScript程序的执⾏单位为⾏（line），也就是⼀⾏⼀⾏地执⾏。⼀般情况下，每⼀⾏就是⼀个语句。语句（statement）是为了完成某种任务⽽进⾏的操作，语句以分号结尾，⼀个分号即表示⼀个语句结束。多个语句可以写在⼀⾏内（不建议这么写代码），但是⼀⾏写多条语句时，语句必须以分号结尾。
>
> 表达式不需要分号结尾。⼀旦在表达式后⾯添加分号，则JavaScript引擎就将表达式视为语句，这样会产⽣⼀些没有任何意义的语句。

## 标识符和关键字

标识符就是⼀个名字，⽤来给变量和函数进⾏命名，有特定规则和规范。

关键字也称保留字，是被JavaScript征⽤来有特殊含义的单词。

## 变量

变量即⼀个带名字的⽤来存储数据的内存空间，数据可以存储到变量中，也可以从变量中取出数据。

变量的声明JavaScript是⼀种弱类型语⾔，在声明变量时不需要指明数据类型，直接⽤var修饰符进⾏声明。

变量声明和赋值：

单⾏注释：⽤//起头；

多⾏注释：放在/* 和 */之间。

兼容html注释⽅式：<!-- -->

由Unicode字⺟、_、$、数字组成、中⽂组成

（1）不能以数字开头

（2）不能是关键字和保留字

（3）严格区分⼤⼩写

（1）⻅名知意

（2）驼峰命名或下划线规则

> arguments、break、case、catch、class、const、continue、debugger、default、delete、do、
>
> else、enum、eval、export、extends、false、finally、for、function、if、implements、import、
>
> in、instanceof、interface、let、new、null、package、private、protected、public、return、
>
> static、super、switch、this、throw、true、try、typeof、var、void、while、with、yield、
>
> Infinity、NaN、undefined

## 基本语法

JS是一门弱类型的语言，变量是没有类型。数据本身是有类型的

变量、标识符、关键字、数据类型

```js
var 变量名 ;   // undefined
var 变量名 = 数据;
```

`var` 定义变量|声明变量的关键字

变量的特点：

> ​	1、没给值的变量 可以用，只是现在是默认值undefined
>
> ​	2、重复声明一个变量
>
> ​	4、js中可以不使用var关键字声明（定义）变量。变量会变成全局变量；不会发生变量提升
>
> ​	3、变量存在变量提升 （可以先使用，再定义）， 在赋值之前 使用的时候值为默认值
>

## 数据类型

> typeof()查看数据的类型
>
> 简单类型： 
>
> number:  5, 100.3,   NaN(不是一个数字),   Infinity (无穷)
>
> undefined: 只有一个值 undefined（只有声明，没有赋值的变量， 手动给，方法有形参没有实参， 方法没有返回值）
>
> null:  只有一个值 null, 手动给 null . 描述符`object`。说明undefined和null本来就是同一个祖宗下来的。表示的含义其实是类似的， `==` true
>
> boolean: true, false
>
> string:  `""`   `''`  "bc", 'efg'
>



## 数据类型转换

> 自动类型转换：系统转的，我们不需要干预，只需要看规则即可
>
> 手动转换：
>
> string->number
>
> parseInt(), parseFloat()
>
> 对于每一个简单类型都有一个类似构造器那样的方法，将类型描述符首字母大写
>
> 当我们要创建（转换）某个类型的数据的时候，可以使用类型描述首字母大写的这个函数
>
> Number("123abc")  -> 整体   NaN
>
> parseInt("123abc") ->  部分   123
>
> toString:转化字符串，但是null和undefine不能用此方法

## 运算符

算数运算符： +, -, *, / , %, ++, --

++,-- 只能操作变量

赋值和扩展运算符： = ， +=， -=， *=， /=， %=

> 在变量原来值的基础上，进行一些算数运算后，结果再赋值给自己
>

比较运算符：`==`（等于：比较值）, `===` （全等：类型值相等）：

> ```
> var a;//值undefined
> var b=null;
> ```
>
> a==b:相等
>
> a===b:不相等，类型不等，类型有派生关系



逻辑运算：

> &&  -> 只要存在false 结果就为false
>
> ||  ->  只要存在true  ,结果就为true
>
> ! -> true变false   false变true
>
> &->二进制与运算，全1为1
>
> ^->异或，不同为1



## 流程控制语句

控制流程走向的特殊语法

> 顺序：自然走向，不需要人为干预（没有特殊语法）
>
> 选择：在众多分支中最多选择其中一种，走下去（if, if-else, if-else if ）
>
> 循环：重复执行一些相同类似的操作（for）
>



### 选择

if 选择： 单项选， 只考虑一种情况

```js
if(条件表达式){
    
}
```



if-else 选择： 双向选择， 考虑两种情况

```js
if(条件表达式){
    
}else{
    
}
```



if-else if 选择： 多项选择，考虑很多种情况， 最多在其中选择一种

```js
if(条件表达式1){
    
}else if(条件表达式2){
    
}else if(条件表达式3){
    
}....else{
    
}
```



### for循环 

> 循环|重复， 重复做一些相同或者类似的事情
>
> ```js
> for(初始表达式; 条件表达式; 迭代因子){
>     循环体;
> }
> ```
>
> 1、初始表达式
>
> 2、条件表达式
>
> 3、如果条件表达式为 true, 执行循环体; 如果条件表达式为false 直接结束整个for循环
>
> 4、迭代因子
>
> 5、重复第2



### 变量的作用域

变量的作用范围，js中，单纯的语句块是不形成作用域的。方法是形成作用域的



### break

break这个关键字，用在循环体中，结束（跳过|终止）本层循环



### continue

continue这个关键字，用在循环体中，结束本层的本次循环，继续下一次循环

## 函数

> 函数有的语言也叫方法， 可以完成特定功能的一个代码块， 名字， 参数， `function`
>
> 语法：定义函数，创建一块具有特定功能的代码块
>
> ```js
> function 函数名(){
>     步骤;
> }
> //或
> var funb=function(){
>     方法体S
> }
> ```
>
> 函数定义好了之后，并不会立刻执行。 需要使用（调用）函数，函数才能执行
>
> ```js
> 函数名();
> ```
>
> 函数可以带参数
>
> 定义： 形式参数  （形参）
>
> 调用：实际参数（实参）
>



## 数组

变量：一个带名字的空间， 同一时刻只可以存储一个数据

数组：一个带名字的连续的空间，在这个空间中可以存储多个数据，每一个数据所在的小空间都有自己的编号 ，编号0开始，整数，依次递增1，每一个数据都叫数组的元素

### 定义数组

```js
var 数组名 = [元素1,元素2,元素3];
var ages = [1,2,43,5];
```

```js
var 数组名 = new Array(元素1,元素2,元素3);
```

```js
var 数组名 = new Array(数组的长度);
```



对数组元素的操作：

> 存|改：   数组名[下标] = 数据;
>
> 取： 数组名[下标]
>
> 超过索引取值：取值未定义：undifined；
>
> 超过索引赋值：自动扩容；

### 数组的长度  length

js中的数组， 大小并不固定，长度在合理范围内可以随意更改



### 弱类型

js数组中可以存任意类型的元素

### 函数

> push 添加元素到最后
>
> unshift 添加元素到最前
>
> pop 删除最后⼀项
>
> shift 删除第⼀项
>
> reverse 数组翻转
>
> join 数组转成字符串
>
> indexOf 数组元素索引
>
> slice 截取（切⽚）数组，原数组不发⽣变化
>
> splice 剪接数组，原数组变化，可以实现前后删除效果
>
> concat 数组合并

```
var arr = ['1','a',5,'3'];
console.log(arr);
arr.push(10);
console.log(arr);
arr.unshift('b');
console.log(arr);
arr.pop();
console.log(arr);
arr.shift();
console.log(arr);
arr.reverse();
console.log(arr);
console.log(arr.join('\''));
console.log(arr);
console.log(arr.indexOf('a'));
console.log(arr.slice(2,5));
console.log(arr);
arr.splice(1,1,'⼀','⼆');
console.log(arr);
var arr1 = [0,'100'];
console.log(arr.concat(arr1));
console.log(arr);
console.log(arr1);
console.log(arr1.(arr));
```

## 内置对象

> Arguments 只在函数内部定义，保存了函数的实参
>
> Array 数组对象
>
> Date ⽇期对象，⽤来创建和获取⽇期
>
> Math 数学对象
>
> String 字符串对象，提供对字符串的⼀系列操作

Arguments 只在函数内部定义，保存了函数的实参

Array 数组对象

String 字符串对象，提供对字符串的⼀系列操作

> ◦ charAt(idx) 返回指定位置处的字符
>
> ◦ indexOf(Chr) 返回指定⼦字符串的位置，从左到右。找不到返回-1 
>
> ◦ substr(m,n) 返回给定字符串中从m位置开始，取n个字符，如果参数n省略，则意味着取到字符串末尾。
>
> ◦ substring(m,n) 返回给定字符串中从m位置开始，到n位置结束，如果参数n省略，则意味着取到字符串末
>
> 尾。
>
> ◦ toLowerCase() 将字符串中的字符全部转化成⼩写。
>
> ◦ toUpperCase() 将字符串中的字符全部转化成⼤写。
>
> ◦ length 属性，不是⽅法，返回字符串的⻓度。

Math 数学对象

> ◦ Math.random() 随机数
>
> ◦ Math.ceil() 向上取整，⼤于最⼤整数
>
> ◦ Math.floor() 向⼩取整，⼩于最⼩整数String

Date ⽇期对象，⽤来创建和获取⽇期

> // 获取⽇期
>
> ◦ getFullYear() 年 
>
> ◦ getMonth() ⽉ 
>
> ◦ getDate() ⽇说明：
>
> 1. getMonth()：得到的值：0~11（1⽉~12⽉）
>
> 2. setMonth()：设置值时0~11
>
> 3. toLocaleString()：可根据本地时间把 Date 对象转换为字符串，并返回结果。

## 对象

> var ob=new Object()创建对象，用ob.属性名=值，添加对象属性值。
>
> var oc={key: value,key:value};

```
var on={
				name : "qwe",
				fun: function(){
					a=123;
					console.log("asd");
				}
			};
			on.fun();
			console.log(on.name);
			var obj=new Object();
			obj.name="123";
			obj.info="qewr";
			console.log(obj);
```

对象序列化和反序列化：

> 和java序列化（对象存入文件，传输，再取出对象）相似，它是将对象变为json字符串（不用变也可以，对象存在形式也是以json字符串形式），从json字符串变为对象







​	
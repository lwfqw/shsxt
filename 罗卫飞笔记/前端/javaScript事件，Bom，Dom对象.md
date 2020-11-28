@[TOC](javaScript修改html和css样式)

# 内容

![你好！ 这是你第一次使用 **Markdown编辑器** 所展示的欢迎页。如果你想学习如何使用Markdown编辑器, 可以仔细阅读这篇文章，了解一下Markdown的基本语法知识。](https://img-blog.csdnimg.cn/20201112204349973.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x3ZjA2MTU=,size_16,color_FFFFFF,t_70#pic_center)


# 事件


> 事件 (Event) 是 JavaScript 应⽤跳动的⼼脏 ，进⾏交互，使⽹⻚动起来。当我们与浏览器中 Web ⻚⾯
> 进⾏某些类型的交互时，事件就发⽣了。事件可能是⽤户在某些内容上的点击、⿏标经过某个特定元素 或按下键盘上的某些按键。事件还可能是 Web
> 浏览器中发⽣的事情，⽐如说某个 Web ⻚⾯加载完成， 或者是⽤户滚动窗⼝或改变窗⼝⼤⼩。

## 常用事件

> ⼏个常⽤的事件：  onclick 、onblur 、onfocus 、onload 、onchange 
> onmouseover、onmouseout、onkeyup、onkeydown

```
onload：当⻚⾯或图像加载完后⽴即触发
onblur：元素失去焦点
onfocus：元素获得焦点
onclick：⿏标点击某个对象
onchange：⽤户改变域的内容
onmouseover：⿏标移动到某个元素上
onmouseout：⿏标从某个元素上离开
onkeyup：某个键盘的键被松开
onkeydown：某个键盘的键被按下
```

## 事件绑定

> 1. 行内式：`<button type="button" onclick="alert()">提交</button>`
> 2. 内联式：在script标签内写事件，使用标签内的事件绑定
> `<script type="text/javascript">
		function showpwd(){
			document.getElementById("pwd").type="text";
		}
		function namecheck(){
			//location.reload();
			var cur=document.getElementById("name");
			var val=cur.value;
			if(val.length<=6){
				cur.nextSibling.innerText="用户名长度不够";
				return 0;
			}
			for(var one in val){
				console.log(one);
				if(val.charAt(one)=='$'||val.charAt(one)=='#'){
					cur.nextSibling.innerText="特殊字符";
					return 0;
				}
			}
			//location.reload();
			cur.nextSibling.innerText="";
			return 1;
		}
		function pwdcheck(){
			var cur=document.getElementById("pwd");
				var val=cur.value;
				if(val.length<=9){
					cur.nextSibling.innerText="密码长度不够";
					return 0;
				}
				cur.nextSibling.innerText="";
				return 1;
		}
		function hobbycheck(){
			var items=document.getElementsByName("hobby");
			var len=0;
			for(var i=0;i<items.length;i++){
				if(items[i].checked){
					len++;
				}
			}
			if(len==0){
				document.getElementById("hb").innerText="请至少选择一项";
				return 0;
			}else{
				document.getElementById("hb").innerText="";
				return len;
			}
		}
		function sexcheck(){
			var items=document.getElementsByName("sex");
			var len=0;
			for(var i=0;i<items.length;i++){
				if(items[i].checked){
					len++;
				}
			}
			if(len==0){
				document.getElementById("hb").innerText="请至少选择一项";
				return 0;
			}else{
				document.getElementById("hb").innerText="";
				return len;
			}
		}
		function submitcheck(){
			if(namecheck()!=0&&pwdcheck()!=0){
				if(hobbycheck()==0){
					alert("请选择至少一项");
					return;
				}
				if(sexcheck()==0){
					alert("性别不能为空");
					return;
				}
				alert("验证成功");
			}else{
				alert("用户名密码请规范");
			}
		}
	</script>`
	

```
<label for="pwd">密码（大于9位）</label><input type="password" id="pwd" name="pwd" onblur="pwdcheck()"><span style="background-color: #FF0000;"></span><br />
```
> 3.引入式：外部引入js文件，事件绑定外部方法
# bom对象
> BOM的核⼼对象是window，它表示浏览器的⼀个实例。window对象有双重⻆⾊，它既是通过
JavaScript访问浏览器窗⼝的⼀个接⼝，⼜是ECMAScript规定的Global对象。这意味着在⽹⻚中定义的任
何⼀个对象、变量和函数，都以window作为其Global对象，因此有权访问parseInt()等⽅法。如果⻚⾯中
包含框架，则每个框架都拥有⾃⼰的window对象，并且保存在frames集合中。在frames集合中，可以通
过数值索引（从0开始，从左⾄右，从上到下）或者框架的名称来访问相应的window对象。

## windows对象
###  系统对话框
> （1）消息框:alert， 常⽤。
 alert() ⽅法⽤于显示带有⼀条指定消息和⼀个 OK 按钮的警告框。
（2）输⼊框:prompt，返回提示框中的值。
 prompt() ⽅法⽤于显示可提示⽤户进⾏输⼊的对话框。
 参数（可选）：
 第⼀个参数：要在对话框中显示的纯⽂本。
 第⼆个参数：默认的输⼊⽂本。
（3）确认框:confirm，返回 true/false.
confirm() ⽅法⽤于显示⼀个带有指定消息和 OK 及取消按钮的对话框
### 窗口
 **打开**：

```
<script type="text/javascript">
function openBaidu(){
 window.open('http://www.baidu.com','_self'); // _self、_blank等
 // window.open(); //空⽩窗⼝
}
</script> <input type="button" name="open" value="百度" onclick='openBaidu();' />
```
**关闭**

```
<input type="button" value="关闭窗⼝" onclick="window.close();" />
```
## location
> location 对象是window对象之⼀，提供了与当前窗⼝中加载的⽂档有关的信息，还提供了⼀些导航功
能。也可通过 window.location 属性来访问。
location 对象的属性 href：设置或返回完整的 URL
location 对象的⽅法
reload()：重新加载当前⽂档。
replace()：⽤新的⽂档替换当前⽂档。

```
<script type="text/javascript">
 function openBaidu(){
 // 没有历史记录,⽤新的⽂档替换当前⽂档
 // window.location.replace("http://www.baidu.com");
 // console.log(window.location.href); // 获取完整的url
 window.location.href = "http://www.baidu.com";
 }
</script> <body>
 <input type="text" value="" />
 <input type="button" value="刷新" onclick="window.location.reload();" />
 <input type="button" value="百度" onclick="openBaidu();" />
</body
```
# dom对象
> **DOM：Document Object Model ⽂档对象模型**
要实现⻚⾯的动态交互效果，bom 操作远远不够，需要操作 html 才是核⼼。如何操作 html，就是
DOM。简单的说，dom 提供了⽤程序动态控制 html 接⼝。DOM即⽂档对象模型描绘了⼀个层次化的节
点树，运⾏开发⼈员添加、移除和修改⻚⾯的某⼀部分。dom 处于javascript 的核⼼地位上。
每个载⼊浏览器的 HTML ⽂档都会成为 Document 对象。Document 对象使我们可以从脚本中对 HTML
⻚⾯中的所有元素进⾏访问。Document 对象是 Window 对象的⼀部分，可通过 window.document 属性
对其进⾏访问。

### 获取节点（标签）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112210921982.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x3ZjA2MTU=,size_16,color_FFFFFF,t_70#pic_center)### 创建节点
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112211032387.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x3ZjA2MTU=,size_16,color_FFFFFF,t_70#pic_center)### 插⼊节点
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020111221112382.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x3ZjA2MTU=,size_16,color_FFFFFF,t_70#pic_center)
### 查找,删除节点
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112211251718.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x3ZjA2MTU=,size_16,color_FFFFFF,t_70#pic_center)  ![在这里插入图片描述](https://img-blog.csdnimg.cn/2020111221143754.png#pic_center)

### 获取表单
> 1、document.表单名称
2、document.getElementById(表单 id);
3、document.forms[表单名称] 4、document.forms[索引]; //从 0 开始

#### 获取表单元素
> 1)、通过 id 获取：document.getElementById(元素 id);
2)、通过 form.名称形式获取: myform.元素名称; name属性值
3)、通过 name 获取 :document.getElementsByName(name属性值)[索引] // 从0开始
4)、通过 tagName 数组 :document.getElementsByTagName('input')[索引] // 从0开始

```
<body>
 <form id='myform' name="myform" action="" method="get"> 
 姓名:<input type="text" id="uname" name="uname" value="zs"/><br />
 密码:<input type="password" id="upwd" name="upwd" value="1234"/><br />
 <input type="hidden" id="uno" name="uno" value="隐藏域" />
 个⼈说明:<textarea name="intro"></textarea>
 <button type="button" onclick="getTxt();" >获取元素内容</button>
 </form>
</body> <script>
 function getTxt(){
 var uno = document.getElementById("uno");
 var uname = myform.uname;
 console.log(uname + "--------");
 var upwd = document.getElementsByTagName('input')[1] ;
 var intro = document.getElementsByName("intro")[0]; 
 console.log(uno.value +"，"+ uname.value +"，"+ upwd.value +"，"+ intro.value);
 }
</script>
```
#### 单选框以及，文本，密码等框
> document.getElementsByName("name属性值").value

#### 复选框
> 已选择的框的checked属性是checked 

```
var ufav = document.getElementsByName("ufav");
var favstr = "";
 for (i = 0;i < ufav.length; i++){
 if(ufav[i].checked){
 favstr += ufav[i].value+",";
 }
 }
favstr = favstr.substr(0,favstr.length-1);
```

#### 下拉列表
 

> （1）获取 select 对象： （2）获取选中项的索引： （3）获取选中项 options 的
> value属性值：注意：当通过options获取选中项的value属性值时，
> 若没有value属性，则取option标签的内容若存在value属性，则取value属性的值 （4）获取选中项 options 的
> text：选中状态设定：selected='selected'selected=true、selected未选中状态设定：不设selected属性

```
<body onload="init()">
 <form id='myform' name="myform" action="" method=""> 
 来⾃:
 <select id="ufrom" name="ufrom">
 <option value="-1" >请选择</option>
 <option value="0" selected="selected">北京</option>
 <option value="1">上海</option>
 </select><br />
 <button type="button" id="sub" name="sub">提交</button>
 </form>
</body> <script>
 function init () {
 var sub = document.getElementById("sub");
 sub.onclick = function () {
 //获取select对象
 var ufrom = document.getElementById("ufrom");
 console.log("表单对象：" + ufrom);
 //获取选中的索引
 var idx = ufrom.selectedIndex;
 console.log("选中项的索引值：" + idx);
 //获取选中项的value值
 var val = ufrom.options[idx].value;
 console.log("选中项的value属性值：" + val);
 //获取选中项的text
 var txt = ufrom.options[idx].text;
 console.log("选中项的text：" + txt);
 }
 }
</script>
```
#### 表单提交
> （1）使⽤普通button按钮+onclick事件+事件中编写代码:
 获取表单.submit();
（2）使⽤submit按钮 + onclick="return 函数()" +函数编写代码:
 最后必须返回：return true|false;
（3）使⽤submit按钮/图⽚提交按钮 + 表单onsubmit="return 函数();" +函数编写代码:
 最后必须返回：return true|false;

```
<form id='myform1' name="myform2" action="#" method="get" onsubmit="return onsub();">
 <input name="test" id="uname"/><span id="msg"></span><br />
 <!--通过js事件：sub()提交表单-->
 <input type="button" onclick="sub();" value="提交表单1" />
 <input type="submit" onclick="return sub2();" value="提交表单2" />
 <input type="submit" value="提交onsubmit" /><br />
 <input type="image" src="img/u=71331624,2965806045&fm=23&gp=0.jpg"
 width="60px" height="40px" />
</form> <script type="text/javascript"> 
 // input的type=button，调⽤submit()⽅法提交
 function sub(){
 document.myform2.submit();
 }
 // 进⾏校验，返回值为true才能提交
 function sub2(){
 var uname = document.getElementById("uname");
 var val = uname.value;
 if(val.length>0){
 return true; // 提交
 }
 document.getElementById("msg").innerHTML = "不能空着啊！！！";
 document.getElementById("msg").style.color="red";
 return false; // 不提交
 }
 // onsubmit事件提交
 function onsub () {
 var uname = document.getElementById("uname");
 var val = uname.value;
 if(val.length>0){
 return true; // 提交
 }
 document.getElementById("msg").innerHTML = "填写点⼉东⻄呗！(ˉ▽￣～) 切~~";
 document.getElementById("msg").style.color="red";
 return false; // 不提交
 }
</script>
```


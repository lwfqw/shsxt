# oracle

## 简述



数据库(Database)是按照数据结构来组织、存储和管理数

据的 仓库 ；随着信息技术和市场的发展，数据管理不再

仅仅是存储和管理数据，而转变成用户所需要的各种数

据管理的方式。数据库有很多种类型，从最简单的存储

有各种数据的 表格 到能够进行海量数据存储的 大型数据 

库系统 都在各个方面得到了广泛的应用。

**数据库**现在已经成为**数据管理的重要技术**，也是计算机

的重要分支。由于数据库具有数据结构化，最低冗余

度、较高的程序与数据独立性，易于扩展、易于编制应

用程序等优点，较大的信息系统都是建立在数据库设计

之上的。数据库的运用从一般管理扩大到计算机辅助技

术、人工智能以及科技计算等领域。

| 分类 | 产品             | 特点                  |
| ---- | ---------------- | --------------------- |
| 小型 | access           | 100以下连接           |
| 中型 | sqlserver，mysql | 10000以内连接，小成本 |
| 大型 | oracle，db2      | 海量连接              |

## 数据库三大范式
1. 第一范式
> 列不可分割
2. 第二范式
> 非主属性依赖主码
3. 第三范式
> 主属性不依赖其他属性
> 3.总结：
> 1NF-->列不
> 可再分最小原子 （避免重复);2NF-->主键依赖(确定唯
> 一)；3NF-->消除传递依赖(建立主外键关联 拆分表)

## 与mysql区别

<div align="left" >
    mysql 表是面向数据库的：表属于属于数据库   数据库名.表名<br>
    oracle 表是面向用户的：表属于用户          用户名.表名
</div>

### 查看表

```sql
--oracle查看当前用户下的所有表名
select TABLE_NAME from tabs；
#mysql
show tables;
```

### 查看表字段(相同)

```
--oracle
desc table_name;

#mysql
desc table_name;
```

### 连接命令

```
--oracle:
conn sys as sysdba|nomal
#mysql:
mysql -uroot -p
```

## sql语言

| 分类 | 命令                                                         |
| :--- | ------------------------------------------------------------ |
| DDL  | create：创建；drop：删除；alter：修改；rename: 重命名; truncate：截断 |
| DML  | insert：插入；delete：删除；update：更新；select :查询;      |
| DCL  | grant：授权；revoke：回收权利；commit:提交；rollback：回滚； |

## 关键字和方法

### 连接

#### 内连接

> 1. 笛卡尔积：全连接，总列数等于左列数*右列数
> 2. 等值连接：在笛卡尔积基础上 取条件列相同的值
> 3. **非等值连接** > < != <>between and
> 4. **自连接**: **特殊的等值连接** (**来自于同一张** **表**)
> 5. 

#### 外连接

> ```
> --找出 所有的员工姓名 及上级名称
> --找出 所有部门的员工数 及部门名称 select dname, nu
> from dept d, (select count(1) nu, deptno
> from emp group by deptno) e where d.deptno(+) = e.deptno;
> ```
>
> 看逗号, 主表在,的左边就叫左外连接主表在,的右边叫
>
> 右连接

#### join连接

>  
>
> **交叉连接**
>
> ```
> 
> --找出 所有的员工姓名 及上级名称
> --找出 所有部门的员工数 及部门名称 select dname, nu
> from dept d, (select count(1) nu, deptno
> from emp group by deptno) e where d.deptno(+) = e.deptno; select * from emp cross join dept;
> ```
>
> **自然连接**
>
> 自动做等值连接
>
> ```
> select * from emp natural join dept;
> --在指定列过程中同名列归共同所有(*除外) select deptno,e.ename,d.dname from emp e natural join dept d;
> ```
>
> using **连接**
>
> 指定同名字段做等值连接
>
> ```
> select deptno,e.ename,d.dname from emp e join dept d using(deptno);
> ```
>
> on **连接**
>
> ```
> -- natrual 等值 
> select ename, dname from emp natural join dept where deptno = 30;
> --using 
> select ename, dname from emp join dept using (deptno) where deptno = 30;
> --on 
> select ename, dname
> from emp join dept on emp.deptno = dept.deptno where emp.deptno = 30;
> --on 非等值连接 、自连接
> --部门编号为30的员工名称 工资等级 
> select ename, grade
> from emp e join salgrade s on e.sal between s.losal and s.hisal where deptno = 30;
> --部门编号为30的员工名称 上级名称 
> select e.ename, m.ename mname
> from emp e join emp m on e.mgr = m.empno where e.deptno = 30;
> --部门编号为30的员工 员工名称 部门名称 工资等级 上级名 称select e.ename, dname, grade, m.ename mname
> from emp e
> -- 外连接 
> join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal join emp m on e.mgr = m.empno where e.deptno = 30;
> ```
>
> **全连接**
>
> ```
> select *
>      from (select 1 no, 'a' "name"
>          from dual union select 2 no, 'b' "name"from dual) a
>            full join (select 1 no, 'c' "name"
>      from dual union select 3 no, 'd' "name"
>            from dual) b on a.no = b.no; select *
>            from (select 1 no, 'a' "name"
>             from dual union select 2 no, 'b' "name"
>               from dual) a
>                   full join (select 1 no, 'c' "name"
>                    from dual union select 3 no, 'd' "name"
>                       from dual) b using (no);
> ```
>
> 

* ### like模糊查询：**%**匹配任意个任意字符，**_**匹配任意一个字符

  > "%A%":匹配含有A的字符串
  >
  > "_A%":匹配第二个为A的字符串
  >
  > ,,,,,,,

* ### 集合操作：

  > ```
  > --union 并集    union all 并集不去重
  > --intersect 交集
  > --
  > select * from emp where sal>2000
  > intersect 
  > select * from emp where sal<4000;
  > ```

* ### 范围运算

  > !=:不等于
  >
  > <>:不等于
  >
  > <=:
  >
  > \>=:
  >
  > =:
  >
  > between 下界 and 上界

* ### 逻辑运算

  >and：
  >
  >or：
  >
  >not：

* ### 简单查询

```
--DQL语句
--select查询语句
--select *|字段1,字段2... from 数据源;

--检索|查询 某个来源中的所有的数据
-- select * from 数据源;

--查询所有的员工信息
--查询的数据: * 所有的员工信息
--数据的来源: 员工表 emp
--条件:
select * from emp;
select * from dept;

--select 字段1,字段2... from 数据源;
--所有的员工姓名
--查询的数据: 员工姓名
--数据的来源: emp
select ename from emp;

--查询公司的所有部门编号
--查询的数据: 部门编号  deptno
--数据的来源: dept,emp
select deptno from dept;
select deptno from emp;

--去重 distinct   结果集中的多条数据完全相同(所有查询的结果中字段的值),才能去重
--有员工存在的部门的部门编号
select distinct deptno from emp;

--查询所有员工的姓名以及所在的部门编号
select distinct ename,deptno from emp;

--select 后面可以查询表达式 
--表达式的内容作为结果集中字段名字 ,表达式结果作为字段值
select distinct 123+456 from emp;
select distinct 123*456 from dept;

--伪列 :不是真实在表结构中存在的字段,但是允许查询,称他们为伪列
select 1 from emp;

--别名 注意:如果别名中存在小写字符或特殊符号,空格等,需要使用""
--给查询的字段起别名 select 字段1 (as) 别名1,字段2 别名2...from 数据源;
select distinct 123+456 和 from emp;
--"" 原封不动使用|显示
select distinct 123+456 "getSum" from emp;
select distinct 123+456 as "123+456的和",123*456 "123*456的积" from emp;

--给表起别名 select 字段1 别名1,字段2 别名2...from 表名 别名;,给表起别名不能使用as
select * from emp  "e";

--select 后可以查询字符串 ''表示字符串
--字符串伪列存在
select 'abc' "abc" from emp;

--字符串拼接 ||
--员工的名称前拼接一个sxt
select 'SXT-'||ename "员工名称" from emp;

--所有员工的员工姓名,员工薪资,员工奖金
select ename,sal,comm from emp;

--给所有的员工原有的奖金基础上多加1块钱
--null值和数字运算结果还是null
select ename,sal,comm "原奖金",comm+1 "新奖金" from emp;

--null值和字符串运算结果还是原串
select ename,sal,comm "原奖金",comm||'1' "新奖金" from emp;

--处理null值的 函数nvl(字段,值2) 如果字段的值为null,结果值2,如果字段的值不为null,结果还是这个字段的值
select nvl(comm,0)+1  from emp;
select ename,sal,comm "原奖金",nvl(comm,0)+1 "新奖金" from emp;

--虚表: 不是真实存在的表,没有数据,没有字段  dual
select * from dual;
--查询当前的日期  sysdate
select distinct sysdate from emp;
select sysdate from dual;
```

### 条件查询

```
--条件查询 select 数据 from 数据源 where 行过滤条件;
--执行流程: from-- where--select

-- = > < >= <= != <>

-- 查询20部门的员工信息
select * from emp where deptno = 20;

-- 查询工资大于1000的员工的姓名 工作岗位  工资   所属部门编号
--查询的数据: ename , job , sal , deptno
--数据来源: emp
--条件: sal > 1000
select ename , job , sal , deptno from emp where sal > 1000;

-- 查询不在20部门工作的员工信息
select * from emp where deptno != 20;
select * from emp where deptno <> 20;

-- 查询员工的年薪大于20000的 员工名称、岗位 年薪
--求出所有员工的年薪,员工名称,岗位
select ename,job,(sal+nvl(comm,0))*12 sum from emp;

select * from (select ename,job,(sal+nvl(comm,0))*12 sum from emp) where sum>20000;

select ename,job,(sal+nvl(comm,0))*12 sum from emp where (sal+nvl(comm,0))*12>20000;


-- 假设现在 900,1000,1100
-- some(值1,值2..) any(值1,值2..) all(值1,值2..)
-- 查询工资比我们三个人都高的那些员工的信息
select * from emp where sal > all(900,1000,1100);

-- 查询比我们中随便一个工资高的员工信息
select * from emp where sal > some(900,1000,1100);

-- 查询 工种为’SALESMAN’的员工信息 （注意 内容区分大小写）
select * from emp where job = 'SALESMAN';

-- or and not
-- 检索 工资 2000, 3000员工名称 岗位 工资
select ename,job,sal from emp where sal =some(2000,3000) ;
select ename,job,sal from emp where sal=2000 or sal=3000 ;

-- >|>= and <|<=     between 值1 and 值2; 
-- 工资在2000到3000之间的员工信息
select * from emp where sal > 2000 and sal < 3000;
select * from emp where sal >= 2000 and sal <= 3000;
select * from emp where sal between 2000 and  3000;  --相当于使用>=  <=

---查询 岗位 为 CLERK 且部门编号为 20的员工名称 部门编号，工资
select ename,deptno,sal,job from emp where job = 'CLERK' and deptno = 20;

-- 查询 岗位 为 CLERK 或部门编号为 20的员工名称 部门编号，工资
select ename,deptno,sal,job from emp where job = 'CLERK' or deptno = 20;

--查询 岗位 不是 CLERK 员工名称 部门编号，工资
select ename,deptno,sal,job from emp where job != 'CLERK';
select ename,deptno,sal,job from emp where job <> 'CLERK';
select ename,deptno,sal,job from emp where not job = 'CLERK';

-- 查询 岗位 不为 CLERK 并且部门编号不为 20的员工名称 部门编号，工资
--两个条件都不满足
select ename,deptno,sal,job from emp where job!='CLERK' and deptno!=20;

--存在佣金|奖金的员工名称
select ename,comm from emp where comm is not null;
select ename,comm from emp where not comm is null;


--查询工资大于1500 或 含有佣金的人员姓名
select ename from emp where sal>1500 or comm is not null;

--集合操作:
--Union，并集(去重) 对两个结果集进行并集操作，不包括重复行同时进行默认规则的排序；
--Union All，全集(不去重) 对两个结果集进行并集操作，包括重复行，不进行排序 ；
--Intersect，交集(找出重复) 对两个结果集进行交集操作，不包括重复行，同时进行默认规则的排序；
--Minus，差集(减去重复) 对两个结果集进行差操作，不包括重复行，同时进行默认规则的排序
select ename from emp where sal>800
Union
select ename from emp where comm is not null;

select ename from emp where sal>800 
Union All
select ename from emp where comm is not null;

--查询显示不存在雇员的所有部门号。
select deptno from dept
Minus
select distinct deptno from emp;

--like 模糊匹配  
--查询员工姓名中字符A开头员工信息
select * from emp where ename like 'A';
```

### in exists

```
select deptno,dname,loc from dept ;  --推荐
select deptno,dname,loc from dept where 1=1 and 条件2 and 条件3;


-- 查询工资为 1500， 2000， 2500， 5000的员工的信息
select * from emp where sal=1500 or sal=2000 or sal=2500 or sal=5000;
--in(值1,值2,值3..结果集) 结果集中的任意一个值只要匹配,就可以
select * from emp where sal in (1500， 2000， 2500， 5000);

--部门名称为 SALES 或 ACCOUNTING 的雇员信息
--数据:员工信息
--来源:emp
--条件:dname in ( 'SALES' , 'ACCOUNTING')
--查询部门名称为 SALES 或 ACCOUNTING的部门编号
select deptno from dept where dname in ( 'SALES' , 'ACCOUNTING');
--员工在 ↑部门的员工信息
select * from emp where deptno in(10,30);
select *
  from emp
 where deptno in
       (select deptno from dept where dname in ('SALES', 'ACCOUNTING'));
       
--要查询数据的来源与判断的条件不在一张表时候,需要观察不同表的关联条件

-- 查询工资等级为 2的员工信息
select * from salgrade;
--查询薪资等级为2的最低薪资 最高薪资
select losal from salgrade where grade = 2;
select *
  from emp
 where sal between (select losal from salgrade where grade = 2) and
       (select hisal from salgrade where grade = 2);

-- 查询 销售部（SALES） 中 工资大于1500的员工信息
select * from emp where deptno = (select deptno from dept where dname = 'SALES') and sal>1500;

-- 查询工资比SMITH高的同一部门的员工信息
select *
  from emp
 where deptno = (select deptno from emp where ename = 'SMITH')
   and sal > (select sal from emp where ename = 'SMITH');
   
--exists() 存在即合法,存在即保留
--select * from 表 where exists (结果集);  
--从from中拿出一条数据,去看where中exists后的结果集是否存在数据,如果有,则当前从from拿出的这条数据就能被保留在select后,如果没有就不保留
select * from emp where exists(select deptno from dept where dname='haha');

--所有员工表中的数据
select * from emp where exists(select deptno from dept where dname in('SALES', 'ACCOUNTING'));

select *
  from emp e
 where exists (select deptno
          from dept d
         where dname in ('SALES', 'ACCOUNTING')
           and e.deptno = d.deptno);
--当工资有员工薪资>2000的时候,就查询所有的员工信息,如果不存在,就查询不到
select ename, sal
  from emp
 where exists (select ename, sal from emp e2 where e2.sal >= 2000);

--与有奖金存在的员工 员工编号相等的员工信息
select empno, ename, sal,comm
  from emp e1
 where exists (select empno, ename, sal, comm
          from emp e2
         where comm is not null
           and e1.empno = e2.empno);


--与有奖金存在的员工部门编号相等的员工信息
select empno, ename, sal,deptno
 from emp e1
where exists (select empno, ename, sal, comm,deptno
 from emp e2
 where comm is not null
 and e1.deptno = e2.deptno );

--排序  order by 排序字段1,排序字段2..
--select 数据 from 数据源 where 行过滤条件 order by 排序字段 desc降序|asc升序..; 
--from--where--select--order by
```

```

```

### 常用函数

#### sysdate，current_date:当前时间

```

--配合select命令使用可以搭配虚表dual
select current_date from dual where 1=1; 
select sysdate from dual where 1=1;
```

#### 字符串转时间，时间转字符串:to_char(),to_date()

to_char()：第一个参数为日期数据，第二个参数为格式

to_date()：第一个参数为日期字符串，第二个参数为格式

格式:

> **数据库日期格式：**yyyy/mm/dd  hh24:mi:ss
>
> yyyy:年
>
> mm：月
>
> dd：日
>
> hh12:12小时制小时          hh24:24小时制小时 
>
> mi: 分钟
>
> ss:秒
>
> **随便提一下SimpleDateFomater的日期格式**
>
> yyyy:年
>
> MM：月
>
> dd：本月第几日            DD：一年第几天
>
> hh:12小时制小时     HH:24小时制    
>
> mm: 分钟
>
> ss:秒
>
> ***实例：***
>
> ```
> Date date = new Date();
>         String strDateFormat = "yyyy-MM-dd HH:mm:ss";
>         SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
>         System.out.println(sdf.format(date));
> ```
>
> 

```
--to_char
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual;
--to_date
select to_date('2020-02-02 12:12:34','yyyy-mm-dd hh24:mi:ss') from dual;
```

#### 多行函数 通常配和group by 使用

```
count :统计记录数 count() -->* 或一个列名
max min: 最大值 最小值
sum：求和
avg:平均值
```

#### 日期计算函数

```
--add_months
select add_months(sysdate,3) from dual;
--next_day
select next_day(sysdate,'星期一') from dual;
--last_day
select last_day(hiredate) from emp;
--months_between
select months_between(hiredate,sysdate) from emp;
```

#### rowid  rownum

​         **ROWID** 是 ORACLE 中的一个重要的概念。用于定位数据

库中一条记录的一个相对唯一地址值。通常情况下，该

值在该行数据插入到数据库表时即被确定且唯一。

ROWID 它是一个伪列，它并不实际存在于表中。它是

ORACLE 在读取表中数据行时，根据每一行数据的物理

地址信息编码而成的一个伪列。所以根据一行数据的

ROWID 能找到一行数据的物理地址信息。从而快速地定

位到数据行。数据库的大多数操作都是通过ROWID 来完

成的，而且使用ROWID 来进行单记录定位速度是最快

的。

​        **ROWNUM** 是一种伪列，它会根据返回记录生成一个序列

化的数字。排序后的结果集的顺序号，每一个结果集 都

有自己顺序号 ，不能直接查询大于 1 的数。利用

ROWNUM，我们可以生产一些原先难以实现的结果输

出。

## 视图

> 视图:建立在表|结果集|视图上的虚拟表，有以下作用
>
> 1. 简化:select 查询语句
>
> 2. 重用:封装select语句 命名
>
> 3. 隐藏:内部细节
>
> 4. 区分:相同数据不同查询
>
> 不是所有的用户都有创建视图的权限
>
> 1. 前提： create view -->组 connect resource dba 
>
> 2. 授权: -->sqlplus /nolog 
>
> ​            a)、sys登录 conn sys/123456@orcl as sysdba 
>
> ​            b)、授权: grant dba to scott;
>
> 回收: revoke dba from scott;
>
> ​            c)、重新登录
>
> 要求:所有列必须存在名称。
>
> ```
> create or replace view 视图名 as select语句 [with read only];
> 
> grant  dba to scott;  
> create view manager as(select * from emp where empno in(select distinct mgr from emp));
> select * from manager;
> update manager set comm=9999 where empno=1111;
> select max(sal),deptno from manager group by deptno;
> ```
>
> 

## 索引

> 前提 : 设计表首先应该按需遵循三范式
>
> 1. 确定表名
>
> 2. 确定字段名 类型 +约束(主键 外键 非空 默 检查认 唯 一)
>
> 主键： 唯一标识一条记录（唯一并且非空）
>
> 唯一： 唯一
>
> 非空：不能为空
>
> 默认： 当没给值时使用给定一个默认值
>
> 外键：参考其他表（自己）的某个（某些）字段
>
> 检查：自定义的规则
>
> ```
> create index 索引名 on表名 (字段列表...) 
> drop index 索引名 
> create index idx_emp on emp(sal,ename); 
> drop index idx_emp; 
> select * from emp order by sal,ename;
> ```
>

## DDL

### 创建表

> create 表名(
>
> 列名 类型  约束，
>
> ................
>
> );

> ​    1.创建表的dao时候写dao注释专
> create table test1(
> field_name int comment '字段的注释'
> )comment='表的注释';
>
> 2.  修改属表的注释
>    alter table test1 comment '修改后的表的注释';
>
> 3. 修改字段的注释
>    alter table test1 modify column field_name int comment '修改后的字段注释';
>    --注意：字段名和字段类型照写就行

### 约束

| 约束  | 简述                                                         |
| ----- | ------------------------------------------------------------ |
| 主键  | 确定主码，限定非空唯一列，系统会根据主码建立索引             |
| 外键  | 与另外的表（主表）关联，一般外键为主表的主键，用来限制从表插入的数据（只能主表存在的数据） |
| 非空  | null，not null；定义插入表时该列数据是否必须定义             |
| 唯一  | unique：唯一约束                                             |
| check | 检查约束，插入时对数据进行检查，符合插入。                   |

```
--表内添加
create table student (
id char(8) primary key,
name varchar2(20) not null,
gender char(2 char) default('男') check(gender in('男','女')),
birthday date null ,
cno char(4) not null,
foreign key(cno) references cname(cno)
);

--建表后加
alter table student add constaint 约束;

--删除约束
alter table tb_user drop constraint uq_user_email cascade;

--修改约束
 --非空 alter table tb_user modify (username    varchar2(20));
 --默认 alter table tb_user modify (age default null); 

--约束的禁用与启用
ALTER TABLE tb_user disable constraint nn_user_name;
ALTER TABLE tb_user enable constraint nn_user_name;
```

### 删除表

> drop 表名；              --主键被子表外键ying
>
> drop 表名 cascade constraint;  --级联删除表

### 删除数据

> delete from  表 where 条件;
>
> --有外键
>
> 1. 删除从表直接删除
>
> 2. ```
>    --****
>    --主外键关系下,删除数据:
>    --从表数据可以直接删除
>    --删除主表数据: 
>                  --没有被从表引用的数据,可以直接删除
>                  --删除主表中已经被从表引用的数据: 3中解决方案
>                                     --先删除引用了当前主表数据的那些从表数据,然后再删除当前主表数据  默认
>                                     --删除主表数据的同时,删除从表中引用了当前主表数据的那些从表数据  on delete cascade
>                                     --删除主表数据的同时,从表中,引用了当前主表数据的那些从表数据的外键字段设置为null
>    ```

### 修改表结构

> --修改表名 
>
> rename old to new;
>
> --修改列名 
>
> alter table 表名 column 旧列名 
>
> to 新列名;
>
> --修改类型 
>
> alter table 表名 modify(列名 类型);
>
> --添加列 
>
> alter table 表名 add 定义列;
>
> --删除列 
>
> alter table 表名 drop column 列名; 

### 插入

普通插入

```sql
INSERT INTO mytable(col1, col2)
VALUES(val1, val2);
```

插入检索出来的数据

```sql
INSERT INTO mytable1(col1, col2)
SELECT col1, col2
FROM mytable2;
```

将一个表的内容插入到一个新表

```sql
CREATE TABLE newtable AS
SELECT * FROM mytable;
```

### 更新

```sql
UPDATE mytable
SET col = val
WHERE id = 1;
```

### 删除

```sql
DELETE FROM mytable
WHERE id = 1;
```

**TRUNCATE TABLE**  可以清空表，也就是删除所有行。

```sql
TRUNCATE TABLE mytable;
```

使用更新和删除操作时一定要用 WHERE 子句，不然会把整张表的数据都破坏。可以先用 SELECT 语句进行测试，防止错误删除。

## 数据库事务

> **事务有一下四个特点：（ACID）**
>
> 1. 原子性（Atomic）：事务中所有数据的修改，要么
>
> 全部执行，要么全部不执行。
>
> 2. 一致性（Consistence）：事务完成时，要使所有所
>
> 有的数据都保持一致的状态，换言之：通过事务进行
>
> 的所有数据修改，必须在所有相关的表中得到反映。
>
> 3. 隔离性（Isolation）：事务应该在另一个事务对数据
>
> 的修改前或者修改后进行访问。
>
> 4. 持久性（Durability）：保证事务对数据库的修改是
>
> 持久有效的，即使发生系统故障，也不应该丢失。

### 事务开启

> 自动开启于 DML 之 insert delete update

### 事务结束

> 1. **成功**
>
> ​       正常执行完成的 DDL 语句：create、alter、drop
>
> ​       正常执行完 DCL 语句 GRANT、REVOKE
>
> ​        正常退出的 SQLPlus 或者 SQL Developer 等客户端
>
> ​        如果人工要使用隐式事务，SET AUTOCOMMIT ON 
>
> ​        (只针对一个连接)
>
> 手动提交 ：使用 commit 
>
> 2. **失败**
>
> ​        rollback ，手动回滚
>
> ​        非法退出 意外的断电
>
> ​         rollback 只能对未提交的数据撤销，已经 Commit 的数据
>
> 是无法撤销的，因为 commit 之后已经持久化到数据库
>
> 中。



***补充: oracle默认不自动提交，而mysql默认自动提交，mysql 开启事务要设置不自动提交：begin 开始事务，commit提交完成事务，rollback回滚***

## java连接

```
String driver = "oracle.jdbc.OracleDriver";    //驱动标识符
String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //链接字符串
String user="usr";
String pwd="pwd";
Class.forName(driver);
Connection con = null;
PreparedStatement pstm = null;
ResultSet rs = null;

try{
con=DriverManager.getConnection(url,user, pwd);
String sql = "select * from user";
pstm =con.prepareStatement(sql);
rs = pstm.executeQuery();
while(rs.next()) {
                int uid= rs.getInt("id");
            }
}catch(Exception e){
     e.printStackTrace();
}finally{
   if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
// 关闭执行通道
            if(pstm !=null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
// 关闭连接通道
            try {
                if(con != null &&(!con.isClosed())) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
```

### 反射操作oracle增删改查

```
package com.lwf.classTest.ReflectJDBC;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lwf
 * @title: OracleJDBCUtils
 * @projectName 11_02Ojdbc
 * @description: TODO
 * @date 2020/11/218:35
 */
public class OracleJDBCUtils<T> implements ReflectUtils<T>{
    private static Connection connection;
    private static Properties pro=new Properties();
    public OracleJDBCUtils(String path) throws ClassNotFoundException, IOException, SQLException {
       pro.load(this.getClass().getClassLoader().getResourceAsStream(path));
        Class.forName(pro.getProperty("driver")) ;
       connection= DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
       //开启事务
        connection.setAutoCommit(false);
    }
    @Override
    public List query(Class c) throws SQLException, IllegalAccessException, InstantiationException {
        String table=c.getSimpleName();
        List<T> list=new ArrayList<>();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from "+table);
        while (rs.next()){
            T t= (T) c.newInstance();
            for(Field f:c.getDeclaredFields()){
                f.setAccessible(true);
                if(f.getType()==Integer.class){
                    if(null==rs.getObject(f.getName()))
                        f.set(t, null);
                    else
                       f.set(t,Integer.valueOf(rs.getObject(f.getName())+""));
                }else {
                    f.set(t,rs.getObject(f.getName()));
                }
            }
            list.add(t);
        }
        close(connection, statement, rs);
        return list;
    }

    @Override
    public boolean delete(T t) throws SQLException, IllegalAccessException {
        String sql="delete from "+t.getClass().getSimpleName()+" where 1=1";
        for(Field f:t.getClass().getDeclaredFields()){
                f.setAccessible(true);
                if(f.get(t)!=null)
                   sql+=" and "+f.getName()+"="+f.get(t);
        }
        Statement statement=connection.createStatement();
        if(statement.executeUpdate(sql)>0){
            System.out.println("删除"+t.toString()+",事务提交");
            connection.commit();
            close(connection, statement, null);
            return true;
        }else {
            System.out.println(sql);
            System.out.println("删除"+t.toString()+",事务回滚");
            connection.rollback();
            close(connection, statement, null);
        }
        return false;
    }

    @Override
    public boolean update(T t,String key) throws IllegalAccessException, NoSuchFieldException, SQLException {
        String sql="update "+t.getClass().getSimpleName()+" set  ";
        String end=" ";
        for(Field f:t.getClass().getDeclaredFields()){
            if(f.getName().equals(key)){
                Field f1= t.getClass().getDeclaredField(key);
                f1.setAccessible(true);
                end+=" where "+key+"='"+f1.get(t)+"' ";
            }else {
                f.setAccessible(true);
                if (f.get(t) != null)
                    sql += " " + f.getName() + "='" + f.get(t)+"' and";
            }
        }
        Statement statement=connection.createStatement();
        sql=sql.substring(0, sql.lastIndexOf('a'));
        if(statement.executeUpdate(sql+end)>0){
            System.out.println("删除"+t.toString()+",事务提交");
            connection.commit();
            close(connection, statement, null);
            return true;
        }else {
            System.out.println(sql);
            System.out.println("删除"+t.toString()+",事务回滚");
            connection.rollback();
            close(connection, statement, null);
        }
        return false;
    }

    @Override
    public boolean insert(T t) throws IllegalAccessException, SQLException {
        String sql="insert into "+t.getClass().getSimpleName()+"(";
        Field[] fields=t.getClass().getDeclaredFields();
        for(Field field:fields){
            sql+=field.getName()+",";
        }
        sql=sql.trim();
        sql=sql.substring(0, sql.length()-1)+") values (";
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getType()==Integer.class){
                sql+=field.get(t)+",";
            }else
                sql+="'"+field.get(t)+"',";
        }
        sql=sql.substring(0, sql.length()-1)+")";
        Statement statement=connection.createStatement();
        int update = statement.executeUpdate(sql);
        if(update>0){
            connection.commit();
            System.out.println("更新 "+update+" 行,事务提交");
            close(connection, statement, null);
            return true;
        }
        connection.rollback();
        close(connection, statement, null);
        System.out.println("失败更新");
        return false;
    }

    public void close(Connection connection,Statement statement,ResultSet rs) throws SQLException {
        if(rs!=null)
            rs.close();
        if(statement!=null)
            statement.close();
        if(connection!=null)
            connection.close();
    }
}

```
**测试代码**

```
public class Test {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        ReflectUtils<Student> utils=new OracleJDBCUtils<>("oracle.properties");
        //ReflectUtils<Student> utils=new OracleJDBCUtils<>("oracle.properties");
        //反射获取对应类在数据库的表(表名与类名，属性名与列名相等)
        //查询
        //System.out.println(utils.query(Student.class));
        //System.out.println(utils1.query(Sc.class));
        //删除
//        Student student=new Student();
//        student.setSno("9512101");
//        utils.delete(student);


//          Sc sc=new Sc();
//          sc.setSno("9521105");
//          utils.delete(sc);
         //更新
//        Sc sc=new Sc();
//        sc.setCno("c06");
//        sc.setSno("9531101");
//        utils.update(sc, "sno");
        //插入
        Student student=new Student();
        student.setSno("9531103");
        student.setSage(34);
        student.setSname("周永日");
        student.setSdept("信息系");
        utils.insert(student);
    }
}

```
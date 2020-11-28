# 核心
***foreach***
动态 SQL 的另一个常见使用场景是对集合进行遍历（尤其是在构建 IN 条件语句的时候）。比如：

```
<select id="selectPostIn" resultType="domain.blog.Post">
  SELECT *
  FROM POST P
  WHERE ID in
  <foreach item="item" index="index" collection="list"
      open="(" separator="," close=")">
        #{item}
  </foreach>
</select>
```


foreach元素的属性主要有item，index，collection，open，separator，close。**

（1）item：集合中元素迭代时的别名，该参数为必选。

（2）index：在list和数组中，index是元素的序号，在map中，index是元素的key，该参数可选。

（3）open：foreach代码的开始符号，一般是 "(" ，它和 close=")" 合用。常用在in()，values()时。该参数可选。

（4）separator：元素之间的分隔符，例如在in()的时候，separator=","会自动在元素中间用","隔开，避免手动输入逗号导致sql错误，如in(1,2,)这样。该参数可选。

（5）close: foreach代码的关闭符号，一般是 ")" ，它和 open="(" 合用。常用在in()，values()时。该参数可选。

（6）collection:  要做foreach的对象，作为入参时，List对象默认用"list"代替作为键，数组对象有"array"代替作为键，Map对象没有默认的键。当然在作为入参时可以使用@Param("keyName")来设置键，设置keyName后，list，array将会失效。除了入参这种情况外，还有一种作为参数对象的某个字段的时候。举个例子：如果User有属性List ids，入参是User对象，那么这个collection = "ids"。如果User有属性Ids  ids，其中Ids是个对象，Ids有个属性List id，入参是User对象，那么collection = "ids.id"

```
<!--    批量删除-->
    <delete id="deleteSomeEmpno" >
        delete from emp where empno in
        <foreach collection="list" open="(" item="item" separator="," close=")">
            #{item}
        </foreach>
    </delete>
<!--    批量插入-->
    <insert id="insertSome"  parameterType="list" >
        insert into emp
        <foreach collection="list"  item="item" index="index"   separator="UNION ALL">
            select     #{item.empno} empno,#{item.ename} ename,#{item.job} job,#{item.mgr} mgr,#{item.hiredate} hiredate,#{item.sal} sal,#{item.comm} comm,#{item.deptno} deptno
            from dual </foreach>

    </insert>
```

# oracle批量操作
## 批量删除
从这句sql语句开始用foreach拼接传入参数作为集合
```
delete from emp where empno in(集合);
```
mapper映射文件
```

<!--    批量删除-->
    <delete id="deleteSomeEmpno" >
        delete from emp where empno in
        <foreach collection="list" open="(" item="item" separator="," close=")">
            #{item}
        </foreach>
    </delete>

```
## 批量插入

利用foreach 的item拼接出 select #{item.row1},#{item.row2}... from dual
再用union 作为分隔符
```
insert into emp select  列... from 表1  union   select  列... from 表2 
```
mapper映射文件：

```
<!--    批量插入-->
    <insert id="insertSome"  parameterType="list" >
        insert into emp 
        <foreach collection="list"  item="item" index="index"   separator="UNION ALL">
            select     #{item.empno} empno,#{item.ename} ename,#{item.job} job,#{item.mgr} mgr,#{item.hiredate} hiredate,#{item.sal} sal,#{item.comm} comm,#{item.deptno} deptno
            from dual </foreach>

    </insert>
```
## 批量查询（类似于删除）
从这句sql语句开始用foreach拼接传入参数作为集合
```
select * from emp where empno in(集合);
```
mapper映射文件
```

<!--    参数为数组 collection="array"-->
    <select id="queryArray" resultType="Emp">
        select * from emp where empno in
        <foreach collection="array" item="item" open="(" close=")" separator=",">
            #{item}
        </foreach>
    </select>
<!--    参数为list collection="list"-->
    <select id="queryList" resultType="Emp">
        select * from emp where empno in
        <foreach collection="list" item="item" open="(" close=")" separator=",">
            #{item}
        </foreach>
    </select>
<!--    查询结果输出为map-->
    <select id="queryByidToMap" parameterType="integer" resultType="map">
        select * from emp where empno=#{no}
    </select>


```
## 批量更新
基于sql语句：

```
begin
update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n；
update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n；
update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n；
end;
```
> begin
> 需要foreach拼接部分
>update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n；
>update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n；
>update 表名 set 字段1=值1，字段2=值2，字段3=值3.... where 字段n=值n
>拼接到此为止
>；end;

mapper映射文件

```
 <update id="updateSome" parameterType="list">
        begin
        <foreach collection="list" item="i" separator=";">
            update emp set ENAME=#{i.ename} where empno=#{i.empno}
        </foreach>
        ;end;
    </update>
```
最后贴完整Mapper.xml内容水一下字数

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="Mybatis.Mapper.EmpMapper">
<!--    输出pojo类-->
   <select id="queryByDept" parameterType="Integer"  resultType="Emp" >
       select * from EMP where DEPTNO=#{deptno}
   </select>
    <select id="query" resultType="Emp">
        select * from EMP
    </select>
<!--    参数为数组 collection="array"-->
    <select id="queryArray" resultType="Emp">
        select * from emp where empno in
        <foreach collection="array" item="item" open="(" close=")" separator=",">
            #{item}
        </foreach>
    </select>
<!--    参数为list collection="list"-->
    <select id="queryList" resultType="Emp">
        select * from emp where empno in
        <foreach collection="list" item="item" open="(" close=")" separator=",">
            #{item}
        </foreach>
    </select>
<!--    查询结果输出为map-->
    <select id="queryByidToMap" parameterType="integer" resultType="map">
        select * from emp where empno=#{no}
    </select>
    <select id="queryBydeptToMap" resultType="map">
        select * from emp where deptno=#{deptno}
    </select>
<!--    参数绑定-->
<!--    一个参数一般参数名相同（或不同)-->
<!--    pojo类属性名相同自动绑定-->
<!--    二参数-->
    <select id="queryByMgrDept" resultType="emp">
        select * from emp where mgr=#{arg0} and deptno=#{arg1}
    </select>
<!--    三参数-->
    <select id="queryByMgrDeptComm" resultType="emp">
        select * from emp where mgr=#{arg0} and deptno=#{arg1} and comm>=#{arg2}
    </select>
<!--    批量删除-->
    <delete id="deleteSomeEmpno" >
        delete from emp where empno in
        <foreach collection="list" open="(" item="item" separator="," close=")">
            #{item}
        </foreach>
    </delete>
<!--    批量插入-->
    <insert id="insertSome"  parameterType="list" >
        insert into emp
        <foreach collection="list"  item="item" index="index"   separator="UNION ALL">
            select     #{item.empno} empno,#{item.ename} ename,#{item.job} job,#{item.mgr} mgr,#{item.hiredate} hiredate,#{item.sal} sal,#{item.comm} comm,#{item.deptno} deptno
            from dual </foreach>

    </insert>
    <update id="updateSome" parameterType="list">
        begin
        <foreach collection="list" item="i" separator=";">
            update emp set ENAME=#{i.ename} where empno=#{i.empno}
        </foreach>
        ;end;
    </update>
</mapper>
```


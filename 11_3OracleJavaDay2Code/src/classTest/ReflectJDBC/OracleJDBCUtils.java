package classTest.ReflectJDBC;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lwf
 * @title: OracleJDBCUtils
 * @projectName 11_02Ojdbc
 * @description: 反射构造器
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

    /**
     * 设置器设置值
     * @param c  类
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Override
    public List query(Class c) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String table=c.getSimpleName();
        List<T> list=new ArrayList<>();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from "+table);
        while (rs.next()){
            T t= (T) c.newInstance();
            for(Field f:c.getDeclaredFields()){
                c.getMethod("set"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1),Object.class).invoke(t, rs.getObject(f.getName()));
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

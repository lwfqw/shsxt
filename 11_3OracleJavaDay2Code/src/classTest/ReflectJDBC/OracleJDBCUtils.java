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
    private static ResultSet rs=null;
    private static Statement statement=null;
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
        statement=connection.createStatement();
        rs=statement.executeQuery("select * from "+table);
        while (rs.next()){
            T t= (T) c.newInstance();
            for(Field f:c.getDeclaredFields()){
                c.getMethod("set"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1),Object.class).invoke(t, rs.getObject(f.getName()));
            }
            list.add(t);
        }
        return list;
    }

    /**
     *
     * @param sql sql语句
     * @param args 可变参数填入预处理模块PreparedStatement
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     */
    @Override
    public boolean delete(String sql,Object... args) throws SQLException, IllegalAccessException {
        statement=connection.prepareStatement(sql);
        PreparedStatement statement1= (PreparedStatement) statement;
        for(int i=1;i<=args.length;i++){
            statement1.setObject(i,args[i]);
        }
        if(statement1.executeUpdate()>0){
            connection.commit();
            return true;
        }else {
            connection.rollback();
            return false;
        }
    }

    /**
     * 调用delete
     * @param sql sql语句
     * @param args 可变参数填入预处理模块PreparedStatement
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SQLException
     */
    @Override
    public boolean update(String sql,Object... args) throws IllegalAccessException, NoSuchFieldException, SQLException {
      return delete(sql, args);
    }

    /**
     *
     * @param sql sql语句
     * @param args 可变参数填入预处理模块PreparedStatement
     * @return
     * @throws IllegalAccessException
     * @throws SQLException
     */
    @Override
    public boolean insert(String sql,Object... args) throws IllegalAccessException, SQLException {
    return delete(sql, args);
    }

    /**
     * 关闭连接
     * @throws SQLException
     */
    @Override
    public  void close() throws SQLException {
        if(rs!=null)
            rs.close();
        if(statement!=null)
            statement.close();
        if(connection!=null)
            connection.close();
    }
}

package classTest.ReflectJDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lwf
 * @title: ConnectionFactory
 * @projectName 11_02Ojdbc
 * @description: 连接工厂
 * @date 2020/11/213:56
 */
class ConnectionFactory {
    public static Connection getOracleConnection(String source) throws SQLException, IOException, ClassNotFoundException {
        Properties pro=new Properties();
        pro.load(ConnectionFactory.class.getClassLoader().getResourceAsStream(source));
        String driver=pro.getProperty("driver");
        String url=pro.getProperty("url");
        String user=pro.getProperty("user");
        String pwd=pro.getProperty("password");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);
        return connection;
    }
    public static void close(Connection connection) throws SQLException {
        if(connection!=null)
            connection.close();
    }
}

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertTest {
    @Test

    public void testInsert() throws Exception{
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();
        //创建用户.食物.收藏表

        String sql1="create table if not exists yong_hu (" +
                "id int primary key auto_increment," +
                "name varchar(20)," +
                "email varchar(50)," +
                "password varchar(50)" +
                ");";
        String sql2=
                "create table if not exists shi_wu(" +
                "id int primary key auto_increment," +
                "name varchar(20)," +
                "canteen varchar(10)," +
                "floor int" +
                ");";
        String sql3="create table if not exists shouCang("+
                "food_id int," +
                "user_id int" +
                ");";


        Statement statement1 = connection.createStatement();
        Statement statement2 = connection.createStatement();
        Statement statement3 = connection.createStatement();

        statement1.executeUpdate(sql1);
        statement2.executeUpdate(sql2);
        statement3.executeUpdate(sql3);

        String sql4="insert into yong_hu(name,email,password) values(?,?,?);";
        String sql5="insert into shi_wu(name,canteen,floor) values(?,?,?);";
        String sql6="insert into shouCang(food_id, user_id) VALUE (?,?);";

            PreparedStatement ps1 = connection.prepareStatement(sql4);
            PreparedStatement ps2 = connection.prepareStatement(sql5);
            PreparedStatement ps3 = connection.prepareStatement(sql6);
            ps1.setString(1,"jys");
            ps1.setString(2,"123@a.com");
            ps1.setString(3,"123");
            ps2.setString(1,"泡面");
            ps2.setString(2,"梅苑食堂");
            ps2.setInt(3,2);
            ps3.setInt(1,1);
            ps3.setInt(2,1);
            int i1=ps1.executeUpdate();
            int i2 = ps2.executeUpdate();

        System.out.println(i1>0&&i2>0);

        statement2.close();
        statement1.close();
        statement3.close();

        connection.close();
    }


}

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class UpdateTest {

    @Test

    public void testUpdate() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();
        String sql1="update shi_wu set name=?,canteen=?,floor=? where id= ?;";
        String sql2="update yong_hu set name=?,email=?,password=? where id= ?;";
        PreparedStatement ps1=connection.prepareStatement(sql1);
        PreparedStatement ps2=connection.prepareStatement(sql2);
        ps1.setString(1,"小汉堡");
        ps1.setString(2,"桃苑餐厅");
        ps1.setInt(3,1);
        ps1.setInt(4,3);

        ps2.setString(1,"老王");
        ps2.setString(2,"666@qq.com");
        ps2.setString(3,"666");
        ps2.setInt(4,3);

        int i1 = ps1.executeUpdate();
        int i2 = ps2.executeUpdate();
        System.out.println(i1>0&&i2>0);

        ps1.close();
        ps2.close();
        connection.close();

    }
}
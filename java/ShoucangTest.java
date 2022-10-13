import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ShoucangTest {
    @Test

    public void testShoucang() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();

        String isSql="insert into shoucang(food_id, user_id) VALUE (?,?);";
        String dpSql="delete from shoucang where food_id =? and user_id=? ; ";

        PreparedStatement ps1=connection.prepareStatement(isSql);
        PreparedStatement ps2=connection.prepareStatement(dpSql);

        ps1.setInt(1,2);
        ps1.setInt(2,2);
        ps2.setInt(1,2);
        ps2.setInt(2,2);

        ps1.executeUpdate();
        ps2.executeUpdate();

        ps1.close();
        ps2.close();
        connection.close();

    }
}

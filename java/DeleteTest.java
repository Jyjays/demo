import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DeleteTest {
    @Test

    public void testDelete() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();
        String sql1="delete from demo.yong_hu where name=?;";
        PreparedStatement ps1=connection.prepareStatement(sql1);
        ps1.setString(1,null);
        int i1=ps1.executeUpdate();
        System.out.println(i1>0);

        ps1.close();
        connection.close();

    }
}

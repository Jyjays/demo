import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ForeignkeyTest {
    @Test

    public void testForeignkey() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();

        String fk1="alter table shoucang add constraint fk_food_id foreign key(food_id) references shi_wu(id);" ;
        String fk2="alter table shoucang add constraint fk_user_id foreign key(user_id) references yong_hu(id);";
        PreparedStatement ps1=connection.prepareStatement(fk1);
        PreparedStatement ps2=connection.prepareStatement(fk2);
        int i = ps1.executeUpdate();
        int i1 = ps2.executeUpdate();

        ps1.close();
        ps2.close();
        connection.close();

    }
}
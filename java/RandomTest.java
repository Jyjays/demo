import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class RandomTest {
    @Test

    public void testRandom() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();
        String sql="select * from demo.shi_wu order by rand() limit 1;";
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Food> list=new ArrayList<>();

        while(rs.next()){
            Food food=new Food();
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String canteen=rs.getString("canteen");
            int floor=rs.getInt("floor");
            food.setId(id);
            food.setName(name);
            food.setCanteen(canteen);
            food.setFloor(floor);

            list.add(food);
        }
        System.out.println(list);

        rs.close();
        ps.close();
        connection.close();

    }
}

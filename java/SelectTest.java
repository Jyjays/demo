import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SelectTest {
    @Test

    public void testSelect() throws Exception{
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();

        String sql1="Select * from yong_hu ";
        String sql2="Select * from shi_wu where canteen='梅苑食堂' and floor=2;";

        Statement statement1= connection.createStatement();
        Statement statement2= connection.createStatement();
        ResultSet rs1=statement1.executeQuery(sql1);
        ResultSet rs2=statement2.executeQuery(sql2);

        ArrayList<User> userArrayList=new ArrayList<>();
        ArrayList<Food> foodArrayList=new ArrayList<>();


        while(rs1.next()){

            int id= rs1.getInt("id");
            String name=rs1.getString("name");
            String email=rs1.getString("email");
            String password=rs1.getString("password");
            User user=new User(id,name,email,password);
            userArrayList.add(user);
        }
        System.out.println(userArrayList);

        while(rs2.next()){

            int id=rs2.getInt("id");
            String name=rs2.getString("name");
            String canteen=rs2.getString("canteen");
            int floor=rs2.getInt("floor");
            Food food=new Food(id,name,canteen,floor);
            foodArrayList.add(food);
        }
        System.out.println(foodArrayList);

        connection.close();
        rs1.close();
        rs2.close();
        statement1.close();
        statement2.close();

    }
}


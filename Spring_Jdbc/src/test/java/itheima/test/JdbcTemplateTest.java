package itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;


public class JdbcTemplateTest {

    @Test
//  Spring产生JdbcTemplate对象
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into person value(?,?,?)", 5,"tom2", "5000");
        System.out.println(row);
    }


    @Test
//    测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException {
//        创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_person");
        dataSource.setUser("root");
        dataSource.setPassword("wty7220898");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//      创建数据源对象
        jdbcTemplate.setDataSource(dataSource);
//        执行操作
        int row = jdbcTemplate.update("insert into person value(?,?,?)", 4,"tom", "5000");
        System.out.println(row);
    }
}

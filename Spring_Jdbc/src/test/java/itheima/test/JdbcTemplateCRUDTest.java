package itheima.test;

import itheima.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQueryAll(){
        List<Person> personList = jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println(personList);
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update person set pwd=? where name=?","t500","tom");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from person where name=?","tom2");
    }
}

package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

//标志该类是Spring的核心配置类
@Configuration
//<context:component-scan base-package="com.itheima"></context:component-scan>
@ComponentScan("com.itheima")
//<import resource=""></import>
@Import({DataSourceConfiguration.class})
public class SpringConfiuration {


}

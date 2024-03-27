import DAO.CourseDAO;
import DAO.JdbcCourseDAO;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
public class DaoConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource webDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(webDataSource());
    }

    @Bean
    public CourseDAO courseDAO(){
        JdbcCourseDAO dao = new JdbcCourseDAO();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }




}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by Ogudsogud on 7/7/2018.
 */

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.msg.data"})
public class MainParts {

    public static void main (String[]args) throws Exception {
        SpringApplication.run(MainParts.class, args);
    }

    @Bean(value = "datasource")
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}

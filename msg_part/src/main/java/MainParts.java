import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Ogudsogud on 7/7/2018.
 */

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.msg.data"})
public class MainParts {

    public static void main (String[]args) throws Exception {
        SpringApplication.run(MainParts.class, args);
    }
}

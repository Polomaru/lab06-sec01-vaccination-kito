package lab06_grupo_kito.lab06;
import cs.software.demo.DemoApplication;
import static org.assertj.core.api.Assertions.assertThat;
import java.lang.String;
import java.util.logging.Logger;

import controller.CitizenController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;


@SpringBootTest(classes={cs.software.demo.DemoApplication.class})
class Lab06ApplicationTests {
    static final Logger logger = Logger.getLogger(DemoApplication.class.getName());

     @Autowired
     private CitizenController controller;


    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
//    @Test(threadPoolSize = 80)
//    public void testCase3()
//    { }
}

package lab06_grupo_kito.lab06;
import cs.software.demo.DemoApplication;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import controller.CitizenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;


@SpringBootTest(
        classes={cs.software.demo.DemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class Lab06ApplicationTests {
    static final Logger logger = Logger.getLogger(DemoApplication.class.getName());
    @LocalServerPort
    private int PORT;
     @Autowired
     private CitizenController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @RepeatedTest(value = 1000)
    void Testthousand() throws Exception{
        var URL = "http://localhost:" + PORT + "/citizen/44731344/";
        var start = System.currentTimeMillis();
        this.restTemplate.getForEntity(URL, String.class);
        var end = System.currentTimeMillis();
        assertThat(end-start).isLessThanOrEqualTo(400);
    }

}

package lab06_grupo_kito.lab06;
import business.CitizenService;
import controller.CitizenController;
import cs.software.demo.DemoApplication;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import cs.software.demo.ServletInitializer;
import data.dtos.CitizenDTO;
import data.entities.Citizen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


@SpringBootTest(
        classes={cs.software.demo.DemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class Lab06ApplicationTests {
    @LocalServerPort
    private int PORT;

    @Autowired
    public MockMvc mvc;

    @Test
    void test1() throws Exception {
        mvc.perform(get("/citizen/44731344")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    void test11() throws Exception {
        mvc.perform(get("/citizen/212444")).andDo(print()).andExpect(status().is(200));
    }


    @Test
    void test12() throws Exception {
        mvc.perform(get("/citizen")).andDo(print()).andExpect(status().is(405));
    }

    @Test
    void test13() throws Exception {
        mvc.perform(get("/citizen/all")).andDo(print()).andExpect(status().is(200));
    }
    @Test
    void test14() throws Exception {
        mvc.perform(get("/citizen/vaccine/44731344")).andDo(print()).andExpect(status().is(200));
    }

//    @Test
//    void test15() throws Exception {
//        mvc.perform(get("/citizen/44731333")).andDo(print()).andExpect(status().is(200));
//    }


    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CitizenController controller;

    @Test
    void test2() throws Exception{
        String url = "http://localhost:"+PORT+"/citizen/44731344";
        Assertions.assertEquals(200, this.restTemplate.getForEntity(url, String.class).getStatusCodeValue());
    }

//    @RepeatedTest(value = 10)
//    void test3() throws Exception {
//        String url = "http://localhost:" + PORT + "/citizen/44731344";
//        assertThat(this.restTemplate.getForEntity(url, String.class).getStatusCodeValue()).isEqualTo(400);
//    }

    /**Data Tests
     * CitizenDTO Tests*/
    @Test
    void CitizenTests() throws Exception{
        var citizen = new Citizen();
        var citizen2 = new Citizen(12345679L,
                "Pedro",
                "Quispe",
                (new Date(2021, Calendar.JANUARY,1)),
                "999999999",
                "a@gmail.com");

        citizen.setDni(12345679L);
        citizen.setNames("Pedro");
        citizen.setSurnames("Quispe");
        citizen.setDate(new Date(2021, Calendar.JANUARY,1));
        citizen.setPhoneNum("999999999");
        citizen.setEmail("a@gmail.com");
        Assertions.assertEquals(citizen.getDni(),citizen2.getDni());
        Assertions.assertEquals(citizen.getNames(),citizen2.getNames());
        Assertions.assertEquals(citizen.getDate(),citizen2.getDate());
        Assertions.assertEquals(citizen.getSurnames(),citizen2.getSurnames());
        Assertions.assertEquals(citizen.getPhoneNum(),citizen2.getPhoneNum());
        Assertions.assertEquals(citizen.getEmail(),citizen2.getEmail());
        Assertions.assertNotNull(citizen.toString());
    }
    @Test
    void CitizenDTOTests() throws Exception{
        var citizenDTO = new CitizenDTO();
        Assertions.assertNotNull(citizenDTO);
        citizenDTO.setDni(12345679L);
        Assertions.assertEquals(12345679L,citizenDTO.getDni());
        citizenDTO.setNames("Pedro");
        Assertions.assertEquals("Pedro",citizenDTO.getNames());
        citizenDTO.setSurnames("Quispe");
        Assertions.assertEquals("Quispe",citizenDTO.getSurnames());
        citizenDTO.setDate(new Date(2021, Calendar.JANUARY,1));
        Assertions.assertEquals(new Date(2021, Calendar.JANUARY,1),citizenDTO.getDate());
        citizenDTO.setPhoneNum("999999999");
        Assertions.assertEquals("999999999",citizenDTO.getPhoneNum());
        citizenDTO.setEmail("a@gmail.com");
        Assertions.assertEquals("a@gmail.com",citizenDTO.getEmail());
        Assertions.assertNotEquals(" ",citizenDTO.toString());

    }

//    @Test
//    void CitizenServiceTests()throws Exception{
//
//        var service = new CitizenService();
//        var datevacc = service.getVaccine(Long.valueOf(44731344));
//        Assertions.assertNotNull(datevacc);
//    }

    @Test
    void demoaplication()throws Exception{
//        DemoApplication.main(new String[]{});
        var main = new DemoApplication();
        Assertions.assertNotNull(main);
        var servient = new ServletInitializer();
        servient.configure(new SpringApplicationBuilder());
        Assertions.assertNotNull(servient);

    }



}

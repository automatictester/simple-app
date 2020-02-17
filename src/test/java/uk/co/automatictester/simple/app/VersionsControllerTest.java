package uk.co.automatictester.simple.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VersionsControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testVersions() {
        // given
        String url = "http://localhost:" + port;

        // when
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        // then
        String pattern = "AppVersion:\\s+unknown\\nRuntimeId:\\s+\\d{4}\\nRequestId:\\s+\\d{4}";
        assertThat(result.getBody()).containsPattern(pattern);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

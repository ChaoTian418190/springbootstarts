package enjoy.teststarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest(classes = TestStarterApplication.class)
class TestStarterApplicationTests {

    @Autowired
    private Jedis jedis;

    @Test
    void contextLoads() {
        jedis.set("enjoy","enjoy");
        String enjoy = jedis.get("enjoy");
        System.out.println(enjoy);
    }

}

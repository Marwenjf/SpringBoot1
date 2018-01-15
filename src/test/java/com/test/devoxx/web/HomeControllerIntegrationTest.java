package com.test.devoxx.web;

import com.test.devoxx.DevoxxApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevoxxApplication.class)
@WebIntegrationTest(randomPort = true)
public class HomeControllerIntegrationTest {

    @Value("${local.server.port}")
    private int port;
    @Test
    public void raunAndInvokeHome(){
    String url = "http://localhost:"+port+"/";
    String body = new RestTemplate().getForObject(url,String.class);
    assertThat(body,is("JF Marwen jaffel"));
}
}
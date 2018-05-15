
# Springboot测试的Demo

- 访问方式：
    http://127.0.0.1:8080/hello.
    
###  springboot版本1.4.2

   @SpringBootTest(classes = MockServletContext.class)替代@SpringApplicationConfiguration(classes = MockServletContext.class)
   
###  测试类编写
    BaseOneApplicationTests
    
##  测试类引入静态包    
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

###  关注我 | About Me

- [北极的大企鹅](http://www.cnblogs.com/liuyangfirst/ "北极的大企鹅")

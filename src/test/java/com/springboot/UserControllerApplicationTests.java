package com.springboot;

import com.springboot.controller.Controller;
import com.springboot.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserControllerApplicationTests {


    private MockMvc mvc;

    // 测试UserController
    RequestBuilder request = null;

    @Before
    public void setUp() throws Exception {

//        mvc = MockMvcBuilders.standaloneSetup(new Controller()).build(); 测试Controller方法时候使用

        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    /**
     * @throws Exception
     */
    @Test
    public void testGetUserController() throws Exception {
        // 1、get查一下user列表，应该为空
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    /**
     * post提交一个user
     *
     * @throws Exception
     */
    @Test
    public void testPostUserController() throws Exception {
        // 2、post提交一个user
        request = post("/users/postUser")
                .param("id","1")
                .param("name","测试大师")
                .param("age","20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }


    /**
     * get获取user列表，应该有刚才插入的数据
     *
     * @throws Exception
     */
    @Test
    public void testGetUserPostController() throws Exception {
        // 2、post提交一个user
        request = post("/users/postUser")
                .param("id","1")
                .param("name","测试大师")
                .param("age","20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
    }


    /**
     * put修改id为1的user
     *
     * @throws Exception
     */
    @Test
    public void testPutUserByIdController() throws Exception {

        // 2、post提交一个user
        request = post("/users/postUser")
                .param("id","1")
                .param("name","测试大师")
                .param("age","20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 4、put修改id为1的user
        request = put("/users/putUser/1")
                .param("name","测试终极大师")
                .param("age","30");

        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    /**
     * get一个id为1的user
     *
     * @throws Exception
     */
    @Test
    public void testGetUserByIdController() throws Exception {
        // 2、post提交一个user
        request = post("/users/postUser")
                .param("id","1")
                .param("name","测试大师")
                .param("age","20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 4、put修改id为1的user
        request = put("/users/putUser/1")
                .param("name","测试终极大师")
                .param("age","30");

        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));


        // 5、get一个id为1的user
        request = get("/users/getUser/1");

        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
    }


    /**
     * get一个id为1的user
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUserByIdController() throws Exception {

        // 6、del删除id为1的user
        request = delete("/users/deleteUser/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

    }


    /**
     * 执行testDeleteUserByIdController()方法后使用
     *
     * @throws Exception
     */
    @Test
    public void testGetUserListNUllController() throws Exception {

        // 7、get查一下user列表，应该为空
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testALLController() throws Exception {

        // 1、get查一下user列表，应该为空
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        request = post("/users/postUser")
                .param("id","1")
                .param("name","测试大师")
                .param("age","20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));


        // 4、put修改id为1的user
        request = put("/users/putUser/1")
                .param("name","测试终极大师")
                .param("age","30");

        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));


        // 5、get一个id为1的user
        request = get("/users/getUser/1");

        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        request = delete("/users/deleteUser/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}

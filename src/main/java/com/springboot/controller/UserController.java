package com.springboot.controller;

import com.springboot.pojo.UserDemo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by liuya
 *
 * @author: liuya
 * Date: 2018/5/15
 * Time:  16:30
 * projectName:baseone
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    /**
     * 创建线程安全的Map
     */
    static Map<Long, UserDemo> userDemoMap = Collections.synchronizedMap(new HashMap<>());


    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<UserDemo> getUserList() {

        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<UserDemo> r = new ArrayList<UserDemo>(userDemoMap.values());

        return r;
    }

    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public String postUser(@ModelAttribute UserDemo userDemo) {

        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数

        userDemoMap.put(userDemo.getId(),userDemo);

        return "success";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public UserDemo getUser(@PathVariable Long id) {

        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userDemoMap.get(id);
    }

    @RequestMapping(value = "/putUser/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute UserDemo user) {

        // 处理"/users/{id}"的PUT请求，用来更新User信息
        UserDemo u = userDemoMap.get(id);

        u.setName(user.getName());
        u.setAge(user.getAge());

        userDemoMap.put(id,u);


        return "success";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        userDemoMap.remove(id);
        return "success";
    }


    public static Long getLongID() {
        long[] a = new long[4];
        Random r = new Random();
        Arrays.setAll(a,i -> r.nextLong());

        return a[1];
    }
}

package com.lds.springbootdemo;

import com.lds.springbootdemo.domain.sbd_user;
import org.json.JSONArray;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
@RunWith(SpringRunner.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@SpringBootTest(classes = com.lds.springbootdemo.SpringBootDemoApplication.class)
public class SpringBootDemoApplicationTests {
    //MockMvc 用于向 controller 接口发起模拟请求
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //@BeforeClass：针对所有测试，只执行一次，且必须为static void
    @BeforeClass
    public static void beforeClass() {
    }
    //@Before 初始化方法，执行当前测试类的每个测试方法前执行。
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  //初始化MockMvc对象
    }

    //@Test 标记当前方法是需要执行的测试用例
    @Test
    public void contextLoads() throws Exception {

        /**
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值,params表示传入多个参数
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */

        MultiValueMap<String,String> params=new LinkedMultiValueMap();
        params.add("account","admin");
        params.add("password","admin");
        MvcResult mvcResult =mockMvc.perform(MockMvcRequestBuilders.get("/login/loginValidate")
                //.param("account","admin")
                .params(params)
                .accept(MediaType.APPLICATION_JSON))
                //期待返回状态码200
                //.andExpect(MockMvcResultMatchers.status().isOk())
                //期待返回的为string并且等于Hello Spring boot!
                //.andExpect(MockMvcResultMatchers.content().string(equalTo("Hello Spring boot!")))
                //打印出请求和相应的内容
                //.andDo(MockMvcResultHandlers.print())
                //将相应的数据转换为字符串;
                .andReturn();
        int status=mvcResult.getResponse().getStatus();                 //得到返回代码
        String content = mvcResult.getResponse().getContentAsString();  //得到返回结果
        //Assert.assertEquals(200,status);                      //断言，判断返回代码是否正确
        //Assert.assertEquals("LDS Say:Hello Spring boot!",content);          //断言，判断返回的值是否正确
        System.out.println("--------返回的数据 = " + content);
    }
    //释放资源，执行当前测试类的每个测试方法后执行
    @After
    public void after(){
    }
    //@AfterClass：针对所有测试，只执行一次，且必须为static void
    @AfterClass
    public static void afterClass() {
    }
}
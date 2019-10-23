package com.lds.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
/*直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，麻烦
  所以可以通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
 */
//注释掉
//@MapperScan("com.lds.springbootdemo.mapper")
// 用来指定配置文件的位置
@PropertySource(value={"classpath:config.properties"})
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

package top.blid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launch{

    public static void main(String[] args){
        SpringApplication.run(Launch.class,args);
        System.out.println("--应用已成功启动--");
    }
}
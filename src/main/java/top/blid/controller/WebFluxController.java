package top.blid.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.blid.bean.User;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/***
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 0:08
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("/user")
public class WebFluxController{

    /**
     * 采用Flux或Mono都能实现响应式或stream流式模型,Flux<T>适用于返回List
     * http://127.0.0.1:8280/user/list
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/6/11 0:23
    */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getList(){
        final List<User> list = new ArrayList();
        for(int i = 0; i < 5; i++){
            list.add(new User(1000+i,"田应平"+i));
        }
        return Flux.fromIterable(list).delayElements(Duration.ofSeconds(1));
    }

    /**
     * 采用Flux或Mono都能实现响应式或stream流式模型,Mono<T>适用于返回单个对象
     * @访问 http://127.0.0.1:8280/user/user
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/6/11 0:23
    */
    @GetMapping("/user")
    public Mono<User> user(){
        return Mono.just(new User(1024,"田卓智"));
    }

}
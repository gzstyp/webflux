package cloud.dwz.controller;

import cloud.dwz.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class WebFluxController{

    /**
     * 采用Flux或Mono都能实现响应式或stream流式模型,Flux<T>适用于返回List,IE8出现下载
     * http://127.0.0.1:8280/user/list
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/6/11 0:23
    */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getList(){
        final List<User> list = new ArrayList<User>(5);
        for(int i = 0; i < 5; i++){
            list.add(new User(1000+i,"田应平"+i));
        }
        return Flux.fromIterable(list).delayElements(Duration.ofSeconds(1));//每隔1秒杀推送数据
    }

    /**
     * 采用Flux或Mono都能实现响应式或stream流式模型,Mono<T>适用于返回单个对象,IE8出现下载
     * @url <url>http://127.0.0.1:8280/user/get</url>
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/6/11 0:23
    */
    @GetMapping("/get")
    public Mono<User> get(){
        return Mono.justOrEmpty(new User(1024,"田卓智"));
    }
}
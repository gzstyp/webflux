package top.blid.bean;

import java.math.BigInteger;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 0:16
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
public class User{

    private Integer id;

    private String name;

    public User(){}

    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
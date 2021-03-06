package com.dytian.controller;


import com.dytian.aspect.SysLog;
import com.dytian.cache.DataObject;
import com.dytian.entity.User_account;
import com.dytian.idGenerater.IdGenerater;
import com.dytian.mapper.User_accountMapper;
import com.dytian.rabbitmq.Book;
import com.dytian.service.IUser_accountService;
import com.dytian.service.IdGenerator;
import com.dytian.spring.dytianboot.config.RabbitConfig;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nutz.json.Json;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;



/**
 * <p>
 * 用户通行证 前端控制器
 * </p>
 *
 * @author dytian
 * @since 2018-09-05
 */
@Controller
@RequestMapping("/dytian/user_account")
@Slf4j
@Api(tags = "用户API")
public class User_accountController {

    @Autowired
    IUser_accountService iUser_accountService;


    @Autowired
    IdGenerater idGenerater;


    @GetMapping("/idGenerator")
    @ResponseBody
    public Object idGenerator() throws InterruptedException {

        long startTime = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("11111111111111111111111111");
                for (int i = 0;i < 100000;i++){
                    int finalI = i;
                    long generator = idGenerater.generator();
                    if (finalI > 99995){
                        System.out.println("i=================="+i);
                        System.out.println("id================="+generator);
                   }
                }
                latch.countDown();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("222222222222222222222222222");
                for (int i = 0;i < 100000;i++){

                    int finalI = i;
                    long generator = idGenerater.generator();
                    if (finalI > 99995){
                        System.out.println("i=================="+i);
                        System.out.println("id================="+generator);
                    }
                }
                latch.countDown();
            }
        }).start();

        latch.await();
        long span = System.currentTimeMillis() - startTime;
        System.out.println("十万次消耗时间==="+span);

        return span;

    }




    @ApiOperation(value = "用户查询")
    @GetMapping("/hello")
    @ResponseBody
    public Object hello() {
        System.out.println("hello world to do things ok;");
        System.out.println("hello world to do things ok;");
        System.out.println("hello world to do things ok;");
        return iUser_accountService.getAllAccounts();
    }


    @ApiOperation(value = "分页查询")
    @GetMapping("/page/{pageNumber}")
    @ResponseBody
    public Object page(@PathVariable("pageNumber") Integer pageNumber, @RequestParam(defaultValue = "3") int pageSize ) {
        log.info("pageNumber==="+pageNumber);
        log.info("pageSize==="+pageSize);
        return null;
    }

    @ApiOperation(value = "数据更新")
    @Transactional
    @GetMapping("/update")
    @ResponseBody
    public Object updateUser() {
        User_account user_account = new User_account();
        user_account.setUser_id(177);
        user_account.setUser_phone("test");
        user_account.setUser_email("tiandeyang52@163.com");
      //  iUser_accountService.updateById(user_account);
        if (1 == 1){
            throw new IllegalArgumentException("the phone format is not correct");
        }
        return "ok";
    }


    @ApiOperation(value = "Aop aspect 测试")
    @GetMapping("/aspect/test")
    @ResponseBody
    @SysLog("aspect 日志测试")
    public Object aspecttest(@RequestParam String name) {
        System.out.println("what happend to you");
        return name;
    }



    //@Autowired
    //private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @ApiOperation(value = "redis测试-赋值")
    @GetMapping("/setredis/{value}")
    @ResponseBody
    public Object redistest(@PathVariable("value") String value){
       redisTemplate.opsForValue().set("testkey",value);




        return "success";
    }



    @ApiOperation(value = "redis取值测试")
    @GetMapping("/getredis")
    @ResponseBody
    public Object fromredis(){
        String testkey = redisTemplate.opsForValue().get("testkey").toString();

        // 斐波那契 数列
        redisTemplate.opsForZSet().add("orders",1,1);
        redisTemplate.opsForZSet().add("orders",3,3);
        redisTemplate.opsForZSet().add("orders",2,2);



        Set orders = redisTemplate.opsForZSet().rangeByScore("orders", 1, 4);

        System.out.println("orders==="+Json.toJson(orders));
        Set<Integer> orders1 = redisTemplate.opsForZSet().reverseRangeByScore("orders", 1, 4);
        System.out.println("reverse_orders====="+Json.toJson(orders1));

        Set<ZSetOperations.TypedTuple<Integer>> orders2 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("orders", 1, 4);
        System.out.println("reverse_orders_with_scores=="+Json.toJson(orders2));

        // haiyoushui

        return testkey;
    }


    @ApiOperation(value = "chacehable测试")
    @GetMapping("/cacheable/{user_id}")
    @ResponseBody
    @Cacheable(value = "user")
    public Object cacheabletest(@PathVariable("user_id") Integer user_id){
       // EntityWrapper<User_account> where = new EntityWrapper<>();
      //  where.eq("user_id",user_id);
       // log.info("数据库获取数据");
     //   return iUser_accountService.selectOne(where);
        return null;
    }


    @ApiOperation(value = "用户删除操作")
    @ApiImplicitParam(name = "user_id",required = true,value = "查询ID")
    @GetMapping("/delete/{user_id}")
    @CacheEvict(value = "user")
    @ResponseBody
    public Object pageCondition(@PathVariable("user_id") Integer user_id ) {
        log.info(String.format("id=%d",user_id));
        iUser_accountService.deleteById(user_id);
        return "success";
    }




    @Autowired
    private AmqpTemplate amqpTemplate;

  //  @Autowired
    RabbitTemplate rabbitTemplate;




    @ApiOperation(value = "rabbit 发送消息")
    @GetMapping("/rabbit/send/{message}")
    @ResponseBody
    public String rabbitTest(@PathVariable("message") String message){
      //  log.info("send message====="+message);
     //   amqpTemplate.convertAndSend("dytian",message);

        Book book = new Book();
        book.setId("1");
        book.setName("一起来学Spring Boot");
        this.rabbitTemplate.convertAndSend(RabbitConfig.DEFAULT_BOOK_QUEUE, book);
        this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_BOOK_QUEUE, book);

        return "发送成功！";
    }

    @ApiOperation(value = "rabbit 延迟消息 发送消息")
    @GetMapping("/rabbit/send")
    @ResponseBody
    public String rabbitDelayTest(){

        Book book = new Book();
        book.setId("1");
        book.setName("一起来学Spring Boot");
        // 添加延时队列
        this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book, message -> {
            // TODO 第一句是可要可不要,根据自己需要自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
            // TODO 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(20 * 1000 + "");
            return message;
        });
        log.info("[发送时间] - [{}]", LocalDateTime.now());

        return "ok";

    }



    @Resource(name = "consumerQueueThreadPool")
    private ExecutorService consumeQueueThreadPool;


    @ApiOperation(value = "线程池")
    @GetMapping("/thread/pool")
    @ResponseBody
    public String threadpool(){
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {


                System.out.println("线程池运行中哦");
            }
        });

        for (int i =0; i < 10 ;i++){
            consumeQueueThreadPool.execute(worker);
        }
        return "发送成功！";
    }


    Cache<String, DataObject> cache = Caffeine.newBuilder().build();

    @ApiOperation(value = " 添加 Caffeine 缓存")
    @GetMapping("/caffeine")
    @ResponseBody
    public String caffeine(){
        String key = "A";
        cache.put(key,DataObject.get("Data For A"));
     //   cache.invalidate(key);
        return "发送成功！";
    }

    @ApiOperation(value = "获取 Caffeine 缓存")
    @GetMapping("/caffeinefrom")
    @ResponseBody
    public String fromcaffeine(){
        String key = "A";
        DataObject dataObject = cache.get(key,  k -> DataObject.get("Data for A"));
        log.info(Json.toJson(dataObject));
        //   cache.invalidate(key);
        return "发送成功！";
    }


    @ApiOperation(value = "清除 Caffeine 缓存")
    @GetMapping("/caffeinerem")
    @ResponseBody
    public String remcaffeine(){

        String key = "A";
           cache.invalidate(key);
        return "发送成功！";
    }


    @ApiOperation(value = "guava")
    @GetMapping("/guava")
    @ResponseBody
    public String guava(){
        String a = null;
        Preconditions.checkNotNull(a);
        return "发送成功！";
    }












}


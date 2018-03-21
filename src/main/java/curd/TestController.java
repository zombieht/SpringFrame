package curd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping(value = "/api")
@RestController
@EnableAutoConfiguration
public class TestController {
    @Autowired
    TestDto testCurd;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/select")
    public List<TestEntity> selectAll() {
        return testCurd.findAll();
    }

    @RequestMapping("/add")
    public String addAccount(Integer id, String book) {
        TestEntity test = new TestEntity(id, book);
        testCurd.save(test);
        return "success";
    }

    @RequestMapping("/delete")
    public String deleteAccount(@RequestParam("id") int id) {
        testCurd.delete(id);
        return "success";
    }

    @RequestMapping("/update")
    public TestEntity testUpdate(@RequestParam("id") int id, @RequestParam("book") String book) {
        TestEntity test = new TestEntity();
        test.setId(id);
        test.setBook(book);
        return testCurd.save(test);
    }

    @GetMapping(value = "/read/{id}")
    public TestEntity FindOne(@PathVariable("id") Integer id) {
        return testCurd.findOne(id);
    }

    @RequestMapping(value = "/read")
    public TestEntity FindOne2(@RequestParam("id") Integer id) {
        return testCurd.findOne(id);
    }


    @RequestMapping("/getUser/{id}")
    @Cacheable(value = "user-key")
    public TestEntity getUser(@PathVariable("id") Integer id) {
//        String key = "1";
//        ValueOperations<String, TestEntity> operations = redisTemplate.opsForValue();
//        boolean hasKey = redisTemplate.hasKey(key);
//
//        if (hasKey) {
//            TestEntity user = operations.get(key);
//
//            return user;
//        }
//
//        TestEntity user = testCurd.findOne(1);
//
//        // 插入缓存
//        operations.set(key, user, 1000000, TimeUnit.SECONDS);
//
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
//        return user;
        TestEntity user = testCurd.findOne(id);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}

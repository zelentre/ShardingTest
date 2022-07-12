package com.zne;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zne.entity.User;
import com.zne.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class ShardingTestApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            // 测试手动输入ID
            // userMapper.insert(new User((long) i, "XX", "233"));
            // 测试自动生成ID
            userMapper.insert(new User("SNOWFLAKE", "233"));
        }
    }

    @Test
    void selectUserList() {
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().between(User::getId,2L,5L));
        log.info("users:{}", users);
    }

}

package com.zne.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zne.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ZNE
 * @since 2022/7/11
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

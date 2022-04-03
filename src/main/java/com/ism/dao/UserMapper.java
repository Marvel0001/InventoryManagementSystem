package com.ism.dao;

import com.ism.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByUserid(String userid);
}

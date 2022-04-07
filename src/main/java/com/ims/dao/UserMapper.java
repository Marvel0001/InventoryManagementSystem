package com.ims.dao;

import com.ims.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByUserid(String userid);

    User selectUserByUsername(String username);
}

package com.biz.user;

import com.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by Administrator on 2016/5/17.
 */
@Transactional
public interface InfUserBiz {
    List login (UserEntity condition);
    boolean register(UserEntity condition);


}

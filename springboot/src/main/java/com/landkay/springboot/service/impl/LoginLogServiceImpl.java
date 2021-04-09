package com.landkay.springboot.service.impl;

import com.landkay.springboot.entity.LoginLog;
import com.landkay.springboot.mapper.LoginLogMapper;
import com.landkay.springboot.service.ILoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alice
 * @since 2021-04-09
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}

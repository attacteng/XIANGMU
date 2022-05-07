package com.example.xq.service.impl;

import com.example.xq.entity.Admin;
import com.example.xq.mapper.AdminMapper;
import com.example.xq.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xq
 * @since 2020-11-20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}

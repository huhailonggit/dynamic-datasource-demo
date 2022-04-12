package vip.huhailong.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.demo.entity.Test;
import vip.huhailong.demo.mapper.TestMapper;
import vip.huhailong.demo.service.ITestService;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
}

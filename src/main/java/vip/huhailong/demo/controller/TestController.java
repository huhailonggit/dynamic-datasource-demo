package vip.huhailong.demo.controller;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.demo.entity.DataSourceDTO;
import vip.huhailong.demo.entity.Test;
import vip.huhailong.demo.service.ITestService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DefaultDataSourceCreator defaultDataSourceCreator;

    @Autowired
    ITestService testService;

    @GetMapping("/get1")
    public List<Test> test1(){
        return testService.list();
    }

    @DS("test")
    @GetMapping("/get2")
    public List<Test> test2(){
        return testService.list();
    }

    @GetMapping("/now")
    public Set<String> now(){
        DynamicRoutingDataSource source = (DynamicRoutingDataSource) dataSource;
        return source.getDataSources().keySet();
    }

    @PostMapping("/addSource")
    public Set<String> addSource(@RequestBody DataSourceDTO dto){
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        BeanUtils.copyProperties(dto,dataSourceProperty);
        DynamicRoutingDataSource source = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = defaultDataSourceCreator.createDataSource(dataSourceProperty);
        source.addDataSource(dto.getPoolName(),dataSource);
        return source.getDataSources().keySet();
    }

    @DeleteMapping("/remove")
    public String removeDataSource(String name){
        DynamicRoutingDataSource source = (DynamicRoutingDataSource) dataSource;
        source.removeDataSource(name);
        return "删除成功";
    }
}

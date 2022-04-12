package vip.huhailong.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class Test {

    private Integer id;
    private String name;
}

package vip.huhailong.demo.entity;

import lombok.Data;

@Data
public class DataSourceDTO {
    private String poolName;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}

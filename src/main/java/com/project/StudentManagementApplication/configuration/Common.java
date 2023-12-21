package com.project.StudentManagementApplication.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Common {

    @Value("${myapp.title}")
    public String title;
    @Value("${myapp.version}")
    public String version;
    @Value("${myapp.build}")
    public String build;

}

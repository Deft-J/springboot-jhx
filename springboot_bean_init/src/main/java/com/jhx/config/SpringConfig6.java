package com.jhx.config;

import com.jhx.bean.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = "com.jhx")
@Import(MyImportSelector.class)
public class SpringConfig6 {
}

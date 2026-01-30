package com.jhx.config;

import com.jhx.bean.MyPostProcessor;
import com.jhx.bean.MyRegistrar;
import com.jhx.bean.MyRegistrar2;
import com.jhx.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

@Import({BookServiceImpl1.class, MyPostProcessor.class, MyRegistrar2.class, MyRegistrar.class})
public class SpringConfig8 {
}

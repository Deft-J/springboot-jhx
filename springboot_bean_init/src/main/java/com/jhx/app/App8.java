package com.jhx.app;

import com.jhx.bean.service.BookSerivce;
import com.jhx.config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App8 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookSerivce bookService = ctx.getBean("bookService", BookSerivce.class);
        bookService.check();
    }
}

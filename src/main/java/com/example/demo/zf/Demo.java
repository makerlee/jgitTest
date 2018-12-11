package com.example.demo.zf;

public class Demo {

    public static void main(String[] args) {
        PageBean pageBean  = new PageBean(3,2 ,7 );
        Integer startIndex = pageBean.getStartIndex();
        System.out.println(startIndex);
    }
}

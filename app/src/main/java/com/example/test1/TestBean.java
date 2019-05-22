package com.example.test1;

public class TestBean {
    private String name;
    private int age;

    public TestBean() {}

    private TestBean(String name){
        this.name = name;
    }

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setMName(String name) {
        this.name = name;
    }

    private void setNameAndAge(String name, int age) {
        this.age = age;
        this.name = name;
    }

    private void testUpload(){

    }
}

package com.rosszhang.javaallinone.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream {
    static class Person {
        private String name;
        private String phoneNumber;
        // getters and setters


        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


    public static void main(String[] args) {
        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack","18163138123"));
        bookList.add(new Person("martin",null));
        // 空指针异常
//        bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber, (v1, v2) -> v1));
        Map<Object, Object> objectObjectMap = Map.of(null, null);
        System.out.println(objectObjectMap);
    }
}

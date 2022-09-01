package com.hand.study;
import java.util.Date;
import com.google.common.collect.Maps;
import io.choerodon.mybatis.domain.AuditDomain.RecordStatus;

import com.alibaba.fastjson.JSONArray;
import com.hand.study.domain.entity.Employee;
import org.apache.avro.data.Json;
import org.apache.poi.hpsf.Decimal;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 练习
 * @date: 2022/8/31 10:25
 */
public class testJava8 {
    static List<Person> personList = new ArrayList<Person>();
    private static void initPerson(){
        Employee employee = new Employee();

        personList.add(new Person(1,"张三",8,12000));
        personList.add(new Person(2,"李四",18,8000));
        personList.add(new Person(3,"王五",28,6000));
        personList.add(new Person(4,"赵六",38,4000));
    }
    public static void main(String[] args) {
        initPerson();
        List<Person> people = personList.stream().filter(person -> person.getPersonId() > 1).collect(Collectors.toList());
        System.out.println("=============" + personList.toString());
        System.out.println(JSONArray.toJSONString(people));
    }
}
class Person{
    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }

    private int personId;
    private String name;
    private int age;
    private int amount;

    public Person(int personId, String name, int age, int amount) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.amount = amount;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
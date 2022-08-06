package com.rakib;

public class Employee {
    private int id;
    private String name;
    private String city;
    private String birthday;

    public Employee(String name, String city, String birthday) {
        this.name = name;
        this.city = city;
        this.birthday = birthday;
    }

    public Employee() {
    }

    public Employee(int id, String name, String city, String birthday) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

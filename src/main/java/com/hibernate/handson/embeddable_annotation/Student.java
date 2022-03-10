package com.hibernate.handson.embeddable_annotation;

import javax.persistence.*;

@Entity(name = "student_certificate")
@Table(name = "student_certificate")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String city;
    @AttributeOverrides({
            @AttributeOverride(name = "course", column = @Column(name = "course_name")),
            @AttributeOverride(name = "duration", column = @Column(name = "course_duration")),
    })
    private Certificate certi;

    public Student(int id, String name, String city, Certificate certi) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.certi = certi;
    }

    public Student() {
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

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", certi=" + certi +
                '}';
    }
}

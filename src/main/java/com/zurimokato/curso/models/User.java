package com.zurimokato.curso.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
    @Id
    @Getter @Setter @Column(name="id")
    private long id;
    @Getter @Setter @Column(name="name")
    private String name;
    @Getter @Setter @Column(name="lastname")
    private String lastName;
    @Getter @Setter @Column(name="email")
    private String email;
    @Getter @Setter @Column(name="phone")
    private String phone;
    @Getter @Setter @Column(name="password")
    private  String password;


    public User(){

    }

    public User(String name,String lastName, long id, String email){
        this.name=name;
        this.lastName=lastName;
        this.id=id;
        this.email=email;
    }


}

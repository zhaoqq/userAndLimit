package com.entity;

import java.util.*;
//import org.hibernate.annotations.*;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 * Created by Administrator on 2017/7/8.
 */
@Entity
@Table (name = "user", schema = "distplatform")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private Integer level;
    private String email;
    private String comment;

//    private Set<Role_UserEntity> sets = new HashSet<>();

    public UserEntity(){}
    public UserEntity(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Id
    //@Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

//    @OneToMany(targetEntity=Role_UserEntity.class,cascade=CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="id",updatable=false)//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
//    public Set<Role_UserEntity> getSets() {
//        return sets;
//    }
//    public void setSets(Set<Role_UserEntity> sets) {
//        this.sets = sets;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = "id=" + this.id + ",username=" + this.username + ",password=" + this.password
                + ",level=" + this.level + ",email=" + this.email + ",comment=" + this.comment;
        return str;
    }
}

package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_user", schema = "distplatform")
public class Role_UserEntity {
    private int id;
    private int role_id;
    private int user_id;

    private RoleEntity role;
    private UserEntity user;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role_id")
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


//    @ManyToOne(targetEntity = UserEntity.class)
//    @JoinColumn(name="user_id",updatable=false)
//    public UserEntity getUser() {
//        return user;
//    }
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    @ManyToOne(targetEntity = RoleEntity.class)
//    @JoinColumn(name="role_id",updatable=false)
//    public RoleEntity getRole() {
//        return role;
//    }
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }

}

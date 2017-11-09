package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_access", schema = "distplatform")
public class Role_AccessEntity {
    private int id;
//    private int role_id;
//    private int access_id;
    private RoleEntity role;
    private AccessEntity access;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

//    cascade=CascadeType.REMOVE,
    @ManyToOne(targetEntity = RoleEntity.class , fetch=FetchType.LAZY)
    @JoinColumn(name = "role_id")
    public RoleEntity getRole() {
        return role;
    }
    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @ManyToOne(targetEntity = AccessEntity.class,fetch=FetchType.LAZY)//cascade=CascadeType.REMOVE,
    @JoinColumn(name = "access_id")
    public AccessEntity getAccess() {
        return access;
    }
    public void setAccess(AccessEntity access) {
        this.access = access;
    }

    @Override
    public String toString() {
        String str = "id:"+this.getId()+"\naccess_id:"+this.getAccess().getId()+"\nrole_id"+this.getRole().getId();
        return str;
    }

    //    @Column(name = "role_id")
//    public int getRole_id() {
//        return role_id;
//    }
//    public void setRole_id(int role_id) {
//        this.role_id = role_id;
//    }
//
//    @Column(name = "access_id")
//    public int getAccess_id() {
//        return access_id;
//    }
//    public void setAccess_id(int access_id) {
//        this.access_id = access_id;
//    }

}

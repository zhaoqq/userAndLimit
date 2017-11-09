package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_menu", schema = "distplatform")
public class Role_MenuEntity {
    private int id;
    private int role_id;
    private int menu_id;

//    private RoleEntity role;
//    private MenuEntity menu;


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

    @Column(name = "menu_id")
    public int getMenu_id() {
        return menu_id;
    }
    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

//    @ManyToOne(targetEntity = MenuEntity.class)
//    @JoinColumn(name="menu_id",updatable=false)
//    public MenuEntity getMenu() {
//        return menu;
//    }
//    public void setMenu(MenuEntity menu) {
//        this.menu = menu;
//    }
//
//    @ManyToOne(targetEntity = RoleEntity.class)
//    @JoinColumn(name="role_id",updatable=false )
//    public RoleEntity getRole() {
//        return role;
//    }
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }
}

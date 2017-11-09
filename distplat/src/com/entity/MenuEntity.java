package com.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu", schema = "distplatform")
public class MenuEntity {
    private int id;
    private int item_id;
    private int parent_id;
    private String menu_name;
    private int level;

//    private Set<Role_MenuEntity> sets = new HashSet<>();


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "item_id", nullable = false)
    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    @Column(name = "parent_id", nullable = false)
    public int getParent_id() {
        return parent_id;
    }
    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Column(name = "menu_name", unique = true, nullable = false, length = 255)
    public String getMenu_name() {
        return menu_name;
    }
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    //与Role_menuEntity的一对多关系
//    @OneToMany(targetEntity=Role_MenuEntity.class,cascade=javax.persistence.CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="id",updatable=false)//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
//    public Set<Role_MenuEntity> getSets() {
//        return sets;
//    }
//    public void setSets(Set<Role_MenuEntity> sets) {
//        this.sets = sets;
//    }
}

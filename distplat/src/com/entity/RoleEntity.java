package com.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;

@Entity
@Table(name = "role", schema = "distplatform")
public class RoleEntity {
    private int id;
    private String name;
    private String comment;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "rolename", nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name ="comment")
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

//    private Set<Role_UserEntity> sets = new HashSet<>();
//    //与Role_userEntity的一对多关系
//    @OneToMany(targetEntity=Role_UserEntity.class,cascade=CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="id",updatable=false)//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
//    public Set<Role_UserEntity> getSets() {
//        return sets;
//    }
//    public void setSets(Set<Role_UserEntity> sets) {
//        this.sets = sets;
//    }
//
//    private Set<Role_AccessEntity> sets1 = new HashSet<>();
//    //与Role_accessEntity的一对多关系
//    @OneToMany(targetEntity = Role_AccessEntity.class,cascade=CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="role_id",updatable=false)//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
//    public Set<Role_AccessEntity> getSets1() {
//        return sets1;
//    }
//    public void setSets1(Set<Role_AccessEntity> sets1) {
//        this.sets1 = sets1;
//    }
//
//    private Set<Role_MenuEntity> sets2 = new HashSet<>();
//    //与MenuEntity的一对多关系
//    @OneToMany(targetEntity = Role_MenuEntity.class,cascade=CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="id",updatable=false)//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
//    public Set<Role_MenuEntity> getSets2() {
//        return sets2;
//    }
//    public void setSets2(Set<Role_MenuEntity> sets2) {
//        this.sets2 = sets2;
//    }

    public String toString() {
        String str = "id:"+this.getId()+"\nname:"+this.getName()+"\ncomment:s"+this.getComment();//+"\nsize:"+this.getSets1().size();
        return str;
    }



}

package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "access", schema = "distplatform")
public class AccessEntity {
    private int id;
    private String name;
//    private int data_id;
//    private int algo_id;
    private String type;
    private String limits;//CRUD操作
    private String comment;

//    private RoleEntity role;
    private DatasetEntity data;
    private AlgorithmEntity algo;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", length = 255, nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


//    @Column(name = "data_id")
//    public int getData_id() {
//        return data_id;
//    }
//    public void setData_id(int data_id) {
//        this.data_id = data_id;
//    }
//
//    @Column(name = "algo_id")
//    public int getAlgo_id() {
//        return algo_id;
//    }
//    public void setAlgo_id(int algo_id) {
//        this.algo_id = algo_id;
//    }

    @Column(name = "type", nullable = false, length = 4)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "limits",nullable = false ,length = 9)
    public String getLimits() {
        return limits;
    }
    public void setLimits(String limits) {
        this.limits = limits;
    }

    @Column(name = "comment", length = 255)
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

//    @ManyToOne(targetEntity = RoleEntity.class,cascade=CascadeType.REMOVE)
//    @JoinColumn(name="role_id")
//    public RoleEntity getRole() {
//        return role;
//    }
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }

    @ManyToOne(targetEntity = DatasetEntity.class,cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JoinColumn(name="data_id")
    public DatasetEntity getData() {
        return data;
    }
    public void setData(DatasetEntity data) {
        this.data = data;
    }

    @ManyToOne(targetEntity = AlgorithmEntity.class,cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JoinColumn(name="algo_id")
    public AlgorithmEntity getAlgo() {
        return algo;
    }
    public void setAlgo(AlgorithmEntity algo) {
        this.algo = algo;
    }


    @Override
    public String toString() {
        String str = "id=" + this.id + "\nname=" + this.name + "\ncomment=" + this.comment + "\nlimits=" + this.limits
                + "\ntype=" + this.type + "\ndata=" + this.data + "\nalgo=" + this.algo;
        return str;
    }
}

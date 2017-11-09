package com.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Benliang on 2017/8/13.
 */
@Entity
@Table(name = "dataset", schema = "distplatform")
public class DatasetEntity {
    private int id;
    private String name;
    private String filepath;
    private String description;
    private String event;

//    private Set<Role_AccessEntity> sets = new HashSet<>();


    public DatasetEntity(){}
    public DatasetEntity(String name, String filepath, String description, String event) {
        this.name = name;
        this.filepath = filepath;
        this.description = description;
        this.event = event;
    }


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "filepath", nullable = false, length = 255)
    public String getFilepath() {
        return filepath;
    }
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "event", nullable = false, length = 255)
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }


//    @OneToMany(targetEntity = Role_AccessEntity.class,cascade=CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name="id",updatable=false)
//    public Set<Role_AccessEntity> getSets() {
//        return sets;
//    }
//    public void setSets(Set<Role_AccessEntity> sets) {
//        this.sets = sets;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatasetEntity that = (DatasetEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (filepath != null ? !filepath.equals(that.filepath) : that.filepath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filepath != null ? filepath.hashCode() : 0);
        return result;
    }

}

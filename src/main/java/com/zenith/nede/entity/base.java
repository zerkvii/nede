package com.zenith.nede.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

@MappedSuperclass
public class base implements Comparable<base>,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private ZonedDateTime createdAT;

    @Column(nullable = false)
    private ZonedDateTime updatedAT;

    @PrePersist
    public void prePersist(){
        createdAT=updatedAT=ZonedDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAT=ZonedDateTime.now();
    }

    @Override
    public int compareTo(base o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof base)) return false;
        base base = (base) o;
        return Objects.equals(getId(), base.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
        /*return new HashCodeBuilder().append(getId()).toHashCode();
            reflective way to get hashcode();
            */
    }

    //setter&getter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAT(ZonedDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public void setUpdatedAT(ZonedDateTime updatedAT) {
        this.updatedAT = updatedAT;
    }

    public ZonedDateTime getCreatedAT() {
        return createdAT;
    }

    public ZonedDateTime getUpdatedAT() {
        return updatedAT;
    }

}

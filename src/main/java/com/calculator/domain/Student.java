package com.calculator.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 2:07
 */
@Data
@Entity
@RestResource(rel = "students",path = "students")
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Date createdAt;

    @NotNull
    @Size(min = 5,message = "student's name should be more than one word")
    private String name;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }


    @ManyToOne
    private User user;




//    public Long getId() {
//        return this.id;
//    }
//
//    public Date getCreatedAt() {
//        return this.createdAt;
//    }
//
//    public @NotNull @Size(min = 5, message = "Name must be at least 2 characters long") String getName() {
//        return this.name;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setName(@NotNull @Size(min = 5, message = "Name must be at least 5 characters long") String name) {
//        this.name = name;
//    }

//    public boolean equals(final Object o) {
//        if (o == this) return true;
//        if (!(o instanceof Student)) return false;
//        final Student other = (Student) o;
//        if (!other.canEqual((Object) this)) return false;
//        final Object this$id = this.getId();
//        final Object other$id = other.getId();
//        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
//        final Object this$createdAt = this.getCreatedAt();
//        final Object other$createdAt = other.getCreatedAt();
//        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
//        final Object this$name = this.getName();
//        final Object other$name = other.getName();
//        return this$name == null ? other$name == null : this$name.equals(other$name);
//    }
//
//    protected boolean canEqual(final Object other) {
//        return other instanceof Student;
//    }
//
//    public int hashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        final Object $id = this.getId();
//        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
//        final Object $createdAt = this.getCreatedAt();
//        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
//        final Object $name = this.getName();
//        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        return result;
//    }
//
//    public String toString() {
//        return "Taco(id=" + this.getId() + ", createdAt=" + this.getCreatedAt() + ", name=" + this.getName() + ", ingredients=" ;
//    }
}

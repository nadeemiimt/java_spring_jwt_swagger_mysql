package com.my.learning.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_role")
@Setter
@Getter
@AllArgsConstructor()
@Data
@ToString
@DynamicUpdate
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable=false, updatable=false)
    private String name;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = User.class, mappedBy = "roles", cascade = CascadeType.ALL)
    private List<User> users;

    public Role() {

    }
}
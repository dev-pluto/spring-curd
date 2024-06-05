package com.techindeck.master.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "constituent_roles")
public class ConstituentRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "`name`")
    private String name;

    @OneToMany(mappedBy = "constituentRole", fetch = FetchType.LAZY)
    @Column(name = "`constituentRoleType`")
    private List<ConstituentRoleType> constituentRoleType;

    @Column(name = "`createdAt`")
	@CreationTimestamp
	private Date createdAt;

    @Column(name = "`updatedAt`")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}

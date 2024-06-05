package com.techindeck.master.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "constituent_role_types")
public class ConstituentRoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "`name`")
    private String name;



    @ManyToOne
    @JoinColumn(name = "constituent_role_id")
    private ConstituentRole constituentRole;

    @Column(name = "`createdAt`")
	@CreationTimestamp
	private Date createdAt;

    @Column(name = "`updatedAt`")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}

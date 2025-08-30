package com.JobHorbour.JobHorbour.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Applications")
public class Applications {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", referencedColumnName = "id", nullable = false)
    private Company company;
}

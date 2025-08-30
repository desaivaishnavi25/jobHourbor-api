package com.JobHorbour.JobHorbour.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Entity
@Data
@Table(name = "Company")
public class Company {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name="companyName")
    private String companyName;
    @Column(name="title")
    private String title;
    @Column(name="companyEmail")
    private String companyEmail;
    @Column(name="companyContactNumber")
    private String companyContactNumber;
    @Column(name="industry")
    private String industry;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="description")
    private String description;
    @Column(name="foundedYear")
    private Date foundedYear;

}

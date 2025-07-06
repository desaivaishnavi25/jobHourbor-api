package com.JobHorbour.JobHorbour.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

@Entity
@Data
@Table(name = "Profile")
public class Profile {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="contactNumber")
    private String contactNumber;
    @Column(name="experience")
    private int experience;
    @Column(name="description")
    private String description;
    @Column(name="links")
    private String links;

}

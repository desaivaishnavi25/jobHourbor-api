package com.JobHorbour.JobHorbour.Repository;

import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByEmail(String email);
    Optional<Profile> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Profile p WHERE p.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Profile p WHERE p.user.id IN (SELECT a.user.id FROM Applications a WHERE a.company.id = :companyId)")
     List<Profile> getApplicationsByCompanyId(@Param("companyId") Long CompanyId);
 }

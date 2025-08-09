package com.JobHorbour.JobHorbour.Repository;

import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCompanyEmail(String email);
    Optional<Company> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Company c WHERE c.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}

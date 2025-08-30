package com.JobHorbour.JobHorbour.Repository;

import com.JobHorbour.JobHorbour.Entity.Applications;
import com.JobHorbour.JobHorbour.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {

    @Query("SELECT a FROM Applications a WHERE a.user.id = :userId AND a.company.id = :companyId")
    Optional<Applications> findByUserIdAndCompanyId(@Param("userId") Long userId,
                                                    @Param("companyId") Long companyId);
}

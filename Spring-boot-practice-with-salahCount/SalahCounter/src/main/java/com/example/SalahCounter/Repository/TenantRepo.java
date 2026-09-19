package com.example.SalahCounter.Repository;

import com.example.SalahCounter.Entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TenantRepo
 */
public interface TenantRepo extends JpaRepository<Tenant, Integer> {
        
}

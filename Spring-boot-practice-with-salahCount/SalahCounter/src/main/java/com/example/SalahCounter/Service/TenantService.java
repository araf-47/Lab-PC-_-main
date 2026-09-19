package com.example.SalahCounter.Service;

import org.springframework.stereotype.Service;

import com.example.SalahCounter.Repository.TenantRepo;

@Service
public class TenantService {
    private final TenantRepo tenantRepo;
    
    public TenantService(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    


}

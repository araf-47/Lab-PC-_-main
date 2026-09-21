package com.example.SalahCounter.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SalahCounter.Entity.Tenant;
import com.example.SalahCounter.Repository.TenantRepo;

@Service
public class TenantService {
    private final TenantRepo tenantRepo;
    public TenantService(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    public List<Tenant> getAllTenants() {
        return tenantRepo.findAll();
    }

    public Tenant getTenantById(int id) {
        return tenantRepo.findById(id).orElse(null);
    }

    //this one can do both, insert & update.
    public Tenant createTenant(Tenant tenant) {
        return tenantRepo.save(tenant);
    }

    //updated Update method
    public Tenant updateTenantById(int id, Tenant tenant) {
        Tenant existingTenant = tenantRepo.findById(id).orElse(null);
        if (existingTenant == null) {
            return null;
        }
        
        existingTenant.setId(tenant.getId());
        existingTenant.setName(tenant.getName());
        return tenantRepo.save(existingTenant);
    }

    // public Tenant updateTenant(Tenant tenant) {
    //     return tenantRepo.save(tenant);
    // }

    public String deleteTenant(int id) {
        tenantRepo.deleteById(id);
        return "Tenant with ID no. " + id + " deleted successfully";
    }


    


}

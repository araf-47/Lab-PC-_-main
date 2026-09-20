package com.example.SalahCounter.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SalahCounter.Entity.Tenant;
import com.example.SalahCounter.Service.TenantService;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantService tenantService;
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/all")
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable int id) {
        return tenantService.getTenantById(id);
    }

    @PostMapping("/add")
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantService.createTenant(tenant);
    }
    
    @PutMapping("/update")
    public Tenant updateTenant(@RequestBody Tenant tenant) {
        return tenantService.updateTenant(tenant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTenant(@PathVariable int id) {
        return tenantService.deleteTenant(id);
    }
    


    // --- Dependencies ---
    /*
    private final TenantRepo tenantRepo;

    public TenantController(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    @GetMapping("/all")
    public List<Tenant> getAllTenants() {
        return tenantRepo.findAll();
    }

    @PostMapping("/all")
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantRepo.save(tenant);
    }

    @PutMapping("/put") 
    public Tenant updateTenant(@RequestBody Tenant tenant) {
        return tenantRepo.save(tenant);
    }
    */

    // --- CRUD Operations ---

    /**
    @GetMapping
    public String getTenant() {
        return "All tenant from LandLord API.";
    }

    @PostMapping
    public String createTenant() {
        return "Create tenant from LandLord API.";
    }

    @PutMapping
    public String updateTenant() {
        return "Update tenant from LandLord API.";
    }
    
    @DeleteMapping
    public String deleteTenant() {
        return "Delete tenant from LandLord API.";
    }

    @GetMapping("/{id}")
    public String getTenantById(@PathVariable int id) {
        if (id <= 0) {
            return "invalid id";
        } else if (id == 1){
            return "Student id: " + id + "; Name = LK John Doe";
        } else if (id == 2){
            return "Student id: " + id + "; Name = Asfakul Alam";
        } else if (id == 3){
            return "Student id: " + id + "; Name = Atiqur Rahman";
        } else if (id == 4){
            return "Student id: " + id + "; Name = Muhammad Ali";
        } else {
            return "Student not found";
        }
    }

    @GetMapping("/search")
    public String searchTenant(@RequestParam String city) {
        return "Searching for tenant in " + city;
    }

    //new
    // @GetMapping("/{id}/search")
    // public String searchTenant(@RequestParam String city) {
    //     return "Searching for tenant in " + city;
    // }
    
    List<Tenant> tenants = new ArrayList<>();

    @PostMapping("/all")
    public String getAllTenants(@RequestBody Tenant tenant) {
        tenants.add(tenant);
        return "Tenant added";
    }

    @GetMapping("/all")
    public List<Tenant> getAllTenants() {
        return tenants;
    }
    */
    
}

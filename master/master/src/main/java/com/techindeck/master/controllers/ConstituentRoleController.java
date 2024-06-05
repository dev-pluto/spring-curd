package com.techindeck.master.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techindeck.master.model.ConstituentRole;
import com.techindeck.master.services.ConstituentRoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/constituent-role")
public class ConstituentRoleController {

    private final ConstituentRoleService constituentRoleService;

    @Autowired
    public ConstituentRoleController(ConstituentRoleService constituentRoleService)
    {
        this.constituentRoleService=constituentRoleService;
    }

    @GetMapping
    public ResponseEntity<List<ConstituentRole>> getConstituentRole() {
        return constituentRoleService.getConstituentRoles();
    }

    @GetMapping(path="{constituentId}")
    public ResponseEntity<ConstituentRole> getConstituentById(@PathVariable("constituentId") Long constituentId) {
        return constituentRoleService.getConstituentRoleById(constituentId);
    }

    @PostMapping
    public ResponseEntity<String> createConstituentRole(@RequestBody ConstituentRole constituentRole) {
        return constituentRoleService.createConstituentRole(constituentRole);
    }
    
    @PutMapping(path = "{constituentId}")
    public ResponseEntity<ConstituentRole> updateConstituentRole(@PathVariable("constituentId") Long constituentId, @RequestBody ConstituentRole constituentRole) {
        return constituentRoleService.updateConstituentRole(constituentId, constituentRole);
    }
    
    @DeleteMapping(path = "{constituentId}")
    public ResponseEntity<String> deleteConstituentRole(@PathVariable("constituentId") Long constituentId) {
        return constituentRoleService.deleteConstituentRole(constituentId);
    }
    

}

package com.techindeck.master.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techindeck.master.model.ConstituentRoleType;
import com.techindeck.master.services.ConstituentRoleTypeService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/constituent-role-types")
public class ConstituentRoleTypeController {

private final ConstituentRoleTypeService constituentRoleTypeService;
public ConstituentRoleTypeController(ConstituentRoleTypeService constituentRoleTypeService){
    this.constituentRoleTypeService=constituentRoleTypeService;
}

@GetMapping
public ResponseEntity<List<ConstituentRoleType>> getAllConstituentRoleType() {
    return constituentRoleTypeService.getConstituentRoleTypes();
}

// get by id 

@GetMapping(path = "{constituentRoleTypeId}")
public ResponseEntity< ConstituentRoleType >getConstituentRoleTypeById(@PathVariable("constituentRoleTypeId") Long constituentRoleTypeId) {
    return constituentRoleTypeService.getConstituentRoleTypeById(constituentRoleTypeId);
}

@PostMapping
public ResponseEntity< String> createConstituentType(@RequestBody ConstituentRoleType constituentRoleType) {
    
    return constituentRoleTypeService.createConstituentRoleType(constituentRoleType);
}


@PutMapping(path = "{constituentRoleTypeId}")
public ResponseEntity<ConstituentRoleType >updateConstituentRoleType(@PathVariable("constituentRoleTypeId") Long constituentRoleTypeId, @RequestBody ConstituentRoleType constituentRoleType) {
    
    return constituentRoleTypeService.updateConstituentRoleType(constituentRoleTypeId, constituentRoleType);
}

@DeleteMapping(path = "{constituentRoleTypeId}")
public ResponseEntity< String> deleteConstituentRoleType(@PathVariable("constituentRoleTypeId") Long constituentRoleTypeId){
    return constituentRoleTypeService.deleteConstituentRoleType(constituentRoleTypeId);
}



}

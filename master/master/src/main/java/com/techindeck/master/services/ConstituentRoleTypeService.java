package com.techindeck.master.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techindeck.master.model.ConstituentRoleType;
import com.techindeck.master.repository.ConstituentRoleTypeRepository;

@Service
public class ConstituentRoleTypeService {
    private final ConstituentRoleTypeRepository constituentRoleTRepository;

    @Autowired
    public ConstituentRoleTypeService(ConstituentRoleTypeRepository constituentRoleTRepository) {
        this.constituentRoleTRepository = constituentRoleTRepository;
    }


    // Get All ConstituentRoleTypes
    public ResponseEntity<List<ConstituentRoleType>> getConstituentRoleTypes() {
        
        return new ResponseEntity<>(constituentRoleTRepository.findAll(), HttpStatus.OK);
    }

    // Get ConstituentRoleType By Id
    public ResponseEntity<ConstituentRoleType> getConstituentRoleTypeById(Long id) {

        try {
            if (!constituentRoleTRepository.existsById(id)) {
                throw new IllegalStateException("ConstituentRoleType with id " + id + " does not exist");
            }

            return new ResponseEntity<>(constituentRoleTRepository.findById(id).orElse(null), HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Create ConstituentRoleType
    public ResponseEntity< String> createConstituentRoleType(ConstituentRoleType constituentRoleType) {
        try {
            if (constituentRoleTRepository.existsByName(constituentRoleType.getName())) {
                throw new IllegalStateException("ConstituentRoleType already exists");
            }
            constituentRoleTRepository.save(constituentRoleType);
            return new ResponseEntity<>("ConstituentRoleType created successfully", HttpStatus.CREATED) ;
        } catch (Exception e) {
           return new ResponseEntity<>("An error occurred while creating ConstituentRoleType", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Update ConstituentRoleType
    public ResponseEntity<ConstituentRoleType> updateConstituentRoleType(Long constituentRoleTypeId, ConstituentRoleType constituentRoleType) {
        ConstituentRoleType existingConstituentRoleType = constituentRoleTRepository.findById(constituentRoleTypeId).orElse(null);
        if (existingConstituentRoleType == null) {
            throw new IllegalStateException("ConstituentRoleType with id " + constituentRoleTypeId + " does not exist");
        }
        existingConstituentRoleType.setName(constituentRoleType.getName());
        return new ResponseEntity<>(constituentRoleTRepository.save(existingConstituentRoleType), HttpStatus.OK); 
    }

    // Delete ConstituentRoleType
    public ResponseEntity<String> deleteConstituentRoleType(Long id) {
        boolean exists = constituentRoleTRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("ConstituentRoleType with id " + id + " does not exist");
        }
        constituentRoleTRepository.deleteById(id);

        return new ResponseEntity<>("ConstituentRoleType deleted successfully", HttpStatus.OK);
    }

}

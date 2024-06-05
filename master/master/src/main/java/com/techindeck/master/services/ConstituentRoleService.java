package com.techindeck.master.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techindeck.master.model.ConstituentRole;
import com.techindeck.master.repository.ConstituentRoleRepository;

@Service
public class ConstituentRoleService {

    private final ConstituentRoleRepository constituentRoleRepository;

    @Autowired
    public ConstituentRoleService(ConstituentRoleRepository constituentRoleRepository){
        this.constituentRoleRepository=constituentRoleRepository;
    }


    // Get All ConstituentRoles
    public ResponseEntity<List<ConstituentRole>> getConstituentRoles() {
        
        return new ResponseEntity<>(constituentRoleRepository.findAll(), HttpStatus.OK);
    }

    // Get ConstituentRole By Id
    public ResponseEntity<ConstituentRole> getConstituentRoleById(Long id) {

        try {
            if (!constituentRoleRepository.existsById(id)) {
                throw new IllegalStateException("ConstituentRole with id " + id + " does not exist");
            }

            return new ResponseEntity<>(constituentRoleRepository.findById(id).orElse(null), HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // Create ConstituentRole
    public ResponseEntity<String> createConstituentRole(ConstituentRole constituentRole){
        try {
            constituentRoleRepository.save(constituentRole);
            return new ResponseEntity<>("Record Created Successfully",HttpStatus.CREATED);

        } catch (Exception e) {
            return new  ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
        }
    }

    // update ConstituentRole
    public ResponseEntity<ConstituentRole> updateConstituentRole(Long constituentId, ConstituentRole constituentRole)
    {
        ConstituentRole record=constituentRoleRepository.findById(constituentId).orElse(null);
        if(record==null)
        {
          throw new   IllegalStateException("ConstituentRoleType with id " + constituentId + " does not exist");
        }
        record.setName(constituentRole.getName());
        return new ResponseEntity<>(constituentRoleRepository.save(constituentRole),HttpStatus.OK); 
    }

    // delete ConstituentRole
    public ResponseEntity<String> deleteConstituentRole(Long Id)
    {
        boolean exists=constituentRoleRepository.existsById(Id);
        if (!exists) {
            throw new IllegalStateException("ConstituentRoleType with id " + Id + " does not exist");
        }
        constituentRoleRepository.deleteById(Id);

        return new ResponseEntity<>("ConstituentRole deleted successfully", HttpStatus.OK);
    }
}

package com.pluralsight.confeduler.controllers;

import com.pluralsight.confeduler.models.Organisation;
import com.pluralsight.confeduler.repositories.OrganisationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @GetMapping
    public List<Organisation> list() { return organisationRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Organisation get(@PathVariable Long id) {
        return organisationRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organisation create(@RequestBody final Organisation organisation){
        return organisationRepository.saveAndFlush(organisation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //TODO: Also need to check for children records before deleting
        organisationRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Organisation update(@PathVariable Long id, @RequestBody Organisation organisation) {
        //Cos this a PUT, we expect all attributes to be passed in.
        // A patch would only need what
        //TODO: Add validation that all attributes are passed in,
        // otherwise return a 400 bad payload
        Organisation existingOrganisation = organisationRepository.getOne(id);
        BeanUtils.copyProperties(organisation, existingOrganisation, "conference_id");
        return organisationRepository.saveAndFlush(existingOrganisation);
    }
}

package com.pluralsight.confeduler.controllers;

import com.pluralsight.confeduler.models.Conference;
import com.pluralsight.confeduler.repositories.ConferenceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @GetMapping
    public List<Conference> list() {
        return conferenceRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Conference get(@PathVariable Long id) {
        return conferenceRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conference create(@RequestBody final Conference conference){
        return conferenceRepository.saveAndFlush(conference);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //TODO: Also need to check for children records before deleting
        conferenceRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Conference update(@PathVariable Long id, @RequestBody Conference conference) {
        //Cos this a PUT, we expect all attributes to be passed in.
        // A patch would only need what
        //TODO: Add validation that all attributes are passed in,
        // otherwise return a 400 bad payload
        Conference existingConference = conferenceRepository.getOne(id);
        BeanUtils.copyProperties(conference, existingConference, "conference_id");
        return conferenceRepository.saveAndFlush(existingConference);
    }
}

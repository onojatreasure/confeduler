package com.pluralsight.confeduler.controllers;

import com.pluralsight.confeduler.models.Tag;
import com.pluralsight.confeduler.repositories.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagsController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list() {
        return tagRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tag get(@PathVariable Long id) {
        return tagRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag create(@RequestBody final Tag tag){
        return tagRepository.saveAndFlush(tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //TODO: Also need to check for children records before deleting
        tagRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable Long id, @RequestBody Tag speaker) {
        //Cos this a PUT, we expect all attributes to be passed in.
        // A patch would only need what
        //TODO: Add validation that all attributes are passed in,
        // otherwise return a 400 bad payload
        Tag existingSpeaker = tagRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return tagRepository.saveAndFlush(existingSpeaker);
    }

}

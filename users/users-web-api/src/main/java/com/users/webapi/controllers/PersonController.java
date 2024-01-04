package com.users.webapi.controllers;

import com.users.webapi.contract.PersonDto;
import com.users.webapi.contract.PictureDto;
import com.users.webapi.services.IPersonService;
import com.users.webapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPage(
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "1") int page){
        return ResponseEntity.ok(personService.getByPage(size, page));
    }

    @PostMapping
    public ResponseEntity savePerson(@RequestBody PersonDto personDto){
        var id = personService.save(personDto);
        return ResponseEntity.created(getLocationUri(id)).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable long id){
        var result = personService.getById(id);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        var result = personService.delete(id);
        if(result==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id,
                                 @RequestBody PersonDto personDto){
        var result = personService.update(id, personDto);
        if(result==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/pictures")
    public ResponseEntity<PictureDto> getPictures(@PathVariable("id") long personId){
        var pictureDto = personService.getPictures(personId);
        if(pictureDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pictureDto);
    }

    // Dalsza część deklarowania endpointów (pisane w podobnym stylu)

    private static URI getLocationUri(long id) {

        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(id+"")
                .buildAndExpand(1)
                .toUri();
    }
}

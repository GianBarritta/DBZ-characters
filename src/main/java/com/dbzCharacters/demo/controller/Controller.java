package com.dbzCharacters.demo.controller;

import com.dbzCharacters.demo.model.Character;
import com.dbzCharacters.demo.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    //implemento la interface
    @Autowired
    private ICharacterService chaServ;

    @GetMapping ("/characters")
    public List<Character> getCharacters () {
        List<Character> characterList = chaServ.getCharacters();
        return characterList;
    }

    @PostMapping ("/create")
      public String createCharacter(@RequestBody Character character) {
        chaServ.saveCharacter(character);
        return "El personaje fue agregado correctamente";
    }

    //acá también puedo poner un objeto y lo relaciona al id
    // (si se llaman igual ambos parámetros)
    @PostMapping("delete/{id}")
    public String deleteCharacter (@PathVariable long id) {
        chaServ.deleteCharacter(id);
        return "El personaje fue borrado correctamente";
    }

    @PostMapping ("edit/{id}")
    public Character editCharacter (@PathVariable long id,
                                  @RequestParam ("name") String newName,
                                  @RequestParam ("lastname") String newLastname) {
        Character cha = chaServ.findCharacter(id);
        //esto puede ir en el service
        cha.setName(newLastname);
        chaServ.saveCharacter(cha);
        return cha;
    }






}

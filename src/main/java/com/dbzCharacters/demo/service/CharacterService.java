package com.dbzCharacters.demo.service;

import com.dbzCharacters.demo.model.Character;
import com.dbzCharacters.demo.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CharacterService implements ICharacterService{

private final CharacterRepository chaRepo;

 //Si implemento con constructor es así:
    public CharacterService (CharacterRepository chaRepo) {
        this.chaRepo = chaRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Character> getCharacters() {
        List<Character> characterList = chaRepo.findAll();
        return characterList;
    }

    @Override
    @Transactional
    public void saveCharacter(Character cha) {

        chaRepo.save(cha);
    }

    @Override
    @Transactional
    public void deleteCharacter(long id) {
        chaRepo.deleteById(id);
    }

    //el método edit no existe más

    @Override
    @Transactional (readOnly = true)
    public Character findCharacter(long id) {
        //acá si no encuentro el character, devuelvo null, eso hace el orElse
        Character cha=chaRepo.findById(id).orElse(null);
        return cha;
    }


}




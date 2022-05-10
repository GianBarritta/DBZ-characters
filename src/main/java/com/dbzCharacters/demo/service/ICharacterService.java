package com.dbzCharacters.demo.service;

import com.dbzCharacters.demo.model.Character;
import java.util.List;

public interface ICharacterService {

    List<Character> getCharacters ();
    void saveCharacter (Character cha);
    void deleteCharacter (long id);
    Character findCharacter (long id);



}

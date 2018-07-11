package com.efgh.dnd.cards.entities.business;


import com.efgh.dnd.cards.entities.json.Archetype;
import com.efgh.dnd.cards.entities.json.Class;

import java.util.*;

public class MergedClassList {
    static HashMap<String, Class> CLASS_LIST = new HashMap<>();

    public static void addClassInformation(Class classToAdd){
        Class characterClass = CLASS_LIST.get(classToAdd.getName());
        if(characterClass != null){
            characterClass.merge(classToAdd);
        }else{
            characterClass = classToAdd;
        }
        CLASS_LIST.put(characterClass.getName(), characterClass);
    }

    public static Class getClassByName(String className){
        return CLASS_LIST.get(className);
    }

    public static Set<String> getSpellNamesForClassAndArchetype(String className, String archName){
        List<String> spells = new ArrayList<>();
        Class matchingClass = getClassByName(className);

        if(matchingClass != null){
            spells.addAll(matchingClass.getSpells());

            Archetype matchingArchetype = matchingClass.getArchetypeByName(archName);

            if(matchingArchetype != null){
                spells.addAll(matchingArchetype.getSpells());
            }
        }

        return new HashSet(spells);
    }

    public static HashMap<String, Class> getClassList() {
        return CLASS_LIST;
    }

}

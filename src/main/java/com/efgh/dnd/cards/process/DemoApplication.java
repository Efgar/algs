package com.efgh.dnd.cards.process;
import com.efgh.dnd.cards.entities.business.CardOptions;
import com.efgh.dnd.cards.entities.business.Classes;
import com.efgh.dnd.cards.entities.business.MergedClassList;
import com.efgh.dnd.cards.entities.business.SpellListQuery;
import com.efgh.dnd.cards.entities.json.Class;
import com.efgh.dnd.cards.entities.json.Example;
import com.efgh.dnd.cards.entities.json.Spell;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DemoApplication {

    static HashMap<String, Spell> SPELL_LIST = new HashMap<>();

    public static void DemoApplicationInit(){
        try {
            List<String> inputFiles = new ArrayList<>();
            inputFiles.add("SRD.json");
            inputFiles.add("ALL_DATA.json");

            Set<Example> availableDataSources = new HashSet<>();

            //Load Data Files
            for (String inputFile : inputFiles) {
                String json = new String(Files.readAllBytes(Paths.get(inputFile)));
                Example[] ex = new ObjectMapper().readValue(json, Example[].class);
                availableDataSources.addAll(Arrays.asList(ex));
            }

            //Fill available data
            for (Example datasource : availableDataSources) {
                if (datasource.getSpells() != null) {
                    for (Spell spell : datasource.getSpells()) {
                        if (SPELL_LIST.get(spell.getName()) != null && spell.getNewName() != null) {
                            spell.setName(spell.getNewName());
                        }
                        SPELL_LIST.put(spell.getName(), spell);
                    }
                }

                if (datasource.getClasses() != null) {
                    for (Class characterClass : datasource.getClasses()) {
                        MergedClassList.addClassInformation(characterClass);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DemoApplicationInit();
        List<String> formattedOutput = new ArrayList<>();
        List<String> printedSpells = new ArrayList<>();

        List<Spell> spellsToReturn = new ArrayList<>();
        //List<Spell> spellsToReturn = getAllSpells();
        //spellsToReturn.addAll(getFilteredSpells(new SpellListQuery( Classes.PALADIN.getName(), "", 0,1), new CardOptions(Classes.PALADIN)));

        List<String> tzarneSpells = new ArrayList<>();
        /*tzarneSpells.add("Eldritch Blast");
        tzarneSpells.add("Poison Spray");
        tzarneSpells.add("Armor of Agathys");
        tzarneSpells.add("Disguise Self");
        tzarneSpells.add("Hex");
        tzarneSpells.add("Friends");
        tzarneSpells.add("Charm Person");
        tzarneSpells.add("Cause Fear");
        tzarneSpells.add("Dancing Lights");
        tzarneSpells.add("Mage Hand");
        tzarneSpells.add("Toll the Dead");
        tzarneSpells.add("Magic Stone");
        tzarneSpells.add("Minor Illusion");
        tzarneSpells.add("Frostbite");


        tzarneSpells.add("Detect Thoughts");
        tzarneSpells.add("Mind Spike");
        tzarneSpells.add("Hold Person");
        tzarneSpells.add("Mirror Image");
        tzarneSpells.add("Suggestion");
        tzarneSpells.add("Misty Step");
        tzarneSpells.add("Hideous Laughter");
        tzarneSpells.add("Shadow Blade");
        tzarneSpells.add("Phantasmal Force");
        */
        tzarneSpells.add("Disguise Self");
        tzarneSpells.add("Dancing Lights");
        spellsToReturn.addAll(getFilteredSpellsByName(tzarneSpells, new CardOptions(Classes.WARLOCK)));

        //spellsToReturn.addAll(getFilteredSpellsByName(rauloSpells, new CardOptions(Classes.PALADIN)));
        spellsToReturn.addAll(getFilteredSpells(Classes.PALADIN.getName(), "Conquest",0,1, new CardOptions(Classes.PALADIN)));
        spellsToReturn.addAll(getFilteredSpells(Classes.WARLOCK.getName(), "Great Old One",0,2, new CardOptions(Classes.WARLOCK)));


        for (Spell spell: spellsToReturn) {
            printedSpells.add(spell.getCardIcon() + " - " + spell.getName());
            formattedOutput.add(spell.getSpellFormat());
        }

        Files.write(Paths.get("PrintedCards.json"), printedSpells.toString().getBytes());
        Files.write(Paths.get("CardSet.json"), formattedOutput.toString().getBytes());
        System.out.println(formattedOutput.size() + " Spells have been printed");
    }

    private static List<Spell> getFilteredSpells(SpellListQuery query, CardOptions cardOptions){
        return getFilteredSpells(query.getClassName(), query.getArchetypeName(), query.getMinLevel(), query.getMaxLevel(), cardOptions);
    }


    private static List<Spell> getFilteredSpells(String className, String archetypeName, int minLevel, int maxLevel, CardOptions cardOptions){
        List<Spell> spellsToReturn = new ArrayList<>();
        Set<String> spellNamesForClassAndArchetype = MergedClassList.getSpellNamesForClassAndArchetype(className, archetypeName);
        for (String spell :spellNamesForClassAndArchetype) {
            Spell matchingSpell = SPELL_LIST.get(spell);
            try {
                if (matchingSpell != null && minLevel <= matchingSpell.getLevel() && matchingSpell.getLevel() <= maxLevel) {
                    matchingSpell.setCardIcon(cardOptions.getCardIcon());
                    matchingSpell.setCardColor(cardOptions.getCardColor());
                    spellsToReturn.add(matchingSpell);
                }
            }catch (Exception e){
                System.out.println(matchingSpell.getName() + "(" + matchingSpell.getLevel()  + ")" + " COULD NOT BE ADDED");
                e.printStackTrace();
            }
        }
        return spellsToReturn;
    }

    private static List<Spell> getFilteredSpellsByName(List<String> spellNames, CardOptions cardOptions){
        List<Spell> spellsToReturn = new ArrayList<>();
        for (String spell :spellNames) {
            try{
                Spell matchingSpell = SPELL_LIST.get(spell);
                matchingSpell.setCardIcon(cardOptions.getCardIcon());
                matchingSpell.setCardColor(cardOptions.getCardColor());
                spellsToReturn.add(matchingSpell);
            }catch (Exception e){
                System.out.println(spell + " can not be found." );
                e.printStackTrace();
            }

        }
        return spellsToReturn;
    }

    private static List<Spell> getAllSpells(){
        Set<Spell> spellsToReturn = new HashSet<>();
        MergedClassList.getClassList().forEach((className, classObj) -> {
            Set<Spell> spellsByClass = new HashSet<>();
            spellsByClass.addAll(getFilteredSpells(className, null, 0, 99, new CardOptions(Classes.getClassByName(className))));
            classObj.getArchetypes().forEach(archetype -> {
                spellsByClass.addAll(getFilteredSpells(className, archetype.getName(), 0, 99, new CardOptions(Classes.getClassByName(className))));
            });
            spellsToReturn.addAll(spellsByClass);
        });
        return new ArrayList<>(spellsToReturn);
    }

}

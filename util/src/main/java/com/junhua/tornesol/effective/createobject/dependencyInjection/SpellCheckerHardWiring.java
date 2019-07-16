package com.junhua.tornesol.effective.createobject.dependencyInjection;

public class SpellCheckerHardWiring {

    /**
     * hardWiring
     */
    private static final Lexicon dictionary = new Lexicon();

    private SpellCheckerHardWiring() {
    }

    public boolean isValid(String word) {
        return dictionary.findWord(word);
    }
}

package com.junhua.tornesol.effective.createobject.dependencyInjection;

import java.util.function.Supplier;

/**
 *
 */
public class SpellCheckerDI {

    private Lexicon dictionary;

    public SpellCheckerDI(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public SpellCheckerDI(Supplier<Lexicon> supplier) {
        this.dictionary = supplier.get();
    }

    public boolean isValid(String word) {
        return dictionary.findWord(word);
    }
}

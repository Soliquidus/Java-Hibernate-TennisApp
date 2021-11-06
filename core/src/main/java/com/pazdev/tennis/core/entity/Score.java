package com.pazdev.tennis.core.entity;
/**
 * Class Score
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class Score {
    private Long id;
    private Byte set1;
    private Byte set2;
    private Byte set3;
    private Byte set4;
    private Byte set5;
    private Match match;

    public Long getId() {
        return id;
    }

    public Score setId(Long id) {
        this.id = id;
        return this;
    }

    public Byte getSet1() {
        return set1;
    }

    public Score setSet1(Byte set1) {
        this.set1 = set1;
        return this;
    }

    public Byte getSet2() {
        return set2;
    }

    public Score setSet2(Byte set2) {
        this.set2 = set2;
        return this;
    }

    public Byte getSet3() {
        return set3;
    }

    public Score setSet3(Byte set3) {
        this.set3 = set3;
        return this;
    }

    public Byte getSet4() {
        return set4;
    }

    public Score setSet4(Byte set4) {
        this.set4 = set4;
        return this;
    }

    public Byte getSet5() {
        return set5;
    }

    public Score setSet5(Byte set5) {
        this.set5 = set5;
        return this;
    }

    public Match getMatch() {
        return match;
    }

    public Score setMatch(Match match) {
        this.match = match;
        return this;
    }
}

package me.robifoxx.jfunction.commands.scoreboard;

public class Scoreboard {
    public enum Comparator {
        LESS("<"),
        LESS_OR_EQUAL("<="),
        EQUAL("="),
        MORE_OR_EQUAL(">="),
        MORE(">"),
        NOT_EQUAL("!=");

        private String s;
        Comparator(String s) {
            this.s = s;
        }

        public String toString() {
            return s;
        }
    }

    public enum Operator {
        ADD("+="),
        SUBTRACT("-="),
        MULTIPLY("*="),
        DIVISION("/="),
        MODULUS("%="),
        MIN("<"),
        MAX(">"),
        SWAP("><");

        private String s;
        Operator(String s) {
            this.s = s;
        }

        public String toString() {
            return s;
        }
    }
}

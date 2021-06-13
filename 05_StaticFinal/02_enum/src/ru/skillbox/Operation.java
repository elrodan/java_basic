package ru.skillbox;

public enum Operation {
    ADD {
        public int add(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        public int subtract(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        public int multiply(int a, int b) {
            return a * b;
        }
    }
}

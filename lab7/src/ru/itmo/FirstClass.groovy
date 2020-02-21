package ru.itmo

class FirstClass {
    int var = 5;
    String string = "string";

    FirstClass(int var, String string) {
        this.var = var
        this.string = string
    }

    @Override
    String toString() {
        return "FirstClass{" +
                "var=" + var +
                ", string='" + string + '\'' +
                '}';
    }
}

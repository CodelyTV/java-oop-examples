package tv.codely.oop_recap.example_02_static;

final class Counter {
    private static Integer total = 0;

    Integer getTotal() {
        return total;
    }

    void increaseTotal() {
        total++;
    }
}

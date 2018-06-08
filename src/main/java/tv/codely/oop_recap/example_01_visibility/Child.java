package tv.codely.oop_recap.example_01_visibility;

final class Child extends Parent {
    private String privateMethod() {
        return "Child#privateMethod";
    }

    protected String protectedMethod() {
        return "Child#protectedMethod";
    }

    public String publicMethod() {
        return "Child#publicMethod";
    }
}

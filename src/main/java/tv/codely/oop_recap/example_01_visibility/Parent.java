package tv.codely.oop_recap.example_01_visibility;

class Parent {
    String visibilityTest() {
        return privateMethod() + " " + protectedMethod() + " " + publicMethod();
    }

    private String privateMethod() {
        return "Parent#privateMethod";
    }

    protected String protectedMethod() {
        return "Parent#protectedMethod";
    }

    public String publicMethod() {
        return "Parent#publicMethod";
    }
}

// for testing purposes only

public void main() {
    var a = new OurAbstractClass();
    var b = new OurAbstractClassTwo();
    System.out.println(a);
    System.out.println(b);
}

public static class OurAbstractClass {
    @Override
    public String toString() {
        return "abstraction";
    }
}

public static class OurAbstractClassTwo {
    @Override
    public String toString() {
        return "abstraction-2";
    }
}



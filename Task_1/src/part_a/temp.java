


interface C {
    void f1();
    void f2();
}

class A implements C {
    public void f1() {
        System.out.println("A.f1()");
    }

    public void f2() {
        System.out.println("A.f2()");
    }

    public void f3() {
        System.out.println("A.f3()");
    }
}

class B implements C {
    private int x;

    public B(int x) {
        this.x = x;
    }

    public void f1() {
        System.out.println("B.f1()");
    }

    public void f2() {
        System.out.println("B.f2(), x = " + x);
    }
}
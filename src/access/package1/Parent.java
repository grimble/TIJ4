package access.package1;

public class Parent {
    protected void foo() {}
}

class ProtectedPackageCall {
    void bar() {
        Parent p= new Parent();
        p.foo();
    }
}
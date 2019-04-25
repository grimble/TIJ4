package ru.grimble.tij4.access.package2;

import ru.grimble.tij4.access.package1.Parent;

public class ProtectedPublicCall {
    void bar() {
        Parent p= new Parent();
        //p.foo(); // compiler error - trying access protected method from outside the package
    }

}

package a

class MyClass {
    fun component1(<!UNUSED_PARAMETER!>i<!>: Int) {}
}

class MyClass2 {}

<!CONFLICTING_OVERLOADS!>fun MyClass2.component1()<!> = 1.2
<!CONFLICTING_OVERLOADS!>fun MyClass2.component1()<!> = 1.3

fun test(<!UNUSED_PARAMETER!>mc1<!>: MyClass, <!UNUSED_PARAMETER!>mc2<!>: MyClass2) {
    val (a, b) = <!COMPONENT_FUNCTION_MISSING, COMPONENT_FUNCTION_MISSING!>mc1<!>
    val (c) = <!COMPONENT_FUNCTION_AMBIGUITY!>mc2<!>

    //a,b,c are error types
    a : Boolean
    b : Boolean
    c : Boolean
}
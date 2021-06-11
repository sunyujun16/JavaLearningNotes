package chap20_generics;

// {WillNotCompile}

interface Payable<T> {
}

class Employee1 implements Payable<Employee> {
}

// doesn't work.
//class Hourly extends Employee1
//        implements Payable<Hourly> {
//}

// this works.
class Employee2 implements Payable {
}

class Hourly2 extends Employee2
        implements Payable {
}

public class A09_MultipleInterfaceVariants {
}

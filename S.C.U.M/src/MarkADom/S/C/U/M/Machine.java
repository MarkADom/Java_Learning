package MarkADom.S.C.U.M;

import java.util.function.Supplier;

import static MarkADom.S.C.U.M.BiOperation.*;
import static MarkADom.S.C.U.M.MonoOperation.division;
import static MarkADom.S.C.U.M.MonoOperation.multiply;

public class Machine {
    public static void main(String[] args) {

        myThread.start();

        System.out.println(binaryOperator.apply("coding", "...I don't know"));

        System.out.println("Multiplication result is: " + multiply.product(190, 30));
        System.out.println("Division result is: " + division.product(260, 30));

        System.out.println(unaryOperator.applyAsInt(100));

        System.out.println(strLength.apply("Learntocodetogether.com"));
        System.out.println(strLength.apply("wubba lubba dub dub"));

        System.out.println(lengthGreaterThan5.test("Learntocodetogether.com"));
        System.out.println(lengthGreaterThan5.test("Hi"));

        // consumer.accept(names);
        //names.forEach(name -> System.out.println(name));

    }
}
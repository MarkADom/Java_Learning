package MarkADom.S.C.U.M;

public interface MonoOperation
{
     int product(int a, int b);

     MonoOperation multiply = (a, b) -> a * b;
     MonoOperation division = (a, b) -> a/b;
}

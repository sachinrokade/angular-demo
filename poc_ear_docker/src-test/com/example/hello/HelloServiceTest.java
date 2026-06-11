package com.example.hello;

public class HelloServiceTest {
    public static void main(String[] args) {
        String expected = "Hello, World from WebSphere Classic!";
        String actual = HelloService.getMessage();

        if (!expected.equals(actual)) {
            throw new AssertionError("HelloService returned '" + actual + "' instead of '" + expected + "'");
        }

        System.out.println("HelloServiceTest PASSED");
    }
}

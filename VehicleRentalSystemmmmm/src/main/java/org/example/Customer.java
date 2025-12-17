package org.example;

public class Customer {
    private String name;
    private String tckn; // ID veya TC Kimlik No

    public Customer(String name, String tckn) {
        this.name = name;
        this.tckn = tckn;
    }

    public String getName() { return name; }
    public String getTckn() { return tckn; }
}
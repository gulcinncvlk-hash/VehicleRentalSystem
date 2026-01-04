package org.example;

/**
 * Müşteri bilgilerini (Ad, Soyad, TC vb.) güvenli bir şekilde tutan model sınıfı.
 * Veri bütünlüğünü sağlamak için Kapsülleme (Encapsulation) kullanır.
 */
public class Customer {
    private String name;
    private String tckn; // ID veya TC Kimlik No

    public Customer(String name, String tckn) {
        this.name = name;
        this.tckn = tckn;
    }

    public String getName() {
        return name;
    }

    public String getTckn() {
        return tckn;
    }
}
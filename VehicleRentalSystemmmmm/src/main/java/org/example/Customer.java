package org.example;

/**
 * Musteri bilgilerini ve kiralama gecmisini yoneten sinif.
 * Her musterinin adi, iletisim bilgisi ve kiraladigi araclar burada tutulur.
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
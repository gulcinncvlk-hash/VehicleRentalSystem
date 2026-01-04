package org.example;
/**
 * Ödeme işlemlerini simüle eden ve kart doğrulama kontrollerini yapan yardımcı sınıf.
 * <p>
 * Gerçek bir banka entegrasyonu yerine konsol çıktıları ile işlem taklidi yapar.
 * </p>
 */
public class Payment {
    // Odeme islemleri burada yapilacak
    public void processPayment(double amount) {
        System.out.println("Odeme alindi: " + amount + " TL");
    }

    // Kredi karti numarasinin gecerliligini kontrol eden metot
    public boolean validateCard(String cardNumber) {
        // Kart numarasi 16 haneli olmalidir (Basit kural)
        if (cardNumber != null && cardNumber.length() == 16) {
            System.out.println("Kart bilgileri dogrulandi.");
            return true;
        } else {
            System.out.println("Hata: Gecersiz kart numarasi! Lutfen kontrol edin.");
            return false;
        }
    }
}
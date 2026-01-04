package org.example;
/**
 * Araç kiralama sistemindeki tüm kiralanabilir nesnelerin uyması gereken kuralları belirler.
 * <p>
 * Bu arayüzü (interface) kullanan sınıflar, fiyat hesaplama yöntemini
 * kendi içlerinde detaylandırmak zorundadır.
 * </p>
 *
 * @author Gulcin Civelek
 * @version 1.0
 */
public interface Rentable {
    // Kiralama ücretini hesaplayan metot (Her araç kendine göre hesaplayacak)
    double calculateRentalFee(int dayCount);
}
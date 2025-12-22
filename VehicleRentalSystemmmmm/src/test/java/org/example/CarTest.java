package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    // 1. Senaryo: Kiralama ve Iade Durum Kontrolu
    @Test
    void testRentalStatusChange() {
        // DUZELTME BURADA: "Car" yerine "GasCar" yazdik.
        // Boylece 'rent' ve 'returnCar' metodlarini taniyor.
        GasCar car = new GasCar("34TEST34", "Test Car", 1000);

        // Baslangicta musait olmali
        assertTrue(car.isAvailable(), "Hata: Arac ilk basta musait olmaliydi.");

        // Araci Kirala
        car.rent("Mehmet", 3);

        // Simdi musait OLMAMALI (Dolu)
        assertFalse(car.isAvailable(), "Hata: Kiralandiktan sonra arac 'Dolu' gorunmeli.");

        // Iade et
        car.returnCar();

        // Tekrar musait olmali
        assertTrue(car.isAvailable(), "Hata: Iade sonrasi arac tekrar musait olmali.");
    }

    // 2. Senaryo: Polimorfizm Fiyat Testi
    @Test
    void testCalculateRentalFee() {
        // Elektrikli Arac Testi
        ElectricCar electricCar = new ElectricCar("06ELEC06", "Tesla", 1000);

        // 2 gunluk kiralama testi
        // Not: calculateRentalFee metodu double dondugu icin hata payi (delta) ekledik
        assertEquals(2000.0, electricCar.calculateRentalFee(2), 0.1);
    }
}
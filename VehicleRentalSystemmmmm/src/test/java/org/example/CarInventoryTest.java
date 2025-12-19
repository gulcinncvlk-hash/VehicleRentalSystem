package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarInventoryTest {

    @Test
    void testAddAndRemoveCar() {
        // 1. Envanteri olustur
        CarInventory inventory = new CarInventory();

        // DÜZELTİLEN KISIM BURASI: Sadece Plaka, Model ve Fiyat (3 bilgi)
        Car car = new GasCar("34ABC123", "Test Toyota", 500);

        // 2. Baslangicta liste bos mu kontrol et
        assertTrue(inventory.getCars().isEmpty(), "Baslangicta liste bos olmali");

        // 3. Arac Ekle ve kontrol et
        inventory.addCar(car);
        assertEquals(1, inventory.getCars().size(), "Arac eklendikten sonra sayi 1 olmali");
        assertEquals("34ABC123", inventory.getCars().get(0).getVehicleId(), "Eklenen aracin plakasi dogru olmali");

        // 4. Arac Sil ve kontrol et
        inventory.removeCar("34ABC123");
        assertTrue(inventory.getCars().isEmpty(), "Arac silindikten sonra liste tekrar bos olmali");
    }
}
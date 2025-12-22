package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ARAC KIRALAMA SISTEMI DEMO ===\n");

        // 1. Envanteri Olustur
        CarInventory inventory = new CarInventory();

        // 2. Arabalari Uret (Polimorfizm: Biri elektrikli, biri benzinli)
        Car car1 = new ElectricCar("34TESLA", "Tesla Model Y", 2000);
        Car car2 = new GasCar("34BMW", "BMW 320i", 1500);

        // 3. Arabalari Envantere Ekle
        inventory.addCar(car1);
        inventory.addCar(car2);
// --- DEMO ICIN EKLENEN YENI ARACLAR ---

        // 1. Yerli ve Milli: TOGG T10X (Elektrikli)
        // Polimorfizm Ornegi: ElectricCar nesnesi 'Car' olarak ekleniyor
        inventory.addCar(new ElectricCar("34TOGG2023", "TOGG T10X", 1200));

        // 2. Luks Segment: Mercedes C200 (Benzinli)
        inventory.addCar(new GasCar("06MERC06", "Mercedes C200", 1500));

        // 3. Ekonomik Sinif: Fiat Egea (Benzinli)
        inventory.addCar(new GasCar("16BURSA16", "Fiat Egea", 600));
        // 4. Musait Araclari Listele
        inventory.listAvailableCars();

        // 5. Musteri Olustur
        Customer customer1 = new Customer("Ahmet Yilmaz", "12345678901");

        // 6. Kiralama Yap (Tesla'yı 3 günlüğüne kirala)
        System.out.println("\n--- Kiralama Islemi ---");
        Car selectedCar = inventory.findCarById("34TESLA");

        if (selectedCar != null) {
            Rental rental1 = new Rental(selectedCar, customer1, 3);
            rental1.startRental();
        }

        // 7. Tekrar Listele (Tesla artık görünmemeli veya dolu gözükmeli)

        // --- METHOD OVERLOADING TESTI (Akilli Arama) ---
        System.out.println("\n** AKILLI ARAMA TESTLERI **");

        // 1. Isim ile arama testi (String gonderiyoruz)
        inventory.searchCar("TOGG");

        // 2. Butce ile arama testi (Sayi gonderiyoruz - 1000 TL alti)
        inventory.searchCar(1000);
    }

}
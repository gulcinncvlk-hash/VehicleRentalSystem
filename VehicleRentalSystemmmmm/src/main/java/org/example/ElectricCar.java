package org.example;

/**
 * Elektrikli araclari temsil eden alt sinif.
 * Fiyat hesaplamasi (calculateRentalFee) gunluk bazda standart tarife uzerinden yapilir.
 * Yakit tuketimi kWh cinsinden hesaplanir.
 */
public class ElectricCar extends Car {

    // Kurucu Metot (Constructor)
    public ElectricCar(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model, dailyRate); // Ata sınıfın (Car) özelliklerini ayarla
    }

    @Override
    public String getFuelConsumptionInfo() {
        return "Ortalama Tuketim: 15 kWh / 100 km (Elektrik)";
    }

    @Override
    public double calculateRentalFee(int dayCount) {
        // Elektrikli araçlar için basit hesap: Günlük Fiyat x Gün Sayısı
        return getDailyRate() * dayCount;
    }
}
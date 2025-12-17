package org.example;

public class ElectricCar extends Car {

    // Kurucu Metot (Constructor)
    public ElectricCar(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model, dailyRate); // Ata sınıfın (Car) özelliklerini ayarla
    }

    @Override
    public double calculateRentalFee(int dayCount) {
        // Elektrikli araçlar için basit hesap: Günlük Fiyat x Gün Sayısı
        return getDailyRate() * dayCount;
    }
}
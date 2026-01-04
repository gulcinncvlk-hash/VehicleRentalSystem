package org.example;

/**
 * Elektrikli araçları temsil eden çevre dostu araç sınıfı.
 * <p>
 * Fiyat hesaplaması standart günlük tarife üzerinden yapılır.
 * Yakıt tüketim bilgisi kWh (Kilowatt-saat) cinsinden verilir.
 * </p>
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
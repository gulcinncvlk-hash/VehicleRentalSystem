package org.example;

public class GasCar extends Car {

    public GasCar(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model, dailyRate);
    }
    @Override
    public String getFuelConsumptionInfo() {
        // Polimorfizm: Ayni metodun farkli davranisi
        return "Ortalama Tuketim: 8 Litre / 100 km (Kurşunsuz Benzin)";
    }
    @Override
    public double calculateRentalFee(int dayCount) {
        // Polimorfizm Örneği: Benzinli araçlara toplam tutarda 100 TL ek hizmet bedeli ekleyelim
        double total = getDailyRate() * dayCount;
        return total + 100;
    }
}
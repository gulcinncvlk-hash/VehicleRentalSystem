package org.example;

/**
 * Arac kiralama sistemindeki temel arac sinifi (Base Class).
 * Tum arac turleri (Elektrikli, Benzinli) bu soyut siniftan turetilir.
 * Aracin ID, model, gunluk ucret ve musaitlik durumu gibi ortak ozelliklerini yonetir.
 */
// 'abstract' yapıyoruz çünkü tek başına 'Araba' diye bir şey üretilmez, modeli olur.
public abstract class Car implements Rentable ,Maintainable {
    private String vehicleId;   // Plaka veya ID
    private String model;       // Model (örn: Toyota Corolla)
    private double dailyRate;   // Günlük Taban Fiyat
    private boolean isAvailable;
    private String damageDescription; // Hasar aciklamasi (Bos ise hasarsizdir)// Müsait mi?

    // Kurucu Metot (Constructor)
    public Car(String vehicleId, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true; // Araç ilk eklendiğinde boştur
    }

    // Getter ve Setter Metotları (Erişim için)
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // --- OPSIYONEL OZELLIK: Hasar Raporu ---
    private String damageReport;

    public void reportDamage(String report) {
        this.isAvailable = false;
        this.damageReport = report;
        System.out.println(getModel() + " icin hasar kaydedildi: " + report);
    }

    public void repairCar() {
        this.isAvailable = true;
        this.damageReport = null;
        System.out.println(getModel() + " tamir edildi, hasar kaydi silindi.");
    }

    public String getDamageReport() {
        return (damageReport == null) ? "Hasar Kaydi Yok" : damageReport;
    }

    // --- OPSIYONEL OZELLIK: Yakit Tuketimi (Abstract Metot) ---
    // Her arac sinifi kendi tuketim bilgisini dondurmek ZORUNDADIR.
    public abstract String getFuelConsumptionInfo();
    // --- Kiralama ve Iade Metotlari (Testin Calismasi Icin Gerekli) ---

    public void rent(String customerName, int days) {
        // Eger arac zaten kiradaysa uyar
        if (!isAvailable) {
            System.out.println("HATA: Arac zaten kirada!");
            return;
        }

        // Degilse kirala
        this.isAvailable = false; // Durumu 'Dolu' yap
        System.out.println(getModel() + " araci " + customerName + " kisisine " + days + " gunlugune kiralandi.");
    }

    public void returnCar() {
        this.isAvailable = true; // Durumu tekrar 'Musait' yap
        System.out.println(getModel() + " araci basariyla iade alindi.");


    }

}
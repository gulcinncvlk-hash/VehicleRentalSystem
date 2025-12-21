package org.example;

/**
 * Kiralama islemlerini (Transaction) temsil eden sinif.
 * Hangi musterinin, hangi araci, kac gunlugune kiraladigini ve toplam tutari kayit altina alir.
 */
public class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double totalFee;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalFee = car.calculateRentalFee(days); // Polimorfizm burada çalışıyor!
    }

    // Kiralama işlemini başlatan metot
    public void startRental() {
        if (car.isAvailable()) {
            car.setAvailable(false); // Arabayı 'dolu' yap
            System.out.println("\nKiralama Basarili!");
            System.out.println("Musteri: " + customer.getName());
            System.out.println("Arac: " + car.getModel());
            System.out.println("Sure: " + days + " gun");
            System.out.println("Toplam Tutar: " + totalFee + " TL");
        } else {
            System.out.println("Hata: " + car.getModel() + " su an musait degil.");
        }
    }

    // --- YENI OZELLIK: Arac Iade ---
    public void returnCar() {
        System.out.println("\n--- Iade Islemi ---");
        // Araci tekrar musait duruma getir
        car.setAvailable(true);
        System.out.println("Arac basariyla iade alindi: " + car.getModel());
        System.out.println("Musteri " + customer.getName() + " tarafindan teslim edildi.");
    }
}
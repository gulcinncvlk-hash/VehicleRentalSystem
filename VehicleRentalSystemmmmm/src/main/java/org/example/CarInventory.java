package org.example;
/**
 * Arac filosunu yoneten merkezi envanter sinifi.
 * Listeye yeni arac ekleme, silme ve mevcut araclari listeleme islemleri burada yapilir.
 */

import java.util.ArrayList;
import java.util.List;

public class CarInventory {
    private List<Car> cars; // Arabaları tutan liste

    public CarInventory() {
        this.cars = new ArrayList<>();
    }

    // Galeriye yeni araba ekleme
    public void addCar(Car car) {
        cars.add(car);
        System.out.println(car.getModel() + " envantere eklendi.");
    }

    // --- GEREKLI OZELLIK: Arac Silme ---
    public void removeCar(String vehicleId) {
        // Java 8 ve sonrasi icin pratik silme yontemi (removeIf)
        boolean isRemoved = cars.removeIf(car -> car.getVehicleId().equals(vehicleId));

        if (isRemoved) {
            System.out.println(vehicleId + " plakali arac sistemden silindi.");
        } else {
            System.out.println("Hata: " + vehicleId + " plakali arac bulunamadi!");
        }
    }

    // Müsait olan araçları listeleme (Hocanın istediği özellik)
    public void listAvailableCars() {
        System.out.println("\n--- Musait Araclar ---");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Plaka: " + car.getVehicleId() +
                        " | Model: " + car.getModel() +
                        " | Gunluk Fiyat: " + car.getDailyRate());
            }
        }
    }

    // Plakaya göre araç bulma (Kiralama yaparken lazım olacak)
    public Car findCarById(String vehicleId) {
        for (Car car : cars) {
            if (car.getVehicleId().equals(vehicleId)) {
                return car;
            }
        }
        return null; // Bulunamazsa boş döner
    }

    // --- METHOD OVERLOADING ORNEKLERI (Guncellenmis Versiyon) ---

    // 1. Isme Gore Arama (Eski kodunun aynisi, buraya tasidik)
    public void searchCar(String modelName) {
        System.out.println("--- '" + modelName + "' icin Arama Sonuclari ---");
        boolean found = false;
        for (Car car : cars) {
            if (car.getModel().toLowerCase().contains(modelName.toLowerCase())) {
                System.out.println(car.getVehicleId() + " - " + car.getModel() + " (" + car.calculateRentalFee(1) + " TL)");
                found = true;
            }
        }
        if (!found) System.out.println("Bu modelde arac bulunamadi.");
    }

    // 2. Fiyata Gore Arama (Bu YEPYENI bir ozellik)
    public void searchCar(double maxPrice) {
        System.out.println("--- " + maxPrice + " TL altindaki Araclar ---");
        boolean found = false;
        for (Car car : cars) {
            if (car.calculateRentalFee(1) <= maxPrice) {
                System.out.println(car.getModel() + " - Fiyat: " + car.calculateRentalFee(1) + " TL");
                found = true;
            }
        }
        if (!found) System.out.println("Bu fiyata uygun arac yok.");
    }

    // Testler icin gerekli getter metodu
    public java.util.List<Car> getCars() {
        return cars;
    }
}

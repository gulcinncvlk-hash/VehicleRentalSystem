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
    // --- OPSIYONEL OZELLIK: Arama/Filtreleme ---
    public void searchCar(String query) {
        System.out.println("\n--- Arama Sonuclari: " + query + " ---");
        boolean found = false;
        for (Car car : cars) {
            // Kucuk/buyuk harf duyarliligini kaldirmak icin toLowerCase kullandik
            if (car.getModel().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(car.getVehicleId() + " - " + car.getModel() +
                        " (" + (car.isAvailable() ? "Musait" : "Dolu") + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aradiginiz kriterlere uygun arac bulunamadi.");
        }
    }
    // Testler icin gerekli getter metodu
    public java.util.List<Car> getCars() {
        return cars;
    }
}

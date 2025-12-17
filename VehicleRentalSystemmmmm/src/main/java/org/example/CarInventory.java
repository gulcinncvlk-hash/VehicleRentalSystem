package org.example;
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
}
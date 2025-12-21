package org.example;

public interface Rentable {
    // Kiralama ücretini hesaplayan metot (Her araç kendine göre hesaplayacak)
    double calculateRentalFee(int dayCount);
}
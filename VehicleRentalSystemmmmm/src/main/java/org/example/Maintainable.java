package org.example;
/**
 * Bakım ve tamir gerektiren nesneler için ortak özellikleri tanımlar.
 * <p>
 * Bu arayüz sayesinde araçlara hasar raporu girilebilir ve tamir işlemleri yapılabilir.
 * </p>
 */
// Bakim ve Tamir islemleri icin ortak ozellikler
public interface Maintainable {
    void reportDamage(String description); // Hasar rapor et
    void repairCar();                      // Tamir et
}
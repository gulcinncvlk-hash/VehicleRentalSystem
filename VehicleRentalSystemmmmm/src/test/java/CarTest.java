import org.example.Car;
import org.example.ElectricCar;
import org.example.GasCar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testElectricCarPrice() {
        // 1. Senaryo: Elektrikli araç fiyatı doğru hesaplıyor mu?
        Car tesla = new ElectricCar("34TEST1", "Tesla", 1000.0);
        double price = tesla.calculateRentalFee(3);

        // Beklenen: 1000 * 3 = 3000
        assertEquals(3000.0, price, "Elektrikli arac fiyati yanlis hesaplandi!");
    }

    @Test
    void testGasCarPrice() {
        // 2. Senaryo: Benzinli araç (Ekstra 100 TL vergili) doğru hesaplıyor mu?
        Car bmw = new GasCar("34TEST2", "BMW", 1000.0);
        double price = bmw.calculateRentalFee(2);

        // Beklenen: (1000 * 2) + 100 = 2100
        assertEquals(2100.0, price, "Benzinli arac fiyati yanlis hesaplandi!");
    }
}
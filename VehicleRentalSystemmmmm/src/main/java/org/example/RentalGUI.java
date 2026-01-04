package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Projenin Grafik Arayüzü (Swing GUI).
 * Kullanıcıların butonlarla kiralama ve iade işlemi yapmasını sağlar.
 */
public class RentalGUI extends JFrame {

    private CarInventory inventory;
    private JTextArea displayArea; // Sonuçları göstereceğimiz ekran

    public RentalGUI() {
        // 1. Envanteri Hazırla ve Test Verisi Yükle
        inventory = new CarInventory();
        initializeData();

        // 2. Pencere Ayarları
        setTitle("Araç Kiralama Otomasyonu v1.0");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 3. Başlık Kısmı
        JLabel titleLabel = new JLabel("Hoşgeldiniz - Araç Kiralama Sistemi", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // 4. Orta Kısım (Ekran / Log Alanı)
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setText("Sistem Hazır. Lütfen bir işlem seçiniz...\n");
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // 5. Alt Kısım (Butonlar)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnList = new JButton("Araçları Listele");
        JButton btnRent = new JButton("Araç Kirala");
        JButton btnReturn = new JButton("Araç İade Et");
        JButton btnExit = new JButton("Çıkış");

        // Renklendirme
        btnRent.setBackground(new Color(100, 200, 100)); // Yeşilimsi
        btnReturn.setBackground(new Color(200, 100, 100)); // Kırmızımsı

        buttonPanel.add(btnList);
        buttonPanel.add(btnRent);
        buttonPanel.add(btnReturn);
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.SOUTH);

        // --- BUTON AKSİYONLARI (Button Actions) ---

        // A. LİSTELE BUTONU
        btnList.addActionListener(e -> {
            displayArea.setText("=== GÜNCEL ARAÇ LİSTESİ ===\n\n");
            for (Car car : inventory.getCars()) {
                String status = car.isAvailable() ? "[MÜSAİT]" : "[DOLU]";
                displayArea.append(String.format("%-10s %-20s %-10s TL/Gün  %s\n",
                        car.getVehicleId(), car.getModel(), car.getDailyRate(), status));
            }
        });

        // B. KİRALA BUTONU (Pop-up pencerelerle bilgi alır)
        btnRent.addActionListener(e -> {
            // 1. Plaka İste
            String plaka = JOptionPane.showInputDialog(this, "Kiralanacak Araç Plakası (ID):");
            if (plaka == null || plaka.isEmpty()) return;

            Car selectedCar = inventory.findCarById(plaka);

            if (selectedCar != null && selectedCar.isAvailable()) {
                // 2. Müşteri Adı İste
                String musteriAdi = JOptionPane.showInputDialog(this, "Müşteri Adı Soyadı:");
                if (musteriAdi == null) return;

                // 3. Gün Sayısı İste
                String gunStr = JOptionPane.showInputDialog(this, "Kaç Günlük Kiralama?");
                try {
                    int gun = Integer.parseInt(gunStr);

                    // --- ARKA PLANDAKİ LOGIC ÇAĞRILIYOR ---
                    Customer customer = new Customer(musteriAdi, "11111111111"); // Basitlik için dummy TC
                    Rental rental = new Rental(selectedCar, customer, gun);
                    rental.startRental(); // Logic çalışır (Araba kilitlenir)

                    // Ekrana Yaz
                    displayArea.append("\n✅ KİRALAMA BAŞARILI!\n");
                    displayArea.append("Müşteri: " + musteriAdi + "\n");
                    displayArea.append("Araç: " + selectedCar.getModel() + "\n");
                    displayArea.append("Tutar: " + selectedCar.calculateRentalFee(gun) + " TL\n");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Lütfen geçerli bir gün sayısı girin!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Araç bulunamadı veya şu an MÜSAİT DEĞİL!", "Hata", JOptionPane.WARNING_MESSAGE);
            }
        });

        // C. İADE BUTONU
        btnReturn.addActionListener(e -> {
            String plaka = JOptionPane.showInputDialog(this, "İade Edilecek Araç Plakası:");
            if (plaka == null || plaka.isEmpty()) return;

            Car car = inventory.findCarById(plaka);
            if (car != null && !car.isAvailable()) {
                car.returnCar(); // Logic çalışır (Araba açılır)
                displayArea.append("\nℹ️ İADE İŞLEMİ\n");
                displayArea.append(car.getModel() + " (" + car.getVehicleId() + ") başarıyla iade alındı.\n");
                JOptionPane.showMessageDialog(this, "Araç İade Alındı!");
            } else {
                JOptionPane.showMessageDialog(this, "Hata: Araç zaten galeride veya bulunamadı.", "Hata", JOptionPane.WARNING_MESSAGE);
            }
        });

        // D. ÇIKIŞ BUTONU
        btnExit.addActionListener(e -> System.exit(0));
    }

    // Test Verisi Yükleme (Main dosyasındakilerin aynısı)
    private void initializeData() {
        inventory.addCar(new ElectricCar("34TESLA", "Tesla Model Y", 2000));
        inventory.addCar(new GasCar("34BMW", "BMW 320i", 1500));
        inventory.addCar(new GasCar("16BURSA", "Fiat Egea", 600));
        inventory.addCar(new GasCar("06ANK", "Mercedes C200", 1800));
        inventory.addCar(new ElectricCar("34TOGG", "TOGG T10X", 1200));
    }

    // Uygulamayı Başlatmak İçin Main Metodu
    public static void main(String[] args) {
        // Swing uygulamaları "Event Dispatch Thread" içinde çalışmalıdır
        SwingUtilities.invokeLater(() -> {
            new RentalGUI().setVisible(true);
        });
    }
}
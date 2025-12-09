package com.example.vehiclevocabulary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {

    private ArrayList<Vehicle> vehicleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        // Inisialisasi data kendaraan
        initVehicleData();

        // Inisialisasi komponen
        Button btnBack = findViewById(R.id.btnBack);

        // Event click Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Setup click listeners untuk setiap kendaraan
        setupVehicleClickListeners();
    }

    private void initVehicleData() {
        vehicleList = new ArrayList<>();

        vehicleList.add(new Vehicle(1, "Helicopter", "Helikopter",
                R.drawable.helicopter, R.raw.helicopter, "/ˈhelɪkɒptə(r)/",
                "A helicopter is an aircraft with rotating blades that flies vertically"));

        vehicleList.add(new Vehicle(2, "Car", "Mobil",
                R.drawable.car, R.raw.car, "/kɑː(r)/",
                "A car is a road vehicle with four wheels powered by an engine"));

        vehicleList.add(new Vehicle(3, "Motorcycle", "Motor",
                R.drawable.motorcycle, R.raw.motorcycle, "/ˈməʊtə(r)saɪkl/",
                "A motorcycle is a two-wheeled vehicle powered by an engine"));

        vehicleList.add(new Vehicle(4, "Airplane", "Pesawat Terbang",
                R.drawable.airplane, R.raw.airplane, "/ˈeə(r)pleɪn/",
                "An airplane is a powered flying vehicle with fixed wings"));

        vehicleList.add(new Vehicle(5, "Bus", "Bus",
                R.drawable.bus, R.raw.bus, "/bʌs/",
                "A bus is a large motor vehicle that carries passengers"));

        vehicleList.add(new Vehicle(6, "Train", "Kereta Api",
                R.drawable.train, R.raw.train, "/treɪn/",
                "A train is a connected series of rail vehicles that run on tracks"));

        vehicleList.add(new Vehicle(7, "Ship", "Kapal",
                R.drawable.ship, R.raw.ship, "/ʃɪp/",
                "A ship is a large boat for transporting people or goods by sea"));

        vehicleList.add(new Vehicle(8, "Bicycle", "Sepeda",
                R.drawable.bicycle, R.raw.bicycle, "/ˈbaɪsɪkl/",
                "A bicycle is a vehicle with two wheels powered by pedaling"));

        vehicleList.add(new Vehicle(9, "Truck", "Truk",
                R.drawable.truck, R.raw.truck, "/trʌk/",
                "A truck is a large vehicle for transporting goods"));

        vehicleList.add(new Vehicle(10, "Boat", "Perahu",
                R.drawable.boat, R.raw.boat, "/bəʊt/",
                "A boat is a small vessel for traveling on water"));
    }

    private void setupVehicleClickListeners() {
        int[] vehicleIds = {
                R.id.vehicleHelicopter, R.id.vehicleCar, R.id.vehicleMotorcycle,
                R.id.vehicleAirplane, R.id.vehicleBus, R.id.vehicleTrain,
                R.id.vehicleShip, R.id.vehicleBicycle, R.id.vehicleTruck,
                R.id.vehicleBoat
        };

        for (int i = 0; i < vehicleIds.length; i++) {
            final int index = i;
            LinearLayout vehicleLayout = findViewById(vehicleIds[i]);
            vehicleLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDetailActivity(vehicleList.get(index));
                }
            });
        }
    }

    private void openDetailActivity(Vehicle vehicle) {
        Intent intent = new Intent(VocabularyActivity.this, DetailActivity.class);
        intent.putExtra("english_name", vehicle.getEnglishName());
        intent.putExtra("indonesian_name", vehicle.getIndonesianName());
        intent.putExtra("image_resource", vehicle.getImageResource());
        intent.putExtra("audio_resource", vehicle.getAudioResource());  // TAMBAHKAN INI
        intent.putExtra("pronunciation", vehicle.getPronunciation());
        intent.putExtra("description", vehicle.getDescription());
        startActivity(intent);
    }
}
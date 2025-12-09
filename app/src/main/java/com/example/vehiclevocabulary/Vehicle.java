package com.example.vehiclevocabulary;

public class Vehicle {
    private int id;
    private String englishName;
    private String indonesianName;private int imageResource;
    private int audioResource; // UBAH: Tipe data harus int, bukan String
    private String pronunciation;
    private String description;

    // UBAH: Tambahkan parameter 'int audioResource' ke dalam konstruktor
    public Vehicle(int id, String englishName, String indonesianName,
                   int imageResource, int audioResource, String pronunciation, String description) {
        this.id = id;
        this.englishName = englishName;
        this.indonesianName = indonesianName;
        this.imageResource = imageResource;
        this.audioResource = audioResource; // SEKARANG ini akan berfungsi dengan benar
        this.pronunciation = pronunciation;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getIndonesianName() {
        return indonesianName;
    }

    public int getImageResource() {
        return imageResource;
    }

    // UBAH: Getter untuk audioResource harus mengembalikan int
    public int getAudioResource() {
        return audioResource;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getDescription() {
        return description;
    }
}

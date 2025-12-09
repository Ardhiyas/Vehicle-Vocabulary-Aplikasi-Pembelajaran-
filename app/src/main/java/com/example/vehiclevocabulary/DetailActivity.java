package com.example.vehiclevocabulary;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int audioResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi komponen
        Button btnBackDetail = findViewById(R.id.btnBackDetail);
        ImageView imgVehicleDetail = findViewById(R.id.imgVehicleDetail);
        TextView txtEnglishName = findViewById(R.id.txtEnglishName);
        TextView txtIndonesianName = findViewById(R.id.txtIndonesianName);
        TextView txtPronunciation = findViewById(R.id.txtPronunciation);
        TextView txtDescription = findViewById(R.id.txtDescription);
        Button btnPronounce = findViewById(R.id.btnPronounce);

        // Ambil data dari intent
        String englishName = getIntent().getStringExtra("english_name");
        String indonesianName = getIntent().getStringExtra("indonesian_name");
        int imageResource = getIntent().getIntExtra("image_resource", 0);
        audioResource = getIntent().getIntExtra("audio_resource", 0);  // AMBIL AUDIO
        String pronunciation = getIntent().getStringExtra("pronunciation");
        String description = getIntent().getStringExtra("description");

        // Set data ke komponen
        txtEnglishName.setText(englishName);
        txtIndonesianName.setText(indonesianName);
        txtPronunciation.setText(pronunciation);
        txtDescription.setText(description);
        imgVehicleDetail.setImageResource(imageResource);

        // Event click Back
        btnBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Event click Pronounce - PUTAR AUDIO
        btnPronounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });
    }

    private void playAudio() {
        try {
            // Stop audio yang sedang berjalan (jika ada)
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
                mediaPlayer = null;
            }

            // Buat MediaPlayer baru dan putar audio
            mediaPlayer = MediaPlayer.create(this, audioResource);

            if (mediaPlayer != null) {
                mediaPlayer.start();

                // Listener ketika audio selesai
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                        mediaPlayer = null;
                    }
                });

                Toast.makeText(this, "Playing audio...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Audio file not found!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error playing audio: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop audio ketika activity di-pause
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Pastikan MediaPlayer di-release
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
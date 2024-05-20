package com.iremse.meditasyonuygulamasi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MuzikActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton arpBtn, celloBtn, kemanBtn, keyboardBtn, kgitarBtn, egitarBtn;
    private MediaPlayer mediaPlayer;
    private int currentSong = 0; // Şu an çalınan şarkının raw dosya kaynağı

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzik);

        // ImageButton'ları tanımla
        arpBtn = findViewById(R.id.arp_btn);
        celloBtn = findViewById(R.id.cello_btn);
        kemanBtn = findViewById(R.id.keman_btn);
        keyboardBtn = findViewById(R.id.keyboard_btn);
        kgitarBtn = findViewById(R.id.kgitar_btn);
        egitarBtn = findViewById(R.id.egitar_btn);

        // OnClickListener'ları ayarla
        arpBtn.setOnClickListener(this);
        celloBtn.setOnClickListener(this);
        kemanBtn.setOnClickListener(this);
        keyboardBtn.setOnClickListener(this);
        kgitarBtn.setOnClickListener(this);
        egitarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Tıklanan ImageButton'a göre ilgili şarkıyı çal veya duraklat
        int selectedSong = 0;
        if (v.getId() == R.id.arp_btn) {
            selectedSong = R.raw.arpmuzik;
        } else if (v.getId() == R.id.cello_btn) {
            selectedSong = R.raw.cellomuzik;
        } else if (v.getId() == R.id.keman_btn) {
            selectedSong = R.raw.kemanmuzik;
        } else if (v.getId() == R.id.keyboard_btn) {
            selectedSong = R.raw.pianomuzik;
        } else if (v.getId() == R.id.kgitar_btn) {
            selectedSong = R.raw.klasikgitarmuzik;
        } else if (v.getId() == R.id.egitar_btn) {
            selectedSong = R.raw.elektrogitarmuzik;
        }

        if (selectedSong != 0) {
            // Eğer mediaPlayer nesnesi yoksa veya seçilen şarkı farklı ise, yeni şarkıyı başlat
            if (mediaPlayer == null || selectedSong != currentSong) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), selectedSong);
                mediaPlayer.start();
                currentSong = selectedSong;
            } else {
                // Eğer aynı şarkı çalınıyorsa, şarkıyı duraklat veya devam ettir
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Uygulama kapatıldığında MediaPlayer kaynaklarını serbest bırak
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

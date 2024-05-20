package com.iremse.meditasyonuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MeditasyonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditasyon);
        VideoView videoView = findViewById(R.id.videoView);

        // Video dosyasının URI'sini oluşturun
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.medvid; // R.raw.my_video, raw klasöründeki video dosyasının adı
        Uri uri = Uri.parse(videoPath);

        // VideoView'e URI'yi ayarlayın
        videoView.setVideoURI(uri);

        // Videoyu oynatmak için MediaController ekleyin
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Videoyu başlatın
        videoView.start();
    }
}

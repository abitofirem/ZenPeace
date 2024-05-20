package com.iremse.meditasyonuygulamasi;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;


public class TimeFragment extends Fragment {

    Chronometer kronometre;
    Button basladur, restart;
    long fark;
    int deger=0;

    public TimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        kronometre = view.findViewById(R.id.kronometre);
        basladur = view.findViewById(R.id.basladur);
        restart = view.findViewById(R.id.restart);

        // Rengi değiştirmek için kullanacağınız renk
        int color = Color.parseColor("#FB488C"); // Örnek olarak kırmızı rengi seçiyoruz

        // Rengi değiştirme
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);

        // ImageView'e mipmap'teki görseli yükleme
        imageView.setImageResource(R.mipmap.clock); // "your_mipmap_image" yerine kendi mipmap görselinizin adını yazın

        basladur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deger == 0) {
                    kronometre.setBase(SystemClock.elapsedRealtime());
                    kronometre.start();
                    basladur.setText("DURDUR");
                    deger = 1;
                } else if (deger == 1) {
                    fark = SystemClock.elapsedRealtime();
                    kronometre.stop();
                    basladur.setText("DEVAM ETTİR");
                    deger = 2;
                } else {
                    kronometre.setBase(kronometre.getBase() + SystemClock.elapsedRealtime() - fark);
                    basladur.setText("DURDUR");
                    kronometre.start();
                    deger = 1;
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kronometre.setBase(SystemClock.elapsedRealtime());
                kronometre.start();
                basladur.setText("DURDUR");
                deger = 1;
            }
        });

        return view;
    }
}

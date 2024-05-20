package com.iremse.meditasyonuygulamasi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {

    private ImageButton yogi_btn,med_btn,nefes_btn,muzik_btn;


    Button btn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        yogi_btn = view.findViewById(R.id.button4);
        yogi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),YogaActivity.class);
                startActivity(intent);
            }
        });

        View view2 = inflater.inflate(R.layout.fragment_home, container, false);
        med_btn = view.findViewById(R.id.button1);
        med_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MeditasyonActivity.class);
                startActivity(intent);
            }
        });

        View view3 = inflater.inflate(R.layout.fragment_home, container, false);
        nefes_btn = view.findViewById(R.id.button2);
        nefes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NefesActivity.class);
                startActivity(intent);
            }
        });

        View view4 = inflater.inflate(R.layout.fragment_home, container, false);
        muzik_btn = view.findViewById(R.id.button3);
        muzik_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MuzikActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
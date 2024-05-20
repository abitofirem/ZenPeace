package com.iremse.meditasyonuygulamasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.widget.SearchView;

public class ArticlesFragment extends Fragment {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        // Eklemeler buraya gelecek
        androidData = new DataClass(getString(R.string.meditasyon_nedir_baslik), getString(R.string.meditasyonnedir),  R.drawable.meditasyonnedir);
        dataList.add(androidData);

        androidData = new DataClass(getString(R.string.meditasyonun_faydalari_baslik), getString(R.string.meditasyonunfaydalari),  R.drawable.fayda);
        dataList.add(androidData);

        androidData = new DataClass(getString(R.string.meditasyona_baslanir_baslik), getString(R.string.meditasyonabaslamarehberi), R.drawable.meditasyonabaslama);
        dataList.add(androidData);

        androidData = new DataClass(getString(R.string.meditasyon_ve_uyku_iliskisi_baslik), getString(R.string.meditasyonveuyku),  R.drawable.meditasyonveuyku);
        dataList.add(androidData);

        androidData = new DataClass(getString(R.string.meditasyon_ve_yaraticilik_iliskisi_baslik), getString(R.string.meditasyonveyaraticilik),  R.drawable.yaraticilik);
        dataList.add(androidData);
        // Eklemeler burada sona erecek

        adapter = new MyAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(requireContext(), "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}
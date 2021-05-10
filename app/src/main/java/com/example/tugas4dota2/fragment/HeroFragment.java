package com.example.tugas4dota2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas4dota2.R;
import com.example.tugas4dota2.adapter.HeroAdapter;
import com.example.tugas4dota2.data.HeroData;

public class HeroFragment extends Fragment {

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_hero, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Hero Dota 2");

        HeroAdapter heroAdapter = new HeroAdapter(HeroData.generateAgent(),getContext());
        RecyclerView rvAgent = getView().findViewById(R.id.rv_hero_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        rvAgent.setLayoutManager(layoutManager);
        rvAgent.setHasFixedSize(true);
        rvAgent.setAdapter(heroAdapter);
    }
}

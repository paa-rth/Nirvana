package com.example.yogabuddy.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yogabuddy.PlayListActivity;
import com.example.yogabuddy.R;
import com.example.yogabuddy.databinding.FragmentMeditationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MeditationFragment extends Fragment {

    FirebaseAuth mAuth;

    FirebaseDatabase database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMeditationBinding binding = FragmentMeditationBinding.inflate(inflater,container,false);

        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = database.getReference();

        databaseReference.child("users").child(mAuth.getCurrentUser().getUid()).child("username").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful())
                {
                    String uername = task.getResult().getValue().toString();
                    binding.username.setText(uername);
                }
                else
                {
                    SharedPreferences prefs = getActivity().getSharedPreferences("user_data", MODE_PRIVATE);
                    String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
                    int idName = prefs.getInt("idName", 0); //0 is the default value.

                    binding.username.setText(name);

                }
            }
        });

        binding.stressReliefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Stressed");
                startActivity(intent);
            }
        });

        binding.sleepingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Sleeping");
                startActivity(intent);
            }
        });

        binding.dissapointedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Disappointed");
                startActivity(intent);
            }
        });

        binding.relievedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Relieved");
                startActivity(intent);
            }
        });

        binding.focusedMindfulnessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Focused & Mindfulness");
                startActivity(intent);
            }
        });

        binding.joggingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Jogging & Cycling");
                startActivity(intent);
            }
        });

        binding.midnightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                intent.putExtra("title","Midnight & relaxation");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}
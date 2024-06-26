package com.example.yogabuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yogabuddy.databinding.ActivityDailyQuotesBinding;

import java.util.HashMap;
import java.util.Random;

public class DailyQuotesActivity extends AppCompatActivity {

    HashMap<String,String> dailyQuotes = new HashMap<>();

    int min = 0;
    int max = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDailyQuotesBinding binding = ActivityDailyQuotesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dailyQuotes.put("The Bhagavad Gita","Yoga is the journey of the self, through the self, to the self.");
        dailyQuotes.put("Jigar Gor","Yoga is not about touching your toes, it is what you learn on the way down.");
        dailyQuotes.put("Aadil Palkhivala","True yoga is not about the shape of your body, but the shape of your life.");
        dailyQuotes.put("Bob Harper","Yoga is the fountain of youth. You're only as young as your spine is flexible.");
        dailyQuotes.put("Sadhguru","Yoga is a way of getting totally drunk — not on alcohol but on life.");
        dailyQuotes.put("Buddha","The mind is everything. What you think, you become.");
        dailyQuotes.put("Unknown","Inhale the future, exhale the past.");
        dailyQuotes.put("Amit Ray","Meditation is a way for nourishing and blossoming the divinity within you.");
        dailyQuotes.put("Amit Ray","Yoga is the space where flower blossoms.");
        dailyQuotes.put("Ram Dass","The quieter you become, the more you can hear.");
        dailyQuotes.put("T.K.V. Desikachar","The ultimate goal of yoga is to always observe things accurately, and therefore never act in a way that will make us regret our actions later.");
        dailyQuotes.put("Jason Crandell","Yoga is the perfect opportunity to be curious about who you are.");


        Random r = new Random();
        int random = r.nextInt(12);

        String firstKey = (String) dailyQuotes.keySet().toArray()[random];
        String valueForFirstKey = dailyQuotes.get(firstKey);

        binding.dailyQuotes.setText(valueForFirstKey);
        binding.quotesAthor.setText(firstKey);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(DailyQuotesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);



    }
}
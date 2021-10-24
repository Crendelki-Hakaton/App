package com.example.voice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;


public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMic(View view)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent, 10);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null)
        {
            switch (requestCode)
            {
                case 10:
                    ArrayList<String> text =  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textCommand(text.get(0));
                    break;

            }
        }
    }

    protected void textCommand(String text)
    {
        switch (text)
        {
            case "баланс карты 9954":

            case "баланс карты Visa 1":

            case "баланс карты накопления":
                Intent intent = new Intent(TwoActivity.this, Balance1.class);
                startActivity(intent);
                break;

            case "баланс карты 2465":

            case "баланс карты Visa 2":

            case "баланс карты Классик":
                Intent intent2 = new Intent(TwoActivity.this, Balance2.class);
                startActivity(intent2);
                break;

            case "перевод":
                Intent intent3 = new Intent(TwoActivity.this, Transaction.class);
                startActivity(intent3);
                break;

            case "оплата ЖКХ":
                Intent intent4 = new Intent(TwoActivity.this, JKH.class);
                startActivity(intent4);
                break;

            case "мобильная связь":
                Intent intent5 = new Intent(TwoActivity.this, mobile_com.class);
                startActivity(intent5);
                break;

            case "выход":
                finishAffinity();
                break;

        }
    }
}
package com.example.voice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;

public class JKH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jkh);
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
            case "далее":
                Intent intent = new Intent(JKH.this, TransactionSuccess.class);
                startActivity(intent);
                break;

            case "назад":
                Intent intent2 = new Intent(JKH.this, TwoActivity.class);
                startActivity(intent2);
                break;

            case "выход":
                finishAffinity();
                break;
        }
    }
}

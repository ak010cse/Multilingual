package com.onqanet.multilingual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView img_translate;
    String[] language = {"English", "Telugu","Hindi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        setClickEvent();
    }


    private void initialiseViews() {
        img_translate=(ImageView)findViewById(R.id.img_translate);
    }

    private void setClickEvent() {
        img_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(language, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        // the user clicked on colors[which]
                        switch (position){
                            case 0:
                                setLocale("en",MainActivity.this);
                                return;
                            case 1:
                                setLocale("te",MainActivity.this);
                                return;
                            case 2:
                                setLocale("hi",MainActivity.this);
                                return;
                        }
                    }
                });
                builder.show();
            }
        });
    }



    public static void setLocale(String localeName, Activity activity) {
        Locale myLocale;
        String currentLanguage = "", currentLang = "";
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = activity.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(activity, MainActivity.class);
            refresh.putExtra(currentLang, localeName);
            activity. startActivity(refresh);
            activity.finish();
        } else {
//            Toast.makeText(MainActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
            Toast.makeText(activity, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }

}
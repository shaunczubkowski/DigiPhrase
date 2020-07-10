package com.chubbyapps.digiphrase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) throws IOException {
        String audioFile = (String) view.getTag();

        int resId = getResId(audioFile, R.raw.class);

        if (resId == -1) {
            Toast.makeText(this, "Unable to play audio.", Toast.LENGTH_SHORT).show();
            return;
        }

        mediaPlayer = MediaPlayer.create(this, resId);

        mediaPlayer.start();
    }

    private int getResId(String resName, Class<?> c) {
        try {
            Field field = c.getDeclaredField(resName);
            return field.getInt(field);
        } catch (Exception e) {
            Log.i("ERROR", e.toString());
            return -1;
        }
    }
}
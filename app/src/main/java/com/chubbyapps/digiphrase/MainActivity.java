package com.chubbyapps.digiphrase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
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
        String resource = "R.raw." + audioFile;

        mediaPlayer = MediaPlayer.create(this, Uri.parse(Uri.encode(resource)));

        mediaPlayer.start();

    }
}
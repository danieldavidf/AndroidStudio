package com.example.daniel.camera_app;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity {

    private final int VIDEO_REQUEST_CODE = 100;
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video=(VideoView)findViewById(R.id.videoView);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(video.getDuration()!=0)video.start();
            }
        });
    }

    public void gravar(View v) {
        Intent camera_intent = new Intent (MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(camera_intent, VIDEO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==VIDEO_REQUEST_CODE){
            if (resultCode==RESULT_OK){
                Uri videoUri = data.getData();
                video.setVideoURI(videoUri);
                video.setMediaController(new MediaController(this));
                video.requestFocus();
                Toast.makeText(VideoActivity.this, "Vídeo gravado com sucesso.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(VideoActivity.this, "Falha na gravação do vídeo.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public File getFilePath(){
        File folder = new File("sdcard/videoapp");
        if (!folder.exists()){
            folder.mkdir();
        }
        File video_file = new File(folder, "sample_video.mp4");

        return video_file;
    }

    public void voltar(View v) {
        finish();
    }
}
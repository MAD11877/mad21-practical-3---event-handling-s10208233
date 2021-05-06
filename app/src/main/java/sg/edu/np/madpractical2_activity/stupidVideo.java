package sg.edu.np.madpractical2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class stupidVideo extends AppCompatActivity {

    private final static String TAG = "Main Activity 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stupidvideoview);
        VideoView videoViewer = findViewById(R.id.videoViewer);
        videoViewer.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.retardedvideo) );
        videoViewer.start();

    }
    @Override
    protected void  onStart(){
        super.onStart();
        Log.v(TAG,"Start!");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG,"Resume!");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG,"Pause!");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG,"Stop!");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"Destroyed!");
    }
}
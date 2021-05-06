package sg.edu.np.madpractical2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG =  "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"Create!");

        Intent receivingEnd = getIntent();
        int randomNumber = receivingEnd.getIntExtra("randomNumber", 0);

        final User melol = new User("Hank Schrader "+randomNumber,"idk sample description",10208233,false);
        final Button followbtn = findViewById(R.id.followbtn);
        Button msg = findViewById(R.id.messagebtn);
        TextView nameHolder = findViewById(R.id.nameHolder);
        TextView descHolder = findViewById(R.id.descHolder);
        final ImageView imageHolder = findViewById(R.id.imageholder);

        nameHolder.setText(melol.name);
        descHolder.setText(melol.description);



        followbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if(melol.followed == false){
                    followbtn.setText("unfollow");
                    melol.setFollowed(true);
                    imageHolder.setImageResource(R.drawable.hank_depressed);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    followbtn.setText("follow");
                    melol.setFollowed(false);
                    imageHolder.setImageResource(R.drawable.hank_happy);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                MediaPlayer media = MediaPlayer.create(MainActivity.this, R.raw.fart);
                media.start();
                if(!media.isPlaying())
                    media.release();

                Log.v(TAG, melol.getName()+melol.getId()+melol.followed);
            }
        });



        Button button = findViewById(R.id.messagebtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, stupidVideo.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart(){
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
        Log.v(TAG,"Stop!");
    }
}
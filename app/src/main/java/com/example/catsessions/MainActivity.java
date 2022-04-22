package com.example.catsessions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<User> users= new ArrayList<>();
        users.add(new User(R.drawable.ic_launcher_background,"Amany"));
        users.add(new User(R.drawable.ic_launcher_background,"Amany"));

        recyclerView=findViewById(R.id.rv);
        CustomAdapter adapter= new CustomAdapter(users);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.m_settings:
                Toast.makeText(this, "openning settings...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_camera:
                if(mediaPlayer== null){
                mediaPlayer=mediaPlayer.create(MainActivity.this,R.raw.camera);}
                mediaPlayer.start();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }

    @Override
    public void onBackPressed() {
        ExitDialog exitDialog =new ExitDialog();
        exitDialog.show(getSupportFragmentManager(),"");
        exitDialog.setCancelable(false);
    }

}
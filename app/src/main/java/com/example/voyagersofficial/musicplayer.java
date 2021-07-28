package com.example.voyagersofficial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class musicplayer extends AppCompatActivity {

    private DrawerLayout dl2;
    private ActionBarDrawerToggle abdt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);


        dl2 = (DrawerLayout) findViewById(R.id.d12);
        abdt1 = new ActionBarDrawerToggle(this, dl2, R.string.Open, R.string.Close);
        abdt1.setDrawerIndicatorEnabled(true);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view1);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id  = item.getItemId();

                if (id == R.id.test){
                    Toast.makeText(musicplayer.this, "This was Timepass", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.home12){
                    Toast.makeText(musicplayer.this, "Home!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else {
                    Toast.makeText(musicplayer.this, "Logged Out", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(),login.class));
                    finish();
                }

                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt1.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }
}
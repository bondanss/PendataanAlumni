package pnj.remedial.bondan;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import pnj.remedial.bondan.ui.berita.BeritaFragment;
import pnj.remedial.bondan.ui.home.HomeFragment;
import pnj.remedial.bondan.ui.profile.ProfileFragment;


public class HalamanUtama extends AppCompatActivity {

    SharedPreferences preferences;
    HomeFragment homeFragment=new HomeFragment();
    ProfileFragment profileFragment=new ProfileFragment();
    BeritaFragment beritaFragment=new BeritaFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        preferences = getSharedPreferences("user", MODE_PRIVATE);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, homeFragment);
        fragmentTransaction.commit();


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction
                        = getSupportFragmentManager().beginTransaction();

                if (item.getItemId()==R.id.navigation_home){
                    fragmentTransaction.replace(R.id.nav_host_fragment, homeFragment);

                }else if (item.getItemId()==R.id.navigation_dashboard){
                    fragmentTransaction.replace(R.id.nav_host_fragment, beritaFragment);

                }else {
                    fragmentTransaction.replace(R.id.nav_host_fragment, profileFragment);

                }
                fragmentTransaction.commit();

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionTambah) {
            Intent intent = new Intent(this, TambahData.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.actionData) {
            Intent intent = new Intent(this, DataAlumni.class);
            startActivity(intent);

        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return true;

    }


}
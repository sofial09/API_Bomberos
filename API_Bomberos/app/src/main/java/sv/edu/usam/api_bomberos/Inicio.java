package sv.edu.usam.api_bomberos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Inicio extends AppCompatActivity {

    FragmentIncidentes incidente = new FragmentIncidentes();
    FragmentPerfil perfil = new FragmentPerfil();
    FragmentTelefonos telefono = new FragmentTelefonos();
    FragmentSalir salir = new FragmentSalir();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(incidente);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.incidentes:
                    loadFragment(incidente);
                    return true;
                case R.id.telefonos:
                    loadFragment(telefono);
                    return true;
                case R.id.perfil:
                    loadFragment(perfil);
                    return true;
                case R.id.salir:
                    loadFragment(salir);
                    return true;
            }
            return false;
        }
    };


    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

}
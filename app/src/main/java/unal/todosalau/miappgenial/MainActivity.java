package unal.todosalau.miappgenial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Configurar barra de herramientas
    MaterialToolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Configurar título de la barra de herramientas
    TextView toolbarTitle = findViewById(R.id.toolbar_title);
    toolbarTitle.setText(R.string.app_name);

    // Configurar botón de menú de la barra de herramientas
    ImageButton menuButton = findViewById(R.id.boton_bar_menu);
    menuButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopUp(v);
        }
    });

    // Configurar barra inferior
    BottomAppBar bottomAppBar = findViewById(R.id.bottom_appbar);
    setSupportActionBar(bottomAppBar);

    // Configurar navegación en la barra inferior
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            // Lógica para manejar la selección de elementos en la barra inferior
            return true;
        }
    });
}

/**
 * Muestra un menú emergente al hacer clic en el botón de menú.
 *
 * @param v La vista que ha sido clicada.
 */
protected void showPopUp(View v) {
    PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
    // Configurar acciones para los elementos del menú emergente
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // Lógica para manejar las acciones de los elementos del menú emergente
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
    });
    // Mostrar el menú emergente
    popupMenu.show();
}
}
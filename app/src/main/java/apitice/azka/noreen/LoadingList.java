package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class LoadingList extends AppCompatActivity {
    Toolbar toolba;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_list);

        toolba=findViewById(R.id.toolba);
        toolba.setTitle("Azka Noreen");
        setSupportActionBar(toolba); //set toolbar to act as action bar
    }
}
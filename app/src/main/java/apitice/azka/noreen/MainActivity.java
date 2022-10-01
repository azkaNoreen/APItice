package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText u,p;
    Button signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSharedPref();


        u=findViewById(R.id.username);
        p=findViewById(R.id.password);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=u.getText().toString();
                String password=p.getText().toString();
                putPrefernceValues(username,password);
            }
        });


    }
    public void initSharedPref(){
        sharedPreferences=getSharedPreferences("practicePreferences",MODE_PRIVATE);
        sharedPreferencesEditor=sharedPreferences.edit();

    }
    public void putPrefernceValues(String n, String p){
        sharedPreferencesEditor.putString("Name",n);
        sharedPreferencesEditor.putString("Password",p);
        sharedPreferencesEditor.apply();
    }
}
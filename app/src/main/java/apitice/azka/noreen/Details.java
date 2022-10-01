package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView n,e,g,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        n=findViewById(R.id.name);
        e=findViewById(R.id.email);
        g=findViewById(R.id.gender);
        s=findViewById(R.id.status);

        Intent intent=getIntent();
        n.setText("Name: "+intent.getStringExtra("Name"));
        e.setText("Email: "+intent.getStringExtra("Email"));
        g.setText("Gender: "+intent.getStringExtra("Gender"));
        s.setText("Status: "+intent.getStringExtra("Status"));
    }
}
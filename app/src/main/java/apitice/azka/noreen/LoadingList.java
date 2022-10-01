package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingList extends AppCompatActivity {
    Toolbar toolba;
    TextView tn;
    ProgressBar pb;
    RecyclerView  rcl;
    List<Users> userss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_list);

        toolba=findViewById(R.id.toolba);
        pb=findViewById(R.id.progressBar);
        rcl=findViewById(R.id.rcl);
        toolba.setTitle("Azka Noreen");
        setSupportActionBar(toolba); //set toolbar to act as action bar
        getAllUser();
    }
    private void getAllUser(){
        RetrofitClient retrofitClient= new RetrofitClient();
        Call<List<Users>> userCall= retrofitClient.getUserService().getAllUsers();
//        final List<Users> dataList;
        userCall.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(response!=null){
                    List<Users> dataList= response.body();
                    if(dataList != null && dataList.size()>0){
                        String name= dataList.get(3).getName();
                        pb.setVisibility(View.GONE);
                        initRCL(dataList);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });
    }
    public void initRCL(List<Users> ls){
        RecyclerViewAdapter rva=new RecyclerViewAdapter();
        rcl.setAdapter(rva);
        rcl.setLayoutManager(new LinearLayoutManager(this));
        rva.setData(ls);
    }
}
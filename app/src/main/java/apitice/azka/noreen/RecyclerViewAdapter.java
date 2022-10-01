package apitice.azka.noreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Users> studentArrayList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Users st=studentArrayList.get(position);
        StudentViewHolder studentViewHolder= (StudentViewHolder) holder;

        studentViewHolder.studentTextName.setText(st.getName());
        studentViewHolder.studentPhone.setText(st.getId()+"");
        studentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), st.getName(), Toast.LENGTH_SHORT).show();
//                myInterface.onStudentClick(st);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }
    public void setData(List<Users> StudentArrayList){
        this.studentArrayList=StudentArrayList;
        notifyDataSetChanged();
    }
//to find views of single list xml file
    public static class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView studentTextName;
        TextView studentPhone;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            studentTextName=itemView.findViewById(R.id.name);
            studentPhone=itemView.findViewById(R.id.email);

        }
    }

}

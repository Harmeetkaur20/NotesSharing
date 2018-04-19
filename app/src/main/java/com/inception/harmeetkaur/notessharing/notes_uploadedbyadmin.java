package com.inception.harmeetkaur.notessharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inception.harmeetkaur.notessharing.datamodels.notes_details_data;

import java.util.ArrayList;

public class notes_uploadedbyadmin extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<notes_details_data> notes_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_uploadedbyadmin);



            notes_list = new ArrayList<>();

            recyclerView = findViewById(R.id.notes_me_recycler);

            recyclerView.setLayoutManager(new LinearLayoutManager(notes_uploadedbyadmin.this, LinearLayoutManager.VERTICAL, false));


            get_department();

        }


    private void get_data_from_firebase( String department_name )
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        String email = auth.getCurrentUser().getEmail();

        database.getReference().child("notes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot snap : dataSnapshot.getChildren())
                {

                    for(DataSnapshot snap2 : snap.getChildren())
                    {

                        if(snap2.getKey().equals("harmeet@gmailcom"))
                        {
                            for(DataSnapshot snap3 : snap2.getChildren())
                            {
                                notes_details_data data = snap3.getValue(notes_details_data.class);
                                notes_list.add(data);
                            }
                        }
                    }

                }

                recyclerView.setAdapter(new Adapter());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void get_department()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        String email =  auth.getCurrentUser().getEmail();

        database.getReference().child("users").child(email.replace(".","")).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String departmentSession =  dataSnapshot.child("department").getValue().toString()+"_"+dataSnapshot.child("session").getValue().toString();

                get_data_from_firebase(departmentSession);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void move_back2(View view) {
        finish();
    }

    public void move_back(View view) {
        finish();
    }


    public class view_holder extends RecyclerView.ViewHolder
    {

        TextView notes_title , notes_description , time ;

        public view_holder(View itemView) {
            super(itemView);

            notes_title = itemView.findViewById(R.id.notes_title);

            notes_description = itemView.findViewById(R.id.notes_description);

            time = itemView.findViewById(R.id.notes_date);
        }
    }


    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new view_holder(LayoutInflater.from (notes_uploadedbyadmin.this).inflate(R.layout.single_notes_cell , parent , false));
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            notes_details_data data = notes_list.get(position);

            holder.notes_title.setText(data.title);

            holder.notes_description.setText(data.description);
        }

        @Override
        public int getItemCount() {
            return notes_list.size();
        }
    }
}




package com.example.bull_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class phe_complaint extends AppCompatActivity {

    Button submit ;
    String[] dist={"Baramulla", "Srinagar", "Budgam", "Bandipora"};
    AutoCompleteTextView autoCompleteTextView;
    EditText name , email , address, problem_description;
    DatabaseReference register_complaint;
    ProgressDialog progressDialog;


    ArrayAdapter<String> adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phe_complaint);



//        HOOKS
        submit = findViewById(R.id.submit_phe_complaint);
        autoCompleteTextView=findViewById(R.id.auto_complete);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        problem_description = findViewById(R.id.problem_description);


        adapter_items=new ArrayAdapter<String>(this, R.layout.list, dist);
        autoCompleteTextView.setAdapter(adapter_items);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegesterComplaint();
            }
            public void RegesterComplaint(){

                register_complaint = FirebaseDatabase.getInstance().getReference().child("PheComplaints");

                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Address=address.getText().toString();
                String ProblemDescription =problem_description.getText().toString();

                class registerComplaint{
                    String Email = email.getText().toString();
                    String Name = name.getText().toString();
                    String Address=address.getText().toString();
                    String ProblemDescription =problem_description.getText().toString();
                    String District =autoCompleteTextView.getText().toString();


                    public String getUser() {
                        return Name;
                    }

                    public String getEmail() {
                        return Email;
                    }


                    public String getAddress() {
                        return Address;
                    }

                    public String getDistrict() {
                        return District;
                    }

                    public String getProblemDescription() {
                        return ProblemDescription;
                    }
                }
                if(Name.isEmpty() || Email.isEmpty() || Address.isEmpty() || ProblemDescription.isEmpty())
                {
                    Toast.makeText(phe_complaint.this, "Every Field Must Be Filled", Toast.LENGTH_SHORT).show();
                }
                else{
//                    progressDialog.setMessage("Registration.....");
//                    progressDialog.setTitle("Registration");
//                    progressDialog.setCanceledOnTouchOutside(false);
//                    progressDialog.show();
                    registerComplaint COMPLAINT = new registerComplaint();
                    register_complaint.push().setValue(COMPLAINT);

                    Toast.makeText(phe_complaint.this, "Complaint Regester Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(phe_complaint.this,phe_dashboard.class);
                    startActivity(i);
                    finish();
                }

            }

        });


    }
}
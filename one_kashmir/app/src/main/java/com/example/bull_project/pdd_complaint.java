package com.example.bull_project;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;

public class pdd_complaint extends AppCompatActivity {

    Button submit ;
    String[] dist={"Baramulla", "Srinagar", "Budgam", "Bandipora"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd_complaint);


        autoCompleteTextView=findViewById(R.id.auto_complete);
        adapter_items=new ArrayAdapter<String>(this, R.layout.list, dist);
        autoCompleteTextView.setAdapter(adapter_items);

        submit = findViewById(R.id.submit_phe_complaint);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pdd_complaint.this, pdd_dashboard.class);
                startActivity(i);
                finish();
            }
        });



    }
}
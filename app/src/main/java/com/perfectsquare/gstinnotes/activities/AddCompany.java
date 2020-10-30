package com.perfectsquare.gstinnotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.perfectsquare.gstinnotes.R;
import com.perfectsquare.gstinnotes.dao.CompanyDao;
import com.perfectsquare.gstinnotes.database.CompanyDatabase;
import com.perfectsquare.gstinnotes.entities.Company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddCompany extends AppCompatActivity {

    EditText inputCompanyName,inputGstin,inputContactPerson,inputMobile,inputEmail,inputAddress;
    Spinner spinnerCompanyType;
    TextView textViewSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        spinnerCompanyType = findViewById(R.id.SpinnerCompanyType);
        textViewSubmit = findViewById(R.id.textViewSubmit);

        ArrayAdapter<CharSequence> adaptercompType = ArrayAdapter.createFromResource(this,R.array.Company_type,android.R.layout.simple_spinner_item);
        adaptercompType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompanyType.setAdapter(adaptercompType);

        inputCompanyName = findViewById(R.id.InputCompanyName);
        inputGstin = findViewById(R.id.InputGSTIN);
        inputContactPerson = findViewById(R.id.InputContactPerson);
        inputMobile = findViewById(R.id.InputContactMOB);
        inputEmail = findViewById(R.id.inputEmail);
        inputAddress = findViewById(R.id.inputAddress);



        findViewById(R.id.ImageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        textViewSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCompany();
            }
        });

    }

    public void saveCompany(){
        if(inputCompanyName.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Company Name Can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else if(inputGstin.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"GSTIN No can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else if(inputContactPerson.getText().toString().isEmpty()){
            Toast.makeText(this,"GSTIN No can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else if(inputMobile.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Mobile No Can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else if(inputEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Email Address Can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else if(inputAddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Address Can't be empty",Toast.LENGTH_SHORT).show();
            return;
        }else{

            final Company company = new Company();
            company.setCompany_type(spinnerCompanyType.getSelectedItem().toString());
            company.setCompany_name(inputCompanyName.getText().toString());
            company.setGstin(inputGstin.getText().toString());
            company.setContact_person(inputContactPerson.getText().toString());
            company.setMob_no(inputMobile.getText().toString());
            company.setEmail(inputEmail.getText().toString());
            company.setState(inputGstin.getText().toString().substring(0,2));
            company.setAddress(inputAddress.getText().toString());
            company.setCreatedAt(new SimpleDateFormat("dd-MM-yyyy HH:MM", Locale.getDefault()).format(new Date()));

            @SuppressLint("StaticFieldLeak")
            class SaveCompanyTask extends AsyncTask<Void,Void,Void>{
                @Override
                protected Void doInBackground(Void... voids) {
                    CompanyDatabase.getCompanyDatabase(getApplicationContext()).companyDao().InsertCompany(company);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    Intent intent = new Intent();
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }

            new SaveCompanyTask().execute();

        }
    }
}
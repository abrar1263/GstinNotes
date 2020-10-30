package com.perfectsquare.gstinnotes.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.perfectsquare.gstinnotes.R;
import com.perfectsquare.gstinnotes.activities.AddCompany;
import com.perfectsquare.gstinnotes.adapters.CompanyAdapters;
import com.perfectsquare.gstinnotes.database.CompanyDatabase;
import com.perfectsquare.gstinnotes.entities.Company;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_COMPANY = 1;

    private RecyclerView companyRecyclerview;
    private List<Company> companyList;
    private CompanyAdapters companyAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ImageAddPerson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), AddCompany.class),REQUEST_CODE_ADD_COMPANY);
            }
        });

        companyRecyclerview = findViewById(R.id.RecyclerCompany);
        companyRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        companyList = new ArrayList<>();
        companyAdapters = new CompanyAdapters(companyList);
        companyRecyclerview.setAdapter(companyAdapters);

        getCompany();
    }

    private void getCompany(){

        class GetCompanyTask extends AsyncTask<Void,Void, List<Company>>{

            @Override
            protected List<Company> doInBackground(Void... voids) {
                return CompanyDatabase.getCompanyDatabase(getApplicationContext()).companyDao().getAllCompany();
            }

            @Override
            protected void onPostExecute(List<Company> companies) {
                super.onPostExecute(companies);
                if(companyList.size()==0){
                    companyList.addAll(companies);
                    companyAdapters.notifyDataSetChanged();
                }else{
                    companyList.add(0,companies.get(0));
                    companyAdapters.notifyItemInserted(0);
                }
                companyRecyclerview.smoothScrollToPosition(0);
            }
        }
        new GetCompanyTask().execute();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ADD_COMPANY && resultCode == RESULT_OK){
            getCompany();
        }

    }
}
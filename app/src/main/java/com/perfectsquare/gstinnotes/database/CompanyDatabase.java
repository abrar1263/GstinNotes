package com.perfectsquare.gstinnotes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.perfectsquare.gstinnotes.dao.CompanyDao;
import com.perfectsquare.gstinnotes.entities.Company;

@Database(entities = Company.class,version = 1,exportSchema = false)
public abstract class CompanyDatabase extends RoomDatabase {

    public static CompanyDatabase companyDatabase;

    public static synchronized CompanyDatabase getCompanyDatabase(Context context){
        if(companyDatabase == null){
            companyDatabase = Room.databaseBuilder(
                    context,
                    CompanyDatabase.class,
                    "company_db"
            ).build();
        }
        return companyDatabase;
    }

    public  abstract CompanyDao companyDao();


}

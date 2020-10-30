package com.perfectsquare.gstinnotes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.perfectsquare.gstinnotes.entities.Company;

import java.util.List;

@Dao
public interface CompanyDao {

    @Query("SELECT * FROM company ORDER BY id DESC")
    List<Company> getAllCompany();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertCompany(Company company);

    @Delete
    void DeleteNote(Company company);

}

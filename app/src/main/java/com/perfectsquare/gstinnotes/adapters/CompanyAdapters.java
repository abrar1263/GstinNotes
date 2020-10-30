package com.perfectsquare.gstinnotes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perfectsquare.gstinnotes.R;
import com.perfectsquare.gstinnotes.entities.Company;

import java.util.List;

public class CompanyAdapters extends RecyclerView.Adapter<CompanyAdapters.CompanyViewHolder> {

    private List<Company> company;

    public CompanyAdapters(List<Company> company) {
        this.company = company;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CompanyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_company
                        ,parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        holder.setCompany(company.get(position));
    }

    @Override
    public int getItemCount() {
        return company.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class CompanyViewHolder extends RecyclerView.ViewHolder{

        TextView textCompanyName,textGstin;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            textCompanyName = itemView.findViewById(R.id.textCompName);
            textGstin = itemView.findViewById(R.id.textGst);
        }

        void setCompany(Company company){
            textCompanyName.setText(company.getCompany_name());
            textGstin.setText(company.getGstin());

        }
    }
}

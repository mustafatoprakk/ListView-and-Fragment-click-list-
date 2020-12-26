package com.example.fragmentudemy;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFrag extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }

    public ListFrag() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity=(ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data=new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data));  // list
        activity.onItemSelected(0);   // activity başlatıldığında en son tıklananı okuyor
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        activity.onItemSelected(position);
    }
}
package com.example.mingi.sewoon.Event;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.Shop;
import com.example.mingi.sewoon.Shop.ShopListAdapter;

import java.util.List;


public class TourFragment extends Fragment {

    public TourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tour_fragment, container, false);
    }

    private ListView shopListView;
    private ShopListAdapter adapter;
    private List<Shop> shopList;

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

/*
        ListView listView=(ListView) getView().findViewById(R.id.tourListView);
        ArrayList<Shop> data=new ArrayList<>();
        Shop lion=new Shop(R.drawable.lion,”Lion”);
        Shop tiger=new Shop(R.drawable.tiger,”Tiger”);
        Shop dog=new Shop(R.drawable.dog,”Dog”);
        Shop cat=new Shop(R.drawable.cat,”Cat”);
        data.add(lion);
        data.add(tiger);
        data.add(dog);
        data.add(cat);
        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.Shop,data);
        listView.setAdapter(adapter);
*/

    }



}
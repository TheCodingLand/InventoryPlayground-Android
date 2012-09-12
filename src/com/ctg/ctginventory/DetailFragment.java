package com.ctg.ctginventory;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    
    // ListFragment is a very useful class that provides a simple ListView inside of a Fragment.
    // This class is meant to be sub-classed and allows you to quickly build up list interfaces
    // in your app.
    private DataSource datasource;
    private Computer computer;

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        Activity activity = getActivity();
        
        if (activity != null) {
            // Create an instance of the custom adapter for the GridView. A static array of location data
            // is stored in the Application sub-class for this app. This data would normally come
            // from a database or a web service.
        	
        	
            
        }
    }

	 public View onCreateView(LayoutInflater inflater, ViewGroup container, 
		        Bundle savedInstanceState) {
		        // Inflate the layout for this fragment
		 Bundle args = getArguments();
     	 String item = args.getString("item");
     	 datasource = new DataSource(this.getActivity());
         datasource.open();
         computer = datasource.getComputer(item);
         datasource.close();
		 View view = inflater.inflate(R.layout.item_detail_computer, container, false);
		 TextView NameTextView = (TextView) view.findViewById(R.id.detailtextcomputername);
	     NameTextView.setText(computer.getName());
		 
		     return view;
		    }

	
	

   
 
       
}
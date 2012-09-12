package com.ctg.ctginventory;

import java.util.List;

import com.ctg.ctginventory.InventoryActivity.DummySectionFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ComputerListFragment extends ListFragment {
	OnDisplayDetailViewListener mCallback;
	public interface OnDisplayDetailViewListener {
        public void onArticleSelected(String name);
    }
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnDisplayDetailViewListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnDisplayDetailViewListener");
        }
	}
    // ListFragment is a very useful class that provides a simple ListView inside of a Fragment.
    // This class is meant to be sub-classed and allows you to quickly build up list interfaces
    // in your app.
    private DataSource datasource;
    private List<Computer> computers;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        

        
        Activity activity = getActivity();
        
        if (activity != null) {
            // Create an instance of the custom adapter for the GridView. A static array of location data
            // is stored in the Application sub-class for this app. This data would normally come
            // from a database or a web service.
        	
        	datasource = new DataSource(this.getActivity());
            datasource.open();
            computers = datasource.getAllComputers();
            datasource.close();
        	
            ListAdapter listAdapter = new ComputerModelListAdapter(activity, computers);
            setListAdapter(listAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Activity activity = getActivity();
        
        if (activity != null) {   
            ListAdapter listAdapter = getListAdapter();
            Computer computer = (Computer) listAdapter.getItem(position);
            
            // Display a simple Toast to demonstrate that the click event is working. Notice that Fragments have a
            // getString() method just like an Activity, so that you can quickly access your localized Strings.
            Toast.makeText(activity, computer.getName(), Toast.LENGTH_SHORT).show();
            mCallback.onArticleSelected(computer.getName());
        }
    }
    
    
    
    public void OnItemLongClickListener(ListView l, View v, int position, long id) {
        Activity activity = getActivity();
        
        if (activity != null) {   
            ListAdapter listAdapter = getListAdapter();
            Computer computer = (Computer) listAdapter.getItem(position);
            
            // Display a simple Toast to demonstrate that the click event is working. Notice that Fragments have a
            // getString() method just like an Activity, so that you can quickly access your localized Strings.
            Toast.makeText(activity, computer.getName(), Toast.LENGTH_SHORT).show();
            mCallback.onArticleSelected(computer.getName());
            
        }
    }
       
}
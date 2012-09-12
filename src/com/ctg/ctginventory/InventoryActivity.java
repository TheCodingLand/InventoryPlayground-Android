package com.ctg.ctginventory;




import java.util.List;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class InventoryActivity extends FragmentActivity 
    implements ActionBar.TabListener, 
    ComputerListFragment.OnDisplayDetailViewListener {
	


    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    private DataSource datasource;
    private List<Computer> computers;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datasource = new DataSource(this);
        datasource.open();
        computers = datasource.getAllComputers();
        datasource.close();
        
        setContentView(R.layout.activity_inventory);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // For each of the sections in the app, add a tab to the action bar.
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section1).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section2).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section3).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section4).setTabListener(this));
    }
    public void showItemDetailTab(String item) {
    	
    	
        Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, 3);
        fragment.setArguments(args);
        getFragmentManager().beginTransaction()
            .replace(R.id.container, fragment)
            .commit();
     }
    
    


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_inventory, menu);
        return true;
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	  if (scanResult != null) {
    	      String content = scanResult.getContents();
    	      datasource = new DataSource(this);
    	      datasource.open();
    	      Computer computer = datasource.createComputer(content);
    	      //gototab3
    	      //getAssetOrAddNew(content); //TODO
    	      //populate tab3 textview to let it display details.
    	  }
    	  // else continue with any other code you need in the method
    	  
    	}

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, show the tab contents in the container
        Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        fragment.setArguments(args);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    
    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    
    
   
    
    
    public class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        
        public static final String ARG_SECTION_NUMBER = "section_number";
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	Bundle args = getArguments();
        	View view = inflater.inflate(R.layout.activity_inventory, container, false);
        
            /*TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));*/
        	switch (args.getInt(ARG_SECTION_NUMBER)) {
        	case 1:
        		gotoComputerListView();
        		
        		// Computer : User . ip . nb of screens
        		//list of computers + Users
        		//RelativeLayout relativeLayout = getComputersLayout();
        		
        		break;
        	case 2:
        		//Quick Tickets View
        		
        		break;
        	case 3:
        		gotoDetailListView(""); 
        		
        		
        		break;
        	case 4:
        		IntentIntegrator integrator = new IntentIntegrator(this.getActivity());
                integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
                
        		break;
        	}
            
        return view;
        }
    
        public void gotoComputerListView() {
            FragmentManager fm = getFragmentManager();
            
            if (fm != null) {
                // Perform the FragmentTransaction to load in the list tab content.
                // Using FragmentTransaction#replace will destroy any Fragments
                // currently inside R.id.fragment_content and add the new Fragment
                // in its place.
            	FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new ComputerListFragment());
                ft.commit();
            }
        }   
  
    }
    public void onArticleSelected(String item) {
        gotoDetailListView(item);
    }
    public void gotoDetailListView(String item) {
        FragmentManager fm = getFragmentManager();
        
        if (fm != null && item != "") {
            // Perform the FragmentTransaction to load in the list tab content.
            // Using FragmentTransaction#replace will destroy any Fragments
            // currently inside R.id.fragment_content and add the new Fragment
            // in its place.
        	
            
            getActionBar().setSelectedNavigationItem(2);
        	FragmentTransaction ft = fm.beginTransaction();
        	
            Fragment detailListFragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putString("item", item);
            detailListFragment.setArguments(args);
            ft.replace(R.id.container, detailListFragment);
            ft.commit();
            
            
        }
    } 

	
    
}

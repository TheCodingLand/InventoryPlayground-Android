package com.ctg.ctginventory;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ComputerModelListAdapter extends BaseAdapter {

    private class ViewHolder {
        public TextView textView;
    }
    
    private List<Computer> mComputers;
    private LayoutInflater  mInflater;
    
    public ComputerModelListAdapter(Context context, List<Computer> computers) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mComputers = computers;
    }
    
    @Override
    public int getCount() {
        if (mComputers != null) {
            return mComputers.size();
        }
        
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mComputers != null && position >= 0 && position < getCount()) {
            return mComputers.get(position);
        }
        
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (mComputers != null && position >= 0 && position < getCount()) {
            return mComputers.get(position).getId();
        }
        
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        View       view = convertView;
        ViewHolder viewHolder;
        
        if (view == null) {
            view = mInflater.inflate(R.layout.panel1_row, parent, false);
            
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.textComputerName);
            
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        
        Computer computer = mComputers.get(position);
        
        viewHolder.textView.setText(computer.getName());
        
        return view;
    }

}




/*
public class ComputerModelListAdapter extends ArrayAdapter<Computer> {
    private ArrayList<Computer> computers;

    public ComputerModelListAdapter(Context context, int textViewResourceId, ArrayList<Computer> computers) {
        super(context, textViewResourceId, computers);
       this.computers = computers;
    }

    public ComputerModelListAdapter(Activity activity, List<Computer> computers2) {
		// TODO Auto-generated constructor stub
    	
        this.computers = computers2;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
  if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.panel1_row, null);
  }
      
  Computer computer = computers.get(position);
  if (computer != null) {
            TextView computerName = (TextView) v.findViewById(R.id.textComputerName);
            TextView login = (TextView) v.findViewById(R.id.textUser);

      if (computer != null) {
    	  computerName.setText(computer.getName());
      }

      if(computer != null) {
    	  //login.setText(computer.getPrimaryUser().getLogin() );
    	  login.setText("test");
    	  
      }
  }
  return v;
    }
}

*/
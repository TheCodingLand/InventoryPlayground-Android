package com.ctg.ctginventory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class UriStorage {
    public static final int MEDIA_TYPE_IMAGE = 1;
//public static final int MEDIA_TYPE_VIDEO = 2;
    
    public static Uri getOutputMediaFileUri(int type){
	  return Uri.fromFile(writeMediaFile(type));
	}
	
	public static File getOutputMediaFile(){
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "ParkingExpense");
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("ParkingExpense", "failed to create directory");
	            return null;
	        }
	    
	    }
	    return mediaStorageDir;
	    }
	    
	private static File writeMediaFile(int type){

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(getOutputMediaFile().getPath() + File.separator +
	        "ParkingExpense_" + timeStamp + ".jpg");
	  /*} else if(type == MEDIA_TYPE_VIDEO) {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "VID_"+ timeStamp + ".mp4");*/
	    } else {
	        return null;
	    }

	    return mediaFile;
	}
	public static boolean stateReady(){

        String state = Environment.getExternalStorageState();
        
    	if (! Environment.MEDIA_MOUNTED.equals(state)) { 
    		String response = "problem in storage.";
    		Log.d("ParkingExpense", response);
    		return false;
    		};
		return true;
	}
}

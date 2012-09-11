package com.ctg.ctginventory;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {

  // Database fields
  private SQLiteDatabase database;
  private SqlHelper dbHelper;
  private String[] assetsAllColumns = { SqlHelper.colAssetID,
		  SqlHelper.colAssetName, SqlHelper.colAssetType, SqlHelper.colAssetPictureFilePath };

  public DataSource(Context context) {
    dbHelper = new SqlHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Asset createAsset(String name, String type, String filename) {
    ContentValues values = new ContentValues();
    values.put(SqlHelper.colAssetName, name);
    values.put(SqlHelper.colAssetType, type);
    values.put(SqlHelper.colAssetPictureFilePath, filename);
    long insertId = database.insert(SqlHelper.assetTableName, null,
        values);
    Cursor cursor = database.query(SqlHelper.assetTableName,
        assetsAllColumns, SqlHelper.colAssetID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Asset newAsset = cursorToAsset(cursor);
    cursor.close();
    return newAsset;
  }
  
  public Computer createComputer(String name) {
    //SqlHelper.colComputerID
	//create asset using supplied info
	Asset asset = createAsset(name, "computer", "");
    //returns Asset with ID so we create a computer with this exact ID. (check id exists first)
	ContentValues values = new ContentValues();
    values.put(SqlHelper.colComputerAsset, asset.getId());
    values.put(SqlHelper.colComputerCpu, "intel");
    values.put(SqlHelper.colComputerMemory, "4G");
    values.put(SqlHelper.colComputerWindowsVersion, "W7");
    values.put(SqlHelper.colComputerReservedIP, "xxx.xxx.xxx.xxx");
    
    long insertId = database.insert(SqlHelper.computerTableName, null, values);
    Cursor cursor = database.query(SqlHelper.computerTableName,
        assetsAllColumns, SqlHelper.colAssetID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Computer newComputer =  (Computer) cursorToAsset(cursor);
    cursor.close();
    return newComputer;
  
  }

  public void deleteAsset(Asset asset) {
    long id = asset.getId();
    System.out.println("Asset deleted with id: " + id);
    database.delete(SqlHelper.assetTableName, SqlHelper.colAssetID
        + " = " + id, null);
  }

  public List<Asset> getAllAssets() {
    List<Asset> assets = new ArrayList<Asset>();

    Cursor cursor = database.query(SqlHelper.assetTableName,
        assetsAllColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Asset asset = cursorToAsset(cursor);
      assets.add(asset);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return assets;
  }

  private Asset cursorToAsset(Cursor cursor) {
    Asset asset = new Asset();
    asset.setId(cursor.getLong(SqlHelper.assetIdIndex));
    asset.setName(cursor.getString(SqlHelper.assetNameIndex));
    
    return asset;
  }

  public Asset getAssetFromScanedResult(String contents) {
		// TODO Auto-generated method stub
	 //Cursor cursor = database.query(SqlHelper.TABLE_ASSETS,
	 //	        allColumns, null, null, null, null, null);
     
     String q = "SELECT * FROM " + SqlHelper.assetTableName + " WHERE " + SqlHelper.colAssetName + " = " + contents +";";
     Cursor mCursor = database.rawQuery(q, null);

     Asset asset = cursorToAsset(mCursor);
        
        
	return asset;
	}
} 
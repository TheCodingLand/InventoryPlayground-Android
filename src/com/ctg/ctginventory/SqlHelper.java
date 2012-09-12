package com.ctg.ctginventory;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
	static final String dbName="InventorySQL";
	public SqlHelper(Context context) {
		  super(context, dbName, null,33); 
		  }
	// TableUser
	
	
	static final String userTableName = "users";
	static final String colUserID = "userID";
	static final String colUserName = "name";
	static final String colUserLogin = "login";
	static final String colUserEmail = "email";
	static final String colUserPhone = "phone";
	//UsereTableCreateString 
	private String UserCreateTableString = "CREATE TABLE " + userTableName + "("+ 
            colUserID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            colUserName + " TEXT, " +
            colUserLogin + " TEXT, " + 
            colUserEmail + " TEXT, " +
            colUserPhone + " TEXT" +
            ");";
	
	
	
	
	//Table Location
	static final String locationTableName = "locations";
	static final String colLocationID = "locationID";
	static final String colLocationName = "name";
	//TableCreateString 
	private String LocationCreateTableString = "CREATE TABLE " + locationTableName + "("+ 
            colLocationID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colLocationName + " TEXT" +
            ");";
	
	

            
	
	
	//ProviderTable
	static final String providerTableName = "providers";
	static final String colProviderID = "providerID";
	static final String colProviderName = "name";
	//TableCreateString
	private String ProviderCreateTableString = "CREATE TABLE " + providerTableName + "("+ 
            colProviderID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colProviderName + " TEXT" +
            ");";
	
	//Table Contact
	static final String contactTableName = "contacts";
	static final String colContactID = "contactID";
	static final String colContactFullName = "name";
	static final String colContactEmail = "email";
	static final String colContactPhone = "phone";
	static final String colContactProviderID = "provider";
	//TableCreateContract
	private String ContactCreateTableString = "CREATE TABLE " + contactTableName + "("+ 
            colContactID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colContactFullName + " TEXT, "+
            colContactEmail + " TEXT, "+
            colContactPhone + " TEXT, "+
            colContactProviderID + " INTEGER " +
            		");";
	

	//Table Contract
	static final String contractTableName = "contracts";
	static final String colContractID = "contractID";
	static final String colContractNumber = "number";
	static final String colContractStartDate = "startdate";
	static final String colContractEndDate = "enddate";
	static final String colContractProviderID = "provider";
	//TableCreateContract
	private String ContractCreateTableString = "CREATE TABLE " + contractTableName + "("+ 
            colContractID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colContractNumber + " TEXT, "+
            colContractStartDate + " TEXT, "+
            colContractEndDate + " TEXT, "+
            colContractProviderID + "INTEGER"+
            
            
            		");";
    

	
	
	//Table Asset
	static final String assetTableName = "assets";
	static final String colAssetID = "assetID";
	static final String colAssetName = "name";
	static final String colAssetPictureFilePath = "picture_file_path";
	static final String colAssetStatus = "status";
	static final String colAssetSerial = "serial";
	static final String colAssetType = "type";
	static final String colAssetLocationID = "location";
	static final String colAssetContractID = "contract";
	static final String colAssetPrimaryUserID = "user";
	
	//COLUMNS INDEXES
	static final int assetIdIndex = 0;
	static final int assetNameIndex = 1;
	static final int assetPictureIndex = 2;
	static final int assetStatusIndex = 3;
	static final int assetSerialIndex = 4;
	static final int assetTypeIndex = 5;
	static final int assetLocationIndex = 6;
	static final int assetContractIndex = 7;
	static final int assetPrimaryUserIndex = 8;
	

	//TableCreateSTRING
	private String AssetCreateTableString = "CREATE TABLE " + assetTableName + "("+ 
            colAssetID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colAssetName + " TEXT, " +
            colAssetPictureFilePath + " TEXT, " +
            colAssetStatus + " TEXT, " +
            colAssetSerial + " TEXT, " +
            colAssetType + " TEXT, " +
            //ForeignKeyLocation
            colAssetLocationID + " INTEGER, " +
            colAssetContractID + " INTEGER, " +
            colAssetPrimaryUserID + " INTEGER " +
            		");";
  
    
    

    //TableBill
	static final String billTableName = "bills";
	static final String colBillID = "billID"; 
	static final String colBillDescription = "description"; 
	static final String colBillReference = "reference";
	static final String colBillDate = "date";
	static final String colBillTotalPrice = "total";
	static final String colBillProvider = "provider";
	static final String colBillAssetID = "asset";
	//CreateTableBill
	private String BillCreateTableString = "CREATE TABLE " + billTableName + "("+ 
            colBillID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colBillDescription + " TEXT, "+
            colBillReference + " TEXT, "+
            colBillDate + " TEXT, "+
            colBillTotalPrice + " TEXT, " +
            colBillAssetID + " INTEGER ," +
            colBillProvider + " INTEGER NOT NULL ,FOREIGN KEY ("+
            colBillProvider+") REFERENCES "+
            providerTableName+" ("+colProviderID+") " +
            
            		");";
    
    
    //ComputerTable
	static final String computerTableName = "computers";
	static final String colComputerID = "computerID";
	static final String colComputerAsset = "asset";
	static final String colComputerCpu = "cpu";
	static final String colComputerMemory = "memory";
	static final String colComputerWindowsVersion = "windowsVersion";
	static final String colComputerReservedIP = "ip";
	//ComputerTableCreateString
	private String ComputerCreateTableString = "CREATE TABLE " + computerTableName + "("+ 
            colComputerID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colComputerCpu + " TEXT, " +
            colComputerMemory + " TEXT, " +
            colComputerWindowsVersion + " TEXT, " +
            colComputerReservedIP + " TEXT, " +
	        colComputerAsset + " INTEGER NOT NULL ,FOREIGN KEY ("+
            colComputerAsset+") REFERENCES "+
            assetTableName+" ("+colAssetID+")" +
            ");";
	
	
	
	//ScreenTable
	static final String screenTableName = "screens";
	static final String colScreenID = "screenID";
	static final String colScreenName = "name";
	static final String colScreenSize = "size";
	static final String colScreenComputerID = "computer";
	static final String colScreenAsset = "asset";

	//ScreenTableCreateString
	private String ScreenCreateTableString = "CREATE TABLE " + screenTableName + "("+ 
            colScreenID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            colScreenName + " TEXT, " +
            colScreenSize + " REAL, " +
            colScreenComputerID + " INTEGER, " +
            colScreenAsset + " INTEGER NOT NULL ,FOREIGN KEY ("+
            colScreenAsset+") REFERENCES "+
            assetTableName+" ("+colAssetID+") " +
            ");";
	
	//TicketTable
	static final String ticketTableName = "tickets";
	static final String colTicketID = "ticketID";
	static final String colTicketTitle = "title";
	static final String colTicketDescription = "description";
	static final String colTicketState = "state";
	static final String colTicketSolution = "solution";
	static final String colTicketImpactedPersonID = "impacted";
	static final String colTicketResponsibleID = "responsible";
	static final String colTicketAssetID = "asset";
	//TicketTableCreateString
	private String TicketCreateTableString = "CREATE TABLE " + ticketTableName + "("+ 
			colTicketID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
			colTicketTitle + " TEXT, " +
			colTicketDescription + " TEXT, " +
			colTicketState + " TEXT, " +
			colTicketSolution + " TEXT, " +
            colTicketImpactedPersonID + " INTEGER, "+
            colTicketResponsibleID + " INTEGER, "+
            colTicketAssetID + " INTEGER"+
	        ");";
		
	
	
	
    public void onCreate(SQLiteDatabase db) {
    	db.execSQL(UserCreateTableString);
    	db.execSQL(LocationCreateTableString);
    	db.execSQL(ProviderCreateTableString);
    	db.execSQL(ContactCreateTableString);
    	db.execSQL(ContractCreateTableString);
    	db.execSQL(AssetCreateTableString);
    	db.execSQL(BillCreateTableString);
    	db.execSQL(ComputerCreateTableString);
    	db.execSQL(ScreenCreateTableString);
    	db.execSQL(TicketCreateTableString);
    	
    }



	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS "+userTableName);
		db.execSQL("DROP TABLE IF EXISTS "+locationTableName);
		db.execSQL("DROP TABLE IF EXISTS "+providerTableName);
		db.execSQL("DROP TABLE IF EXISTS "+contactTableName);
		db.execSQL("DROP TABLE IF EXISTS "+contractTableName);
		db.execSQL("DROP TABLE IF EXISTS "+assetTableName);
		db.execSQL("DROP TABLE IF EXISTS "+billTableName);
		db.execSQL("DROP TABLE IF EXISTS "+computerTableName);
		db.execSQL("DROP TABLE IF EXISTS "+screenTableName);
		db.execSQL("DROP TABLE IF EXISTS "+ticketTableName);
    onCreate(db);
	}
	

} 
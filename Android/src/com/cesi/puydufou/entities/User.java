package com.cesi.puydufou.entities;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class User {
	
	private WifiInfo info;
	private String macAdress;
	
	
	public User() {
		
	}
	
	public String getMacAdress(Context context) {
        
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        info =  wifiManager.getConnectionInfo();
        
        macAdress = info.getMacAddress();
		return macAdress;
	}
	
	

}

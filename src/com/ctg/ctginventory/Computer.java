package com.ctg.ctginventory;


import java.util.List;

public class Computer extends Asset {
	
	private String cpu;
	private String memory;
	private String windowsVersion;
	private String reservedIP;
	
	
	public String getReservedIP() {
		return reservedIP;
	}

	public void setReservedIP(String reservedIP) {
		this.reservedIP = reservedIP;
	}

	private List<Screen> screens;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getWindowsVersion() {
		return windowsVersion;
	}

	public void setWindowsVersion(String windowsVersion) {
		this.windowsVersion = windowsVersion;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	public void addScreen(Screen screen) {
	    this.screens.add(screen);
	}
	
	public void removeScreen(Screen screen) {
	    this.screens.remove(screen);
	}
	
	
	}


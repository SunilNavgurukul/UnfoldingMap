package com.sunil_parcha;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class TwoMap extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This is where to find the local tiles, for working without an Internet
	 * connection
	 */
	public static String mbTilesString = "blankLight-1-3.mbtiles";

	// IF YOU ARE WORKING OFFLINE: Change the value of this variable to true
	private static final boolean offline = false;

	/** The map we use to display my home town */
	UnfoldingMap map1;

	/** The map you will use to display my live location */
	UnfoldingMap map2;

	public void setup() {
		size(800, 600, P2D); // Set up the Applet window to be 800x600
								// The OPENGL argument indicates to use the
								// Processing library's 2D drawing

		// This sets the background color for the Applet.
		this.background(100, 800, 200);

		// Select a map provider
//		AbstractMapProvider provider = new Google.GoogleTerrainProvider();
//		AbstractMapProvider provider = new Microsoft.AerialProvider();
		AbstractMapProvider provider1 = new OpenStreetMap.OpenStreetMapProvider();
		AbstractMapProvider provider2 = new OpenStreetMap.OpenStreetMapProvider();

		// Set a zoom level
		int zoomLevel = 10;

		if (offline) {
			// If you are working offline, you need to use this provider
			// to work with the maps that are local on your computer.
			provider1 = new MBTilesMapProvider(mbTilesString);
			provider2 = new MBTilesMapProvider(mbTilesString);

			// 3 is the maximum zoom level for working offline
			zoomLevel = 10;
		}

		// Create a new UnfoldingMap to be displayed in this window.
		// The 2nd-5th arguments give the map's x, y, width and height
		map1 = new UnfoldingMap(this, 410, 50, 350, 500, provider1);
		map2 = new UnfoldingMap(this, 50, 50, 350, 500, provider2);

		// The next line zooms in and centers the map at
		// 32.9 (latitude) and -117.2 (longitude)
		map1.zoomAndPanTo(zoomLevel, new Location(12.8f, 77.7f));
		map2.zoomAndPanTo(zoomLevel, new Location(28.7f, 77.0f));
		

		// This line makes the map interactive
		MapUtils.createDefaultEventDispatcher(this, map1, map2);
//		MapUtils.createDefaultEventDispatcher(this, map1);		

		// TODO: Add code here that creates map2
		// Then you'll modify draw() below

	}

	/** Draw the Applet window. */
	public void draw() {
		// So far we only draw map1...
		// TODO: Add code so that both maps are displayed
		map1.draw();
		map2.draw();
	}

}

package com.sunil_parcha;

import processing.core.PApplet;
import processing.core.PImage;

public class ChangeSunColor extends PApplet{
	PImage img;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void setup() {
		size(400, 400);
		background(225);
		stroke(0);
		
		img = loadImage("https://i1.wp.com/feminisminindia.com/wp-content/uploads/2020/08/3-edit.jpeg?resize=696%2C928&ssl=1");
		img.resize(width, height);
		image(img, 0, 0);
		
	}

	@Override
	public void draw() {
		int[] color = sunColorSec(second());
		fill(color[0], color[1], color[2]);
		ellipse(width/4, height/4, width/4, height/4);
	}
	
	public int[] sunColorSec(float second) {
		int[] rgb = new int[3];
		float diffFrom30 = Math.abs(30-second);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;

		return rgb;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especial;

/** An attempt to implement polygon union using areas. 
 * @author Alina
 * @version 1/28/2004
 */

import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

public class UseShapes {

    public static void main(String[] args) {
	Polygon firstPoly, secondPoly;
	Area firstArea, secondArea;
	
	firstPoly = new Polygon();
	firstPoly.addPoint(10,10);
	firstPoly.addPoint(10,100);
	firstPoly.addPoint(100,100);
	firstPoly.addPoint(100,10);

	secondPoly = new Polygon();
	secondPoly.addPoint(50,50);
	secondPoly.addPoint(150,10);
	secondPoly.addPoint(150,100);

	firstArea = new Area(firstPoly);
	secondArea = new Area(secondPoly);

	// perform the union
	firstArea.add(secondArea);

	// and somehow retrieve that polygon
	Polygon tempPoly = new Polygon();

	FlatteningPathIterator myPath;
	myPath = new FlatteningPathIterator(firstArea.getPathIterator(null),500);
	double[] coords = new double[6];

	while (!myPath.isDone()) { // can still iterate through this path
	    myPath.currentSegment(coords);

	    System.out.println(coords[0] + " " + coords[1]);
	    tempPoly.addPoint((int)(coords[0]), (int)(coords[1]));

	    myPath.next();
	} // while

	// for some strange reason, we need to throw out the last point of this polygon
	Polygon resultPoly = new Polygon();

	for (int i = 0; i < tempPoly.npoints-1; i++) 
	    resultPoly.addPoint(tempPoly.xpoints[i], tempPoly.ypoints[i]);

	System.out.println("the resulting polygon has " + resultPoly.npoints + " vertices");

    } // main

} // class
package com.blinkdroid.interview;

import java.util.ArrayList;
import java.util.List;


public class MostNeighbors {
  
  public static void main(String[] args) {
    final List<Point> points = new ArrayList<>();
    points.add(new Point(0,0));
    points.add(new Point(5,5));
    points.add(new Point(10,10));
    points.add(new Point(15,15));
    points.add(new Point(16,16));
    points.add(new Point(19,19));
    points.add(new Point(20,20));
    points.add(new Point(21,21));
    points.add(new Point(22,22));
    points.add(new Point(25,25));
    
    System.out.println("Point with the most neighbors --> " + getPointWithMostNeighbors(points));
  }
  
  private static Point getPointWithMostNeighbors(List<Point> points) {
    Integer maxNeighbors = 0;
    Point pointMaxNeighbors = null;
    for (Point p1 : points) {
      int neighborCount = 0;
      for (Point p2 : points) {
        final double distance = p1.getDistanceFrom(p2);
        if (distance < 5) {
          neighborCount++;
        }
      }
      if (neighborCount > maxNeighbors) {
        maxNeighbors = neighborCount;
        pointMaxNeighbors = p1;
      }
    }
    
    System.out.println("Maximum number of neighbors is: " + maxNeighbors);
    return pointMaxNeighbors;
  }
  
  private static class Point {
    
    private final int latitutde;
    private final int longitude;
    
    public Point(int latitutde, int longitude) {
      this.latitutde = latitutde;
      this.longitude = longitude;
    }
    
    public double getDistanceFrom(Point otherPoint) {
      return Math.sqrt(Math.pow((latitutde - otherPoint.latitutde), 2) + Math.pow((longitude - otherPoint.longitude),2));
    }
    
    @Override
    public String toString() {
      return "Lat: " + latitutde + ", Long: " + longitude;
    }
    
  }
  
}

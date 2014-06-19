package comparators;

import java.util.Comparator;

import resources.Point;

public class AerialDistanceComparator implements Comparator<Point> {

	private Point start;

	public AerialDistanceComparator(Point startingPoint) {
		this.start = startingPoint;
	}
	
	@Override
	public int compare(Point p1, Point p2) {
		double d1 = this.get2PointsDistanceInKm(start, p1);
		double d2 = this.get2PointsDistanceInKm(start, p2);
		return Double.compare(d1, d2);
	}
	
	private double get2PointsDistanceInKm(Point p1, Point p2) {
		return this.getDistanceFromLatLonInKm(p1.getLatitude(),
											  p1.getLongitude(),
											  p2.getLatitude(),
											  p2.getLongitude());
	}
	
	private double getDistanceFromLatLonInKm(double lat1, double lng1, double lat2, double lng2) {
	  Integer R = 6371; // Radius of the earth in km
	  double dLat = deg2rad(lat2 - lat1);
	  double dLon = deg2rad(lng2 - lng1); 
	  double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
			  	 Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
			  	 Math.sin(dLon/2) * Math.sin(dLon/2); 
	  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	  double d = R * c; // Distance in km
	  return d;
	}

	private double deg2rad(double deg) {
	  return deg * (Math.PI/180);
	}

}

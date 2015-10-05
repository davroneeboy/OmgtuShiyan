import java.awt.geom.Point2D;


public class Treugol {
	/* растояния от точки до точки*/
	public static double distance(Point2D start, Point2D end) 
    { 
        double dx = end.getX() - start.getX(); 
        double dy = end.getY() - start.getY(); 
        return Math.sqrt(dx * dx + dy * dy); 
    } 
	//возвращает периметр треугольника
public static double perimeter(Point2D pt1, Point2D pt2, Point2D pt3) 
    { 
        return distance(pt1, pt2) + distance(pt2, pt3) + distance(pt1, pt3); 
    } 
	//возврщает индексы массива точек из которых состоит треугольник
 public static int[] maximum(Point2D [] points) 
	    { 
		 
		 int iMax=0; 
        int jMax=0; 
         int kMax=0;
	 
	       	        double maxPerimeter = 0, curPerimeter = 0; 
	         
	        for(int i = 0; i < points.length; i++) 
	            for(int j = i; j < points.length; j++) 
	                for(int k = j; k < points.length; k++) 
	                    if((curPerimeter = perimeter(points[i], points[j], points[k])) > maxPerimeter) 
	                    { 
	                        maxPerimeter = curPerimeter; 
	                        iMax = i; 
	                        jMax = j; 
	                        kMax = k; 
	                    }
	        int [] triPoints = new int[3];
	        triPoints[0]=iMax;
	        triPoints[1]=jMax;
	        triPoints[2]=kMax;
	        
			return triPoints; 
	    } 


}

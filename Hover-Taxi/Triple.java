/*
 * Triple.java
 * 
 * This class is immutable
 * (as long as you don't directly change x, y, z)
*/

import java.util.Scanner;
import java.nio.FloatBuffer;

public class Triple
{

   /**
   * Instance variables
   */
   public final static Triple xAxis = new Triple(1,0,0);
   public final static Triple yAxis = new Triple(0,1,0);
   public final static Triple zAxis = new Triple(0,0,1);
   // public, but absolutely do not change them directly!
   public double x, y, z;

   /**
    * Triple constructor - creates Triple from x,y,z doubles
    * @param xIn double x value
    * @param yIn double y value
    * @param zIn double z value
    */
   public Triple(double xIn, double yIn, double zIn)
   {
      x = xIn;
      y = yIn;
      z = zIn;
   }

   /**
   * Triple constructor - creates Triple from Scanner input
   * @param input Scanner input
   */
   public Triple(Scanner input)
   {
      x = input.nextDouble();
      y = input.nextDouble();
      z = input.nextDouble();
      input.nextLine();
   }

   /**
   * vectorTo - compute the vector from this Triple to Triple v
   * @param v Triple to get vector towards
   * 
   */
   public Triple vectorTo(Triple v)
   {
      return new Triple(v.x - x, v.y - y, v.z - z);
   }

   /**
   * minus - compute this Triple minus Triple v
   * @param v Triple to subtract from this Triple
   */
   public Triple minus(Triple v)
   {
      return new Triple(x - v.x, y - v.y, z - v.z);
   }

   /**
   * add - compute this Triple added to Triple v
   * @param v Triple to add to this Triple
   */
   public Triple add(Triple v)
   {
      return new Triple(x + v.x, y + v.y, z + v.z);
   }

   /**
   * mult - compute this Triple multiplied by scalar s
   * @param s double scalar to multiply this Triple by
   */
   public Triple mult(double s)
   {
      return new Triple(s*x, s*y, s*z);
   }

   /**
   * dot - compute the dot product of this Triple and Triple v
   * @param v Triple to dot product with this Triple
   */
   public double dot(Triple v)
   {
      return x*v.x + y*v.y + z*v.z;
   }

   /**
   * norm - compute the norm of this Triple
   * @return the norm of this vector
   */
   public double norm()
   {
      return Math.sqrt(x*x + y*y + z*z);
   }

   /**
   * normalize - compute and return this Triple normalized
   * @return this Triple normalized
   */
   public Triple normalize()
   {
      double temp = 1 / norm();    
      return new Triple(temp*x, temp*y, temp*z);
   }

   /**
   * cross - compute the cross product of this Triple and Triple v
   * @param v Triple to cross product with this Triple
   */
   public Triple cross(Triple v)
   {
      return new Triple(y*v.z - v.y*z, v.x*z - x*v.z, x*v.y - v.x*y);
   }

   /**
   * sendData - send data for this Triple to FloatBuffer buffer
   * @param buffer FloatBuffer to send data to
   */
   public void sendData(FloatBuffer buffer)
   {
      buffer.put((float) x);
      buffer.put((float) y);
      buffer.put((float) z);
   }

   /**
   * toString - convert this Triple to a string
   * @return this Triple represented as a string
   */
   public String toString()
   {
      return "[" + x + " " + y + " " + z + "]";
   }

   /**
   * main method
   */
   public static void main(String[] args)
   {
      Triple v = new Triple(1, 2, 3);
      Triple w = new Triple(-4, 5, 7);
      Triple u = v.cross(w);
      System.out.println(v.dot(u) + " " + w.dot(u));
   }
}

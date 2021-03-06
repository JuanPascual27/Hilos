public class HiloVector extends Thread{
   private static double[] vector;
   public static Thread h1, h2, h3;
   
   public HiloVector(int t) {
      vector = new double[t];
      for(int i = 0; i < vector.length; i++)
         vector[i] = (int)(Math.random()*100+1);
      
      System.out.println("Elementos del vector");
      System.out.println("--------------");
      for(int i = 0; i < vector.length; i++){
         System.out.printf("| %2d | %5s |", i+1, vector[i]);
         System.out.println("\n--------------");
      }
      
      h1 = new Thread(new Runnable() {
         double x = 0;
         @Override
         public void run() {
            for(int i = 0; i < vector.length; i++) {
               //System.out.println(vector[i]);
               x += vector[i]; 
            }
            System.out.println("\nSuma de los elementos del vector: " + Double.toString(x));
         }
      });
      h2 = new Thread(new Runnable() {
         double x = 0;
         @Override
         public void run() {
            for(int i = 0; i < vector.length; i++) {
               //System.out.println(vector[i]);
               x += Math.pow(vector[i], 2); 
            }
            System.out.println("Suma de los elementos al cuadrado del vector: " + Double.toString(x));
         }
      });
      h3 = new Thread(new Runnable() {
         double x = 0;
         @Override
         public void run() {
            for(int i = 0; i < vector.length; i++) {
               //System.out.println(vector[i]);
               x += vector[i]; 
            }
            x /= vector.length;
            System.out.println("Media de los elementos del vector: " + Double.toString(x));
         }
      });
      
      h1.setPriority(MAX_PRIORITY);
      h2.setPriority(NORM_PRIORITY);
      h3.setPriority(MIN_PRIORITY);
   }
   
   public void run(){
      h1.start();
      h2.start();
      h3.start();
      
   }
   
}
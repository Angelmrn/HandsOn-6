//Moran Flores Angel Daniel
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Data data = new Data();
        data.loadTrainingData();
        ArrayList<DataPoint> trainingData = data.getTrainingData();

        Random rand = new Random();
        int k = rand.nextInt(10) + 1; // k = 1 a 10

        KNN knn = new KNN(k);

        // Agregar datos de entrenamiento al clasificador
        for (DataPoint point : trainingData) {
            knn.addTrainingData(point);
        }

        
        // Punto por clasificar (radio / textura / perímetro / área / suavidad)
        DataPoint newPoint = new DataPoint(new double[]{13.17, 21.81, 85.42,531.5, 0.09714}, "Unknown");//M
        DataPoint newPoint2 = new DataPoint(new double[]{19.02, 24.59, 122,1076, 0.09029}, "Unknown");//M
        DataPoint newPoint3 = new DataPoint(new double[]{15.46, 19.48, 101.7,748.9, 0.1092}, "Unknown");//M
        DataPoint newPoint4 = new DataPoint(new double[]{17.68, 20.74, 117.4,963.7, 0.1115}, "Unknown");//M
        DataPoint newPoint5 = new DataPoint(new double[]{13.96, 17.05, 91.43,602.4, 0.1096}, "Unknown");//M
    
        DataPoint newPoint6 = new DataPoint(new double[]{12, 15.65, 76.95, 443.3, 0.09723}, "Unknown");//B
        DataPoint newPoint7 = new DataPoint(new double[]{9.876, 19.4, 63.95, 298.3, 0.1005}, "Unknown");//B
        DataPoint newPoint8 = new DataPoint(new double[]{9.738, 11.97, 61.24, 288.5, 0.0925}, "Unknown");//B
        DataPoint newPoint9 = new DataPoint(new double[]{10.8, 9.71, 68.77, 357.6, 0.09594}, "Unknown");//B
        DataPoint newPoint10 = new DataPoint(new double[]{9, 14.4, 56.36, 246.3, 0.07005}, "Unknown");//B
       
        String result = knn.classify(newPoint);
        String result2 = knn.classify(newPoint2);
        String result3 = knn.classify(newPoint3);
        String result4 = knn.classify(newPoint4);
        String result5 = knn.classify(newPoint5);
        
        String result6 = knn.classify(newPoint6);
        String result7 = knn.classify(newPoint7);
        String result8 = knn.classify(newPoint8);
        String result9 = knn.classify(newPoint9);
        String result10 = knn.classify(newPoint10);

        System.out.println("Numero de k = " + k);
        System.out.println("Clasificado como: " + result);
        System.out.println("Clasificado como: " + result2);
        System.out.println("Clasificado como: " + result3);
        System.out.println("Clasificado como: " + result4);
        System.out.println("Clasificado como: " + result5);
        System.out.println();
        System.out.println("Clasificado como: " + result6);
        System.out.println("Clasificado como: " + result7);
        System.out.println("Clasificado como: " + result8);
        System.out.println("Clasificado como: " + result9);
        System.out.println("Clasificado como: " + result10);
        
    }
}

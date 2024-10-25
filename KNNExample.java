import java.util.Random;

public class KNNExample {
    public static void main(String[] args) {
        // Crear una instancia de Random
        Random rand = new Random();

        // Generar un número aleatorio para k (por ejemplo, entre 1 y 10)
        int k = rand.nextInt(10) + 1;

        // Crear un clasificador kNN con k aleatorio
        KNNClassifier knn = new KNNClassifier(k);

        // Datos de entrenamiento: Height / Weight
        knn.addTrainingData(new DataPoint(new double[]{173.57, 71.98}, "Normal weight"));
        knn.addTrainingData(new DataPoint(new double[]{183.56, 69.03}, "Normal weight"));
        knn.addTrainingData(new DataPoint(new double[]{182.97, 81.53}, "Normal weight"));
        knn.addTrainingData(new DataPoint(new double[]{169.49, 55.31}, "Normal weight"));
        knn.addTrainingData(new DataPoint(new double[]{158.14, 61.08}, "Normal weight"));

        knn.addTrainingData(new DataPoint(new double[]{164.12, 89.95}, "Obese"));
        knn.addTrainingData(new DataPoint(new double[]{144.70, 82.16}, "Obese"));
        knn.addTrainingData(new DataPoint(new double[]{168.28, 89.90}, "Obese"));
        knn.addTrainingData(new DataPoint(new double[]{143.52, 83.79}, "Obese"));
        knn.addTrainingData(new DataPoint(new double[]{166.96, 104.33}, "Obese"));

        knn.addTrainingData(new DataPoint(new double[]{168.45, 84.88}, "Overweight"));
        knn.addTrainingData(new DataPoint(new double[]{183.56, 92.20}, "Overweight"));
        knn.addTrainingData(new DataPoint(new double[]{142.87, 59.35}, "Overweight"));
        knn.addTrainingData(new DataPoint(new double[]{180.18, 85.77}, "Overweight"));
        knn.addTrainingData(new DataPoint(new double[]{184.98, 93.35}, "Overweight"));

        knn.addTrainingData(new DataPoint(new double[]{178.36, 57.72}, "Underweight"));
        knn.addTrainingData(new DataPoint(new double[]{167.81, 44.88}, "Underweight"));
        knn.addTrainingData(new DataPoint(new double[]{174.33, 56.11}, "Underweight"));
        knn.addTrainingData(new DataPoint(new double[]{194.68, 42.63}, "Underweight"));
        knn.addTrainingData(new DataPoint(new double[]{177.89, 43.00}, "Underweight"));

        // Puntos por clasificar
        DataPoint newPoint = new DataPoint(new double[]{179.37, 64.65}, "Unknown");
        DataPoint new1Point = new DataPoint(new double[]{185.80, 76.15}, "Unknown");
        DataPoint new2Point = new DataPoint(new double[]{173.42, 70.32}, "Unknown");
        DataPoint newP3oint = new DataPoint(new double[]{180.42, 71.38}, "Unknown");

        String result = knn.classify(newPoint);
        String result1 = knn.classify(new1Point);
        String result2 = knn.classify(new2Point);
        String result3 = knn.classify(newP3oint);
        

        // Imprimir el resultado
        System.out.println("Clasificado como: " + result);
        System.out.println("Clasificado como: " + result1);
        System.out.println("Clasificado como: " + result2);
        System.out.println("Clasificado como: " + result3);
    }
}
import java.util.ArrayList;
import java.util.List;

class KNNClassifier {
    private List<DataPoint> trainingData;
    private int k;

    public KNNClassifier(int k) {
        this.k = k;
        this.trainingData = new ArrayList<>();
    }

    // Añadir puntos de datos al conjunto de entrenamiento
    public void addTrainingData(DataPoint point) {
        trainingData.add(point);
    }

    // Clasificar un nuevo punto de datos basándose en los k vecinos más cercanos
    public String classify(DataPoint newPoint) {
        List<DataPointDistance> distances = new ArrayList<>();
        for (DataPoint point : trainingData) {
            double distance = DataPoint.calculateDistance(point, newPoint);
            distances.add(new DataPointDistance(point, distance));
        }

        // Ordenar manualmente las distancias
        sortDistances(distances);

        // Obtener las etiquetas de los k vecinos más cercanos
        List<String> nearestLabels = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            nearestLabels.add(distances.get(i).getPoint().label);
        }

        // Devolver la etiqueta más común (clasificación)
        return findMostCommonLabel(nearestLabels);
    }

    // Método para ordenar distancias manualmente
    private void sortDistances(List<DataPointDistance> distances) {
        for (int i = 0; i < distances.size() - 1; i++) {
            for (int j = 0; j < distances.size() - i - 1; j++) {
                if (distances.get(j).getDistance() > distances.get(j + 1).getDistance()) {
                    DataPointDistance temp = distances.get(j);
                    distances.set(j, distances.get(j + 1));
                    distances.set(j + 1, temp);
                }
            }
        }
    }

    // Función para encontrar la etiqueta más común
    private String findMostCommonLabel(List<String> labels) {
        String mostCommon = null;
        int maxCount = 0;
        for (String label : labels) {
            int count = countFrequency(labels, label);
            if (count > maxCount) {
                maxCount = count;
                mostCommon = label;
            }
        }
        return mostCommon;
    }

    // Función para contar la frecuencia de una etiqueta
    private int countFrequency(List<String> labels, String label) {
        int count = 0;
        for (String l : labels) {
            if (l.equals(label)) {
                count++;
            }
        }
        return count;
    }

    // Clase anidada para almacenar la distancia desde un punto de datos
    private static class DataPointDistance {
        private DataPoint point;
        private double distance;

        public DataPointDistance(DataPoint point, double distance) {
            this.point = point;
            this.distance = distance;
        }

        public DataPoint getPoint() {
            return point;
        }

        public double getDistance() {
            return distance;
        }
    }
}

class DataPoint {
    public double[] features;
    public String label;

    public DataPoint(double[] features, String label) {
        this.features = features;
        this.label = label;
    }

    // Método estático para calcular la distancia euclidiana entre dos puntos de datos
    public static double calculateDistance(DataPoint p1, DataPoint p2) {
        double sum = 0;
        for (int i = 0; i < p1.features.length; i++) {
            sum += Math.pow(p1.features[i] - p2.features[i], 2);
        }
        return Math.sqrt(sum);
    }
}

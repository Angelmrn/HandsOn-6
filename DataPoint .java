class DataPoint {
    double[] features;
    String label;

    public DataPoint(double[] features, String label) {
        this.features = features;
        this.label = label;
    }

    // Function to calculate Euclidean distance between two data points
    public static double calculateDistance(DataPoint p1, DataPoint p2) {
        double sum = 0;
        for (int i = 0; i < p1.features.length; i++) {
            sum += Math.pow(p1.features[i] - p2.features[i], 2);
        }
        return Math.sqrt(sum);
    }
}
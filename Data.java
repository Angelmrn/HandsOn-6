//Moran Flores Angel Daniel
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    private ArrayList<DataPoint> trainingData;
    

    public Data() {
        this.trainingData = new ArrayList<>();
    }

    public void loadTrainingData(){
        String filePath = "C:\\Users\\PC DPC ELITE\\Desktop\\Tec\\Aprenidzaje Automatico\\HandsOn-6\\Cancer_Data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                double[] features = new double[] {
                    Double.parseDouble(values[2]),
                    Double.parseDouble(values[3]),
                    Double.parseDouble(values[4]),
                    Double.parseDouble(values[5]),
                    Double.parseDouble(values[6])
                };
                String label = values[1]; // Usa la columna de etiqueta, por ejemplo, la columna 1

                trainingData.add(new DataPoint(features, label));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DataPoint> getTrainingData() {
        return trainingData;
    }
}

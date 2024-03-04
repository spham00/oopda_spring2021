package herd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

/**
 * This Driver class creates a DataSet based on the csv file included in the project and
 * performs actions on it.
 * 
 * @author Sarah Pham
 */
public class Driver {
	
	private static String serializeFile = "resources//randomSerialization.ser";	// The file used to serialized.
	private static String fileName = "resources//herdManagement.csv";			// The file where the data is contained.
	private static int skipRows = 3;											// The number of non-descriptive rows skipped.

	public static void main(String[] args) {
		
		DataSet dataset = new DataSet();
		
		try {
			loadStatistics(dataset, fileName, skipRows);
		} catch (StatisticDataNotFoundException e) {
			System.out.println("\nFile " + fileName + " not found at " + LocalDate.now());
		}
		
		displayStatistics(dataset);
		serializeAndDeserializeStateStatistic(dataset);
		
	}

	/**
	 * Loads the statistics from the included csv file to a DataSet.
	 * 
	 * @param dataset							The DataSet the statistics are being added to.
	 * @param fileName							The name of the file that contains the data.
	 * @param numOfHeaderRows					The number of rows to skip (header rows).
	 * @throws StatisticDataNotFoundException	Throws if the file name cannot be found.
	 */
	private static void loadStatistics(DataSet dataset, String fileName, int numOfHeaderRows) throws StatisticDataNotFoundException {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			for (int i = 0; i < numOfHeaderRows; i++)
	              reader.readLine();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(",");
				StateStatistic stat = new StateStatistic(State.valueOf(array[0]), Long.parseLong(array[1]),
					Long.parseLong(array[2]), Long.parseLong(array[3]), Long.parseLong(array[4]),
					Long.parseLong(array[5]), Long.parseLong(array[6]));
				dataset.addStatistic(stat);
			}
			reader.close();
		}
		catch (Exception e) {
			throw new StatisticDataNotFoundException("Threw StatisticDataNotFoundException");
		}
	}
	
	/**
	 * Displays each statistic from the data file.
	 * 
	 * @param dataset	The DataSet the statistics are stored in.
	 */
	private static void displayStatistics(DataSet dataset) {
		
		System.out.println("Here are the different statistics in the data file:\n");
		dataset.getStats().forEach(s -> System.out.println(s));
	}
	
	/**
	 * Serializes and deserializes a random StateStatistic from the DataSet, and
	 * then displays the number of burros and horses for that StateStatistic.
	 * 
	 * @param dataset	The DataSet a random Statistic will be chosen from.
	 */
	private static void serializeAndDeserializeStateStatistic(DataSet dataset) {
				
		Statistic.serialize(dataset.getStats().get((int)(Math.random() * (dataset.getStats().size() - 1))), serializeFile);
		StateStatistic newStat = Statistic.deserialize(serializeFile);
		
		System.out.println("\nThere are " + newStat.getNumBurros() + " burros and " + newStat.getNumHorses() + " horses in " 
				+ newStat.getState() + ".");
	}
}

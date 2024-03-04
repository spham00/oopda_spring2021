package herd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A superclass to allow for future expansion in which additional forms
 * of statistics may be introduced.
 * 
 * @author myersjac
 *
 */
public class Statistic implements Serializable {
	
	private static final long serialVersionUID = -200347581739009347L;
	
	/**
	 * Serializes a random Statistic from the DataSet.
	 * 
	 * @param dataset		The DataSet of statistics that will be serialized.
	 * @param fileName		The name of the file the data should be serialized to.
	 */
	public static void serialize(Statistic randomStat, String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(randomStat);
			out.close();
			fileOut.close();
			System.out.printf("\nSerialized data is saved in %s", fileName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deserializes the serialized StateStatistic within a file.
	 * 
	 * @param fileName		The name of the file that contains the serialized data.
	 * @return				The deserialized StateStatistic.
	 */
	public static StateStatistic deserialize(String fileName) {
		StateStatistic stat = null;
		try {
			FileInputStream fileIn = null;
			ObjectInputStream in = null;
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			stat = (StateStatistic)in.readObject();
			in.close();
			fileIn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return stat;
	}
	
}
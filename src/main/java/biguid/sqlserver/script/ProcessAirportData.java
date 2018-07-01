package biguid.sqlserver.script;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

public class ProcessAirportData {
	public static void main(String[] args) {
		File file = new File("E:\\Workspace\\Java\\sqlserver.generator\\src\\resources\\Airport.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				int begin = line.indexOf("(");
				int end = line.indexOf(")");
				if (begin == -1 || end == -1) {
					continue;
				}
				String airport = line.substring(begin + 1, end);
				lines.add(airport);

			}
			reader.close();
			File file1 = new File("E:\\Workspace\\Java\\sqlserver.generator\\src\\resources\\Airport.json");
			file1.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
			String json = new GsonBuilder().setPrettyPrinting().create().toJson(lines);
			writer.write(json);
			writer.close();
			System.out.print("Finish");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

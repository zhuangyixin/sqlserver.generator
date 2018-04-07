package biguid.sqlserver.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public abstract class Generator {
	protected List<String> data;

	public Generator() {
		this.data = this.getData();
	}

	public abstract String get();

	private static final String resourcePath = "E:\\Workspace\\Java\\sqlserver.generator\\src\\resources\\";

	private List<String> getData() {
		List<String> list = null;
		try {
			String fileName = this.getClass().getSimpleName().replace("Generator", "");
			String path = resourcePath + fileName + ".json";
			File file = new File(path);
			if (!file.exists()) {
				return new ArrayList<String>();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			list = gson.fromJson(reader, new TypeToken<List<String>>() {
			}.getType());

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}

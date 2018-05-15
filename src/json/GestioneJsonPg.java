package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import obj.OpzioniObj;
import obj.PgDatiObj;

import Classi.DataOra;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GestioneJsonPg {

	Gson gson = new Gson();

	String jsonString = "";
	FileReader fileReader;
	File file;

	FileWriter fileWriter;
	BufferedReader bufferedReader;
	String path = "";
	public static final String UTF8_BOM = "\uFEFF";

	public String[] getPgList() {

		ArrayList<String> arrayPg = new ArrayList<String>();

		File folder = new File("./JsonDb/Pg/");
		File[] listOfFiles = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}
		});
		for (File file : listOfFiles) {
			if (file.isFile()) {
				arrayPg.add(file.getName());
			}
		}

		String[] pgList = new String[arrayPg.size()];
		pgList = arrayPg.toArray(pgList);
		return pgList;
	}

	public PgDatiObj getPgByFileName(String fileName) {
		PgDatiObj pgDatiObj = new PgDatiObj();

		try {
			FileInputStream fis = new FileInputStream("./JsonDb/Pg/" + fileName);
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));

			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				pgDatiObj = new Gson().fromJson(jsonString, PgDatiObj.class);
				pgDatiObj.setFileName(fileName);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file " + fileName + ": " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		return pgDatiObj;
	}

	public boolean createPg(PgDatiObj newPg) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		jsonString = gson.toJson(newPg);
		DataOra dataora = new DataOra();
		String timestamp = dataora.getTimestamp();

		path = "./JsonDb/Pg/" + newPg.getNomePg() + "_" + timestamp + ".json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore creazione json pg: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public boolean aggiornaPg(PgDatiObj pgDatiObj) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		backupPg(pgDatiObj);
		pgDatiObj.setDatiCommittati(true);
		jsonString = gson.toJson(pgDatiObj);

		path = "./JsonDb/Pg/" + pgDatiObj.getFileName();
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento pg: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean backupPg(PgDatiObj pgDatiObj) {
		String fileName = pgDatiObj.getFileName().substring(0, pgDatiObj.getFileName().lastIndexOf('.'));

		File file = new File("./JsonDb/History/Pg/" + fileName);
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		
		if (directories != null){
			Arrays.sort(directories);
			
			if (directories.length > 19){
				int folderNumber = directories.length;
				for (int i=0; i < directories.length; i++){
					if (folderNumber > 19){
						File fileToDelete = new File("./JsonDb/History/Pg/" + fileName + "/" + directories[i]);
						try {
							FileUtils.deleteDirectory(fileToDelete);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Errore cancellazione direcory: " + fileToDelete.getAbsolutePath(), "Errore",
									JOptionPane.ERROR_MESSAGE);
							return false;
						}
						folderNumber = folderNumber - 1;
					}
				}
			}
		}
		
	
		DataOra dataOra = new DataOra();
		String timestamp = dataOra.getTimestamp();

		File fileOriginale = new File("./JsonDb/Pg/" + pgDatiObj.getFileName());
		File fileBackup = new File("./JsonDb/History/Pg/" + fileName + "/" + timestamp + "/" + pgDatiObj.getFileName());
		if (fileBackup.exists()) {
			return true;
		}

		try {
			FileUtils.copyFile(fileOriginale, fileBackup);
//			Files.copy(fileOriginale.toPath(), fileBackup.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore backup pg " + pgDatiObj.getFileName() + ": " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;

		}

		return true;
	}

	public boolean deletePg(String fileName) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		file = new File("./JsonDb/Pg/" + fileName);
		if (file.delete()) {

		} else {
			JOptionPane.showMessageDialog(null, "Errore cancellazione pg: " + fileName, "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private static String removeUTF8BOM(String s) {
		if (s.startsWith(UTF8_BOM)) {
			s = s.substring(1);
		}
		return s;
	}
}

package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import obj.DbAbilitaObj;
import obj.DbArmaturaScudoObj;
import obj.DbArmiObj;
import obj.DbTaglieObj;

public class GestioneJsonItems {

	Gson gson = new Gson();

	String jsonString = "";
	FileReader fileReader;
	File file;
	File fileDefault;
	String path = "";
	public static final String UTF8_BOM = "\uFEFF";

	FileWriter fileWriter;
	BufferedReader bufferedReader;

	public ArrayList<DbAbilitaObj> getListaAbilita() {
		ArrayList<DbAbilitaObj> arrayAbilita = new ArrayList<DbAbilitaObj>();

		try {
            FileInputStream fis = new FileInputStream("./JsonDb/Items/abilita.json");
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			
			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				Type listType = new TypeToken<ArrayList<DbAbilitaObj>>() {
				}.getType();
				arrayAbilita = new Gson().fromJson(jsonString, listType);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file abilita.json: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}

		return arrayAbilita;
	}

	public boolean aggiornaAbilita(ArrayList<DbAbilitaObj> arrayAbilita) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		jsonString = gson.toJson(arrayAbilita);
		path = "./JsonDb/Items/abilita.json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento abilita: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public ArrayList<DbArmaturaScudoObj> getListaArmaturaScudo() {

		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = new ArrayList<DbArmaturaScudoObj>();

		try {
            FileInputStream fis = new FileInputStream("./JsonDb/Items/armatureScudi.json");
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			
			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				Type listType = new TypeToken<ArrayList<DbArmaturaScudoObj>>() {
				}.getType();
				arrayArmaturaScudo = new Gson().fromJson(jsonString, listType);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file abilita.json: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		
		return arrayArmaturaScudo;
	}

	public DbArmaturaScudoObj getArmaturaScudoByName(String nomeArmaturaScudo) {

		DbArmaturaScudoObj dbArmaturaScudoObj = new DbArmaturaScudoObj();
		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = getListaArmaturaScudo();

		for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
			if (arrayArmaturaScudo.get(i).getNome().equals(nomeArmaturaScudo)) {
				dbArmaturaScudoObj = arrayArmaturaScudo.get(i);
			}
		}
		return dbArmaturaScudoObj;
	}

	public boolean aggiornaArmaturaScudo(ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		jsonString = gson.toJson(arrayArmaturaScudo);
		path = "./JsonDb/Items/armatureScudi.json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento abilita: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public ArrayList<DbArmiObj> getListaArmi() {
		ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();

		try {
            FileInputStream fis = new FileInputStream("./JsonDb/Items/armi.json");
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			
			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				Type listType = new TypeToken<ArrayList<DbArmiObj>>() {
				}.getType();
				arrayArmi = new Gson().fromJson(jsonString, listType);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file abilita.json: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		return arrayArmi;
	}

	public DbArmiObj getArmaByName(String nomeArma) {
		DbArmiObj dbArmiObj = new DbArmiObj();
		ArrayList<DbArmiObj> arrayArmi = getListaArmi();

		for (int i = 0; i < arrayArmi.size(); i++) {
			if (arrayArmi.get(i).getNome().equals(nomeArma)) {
				dbArmiObj = arrayArmi.get(i);
			}
		}
		return dbArmiObj;
	}

	public boolean aggiornaArmi(ArrayList<DbArmiObj> arrayArmi) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		jsonString = gson.toJson(arrayArmi);
		path = "./JsonDb/Items/armi.json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento abilita: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public ArrayList<DbTaglieObj> getListaTaglie() {
		ArrayList<DbTaglieObj> arrayTaglie = new ArrayList<DbTaglieObj>();

		try {
            FileInputStream fis = new FileInputStream("./JsonDb/Items/taglie.json");
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			
			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				Type listType = new TypeToken<ArrayList<DbTaglieObj>>() {
				}.getType();
				arrayTaglie = new Gson().fromJson(jsonString, listType);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file abilita.json: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		return arrayTaglie;
	}

	public DbTaglieObj getTagliaByName(String nomeTaglia) {
		DbTaglieObj dbTaglieObj = new DbTaglieObj();
		ArrayList<DbTaglieObj> arrayTaglie = getListaTaglie();

		for (int i = 0; i < arrayTaglie.size(); i++) {
			if (arrayTaglie.get(i).getNome().equals(nomeTaglia)) {
				dbTaglieObj = arrayTaglie.get(i);
			}
		}
		return dbTaglieObj;
	}

	public boolean aggiornaTaglie(ArrayList<DbTaglieObj> arrayTaglie) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		jsonString = gson.toJson(arrayTaglie);
		path = "./JsonDb/Items/taglie.json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento abilita: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean checkDefault() {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result) {
			return false;
		}
		String fileName = "";
		fileName = "abilita.json";
		result = copyDefault(fileName);
		if (!result) {
			return false;
		}

		fileName = "armatureScudi.json";
		result = copyDefault(fileName);
		if (!result) {
			return false;
		}

		fileName = "armi.json";
		result = copyDefault(fileName);
		if (!result) {
			return false;
		}

		fileName = "taglie.json";
		result = copyDefault(fileName);
		if (!result) {
			return false;
		}
		return true;

	}

	private boolean copyDefault(String fileName) {
		File file = new File("./JsonDb/Items/" + fileName);
		if (file.exists()) {
			return true;
		}

		InputStream stream = null;
		OutputStream resStreamOut = null;
		stream = getClass().getResourceAsStream("/json/base/" + fileName);
		if (stream == null) {
			JOptionPane.showMessageDialog(null, "Errore copia file " + fileName + "(1)", "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		int readBytes;
		byte[] buffer = new byte[4096];
		try {
			resStreamOut = new FileOutputStream("./JsonDb/Items/" + fileName);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Errore copia file " + fileName + ": " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			while ((readBytes = stream.read(buffer)) > 0) {
				resStreamOut.write(buffer, 0, readBytes);
			}
			stream.close();
			resStreamOut.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore copia file " + fileName + ": " + e.getMessage(), "Errore",
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

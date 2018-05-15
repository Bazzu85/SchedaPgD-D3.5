package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import obj.DbAbilitaObj;
import obj.OpzioniObj;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class GestioneJsonOpzioni {
	
	Gson gson = new Gson();

	String jsonString = "";
	FileReader fileReader;
	File file;
	
	FileWriter fileWriter;
	BufferedReader bufferedReader;
	String path = "";
	public static final String UTF8_BOM = "\uFEFF";
	
	public OpzioniObj getOpzioniObj() {
		OpzioniObj opzioniObj = new OpzioniObj();
		File fileOpzioni = new File("./JsonDb/opzioni.json");
		if (!fileOpzioni.exists()){
			boolean result = false;
			GestioneJson gestioneJson = new GestioneJson();
			result = gestioneJson.creaStrutturaJson();
			if (!result){
			}
			salvaOpzioniObj(opzioniObj);
		}
		
		try {
            FileInputStream fis = new FileInputStream("./JsonDb/opzioni.json");
			bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF8"));
			
			while ((jsonString = bufferedReader.readLine()) != null) {
				jsonString = removeUTF8BOM(jsonString);
				opzioniObj = new Gson().fromJson(jsonString, OpzioniObj.class);
			}
		} catch (JsonSyntaxException | IOException e) {
			JOptionPane.showMessageDialog(null, "Errore lettura file opzioni.json: " + e.getMessage(), "Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		
		return opzioniObj;
	}

	public boolean salvaOpzioniObj(OpzioniObj opzioniObj) {
		boolean result = false;
		GestioneJson gestioneJson = new GestioneJson();
		result = gestioneJson.creaStrutturaJson();
		if (!result){
			return false;
		}
		jsonString = gson.toJson(opzioniObj);
		path = "./JsonDb/opzioni.json";
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
			bw.write("\uFEFF");
			bw.write(jsonString);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore aggiornamento opzioni: " + e.getMessage(), "Errore",
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

package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.DataOra;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import obj.OpzioniObj;
import obj.PgDatiObj;

public class GestioneJson {
	
	Gson gson = new Gson();
	String jsonString = "";

	FileReader fileReader;
	File file;
	
	FileWriter fileWriter;
	BufferedReader bufferedReader;



	boolean creaStrutturaJson() {

		File f;
		f = new File("./JsonDb");
		if (!f.exists()) {
			try {
				f.mkdir();
			} catch (SecurityException se) {
				JOptionPane.showMessageDialog(null, "Errore creazione directory " + f.getAbsolutePath() + ": " + se.getMessage(), "Errore",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		f = new File("./JsonDb/Pg");
		if (!f.exists()) {
			try {
				f.mkdir();
			} catch (SecurityException se) {
				JOptionPane.showMessageDialog(null, "Errore creazione directory " + f.getAbsolutePath() + ": " + se.getMessage(), "Errore",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		f = new File("./JsonDb/Items");
		if (!f.exists()) {
			try {
				f.mkdir();
			} catch (SecurityException se) {
				JOptionPane.showMessageDialog(null, "Errore creazione directory " + f.getAbsolutePath() + ": " + se.getMessage(), "Errore",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		f = new File("./JsonDb/History");
		if (!f.exists()) {
			try {
				f.mkdir();
			} catch (SecurityException se) {
				JOptionPane.showMessageDialog(null, "Errore creazione directory " + f.getAbsolutePath() + ": " + se.getMessage(), "Errore",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		f = new File("./JsonDb/History/Pg");
		if (!f.exists()) {
			try {
				f.mkdir();
			} catch (SecurityException se) {
				JOptionPane.showMessageDialog(null, "Errore creazione directory " + f.getAbsolutePath() + ": " + se.getMessage(), "Errore",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}



	public void backup() {
		// TODO Auto-generated method stub
		
	}
}

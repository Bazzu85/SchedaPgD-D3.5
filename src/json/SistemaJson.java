package json;

import java.util.ArrayList;
import java.util.regex.Pattern;

import obj.DbArmaturaScudoObj;
import obj.DbArmiObj;

public class SistemaJson {

	static GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		sistemaDbArmi();
		
		sistemaDbArmaturaScudo();
	}

	private static void sistemaDbArmi() {
		ArrayList<DbArmiObj> arrayArmi = gestioneJsonItems.getListaArmi();

		 for (int i = 0; i < arrayArmi.size(); i++) {
//		for (int i = 0; i < 1; i++) {
			DbArmiObj dbArmiObj = arrayArmi.get(i);
			System.out.println("dbArmiObj.getNome(): " + dbArmiObj.getNome());
			String[] parts = dbArmiObj.getNome().split(Pattern.quote("["));
			System.out.println("parts.length: " + parts.length);

			for (int i2 = 0; i2 < parts.length; i2++) {
				System.out.println("for per parts: " + parts[i2] + "[" + i2
						+ "]");
				if (!parts[i2].trim().isEmpty()) {
					if (i2 == 1) {
						String[] parts2 = parts[i2].split(Pattern.quote("]"));
						System.out.println("parts2.length: " + parts2.length);
						for (int i3 = 0; i3 < parts2.length; i3++) {
							if (!parts2[i3].trim().isEmpty()) {
								System.out.println("for per parts2: "
										+ parts2[i3] + "[" + i3 + "]");
								if (i3 == 0) {
									dbArmiObj.setCategoria1(parts2[i3].trim());
								}
							}
						}
					}
					if (i2 == 2) {
						String[] parts3 = parts[i2].split(Pattern
								.quote("]"));
						System.out.println("parts3.length: " + parts3.length);
						for (int i3 = 0; i3 < parts3.length; i3++) {
							if (!parts3[i3].trim().isEmpty()) {
								System.out.println("for per parts3: "
										+ parts3[i3] + "[" + i3 + "]");
								if (i3 == 0){
									dbArmiObj.setCategoria2(parts3[i3].trim());
								}
								if (i3 == 1){
									dbArmiObj.setNome(parts3[i3].trim());
								}
							}
						}
					}
				}

			}
			System.out.println("dbArmiObj.getCategoria1(): "
					+ dbArmiObj.getCategoria1());
			System.out.println("dbArmiObj.getCategoria2(): "
					+ dbArmiObj.getCategoria2());		
			System.out.println("dbArmiObj.getNome(): "
							+ dbArmiObj.getNome());
			arrayArmi.set(i, dbArmiObj);
		}
		 gestioneJsonItems.aggiornaArmi(arrayArmi);
	}
	
	private static void sistemaDbArmaturaScudo() {
		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = gestioneJsonItems.getListaArmaturaScudo();

		 for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
//		for (int i = 0; i < 1; i++) {
			 DbArmaturaScudoObj dbArmaturaScudoObj = arrayArmaturaScudo.get(i);
			System.out.println("dbArmiObj.getNome(): " + dbArmaturaScudoObj.getNome());
			String[] parts = dbArmaturaScudoObj.getNome().split(Pattern.quote("["));
			System.out.println("parts.length: " + parts.length);

			for (int i2 = 0; i2 < parts.length; i2++) {
				System.out.println("for per parts: " + parts[i2] + "[" + i2
						+ "]");
				if (!parts[i2].trim().isEmpty()) {
					if (i2 == 1) {
						String[] parts2 = parts[i2].split(Pattern.quote("]"));
						System.out.println("parts2.length: " + parts2.length);
						for (int i3 = 0; i3 < parts2.length; i3++) {
							if (!parts2[i3].trim().isEmpty()) {
								System.out.println("for per parts2: "
										+ parts2[i3] + "[" + i3 + "]");
								if (i3 == 0) {
									dbArmaturaScudoObj.setCategoria(parts2[i3].trim());
								}
								if (i3 == 1){
									dbArmaturaScudoObj.setNome(parts2[i3].trim());
								}
							}
						}
					}
//					if (i2 == 2) {
//						String[] parts3 = parts[i2].split(Pattern
//								.quote("]"));
//						System.out.println("parts3.length: " + parts3.length);
//						for (int i3 = 0; i3 < parts3.length; i3++) {
//							if (!parts3[i3].trim().isEmpty()) {
//								System.out.println("for per parts3: "
//										+ parts3[i3] + "[" + i3 + "]");
//								if (i3 == 0){
//									dbArmaturaScudoObj.setCategoria(parts3[i3].trim());
//								}
//								if (i3 == 1){
//									dbArmaturaScudoObj.setNome(parts3[i3].trim());
//								}
//							}
//						}
//					}
				}

			}
			System.out.println("dbArmiObj.getCategoria1(): "
					+ dbArmaturaScudoObj.getCategoria());
			System.out.println("dbArmiObj.getNome(): "
							+ dbArmaturaScudoObj.getNome());
			arrayArmaturaScudo.set(i, dbArmaturaScudoObj);
		}
		 gestioneJsonItems.aggiornaArmaturaScudo(arrayArmaturaScudo);
	}
}

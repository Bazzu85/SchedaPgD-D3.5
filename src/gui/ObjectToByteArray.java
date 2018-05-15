package gui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import obj.PgDatiObj;


public class ObjectToByteArray {

	public byte[] converti(PgDatiObj pgDatiObj) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(pgDatiObj);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] pgDatiObjConvertiti = bos.toByteArray();
		return pgDatiObjConvertiti;
	}

}

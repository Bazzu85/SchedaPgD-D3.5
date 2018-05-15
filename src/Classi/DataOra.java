package Classi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataOra {

	public String getTimestamp() {
		DateFormat formatData = new SimpleDateFormat( "yyyy-MM-dd" ) ;
		String data = formatData.format( new Date(  ));
        DateFormat formatOra = new SimpleDateFormat( "HH-mm-ss") ;
		String ora = formatOra.format( new Date(  ));
		String timestamp = data + "_" + ora;

		return timestamp;
	}

}

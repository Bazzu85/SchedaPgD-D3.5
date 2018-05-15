package Classi;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

public class Formati {

	public NumberFormatter getSoloNumeri() {
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter soloNumeri = new NumberFormatter(format);
		soloNumeri.setValueClass(Integer.class);
		soloNumeri.setMinimum(0);
		soloNumeri.setMaximum(Integer.MAX_VALUE);
		soloNumeri.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		soloNumeri.setCommitsOnValidEdit(true);
		return soloNumeri;
	}

	public NumberFormatter getSoloNumeriConSegno() {
		DecimalFormat formatConSegno = new DecimalFormat("+#;-#");
		formatConSegno.setGroupingUsed(false);
		NumberFormatter soloNumeriConSegno = new NumberFormatter(formatConSegno);
		soloNumeriConSegno.setValueClass(Integer.class);
		soloNumeriConSegno.setMinimum(Integer.MIN_VALUE);
		soloNumeriConSegno.setMaximum(Integer.MAX_VALUE);
		soloNumeriConSegno.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		soloNumeriConSegno.setCommitsOnValidEdit(true);
		return soloNumeriConSegno;
	}
	
	public NumberFormatter getSoloNumeriConPercentuale() {
		DecimalFormat formatConPercentuale = new DecimalFormat("#'%'");
		formatConPercentuale.setGroupingUsed(false);
		NumberFormatter soloNumeriConPercentuale = new NumberFormatter(formatConPercentuale);
		soloNumeriConPercentuale.setValueClass(Integer.class);
		soloNumeriConPercentuale.setMinimum(Integer.MIN_VALUE);
		soloNumeriConPercentuale.setMaximum(Integer.MAX_VALUE);
		soloNumeriConPercentuale.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		soloNumeriConPercentuale.setCommitsOnValidEdit(true);
		return soloNumeriConPercentuale;
	}
	
	public NumberFormat getSoloNumeriDouble1() {
		NumberFormat format = DecimalFormat.getInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);

		return format;
	}
	public NumberFormatter getVelocita() {
		DecimalFormat formatVelocita = new DecimalFormat("#.## 'M'");
		formatVelocita.setGroupingUsed(false);
		NumberFormatter velocita = new NumberFormatter(formatVelocita);
		velocita.setValueClass(Double.class);
		velocita.setMinimum(Double.MIN_VALUE);
		velocita.setMaximum(Double.MAX_VALUE);
		velocita.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		velocita.setCommitsOnValidEdit(true);
		return velocita;
	}
}

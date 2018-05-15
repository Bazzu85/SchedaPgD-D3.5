package gui.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgDati;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgDatiObj;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PgTrattiRazzialiPanel extends JPanel implements FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7901398945208847246L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private JTextArea textAreaTrattiRazziali;
	private OpzioniObj opzioniObj;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgTrattiRazzialiPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		textAreaTrattiRazziali = new JTextArea();
		textAreaTrattiRazziali.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaTrattiRazziali.addFocusListener(this);
		scrollPane.setViewportView(textAreaTrattiRazziali);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;

		// TODO Popolamento scheda "Tratti Razziali"
		textAreaTrattiRazziali.setText(pgDatiObj.getTrattiRazziali());
		textAreaTrattiRazziali.setCaretPosition(0);

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JTextArea) {
			if ((JTextArea) component == textAreaTrattiRazziali) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.TRATTI_RAZZIALI,
						textAreaTrattiRazziali.getText());
			}
		}

	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

	public PgDatiObj getPgDatiObj() {
		return pgDatiObj;
	}

	public void setPgDatiObj(PgDatiObj pgDatiObj) {
		this.pgDatiObj = pgDatiObj;
	}

}

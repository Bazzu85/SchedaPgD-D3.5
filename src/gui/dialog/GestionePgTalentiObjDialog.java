package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgTalenti;
import obj.PgTalentiObj;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class GestionePgTalentiObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383820238827879403L;
	private final JPanel contentPanel = new JPanel();
	int id = 0;
	PgTalentiObj pgTalentiObj = new PgTalentiObj();
	boolean rigaGestita = false;
	ListaGestioneDati azione;

	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldNome;
	private JTextArea textAreaDescrizione;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}

		try {
			PgTalentiObj pgTalentiObj = new PgTalentiObj();
			GestionePgTalentiObjDialog dialog = new GestionePgTalentiObjDialog(ListaGestioneDati.INSERISCI, 0, pgTalentiObj);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param id
	 */
	public GestionePgTalentiObjDialog(ListaGestioneDati azione, int id, PgTalentiObj pgTalentiObj) {

		setAzione(azione);
		setId(id);
		setPgTalentiObj(pgTalentiObj);
		switch (azione) {
		case INSERISCI:
			setTitle("Nuovo Talento");
			break;
		case MODIFICA:
			setTitle("Modifica Abilità");
			break;
		}

		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 439, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 99, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblTalento = new JLabel("Talento:");
			GridBagConstraints gbc_lblTalento = new GridBagConstraints();
			gbc_lblTalento.insets = new Insets(0, 0, 5, 5);
			gbc_lblTalento.anchor = GridBagConstraints.EAST;
			gbc_lblTalento.gridx = 0;
			gbc_lblTalento.gridy = 0;
			contentPanel.add(lblTalento, gbc_lblTalento);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.addFocusListener(this);
			GridBagConstraints gbc_textFieldTalento = new GridBagConstraints();
			gbc_textFieldTalento.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldTalento.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTalento.gridx = 1;
			gbc_textFieldTalento.gridy = 0;
			contentPanel.add(textFieldNome, gbc_textFieldTalento);
			textFieldNome.setColumns(10);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione:");
			GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
			gbc_lblDescrizione.anchor = GridBagConstraints.EAST;
			gbc_lblDescrizione.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescrizione.gridx = 0;
			gbc_lblDescrizione.gridy = 1;
			contentPanel.add(lblDescrizione, gbc_lblDescrizione);
		}
		{
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 1;
				contentPanel.add(scrollPane, gbc_scrollPane);
				textAreaDescrizione = new JTextArea();
				scrollPane.setViewportView(textAreaDescrizione);
				textAreaDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 11));
				textAreaDescrizione.addFocusListener(this);
				textAreaDescrizione.setBorder(UIManager.getBorder("TextField.border"));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				// Impostare a null per evitare che con ENTER venga chiuso il
				// dialog
				getRootPane().setDefaultButton(null);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if (!Beans.isDesignTime()) {
			popolaFrame();
		}
	}

	private void popolaFrame() {

		textFieldNome.setText(pgTalentiObj.getNome());
		textAreaDescrizione.setText(pgTalentiObj.getDescrizione());

	}

	private void gestioneTalento() {
		boolean datiOk = true;

		if (datiOk && pgTalentiObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome del talento", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk) {
			rigaGestita = true;
			setVisible(false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNome) {
				pgTalentiObj = aggiornaOggetti.aggiornaTalenti(pgTalentiObj, ListaPgTalenti.NOME,
						textFieldNome.getText());
			}

		}
		if (component instanceof JTextArea) {
			if ((JTextArea) component == textAreaDescrizione) {
				pgTalentiObj = aggiornaOggetti.aggiornaTalenti(pgTalentiObj, ListaPgTalenti.DESCRIZIONE,
						textAreaDescrizione.getText());
			}
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneTalento();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
	}

	public PgTalentiObj getPgTalentiObj() {
		return pgTalentiObj;
	}

	public void setPgTalentiObj(PgTalentiObj pgTalentiObj) {
		this.pgTalentiObj = pgTalentiObj;
	}

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

}

package gui.panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgMovimento;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgMovimentoObj;
import obj.PgDatiObj;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class PgMovimentoPanel extends JPanel implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7108403604924270001L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;

	private MainWindow frame;
	private OpzioniObj opzioniObj;
	private JScrollPane scrollPane;
	private JTextField textFieldVelocitaDiBase;
	private JTextField textFieldVolare;
	private JTextField textFieldAltroMovimento;
	private JTextField textFieldTatticoX1;
	private JTextField textFieldTatticoX2;
	private JTextField textFieldTatticoX3;
	private JTextField textFieldTatticoX4;
	private JTextField textFieldLocaleX1;
	private JTextField textFieldLocaleX2;
	private JTextField textFieldLocaleX4;
	private JTextField textFieldOraX1;
	private JTextField textFieldOraX2;
	private JTextField textFieldOraX3;
	private JTextField textFieldOraX4;
	private JTextField textFieldGiornoX1;
	private JTextField textFieldGiornoX2;
	private JTextField textFieldGiornoX3;
	private JTextField textFieldGiornoX4;
	private JTextField textFieldLocaleX3;

	public PgMovimentoPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);


		GridBagLayout gbl_pgBonusAttaccoBasePanel = new GridBagLayout();
		gbl_pgBonusAttaccoBasePanel.columnWidths = new int[] { 87,
				0 };
		gbl_pgBonusAttaccoBasePanel.rowHeights = new int[] { 259, 0 };
		gbl_pgBonusAttaccoBasePanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pgBonusAttaccoBasePanel.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_pgBonusAttaccoBasePanel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 93, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblVelocitDiBase = new JLabel("Velocit\u00E0 di Base:");
		lblVelocitDiBase.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblVelocitDiBase = new GridBagConstraints();
		gbc_lblVelocitDiBase.insets = new Insets(0, 0, 5, 5);
		gbc_lblVelocitDiBase.anchor = GridBagConstraints.EAST;
		gbc_lblVelocitDiBase.gridx = 0;
		gbc_lblVelocitDiBase.gridy = 0;
		panel.add(lblVelocitDiBase, gbc_lblVelocitDiBase);
		
		textFieldVelocitaDiBase = new JTextField();
		textFieldVelocitaDiBase.addFocusListener(this);
		GridBagConstraints gbc_textFieldVelocitaDiBase = new GridBagConstraints();
		gbc_textFieldVelocitaDiBase.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVelocitaDiBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVelocitaDiBase.gridx = 1;
		gbc_textFieldVelocitaDiBase.gridy = 0;
		panel.add(textFieldVelocitaDiBase, gbc_textFieldVelocitaDiBase);
		textFieldVelocitaDiBase.setColumns(10);
		
		JLabel lblVolare = new JLabel("Volare:");
		lblVolare.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblVolare = new GridBagConstraints();
		gbc_lblVolare.insets = new Insets(0, 0, 5, 5);
		gbc_lblVolare.anchor = GridBagConstraints.EAST;
		gbc_lblVolare.gridx = 2;
		gbc_lblVolare.gridy = 0;
		panel.add(lblVolare, gbc_lblVolare);
		
		textFieldVolare = new JTextField();
		textFieldVolare.setEnabled(false);
		textFieldVolare.setEditable(false);
		textFieldVolare.setColumns(10);
		GridBagConstraints gbc_textFieldVolare = new GridBagConstraints();
		gbc_textFieldVolare.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVolare.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVolare.gridx = 3;
		gbc_textFieldVolare.gridy = 0;
		panel.add(textFieldVolare, gbc_textFieldVolare);
		
		JLabel lblAltroMovimento = new JLabel("Altro Movimento:");
		lblAltroMovimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAltroMovimento = new GridBagConstraints();
		gbc_lblAltroMovimento.anchor = GridBagConstraints.EAST;
		gbc_lblAltroMovimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltroMovimento.gridx = 0;
		gbc_lblAltroMovimento.gridy = 1;
		panel.add(lblAltroMovimento, gbc_lblAltroMovimento);
		
		textFieldAltroMovimento = new JTextField();
		textFieldAltroMovimento.setEnabled(false);
		textFieldAltroMovimento.setEditable(false);
		textFieldAltroMovimento.setColumns(10);
		GridBagConstraints gbc_textFieldAltroMovimento = new GridBagConstraints();
		gbc_textFieldAltroMovimento.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAltroMovimento.gridwidth = 3;
		gbc_textFieldAltroMovimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAltroMovimento.gridx = 1;
		gbc_textFieldAltroMovimento.gridy = 1;
		panel.add(textFieldAltroMovimento, gbc_textFieldAltroMovimento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblMovimento = new JLabel("MOVIMENTO");
		lblMovimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMovimento = new GridBagConstraints();
		gbc_lblMovimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovimento.gridx = 0;
		gbc_lblMovimento.gridy = 0;
		panel_1.add(lblMovimento, gbc_lblMovimento);
		
		JLabel lbltatticometriround = new JLabel("<html><center>TATTICO<br>(metri/round)</center></html>");
		lbltatticometriround.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lbltatticometriround = new GridBagConstraints();
		gbc_lbltatticometriround.insets = new Insets(0, 0, 5, 5);
		gbc_lbltatticometriround.gridx = 1;
		gbc_lbltatticometriround.gridy = 0;
		panel_1.add(lbltatticometriround, gbc_lbltatticometriround);
		
		JLabel lbllocalexmetriminuto = new JLabel("<html><center>LOCALE (x10)<br>(metri/minuto)</center></html>");
		lbllocalexmetriminuto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lbllocalexmetriminuto = new GridBagConstraints();
		gbc_lbllocalexmetriminuto.insets = new Insets(0, 0, 5, 5);
		gbc_lbllocalexmetriminuto.gridx = 2;
		gbc_lbllocalexmetriminuto.gridy = 0;
		panel_1.add(lbllocalexmetriminuto, gbc_lbllocalexmetriminuto);
		
		JLabel lblorakmora = new JLabel("<html><center>ORA<br>(km/ora)</center></html>");
		lblorakmora.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblorakmora = new GridBagConstraints();
		gbc_lblorakmora.insets = new Insets(0, 0, 5, 5);
		gbc_lblorakmora.gridx = 3;
		gbc_lblorakmora.gridy = 0;
		panel_1.add(lblorakmora, gbc_lblorakmora);
		
		JLabel lblgiornokmOre = new JLabel("<html><center>GIORNO<br>(km/8 ore)</center></html>");
		lblgiornokmOre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblgiornokmOre = new GridBagConstraints();
		gbc_lblgiornokmOre.insets = new Insets(0, 0, 5, 0);
		gbc_lblgiornokmOre.gridx = 4;
		gbc_lblgiornokmOre.gridy = 0;
		panel_1.add(lblgiornokmOre, gbc_lblgiornokmOre);
		
		JLabel lblCamminare = new JLabel("CAMMINARE");
		lblCamminare.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCamminare = new GridBagConstraints();
		gbc_lblCamminare.anchor = GridBagConstraints.EAST;
		gbc_lblCamminare.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamminare.gridx = 0;
		gbc_lblCamminare.gridy = 1;
		panel_1.add(lblCamminare, gbc_lblCamminare);
		
		textFieldTatticoX1 = new JTextField();
		textFieldTatticoX1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTatticoX1.setEnabled(false);
		textFieldTatticoX1.setEditable(false);
		GridBagConstraints gbc_textFieldTatticoX1 = new GridBagConstraints();
		gbc_textFieldTatticoX1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTatticoX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatticoX1.gridx = 1;
		gbc_textFieldTatticoX1.gridy = 1;
		panel_1.add(textFieldTatticoX1, gbc_textFieldTatticoX1);
		textFieldTatticoX1.setColumns(10);
		
		textFieldLocaleX1 = new JTextField();
		textFieldLocaleX1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLocaleX1.setEnabled(false);
		textFieldLocaleX1.setEditable(false);
		textFieldLocaleX1.setColumns(10);
		GridBagConstraints gbc_textFieldLocaleX1 = new GridBagConstraints();
		gbc_textFieldLocaleX1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLocaleX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLocaleX1.gridx = 2;
		gbc_textFieldLocaleX1.gridy = 1;
		panel_1.add(textFieldLocaleX1, gbc_textFieldLocaleX1);
		
		textFieldOraX1 = new JTextField();
		textFieldOraX1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOraX1.setEnabled(false);
		textFieldOraX1.setEditable(false);
		textFieldOraX1.setColumns(10);
		GridBagConstraints gbc_textFieldOraX1 = new GridBagConstraints();
		gbc_textFieldOraX1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOraX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOraX1.gridx = 3;
		gbc_textFieldOraX1.gridy = 1;
		panel_1.add(textFieldOraX1, gbc_textFieldOraX1);
		
		textFieldGiornoX1 = new JTextField();
		textFieldGiornoX1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGiornoX1.setEnabled(false);
		textFieldGiornoX1.setEditable(false);
		textFieldGiornoX1.setColumns(10);
		GridBagConstraints gbc_textFieldGiornoX1 = new GridBagConstraints();
		gbc_textFieldGiornoX1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGiornoX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGiornoX1.gridx = 4;
		gbc_textFieldGiornoX1.gridy = 1;
		panel_1.add(textFieldGiornoX1, gbc_textFieldGiornoX1);
		
		JLabel lblVelocix = new JLabel("VELOCI (X2)");
		lblVelocix.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblVelocix = new GridBagConstraints();
		gbc_lblVelocix.anchor = GridBagConstraints.EAST;
		gbc_lblVelocix.insets = new Insets(0, 0, 5, 5);
		gbc_lblVelocix.gridx = 0;
		gbc_lblVelocix.gridy = 2;
		panel_1.add(lblVelocix, gbc_lblVelocix);
		
		textFieldTatticoX2 = new JTextField();
		textFieldTatticoX2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTatticoX2.setEnabled(false);
		textFieldTatticoX2.setEditable(false);
		textFieldTatticoX2.setColumns(10);
		GridBagConstraints gbc_textFieldTatticoX2 = new GridBagConstraints();
		gbc_textFieldTatticoX2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTatticoX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatticoX2.gridx = 1;
		gbc_textFieldTatticoX2.gridy = 2;
		panel_1.add(textFieldTatticoX2, gbc_textFieldTatticoX2);
		
		textFieldLocaleX2 = new JTextField();
		textFieldLocaleX2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLocaleX2.setEnabled(false);
		textFieldLocaleX2.setEditable(false);
		textFieldLocaleX2.setColumns(10);
		GridBagConstraints gbc_textFieldLocaleX2 = new GridBagConstraints();
		gbc_textFieldLocaleX2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLocaleX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLocaleX2.gridx = 2;
		gbc_textFieldLocaleX2.gridy = 2;
		panel_1.add(textFieldLocaleX2, gbc_textFieldLocaleX2);
		
		textFieldOraX2 = new JTextField();
		textFieldOraX2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOraX2.setEnabled(false);
		textFieldOraX2.setEditable(false);
		textFieldOraX2.setColumns(10);
		GridBagConstraints gbc_textFieldOraX2 = new GridBagConstraints();
		gbc_textFieldOraX2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOraX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOraX2.gridx = 3;
		gbc_textFieldOraX2.gridy = 2;
		panel_1.add(textFieldOraX2, gbc_textFieldOraX2);
		
		textFieldGiornoX2 = new JTextField();
		textFieldGiornoX2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGiornoX2.setEnabled(false);
		textFieldGiornoX2.setEditable(false);
		textFieldGiornoX2.setColumns(10);
		GridBagConstraints gbc_textFieldGiornoX2 = new GridBagConstraints();
		gbc_textFieldGiornoX2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGiornoX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGiornoX2.gridx = 4;
		gbc_textFieldGiornoX2.gridy = 2;
		panel_1.add(textFieldGiornoX2, gbc_textFieldGiornoX2);
		
		JLabel lblCorrerex = new JLabel("CORRERE (X3)");
		lblCorrerex.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCorrerex = new GridBagConstraints();
		gbc_lblCorrerex.anchor = GridBagConstraints.EAST;
		gbc_lblCorrerex.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorrerex.gridx = 0;
		gbc_lblCorrerex.gridy = 3;
		panel_1.add(lblCorrerex, gbc_lblCorrerex);
		
		textFieldTatticoX3 = new JTextField();
		textFieldTatticoX3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTatticoX3.setEnabled(false);
		textFieldTatticoX3.setEditable(false);
		textFieldTatticoX3.setColumns(10);
		GridBagConstraints gbc_textFieldTatticoX3 = new GridBagConstraints();
		gbc_textFieldTatticoX3.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTatticoX3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatticoX3.gridx = 1;
		gbc_textFieldTatticoX3.gridy = 3;
		panel_1.add(textFieldTatticoX3, gbc_textFieldTatticoX3);
		
		textFieldLocaleX3 = new JTextField();
		textFieldLocaleX3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLocaleX3.setEnabled(false);
		textFieldLocaleX3.setEditable(false);
		textFieldLocaleX3.setColumns(10);
		GridBagConstraints gbc_textFieldLocaleX3 = new GridBagConstraints();
		gbc_textFieldLocaleX3.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLocaleX3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLocaleX3.gridx = 2;
		gbc_textFieldLocaleX3.gridy = 3;
		panel_1.add(textFieldLocaleX3, gbc_textFieldLocaleX3);
		
		textFieldOraX3 = new JTextField();
		textFieldOraX3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOraX3.setEnabled(false);
		textFieldOraX3.setEditable(false);
		textFieldOraX3.setColumns(10);
		GridBagConstraints gbc_textFieldOraX3 = new GridBagConstraints();
		gbc_textFieldOraX3.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOraX3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOraX3.gridx = 3;
		gbc_textFieldOraX3.gridy = 3;
		panel_1.add(textFieldOraX3, gbc_textFieldOraX3);
		
		textFieldGiornoX3 = new JTextField();
		textFieldGiornoX3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGiornoX3.setEnabled(false);
		textFieldGiornoX3.setEditable(false);
		textFieldGiornoX3.setColumns(10);
		GridBagConstraints gbc_textFieldGiornoX3 = new GridBagConstraints();
		gbc_textFieldGiornoX3.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGiornoX3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGiornoX3.gridx = 4;
		gbc_textFieldGiornoX3.gridy = 3;
		panel_1.add(textFieldGiornoX3, gbc_textFieldGiornoX3);
		
		JLabel lblCorrerex_1 = new JLabel("CORRERE (X4)");
		lblCorrerex_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCorrerex_1 = new GridBagConstraints();
		gbc_lblCorrerex_1.anchor = GridBagConstraints.EAST;
		gbc_lblCorrerex_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblCorrerex_1.gridx = 0;
		gbc_lblCorrerex_1.gridy = 4;
		panel_1.add(lblCorrerex_1, gbc_lblCorrerex_1);
		
		textFieldTatticoX4 = new JTextField();
		textFieldTatticoX4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTatticoX4.setEnabled(false);
		textFieldTatticoX4.setEditable(false);
		textFieldTatticoX4.setColumns(10);
		GridBagConstraints gbc_textFieldTatticoX4 = new GridBagConstraints();
		gbc_textFieldTatticoX4.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldTatticoX4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatticoX4.gridx = 1;
		gbc_textFieldTatticoX4.gridy = 4;
		panel_1.add(textFieldTatticoX4, gbc_textFieldTatticoX4);
		
		textFieldLocaleX4 = new JTextField();
		textFieldLocaleX4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLocaleX4.setEnabled(false);
		textFieldLocaleX4.setEditable(false);
		textFieldLocaleX4.setColumns(10);
		GridBagConstraints gbc_textFieldLocaleX4 = new GridBagConstraints();
		gbc_textFieldLocaleX4.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldLocaleX4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLocaleX4.gridx = 2;
		gbc_textFieldLocaleX4.gridy = 4;
		panel_1.add(textFieldLocaleX4, gbc_textFieldLocaleX4);
		
		textFieldOraX4 = new JTextField();
		textFieldOraX4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOraX4.setEnabled(false);
		textFieldOraX4.setEditable(false);
		textFieldOraX4.setColumns(10);
		GridBagConstraints gbc_textFieldOraX4 = new GridBagConstraints();
		gbc_textFieldOraX4.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldOraX4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOraX4.gridx = 3;
		gbc_textFieldOraX4.gridy = 4;
		panel_1.add(textFieldOraX4, gbc_textFieldOraX4);
		
		textFieldGiornoX4 = new JTextField();
		textFieldGiornoX4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGiornoX4.setEnabled(false);
		textFieldGiornoX4.setEditable(false);
		textFieldGiornoX4.setColumns(10);
		GridBagConstraints gbc_textFieldGiornoX4 = new GridBagConstraints();
		gbc_textFieldGiornoX4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGiornoX4.gridx = 4;
		gbc_textFieldGiornoX4.gridy = 4;
		panel_1.add(textFieldGiornoX4, gbc_textFieldGiornoX4);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		//Salvataggio dell'oggetto nella classe per giri successivi (chiamati da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Movimento"
		PgMovimentoObj pgMovimentoObj = pgDatiObj.getPgMovimentoObj();

		textFieldVelocitaDiBase.setText(pgMovimentoObj.getVelocitaDiBase().toString());

		textFieldTatticoX1.setText(pgMovimentoObj.getTatticoX1().toString());
		textFieldTatticoX2.setText(pgMovimentoObj.getTatticoX2().toString());
		textFieldTatticoX3.setText(pgMovimentoObj.getTatticoX3().toString());
		textFieldTatticoX4.setText(pgMovimentoObj.getTatticoX4().toString());
		textFieldLocaleX1.setText(pgMovimentoObj.getLocaleX1().toString());
		textFieldLocaleX2.setText(pgMovimentoObj.getLocaleX2().toString());
		textFieldLocaleX3.setText(pgMovimentoObj.getLocaleX3().toString());
		textFieldLocaleX4.setText(pgMovimentoObj.getLocaleX4().toString());
		textFieldOraX1.setText(pgMovimentoObj.getOraX1().toString());
		textFieldOraX2.setText(pgMovimentoObj.getOraX2().toString());
		textFieldOraX3.setText(pgMovimentoObj.getOraX3().toString());
		textFieldOraX4.setText(pgMovimentoObj.getOraX4().toString());
		textFieldGiornoX1.setText(pgMovimentoObj.getGiornoX1().toString());
		textFieldGiornoX2.setText(pgMovimentoObj.getGiornoX2().toString());
		textFieldGiornoX3.setText(pgMovimentoObj.getGiornoX3().toString());
		textFieldGiornoX4.setText(pgMovimentoObj.getGiornoX4().toString());


	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldVelocitaDiBase) {
				try {
					textFieldVelocitaDiBase.setText(textFieldVelocitaDiBase.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldVelocitaDiBase.getText());
					pgDatiObj = aggiornaOggetti.aggiornaPgMovimento(pgDatiObj,
							ListaPgMovimento.VELOCITA_DI_BASE,
							textFieldVelocitaDiBase.getText());
					if (pgDatiObj.getPgMovimentoObj().isDatiVariati()) {
						frame.popolaFrame(pgDatiObj);
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldVelocitaDiBase.setText(String.valueOf(d));
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

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

package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.CalcolaDati;
import Classi.Formati;
import ENUM.ListaPgDati;
import ENUM.ListaPgManovre;
import gui.dialog.DbArmaturaScudoDialog;
import gui.dialog.DbArmiDialog;
import gui.dialog.DbTaglieDialog;
import gui.dialog.CaricaPgDialog;
import gui.dialog.DbAbilitaDialog;
import gui.dialog.ScegliLinguaDialog;
import gui.panel.PgAbilitaPanel;
import gui.panel.PgAppuntiPanel;
import gui.panel.PgArmiPanel;
import gui.panel.PgBabPanel;
import gui.panel.PgBonusPanel;
import gui.panel.PgClasseArmaturaPanel;
import gui.panel.PgClassiPanel;
import gui.panel.PgDatiPanel;
import gui.panel.PgEquipPanel;
import gui.panel.PgIniziativaPanel;
import gui.panel.PgLinguePanel;
import gui.panel.PgManovrePanel;
import gui.panel.PgPuntiFeritaPanel;
import gui.panel.PgRiepilogoPanel;
import gui.panel.PgStatistichePanel;
import gui.panel.PgTalentiPanel;
import gui.panel.PgTiriSalvezzaPanel;
import gui.panel.PgTrattiRazzialiPanel;
import gui.panel.PgCaricoPanel;
import gui.panel.PgMovimentoPanel;
import json.GestioneJson;
import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import gui.panel.PgPrivilegiDiClassePanel;
import obj.OpzioniObj;
import obj.PgDatiObj;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.WindowStateListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class MainWindow extends JFrame implements FocusListener, ActionListener, TreeSelectionListener {

	private JPanel contentPane;
	PgDatiObj pgDatiObj = new PgDatiObj();
	GestioneJson gestioneJson = new GestioneJson();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	boolean manovrePanelAggiunto = false;

	CalcolaDati calcolaDati = new CalcolaDati();
	Formati formati = new Formati();
	private JMenuItem mntmApriCreaPg;
	private JMenuItem mntmSalvaPg;
	private JMenuItem mntmEsci;
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JMenu mnGestioneOggetti;
	private JMenuItem mntmGestioneArmatureScudi;
	JTabbedPane tabbedPane;
	PgDatiPanel pgDatiPanel;
	private PgRiepilogoPanel pgRiepilogoPanel;
	private PgBonusPanel pgBonusPanel;
	private PgClassiPanel pgClassiPanel;
	private PgStatistichePanel pgStatistichePanel;
	private PgPuntiFeritaPanel pgPuntiFeritaPanel;
	private PgClasseArmaturaPanel pgClasseArmaturaPanel;
	private PgBabPanel pgBabPanel;
	private PgTiriSalvezzaPanel pgTiriSalvezzaPanel;
	private PgIniziativaPanel pgIniziativaPanel;
	private PgArmiPanel pgArmiPanel;
	private PgAbilitaPanel pgAbilitaPanel;
	private PgTalentiPanel pgTalentiPanel;
	private PgTrattiRazzialiPanel pgTrattiRazzialiPanel;
	private PgCaricoPanel pgCaricoPanel;
	private PgMovimentoPanel pgMovimentoPanel;
	private PgPrivilegiDiClassePanel pgPrivilegiDiClassePanel;
	private PgLinguePanel pgLinguePanel;
	private PgEquipPanel pgEquipPanel;
	private PgAppuntiPanel pgAppuntiPanel;
	private PgManovrePanel pgManovrePanel;
	static MainWindow frame;
	private JMenuItem mntmGestioneArmi;
	private JMenuItem mntmGestioneTaglie;
	private JMenuItem mntmGestioneAbilita;
	private JMenu mnPannelli;
	private JCheckBoxMenuItem chckbxmntmManovre;
	private JMenu mnOpzioni;
	private JMenuItem mntmCambioLingua;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					System.out.println(e.getMessage());
				}

				try {
					frame = new MainWindow();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				int state = e.getNewState();
				if (state == MAXIMIZED_BOTH) {
				}
				if (state == NORMAL) {
					opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
					if (opzioniObj.getWindowX() > 0 && opzioniObj.getWindowY() > 0 && opzioniObj.getWindowWidth() > 0
							&& opzioniObj.getWindowHeight() > 0) {
						setBounds(opzioniObj.getWindowX(), opzioniObj.getWindowY(), opzioniObj.getWindowWidth(),
								opzioniObj.getWindowHeight());
					}

				}
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				chiudiSchedaPg();

			}
		});

		// Controllimo se ci sono gli oggetti nel db
		gestioneJsonItems.checkDefault();

		// TODO da integrare
		gestioneJson.backup();

		// Creazione formatter per i textField solo numerici
		// DecimalFormat formatConSegno = new DecimalFormat("+#;-#");

		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		setTitle("Scheda PG by Bazzu");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 1091, 590);
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		if (opzioniObj.isMaximized()) {
			setExtendedState(MAXIMIZED_BOTH);
		} else {
			if (opzioniObj.getWindowX() > 0 && opzioniObj.getWindowY() > 0 && opzioniObj.getWindowWidth() > 0
					&& opzioniObj.getWindowHeight() > 0) {
				setBounds(opzioniObj.getWindowX(), opzioniObj.getWindowY(), opzioniObj.getWindowWidth(),
						opzioniObj.getWindowHeight());
			}
		}

		// Se i dati del PG non ci sono li carichiamo
		// Se è presente l'ultimo pg caricato nelle opzioni carichiamo quello
		if (pgDatiObj.getFileName().trim().isEmpty()) {
			if (!opzioniObj.getLastFileName().trim().isEmpty()) {
				caricaUltimoPg();
			} else {
				caricaPg();
			}
		}

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmApriCreaPg = new JMenuItem("Apri/Crea PG");
		mntmApriCreaPg.addActionListener(this);
		mnFile.add(mntmApriCreaPg);

		mntmSalvaPg = new JMenuItem("Salva PG");
		mntmSalvaPg.addActionListener(this);
		mnFile.add(mntmSalvaPg);

		mntmEsci = new JMenuItem("Esci");
		mntmEsci.addActionListener(this);
		mnFile.add(mntmEsci);

		mnGestioneOggetti = new JMenu("Gestione Oggetti");
		menuBar.add(mnGestioneOggetti);

		mntmGestioneArmatureScudi = new JMenuItem("Gestione Armature/Scudi");
		mntmGestioneArmatureScudi.addActionListener(this);
		mnGestioneOggetti.add(mntmGestioneArmatureScudi);

		mntmGestioneArmi = new JMenuItem("Gestione Armi");
		mntmGestioneArmi.addActionListener(this);
		mnGestioneOggetti.add(mntmGestioneArmi);

		mntmGestioneTaglie = new JMenuItem("Gestione Taglie");
		mntmGestioneTaglie.addActionListener(this);
		mnGestioneOggetti.add(mntmGestioneTaglie);

		mntmGestioneAbilita = new JMenuItem("Gestione Abilita");
		mntmGestioneAbilita.addActionListener(this);
		mnGestioneOggetti.add(mntmGestioneAbilita);

		mnPannelli = new JMenu("Pannelli");
		menuBar.add(mnPannelli);

		chckbxmntmManovre = new JCheckBoxMenuItem("Manovre");
		chckbxmntmManovre.addActionListener(this);
		mnPannelli.add(chckbxmntmManovre);

		mnOpzioni = new JMenu("Opzioni");
		menuBar.add(mnOpzioni);

		mntmCambioLingua = new JMenuItem("Cambio Lingua");
		mntmCambioLingua.addActionListener(this);
		mnOpzioni.add(mntmCambioLingua);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 863, 0 };
		gbl_contentPane.rowHeights = new int[] { 520, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		tree = new JTree();
		tree.addTreeSelectionListener(this);

		
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		panel.add(tree, gbc_tree);

		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		pgDatiPanel = new PgDatiPanel(pgDatiObj, opzioniObj);
		pgDatiPanel.getTextFieldNomePg().setEnabled(true);
		tabbedPane.addTab("Dati Personaggio", null, pgDatiPanel, null);

		pgRiepilogoPanel = new PgRiepilogoPanel(pgDatiObj);
		tabbedPane.addTab("Riepilogo", null, pgRiepilogoPanel, null);

		pgBonusPanel = new PgBonusPanel(pgDatiObj);
		pgBonusPanel.setFrame(this);
		tabbedPane.addTab("Bonus Applicabili", null, pgBonusPanel, null);

		pgClassiPanel = new PgClassiPanel(pgDatiObj);
		pgClassiPanel.setFrame(this);
		tabbedPane.addTab("Classi e Px", null, pgClassiPanel, null);

		pgStatistichePanel = new PgStatistichePanel(pgDatiObj);
		pgStatistichePanel.setFrame(this);
		tabbedPane.addTab("Caratteristiche", null, pgStatistichePanel, null);

		pgPuntiFeritaPanel = new PgPuntiFeritaPanel(pgDatiObj);
		pgPuntiFeritaPanel.setFrame(this);
		tabbedPane.addTab("Punti Ferita", null, pgPuntiFeritaPanel, null);

		pgClasseArmaturaPanel = new PgClasseArmaturaPanel(pgDatiObj);
		pgClasseArmaturaPanel.setFrame(this);
		tabbedPane.addTab("Classe Armatura", null, pgClasseArmaturaPanel, null);

		pgBabPanel = new PgBabPanel(pgDatiObj);
		pgBabPanel.setFrame(this);
		tabbedPane.addTab("Bonus Attacco Base", null, pgBabPanel, null);

		pgTiriSalvezzaPanel = new PgTiriSalvezzaPanel(pgDatiObj);
		pgTiriSalvezzaPanel.setFrame(this);
		tabbedPane.addTab("Tiri Salvezza", null, pgTiriSalvezzaPanel, null);

		pgIniziativaPanel = new PgIniziativaPanel(pgDatiObj);
		pgIniziativaPanel.setFrame(this);
		tabbedPane.addTab("Iniziativa", null, pgIniziativaPanel, null);

		pgArmiPanel = new PgArmiPanel(pgDatiObj);
		pgArmiPanel.setFrame(this);
		tabbedPane.addTab("Armi", null, pgArmiPanel, null);

		pgAbilitaPanel = new PgAbilitaPanel(pgDatiObj);
		pgAbilitaPanel.setFrame(this);
		tabbedPane.addTab("Abilità", null, pgAbilitaPanel, null);

		pgTalentiPanel = new PgTalentiPanel(pgDatiObj);
		pgTalentiPanel.setFrame(this);
		tabbedPane.addTab("Talenti", null, pgTalentiPanel, null);

		pgTrattiRazzialiPanel = new PgTrattiRazzialiPanel(pgDatiObj);
		pgTrattiRazzialiPanel.setFrame(this);
		tabbedPane.addTab("Tratti Razziali", null, pgTrattiRazzialiPanel, null);

		pgPrivilegiDiClassePanel = new PgPrivilegiDiClassePanel(pgDatiObj);
		pgPrivilegiDiClassePanel.setFrame(this);
		tabbedPane.addTab("Privilegi di Classe", null, pgPrivilegiDiClassePanel, null);

		pgLinguePanel = new PgLinguePanel(pgDatiObj);
		pgLinguePanel.setFrame(this);
		tabbedPane.addTab("Lingue", null, pgLinguePanel, null);

		pgEquipPanel = new PgEquipPanel(pgDatiObj);
		pgEquipPanel.setFrame(this);
		tabbedPane.addTab("Equipaggiamento", null, pgEquipPanel, null);

		pgMovimentoPanel = new PgMovimentoPanel(pgDatiObj);
		pgMovimentoPanel.setFrame(this);
		tabbedPane.addTab("Movimento", null, pgMovimentoPanel, null);

		pgCaricoPanel = new PgCaricoPanel(pgDatiObj);
		pgCaricoPanel.setFrame(this);
		tabbedPane.addTab("Carico", null, pgCaricoPanel, null);

		pgAppuntiPanel = new PgAppuntiPanel(pgDatiObj);
		pgAppuntiPanel.setFrame(this);
		tabbedPane.addTab("Appunti", null, pgAppuntiPanel, null);
		// TODO
		if (!Beans.isDesignTime()) {
			popolaFrame(pgDatiObj);
		}

	}

	/**
	 * Popolamento frame per la GUI Chiamato dopo il caricamento dei dati di un
	 * PG o a fronte di modifiche di campi che influenzano altri
	 * 
	 * @param pgDatiObj
	 */
	@SuppressWarnings("serial")
	public void popolaFrame(PgDatiObj pgDatiObj) {

		setTitle(pgDatiObj.getNomePg() + " - Scheda PG by Bazzu");

		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		// Inserimento o cancellazione Pannelli sulla base della scelta utente
		chckbxmntmManovre.setSelected(pgDatiObj.isManovrePanel());
		if (pgDatiObj.isManovrePanel()) {
			if (!manovrePanelAggiunto) {
				pgManovrePanel = new PgManovrePanel(pgDatiObj);
				pgManovrePanel.setFrame(this);
				tabbedPane.addTab("Manovre", null, pgManovrePanel, null);
				manovrePanelAggiunto = true;

				for (int i = 0; i < tabbedPane.getTabCount(); i++) {
					if (tabbedPane.getTitleAt(i).equals("Manovre")) {
						pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.INDEX_MANOVRE_PANEL,
								Integer.toString(i));
					}
				}
			}

		} else {
			if (pgDatiObj.getIndexManovrePanel() != 0) {
				tabbedPane.removeTabAt(pgDatiObj.getIndexManovrePanel());
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.INDEX_MANOVRE_PANEL,
						Integer.toString(0));
				manovrePanelAggiunto = false;

			}
		}

		// Aggiornamento tree laterale
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Scheda") {
			{
				for (int i=0; i < tabbedPane.getTabCount();i++){
					add(new DefaultMutableTreeNode(tabbedPane.getTitleAt(i)));
				}
			}
		}));
		// Aggiornamento oggetto con tutti i dati calcolati
		pgDatiObj = calcolaDati.calcola(pgDatiObj);

		pgDatiPanel.setFrame(this);
		pgDatiPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgRiepilogoPanel.setFrame(this);
		pgRiepilogoPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgBonusPanel.setFrame(this);
		pgBonusPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgClassiPanel.setFrame(this);
		pgClassiPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgStatistichePanel.setFrame(this);
		pgStatistichePanel.popolaPanel(pgDatiObj, opzioniObj);

		pgPuntiFeritaPanel.setFrame(this);
		pgPuntiFeritaPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgClasseArmaturaPanel.setFrame(this);
		pgClasseArmaturaPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgBabPanel.setFrame(this);
		pgBabPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgTiriSalvezzaPanel.setFrame(this);
		pgTiriSalvezzaPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgIniziativaPanel.setFrame(this);
		pgIniziativaPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgArmiPanel.setFrame(this);
		pgArmiPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgTalentiPanel.setFrame(this);
		pgTalentiPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgAbilitaPanel.setFrame(this);
		pgAbilitaPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgTrattiRazzialiPanel.setFrame(this);
		pgTrattiRazzialiPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgPrivilegiDiClassePanel.setFrame(this);
		pgPrivilegiDiClassePanel.popolaPanel(pgDatiObj, opzioniObj);

		pgLinguePanel.setFrame(this);
		pgLinguePanel.popolaPanel(pgDatiObj, opzioniObj);

		pgEquipPanel.setFrame(this);
		pgEquipPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgMovimentoPanel.setFrame(this);
		pgMovimentoPanel.popolaPanel(pgDatiObj, opzioniObj);

		pgCaricoPanel.setFrame(this);
		pgCaricoPanel.popolaPanel(pgDatiObj, opzioniObj);

		if (chckbxmntmManovre.isSelected()) {
			pgManovrePanel.setFrame(this);
			pgManovrePanel.popolaPanel(pgDatiObj, opzioniObj);
		}

		pgAppuntiPanel.setFrame(this);
		pgAppuntiPanel.popolaPanel(pgDatiObj, opzioniObj);

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		// TODO SchedaPg - MainWindow - popolaFrame
	}

	protected void apriCreaPg() {
		// System.out.println("MainWindow apriCreaPg");
		// System.out.println(" isDatiCommittati: " +
		// pgDatiObj.isDatiCommittati());

		if (pgDatiObj.isDatiCommittati()) {
			caricaPg();
			popolaFrame(pgDatiObj);
		} else {
			int scelta = JOptionPane.showConfirmDialog(MainWindow.this, "Vuoi salvare le modifiche?", "Attenzione!",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (scelta) {
			case JOptionPane.YES_OPTION:
				aggiornaPg();
				break;
			case JOptionPane.NO_OPTION:
				break;
			case JOptionPane.CANCEL_OPTION:
				break;
			}
			if (scelta != JOptionPane.CANCEL_OPTION) {
				caricaPg();
				popolaFrame(pgDatiObj);
			}
		}
	}

	protected void chiudiSchedaPg() {

		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		Rectangle dimensioniFinestra = getBounds();
		if (getExtendedState() != MAXIMIZED_BOTH) {
			opzioniObj.setWindowX(dimensioniFinestra.x);
			opzioniObj.setWindowY(dimensioniFinestra.y);
			opzioniObj.setWindowWidth(dimensioniFinestra.width);
			opzioniObj.setWindowHeight(dimensioniFinestra.height);
			opzioniObj.setMaximized(false);
		} else {
			// opzioniObj.setWindowX(0);
			// opzioniObj.setWindowY(0);
			// opzioniObj.setWindowWidth(0);
			// opzioniObj.setWindowHeight(0);
			opzioniObj.setMaximized(true);
		}
		opzioniObj.setLastId(pgDatiObj.getId());
		opzioniObj.setLastFileName(pgDatiObj.getFileName());
		opzioniObj.setMigToJson(true);

		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);

		if (pgDatiObj.isDatiCommittati()) {
			System.exit(0);
		} else {
			int scelta = JOptionPane.showConfirmDialog(MainWindow.this, "Vuoi salvare le modifiche?", "Attenzione!",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (scelta) {
			case JOptionPane.YES_OPTION:
				aggiornaPg();
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			case JOptionPane.CANCEL_OPTION:
				break;
			}
		}
	}

	private void chiudiSenzaSalvare() {
		System.exit(0);
	}

	protected void aggiornaPg() {
		// Aggiorna i dati in tabella e pulisce i flag datiVariati
		boolean datiCommittati = pgDatiObj.isDatiCommittati();
		// se l'aggiornamento va male ripristiniamo il flag come prima
		if (!gestioneJsonPg.aggiornaPg(pgDatiObj)) {
			pgDatiObj.setDatiCommittati(datiCommittati);
		}
	}

	private void caricaPg() {
		CaricaPgDialog caricaPgDialog = new CaricaPgDialog();
		caricaPgDialog.setVisible(true);

		// Se non abbiamo ancora caricato nessun pg
		// Se dal dialog ne è tornato uno usiamo quello
		// Se dal dialog non ne è tornato uno chiudiamo tutto
		// Se invece abbiamo gia un pg caricato
		// Se dal dialog ne è tornato uno usiamo quello
		// Se dal dialog non ne è tornato uno continuiamo come se niente fosse

		if (pgDatiObj.getFileName().trim().isEmpty()) {

			if (!caricaPgDialog.getPgDatiObj().getFileName().trim().isEmpty()) {
				pgDatiObj = caricaPgDialog.getPgDatiObj();
			} else {
				chiudiSenzaSalvare();
			}
		} else {
			if (!caricaPgDialog.getPgDatiObj().getFileName().trim().isEmpty()) {
				pgDatiObj = caricaPgDialog.getPgDatiObj();
			}
		}

	}

	private void caricaUltimoPg() {
		// pgDatiObj = gestioneDbPgJson.getPgDatiById(opzioniObj.getLastId());
		pgDatiObj = gestioneJsonPg.getPgByFileName(opzioniObj.getLastFileName());

		if (pgDatiObj.getFileName().trim().isEmpty()) {
			caricaPg();
		}
	}

	private void gestioneArmatureScudi() {
		DbArmaturaScudoDialog armaturaScudoDialog = new DbArmaturaScudoDialog();
		armaturaScudoDialog.setVisible(true);
		popolaFrame(pgDatiObj);
	}

	private void gestioneArmi() {
		DbArmiDialog armiDialog = new DbArmiDialog();
		armiDialog.setVisible(true);
		popolaFrame(pgDatiObj);
	}

	private void gestioneTaglie() {
		DbTaglieDialog dbTaglieDialog = new DbTaglieDialog();
		dbTaglieDialog.setVisible(true);
		popolaFrame(pgDatiObj);
	}

	private void gestioneAbilita() {
		// Aggiorniamo il pg qui visto che le modifiche nel dialog Abilita vanno
		// a influire sulle abilita di tutti i pg
		aggiornaPg();
		DbAbilitaDialog dbAbilitaDialog = new DbAbilitaDialog();
		dbAbilitaDialog.setVisible(true);
		// pgDatiObj = gestioneDbPgJson.getPgDatiById(pgDatiObj.getId());
		pgDatiObj = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());
		popolaFrame(pgDatiObj);
	}

	private void cambioLingua() {
		ScegliLinguaDialog scegliLinguaDialog = new ScegliLinguaDialog();
		scegliLinguaDialog.setVisible(true);
		popolaFrame(pgDatiObj);
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object oggetto = e.getSource();

		if (oggetto instanceof JMenuItem) {
			if (((JMenuItem) oggetto).getActionCommand() == mntmApriCreaPg.getActionCommand()) {
				apriCreaPg();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmSalvaPg.getActionCommand()) {
				aggiornaPg();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmEsci.getActionCommand()) {
				chiudiSchedaPg();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmGestioneArmatureScudi.getActionCommand()) {
				gestioneArmatureScudi();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmGestioneArmi.getActionCommand()) {
				gestioneArmi();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmGestioneTaglie.getActionCommand()) {
				gestioneTaglie();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmGestioneAbilita.getActionCommand()) {
				gestioneAbilita();
			}
			if (((JMenuItem) oggetto).getActionCommand() == mntmCambioLingua.getActionCommand()) {
				cambioLingua();
			}

		}
		if (oggetto instanceof JCheckBoxMenuItem) {
			if (((JCheckBoxMenuItem) oggetto).getActionCommand() == chckbxmntmManovre.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.MANOVRE_PANEL,
						Boolean.valueOf(chckbxmntmManovre.isSelected()).toString());
				popolaFrame(pgDatiObj);
			}
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object oggetto = e.getSource();
		if (oggetto instanceof JTree) {
			if (((JTree) oggetto) == tree) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if (node == null) {
					return;
				}

				if (node.isLeaf()) {
					for (int i = 0; i < tabbedPane.getTabCount(); i++) {
						if (tabbedPane.getTitleAt(i).equals(node.toString())) {
							tabbedPane.setSelectedIndex(i);
						}
					}
				} else {
				}
			}
		}
	}

}
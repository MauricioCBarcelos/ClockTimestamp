package zaas.ClockTimestamp.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import zaas.ClockTimestamp.controller.ControllerTimer;

import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TelaPrincipal.class);
	private JPanel contentPane;
	private JTextPane textPaneClockNormal;
	private JTextPane textPaneClockTimestamp;
	private ControllerTimer timer = new ControllerTimer();
	private JPanel jPanelTitleDataHoraAtual;
	private JTextPane textPaneValueConvert = new JTextPane();
	private JTextPane textPaneResult = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

					TelaPrincipal frame = new TelaPrincipal();

					frame.setVisible(true);

				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setType(Type.POPUP);
		setTitle("ClockTimestamp");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[209.00px]", "[83px][21.00px][20px][21.00px][20px]"));

		jPanelTitleDataHoraAtual = new JPanel();
		jPanelTitleDataHoraAtual.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Data e hora atual:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(jPanelTitleDataHoraAtual, "cell 0 0,alignx left,growy");
		GridBagLayout gbl_jPanelTitleDataHoraAtual = new GridBagLayout();
		gbl_jPanelTitleDataHoraAtual.columnWidths = new int[] { 157, 0 };
		gbl_jPanelTitleDataHoraAtual.rowHeights = new int[] { 0, 20, 0 };
		gbl_jPanelTitleDataHoraAtual.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_jPanelTitleDataHoraAtual.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jPanelTitleDataHoraAtual.setLayout(gbl_jPanelTitleDataHoraAtual);

		textPaneClockTimestamp = new JTextPane();
		GridBagConstraints gbc_textPaneClockTimestamp = new GridBagConstraints();
		gbc_textPaneClockTimestamp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPaneClockTimestamp.anchor = GridBagConstraints.NORTH;
		gbc_textPaneClockTimestamp.insets = new Insets(0, 0, 5, 0);
		gbc_textPaneClockTimestamp.gridx = 0;
		gbc_textPaneClockTimestamp.gridy = 0;
		jPanelTitleDataHoraAtual.add(textPaneClockTimestamp, gbc_textPaneClockTimestamp);
		textPaneClockTimestamp.setEditable(false);

		textPaneClockNormal = new JTextPane();
		GridBagConstraints gbc_textPaneClockNormal = new GridBagConstraints();
		gbc_textPaneClockNormal.anchor = GridBagConstraints.NORTH;
		gbc_textPaneClockNormal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPaneClockNormal.gridx = 0;
		gbc_textPaneClockNormal.gridy = 1;
		jPanelTitleDataHoraAtual.add(textPaneClockNormal, gbc_textPaneClockNormal);
		textPaneClockNormal.setEditable(false);

		JLabel lblConvert = new JLabel("Valor a ser convertido:");
		contentPane.add(lblConvert, "cell 0 1,alignx left,aligny top");

		textPaneValueConvert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				dateTimeConverter();

			}

		});
		contentPane.add(textPaneValueConvert, "cell 0 2,growx,aligny top");

		textPaneResult.setEditable(false);
		contentPane.add(textPaneResult, "cell 0 4,growx,aligny top");

		JLabel lblResultado = new JLabel("Resultado:");
		contentPane.add(lblResultado, "cell 0 3,alignx left,aligny top");
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { contentPane, jPanelTitleDataHoraAtual, textPaneClockTimestamp, textPaneClockNormal,
						lblConvert, textPaneValueConvert, textPaneResult, lblResultado }));
		timer();
	}

	private void timer() {

		Thread thread = new Thread() {

			@Override
			public void run() {

				try {
					for (;;) {
						textPaneClockNormal.setText(timer.timerControllerNormal());

						textPaneClockTimestamp.setText(timer.timerControllerTimestamp());

						sleep(1000);
					}

				} catch (Exception e) {

					logger.error("Erro na atualizacao: " + e.getMessage(), e);

				}

			}

		};

		thread.start();
	}

	private void dateTimeConverter() {
		try {
			String result = timer.formaterDateTimeController(textPaneValueConvert.getText());

			textPaneResult.setText(result);
		} catch (Exception e) {
			logger.error("Valor nulo: " + e.getMessage(), e);
			textPaneResult.setText("");
		}

	}
}

package zaas.ClockTimestamp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;


import zaas.ClockTimestamp.controller.ControllerTimer;

import javax.swing.JTextPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextPane textPaneClockNormal;
	private JTextPane textPaneClockTimestamp;
	private static final Logger logger = Logger.getLogger(TelaPrincipal.class);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPaneClockTimestamp = new JTextPane();
		textPaneClockTimestamp.setEditable(false);
		textPaneClockTimestamp.setBounds(29, 44, 157, 20);
		contentPane.add(textPaneClockTimestamp);
		
		textPaneClockNormal = new JTextPane();
		textPaneClockNormal.setEditable(false);
		textPaneClockNormal.setBounds(29, 100, 157, 20);
		contentPane.add(textPaneClockNormal);
		
		timer();
	}

	private void timer() {
		// TODO Auto-generated method stub
		ControllerTimer timer = new ControllerTimer();
		
		
		textPaneClockNormal.setText(timer.timerControllerNormal());
		
		textPaneClockTimestamp.setText(timer.timerControllerTimestamp());
		
	}
}

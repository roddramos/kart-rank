package com.rodolfo.kartrank.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.rodolfo.kartrank.Processo;

public class SwingFile extends JFrame {

	private static JTextArea textAreal;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingFile swingFile = new SwingFile();
		swingFile.executar();

	}

	private void executar() {
		JFrame frame = new JFrame("Tela Seleção");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JButton selecionar = new JButton("Selecione o Arquivo de Log");
		selecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escolhe();
			}
		});
		frame.add(selecionar, BorderLayout.PAGE_START);

		textAreal = new JTextArea("", 5, 10);
		textAreal.setPreferredSize(new Dimension(500, 500));

		JScrollPane scrollPane = new JScrollPane(textAreal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(600, 500));
		textAreal.setLineWrap(true);

		frame.add(scrollPane, BorderLayout.AFTER_LAST_LINE);
		frame.pack();
		frame.setVisible(true);
	}

	public void escolhe() {
		JFileChooser chooser = new JFileChooser();
		int retorno = chooser.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			String selecao = chooser.getSelectedFile().getPath();
			if (selecao == null || selecao.equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Arquivo não selecionado.");
			} else {
				Processo processo = new Processo(selecao);
				try {
					textAreal.setText(processo.processarArquivo());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

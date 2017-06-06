package com.rodolfo.kartrank;

/**
 * Rodolfo D Avila Ramos 04/06/2017
 *
 */
public class App {
    public static void main( String[] args ) {
        String caminhoArquivo = args[0];
        Processo processo = new Processo(caminhoArquivo);
		try {
			processo.processarArquivo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

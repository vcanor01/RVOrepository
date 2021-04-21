package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TableroAleatorioTest {

	@Test
	void testTableroAleatorioContarMinasalrededor() {
		// Tantas como minas
		ArrayList<Coordenada> posiciones = null;
		// lo que decidais de lado de Dificultad
//		Ejemplo de la pizarra

		posiciones.add(new Coordenada(0, 0));
		posiciones.add(new Coordenada(1, 2));
		posiciones.add(new Coordenada(2, 2));
		// minas en {0,0},{1,2},{2,2}
		TableroAleatorio tableroAleatorio = new TableroAleatorio(4, posiciones);
		int tablero[][] = { {0,2,1,1}, {1,3,0,2}, {0,2,0,2}, {0,1,1,1} };
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				assertEquals(tablero[i][j],tableroAleatorio.getCasilla(new Coordenada(i, j)).getMinasAlrededor());
			}
		}

	}

	@Test
	void testTableroAleatorio() {
		Dificultad dificultad = Dificultad.dificil;
		int minas = 143;
		TableroAleatorio tableroAleatorio = new TableroAleatorio(dificultad.getLongitud(), minas);
		ArrayList<Coordenada> posiciones = tableroAleatorio.generaAleatorio(minas, dificultad.getLongitud());
		for (int i = 0; i < posiciones.size(); i++) {
			for (int j = i + 1; j < posiciones.size(); j++) {
				assertFalse(posiciones.get(i).equals(posiciones.get(j)));
			}
		}
	}
}

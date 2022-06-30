package ManipuladorCompetidores;

import manejoDePersonajes.Caracteristica;
import manejoDePersonajes.Competidor;

public class QSCompetidores {
	
	/*
	 * Quicksort modificado para trabajar sobre la caracteristica indicada
	 */
	public void quickSort(Competidor[] arr, int low, int high, Caracteristica c) {
		if (low < high) {

			int pi = partition(arr, low, high, c);

			quickSort(arr, low, pi - 1, c);
			quickSort(arr, pi + 1, high, c);
		}
	}

	private void swap(Competidor[] arr, int i, int j) {
		Competidor temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int partition(Competidor[] arr, int low, int high, Caracteristica c) {

		Competidor pivot = arr[high];

		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j].getCaracteristicaPorEnum(c) < pivot.getCaracteristicaPorEnum(c)) {

				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

}

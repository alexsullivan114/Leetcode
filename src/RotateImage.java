public class RotateImage {
	public static void test() {
		int[][] array = {
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};
		new RotateImage().rotate(array);
		System.out.println("Rotated: " + array);
	}

	public void rotate(int[][] matrix) {
		int offset = 0;
		while (matrix.length - offset - offset > 1) {
			for (int i = offset; i < matrix.length - offset - 1; i++) {
				int saved = matrix[offset][i];
				matrix[offset][i] = matrix[matrix.length - 1 - i][offset];
				matrix[matrix.length - 1 - i][offset] = matrix[matrix.length - 1 - offset][matrix.length - 1 - i];
				matrix[matrix.length - 1 - offset][matrix.length - 1 - i] = matrix[matrix.length - 1 - (matrix.length - 1 - i)][matrix.length - 1 - offset];
				matrix[matrix.length - 1 - (matrix.length - 1 - i)][matrix.length - 1 - offset] = saved;
			}
			offset++;
		}
	}
}

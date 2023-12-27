import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void test() {
		int[][] array = {
				{1, 2},
				{3,4},
				{5,6},
				{7,8}
		};
		List<Integer> result = new SpiralMatrix().spiralOrder(array);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> returnList = new ArrayList<>();
		int offset = 0;
		while (true) {
			// Forwards across.
			int[] forwardsRow = matrix[offset];
			for (int i = offset; i <= forwardsRow.length - offset - 1; i++) {
				returnList.add(forwardsRow[i]);
			}
			if (returnList.size() == matrix.length * forwardsRow.length) {
				break;
			}
			// Down
			int downIndex = forwardsRow.length - offset - 1;
			for (int i = offset + 1; i < matrix.length - offset - 1; i++) {
				returnList.add(matrix[i][downIndex]);
			}
			if (returnList.size() == matrix.length * forwardsRow.length) {
				break;
			}
			// Backwards across.
			int[] backwardsRow = matrix[matrix.length - offset - 1];
			for (int i = backwardsRow.length - offset - 1; i >= offset; i--) {
				returnList.add(backwardsRow[i]);
			}
			if (returnList.size() == matrix.length * forwardsRow.length) {
				break;
			}
			// Up
			int upIndex = offset;
			for (int i = matrix.length - offset - 2; i > offset; i--) {
				returnList.add(matrix[i][upIndex]);
			}
			if (returnList.size() == matrix.length * forwardsRow.length) {
				break;
			}
			offset++;
		}
		return returnList;
	}
}

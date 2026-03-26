package Test_7;

public class Solution1 {
    public String compress(int[][] img, int x, int y, int size) {
        if (isUniform(img, x, y, size)) {
            return String.valueOf(img[x][y]);
        }

        int newSize = size / 2;
        String topLeft = compress(img, x, y, newSize);
        String topRight = compress(img, x, y+newSize, newSize);
        String bottomLeft = compress(img, x+newSize, y, newSize);
        String bottomRight = compress(img, x+newSize, y+newSize, newSize);

        return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
    }

    public boolean isUniform(int[][] img, int x, int y, int size) {
        int firstValue = img[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (img[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    };

    public static void main(String[] args) {
        int[][] img = {
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0}
        };

        // (011(0110))
        System.out.println(new Solution1().compress(img, 0, 0, img.length));
    }
}

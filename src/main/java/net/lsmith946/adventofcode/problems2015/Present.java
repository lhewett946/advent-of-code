package net.lsmith946.adventofcode.problems2015;

public class Present {
    private int length;
    private int width;
    private int depth;

    public Present(int length, int width, int depth) {
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    /**
     * @return the surface area of the present
     */
    private int calculateSurfaceArea() {
        int surfaceArea = 0;
        surfaceArea += 2 * length * width;
        surfaceArea += 2 * width * depth;
        surfaceArea += 2 * depth * length;
        return surfaceArea;
    }

    private int findSmallestSide() {
        int sideArea = length * width;
        if (width * depth < sideArea) {
            sideArea = width * depth;
        }
        if (depth * length < sideArea) {
            sideArea = depth * length;
        }
        return sideArea;
    }

    public int calculateWrappingPaperNeeded() {
        return calculateSurfaceArea() + findSmallestSide();
    }
}

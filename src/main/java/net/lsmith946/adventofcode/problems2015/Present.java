package net.lsmith946.adventofcode.problems2015;

public record Present (int length, int width, int depth) {

    private int calculateSurfaceArea() {
        int surfaceArea = 0;
        surfaceArea += 2 * length * width;
        surfaceArea += 2 * width * depth;
        surfaceArea += 2 * depth * length;
        return surfaceArea;
    }

    private int findSmallestSideArea() {
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
        return calculateSurfaceArea() + findSmallestSideArea();
    }

    private int findSmallestSidePerimeter() {
        int sidePerimeter = (2 * length) + (2 * width);
        if (((2 * width) + (2 * depth)) < sidePerimeter) {
            sidePerimeter = (2 * width) + (2 * depth);
        }
        if (((2 * depth) + (2 * length)) < sidePerimeter) {
            sidePerimeter = (2 * depth) + (2 * length);
        }
        return sidePerimeter;
    }

    private int findVolume() {
        return width * length * depth;
    }

    public int calculateRibbonLength() {
        return findSmallestSidePerimeter() + findVolume();
    }
}

public class Point {
    // write your code here
    
    private int x;
    private int y;

    public Point() {
        this(0,0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(this.y*this.y+this.x*this.x);
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.y-y,2) + Math.pow(this.x-x,2));
    }

    public double distance(Point another) {
        return Math.sqrt(Math.pow(this.y-another.y,2) + Math.pow(this.x-another.x,2));
    }
}
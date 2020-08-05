public class BedRoom {
    private String bedSize;
    private RoomDimensions dimensions;
    private boolean hasBathroom;
    private int chairs;

    public BedRoom(String bedSize, RoomDimensions dimensions, boolean hasBathroom, int chairs) {
        this.bedSize = bedSize;
        this.dimensions = dimensions;
        this.hasBathroom = hasBathroom;
        this.chairs = chairs;
    }

    public String getBedSize() {
        return bedSize;
    }

    public RoomDimensions getDimensions() {
        return dimensions;
    }

    public boolean isHasBathroom() {
        return hasBathroom;
    }

    public int getChairs() {
        return chairs;
    }
}

public class RoomDimensions {
    private int length;
    private int width;
    private int height;

    public RoomDimensions(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String printDimensions() {
        return (this.length+"m length, " + this.width + "m width, " + this.height + "m height.");
    }

    public int getArea() {
        return (this.length * this.width);
    }

    public int getVolume() {
        return this.getArea() * this.height;
    }
}


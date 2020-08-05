public class Printer {

    private int tonerLevel;
    private int prtPages;
    private boolean isDuplex;

    public Printer(int tonerLevel, int prtPages, boolean isDuplex) {
        this.tonerLevel = tonerLevel;
        this.prtPages = prtPages;
        this.isDuplex = isDuplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPrtPages() {
        return prtPages;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public void setPrtPages(int prtPages) {
        this.prtPages = prtPages;
    }

    public void setDuplex(boolean duplex) {
        isDuplex = duplex;
    }

    public void printing(int pages) {
        System.out.println("Please wait while printing...\n");
        int i = 0;
        while (i < pages) {
            this.prtPages ++;
            i ++;
            if (isDuplex()) {
                int j = i/2;
                if (i % 2 != 0) {
                    j++;
                    System.out.println("Printing page #" + j + " front");
                }
                else {
                    System.out.println("Printing page #" + j + " back");
                }
            }
            else {
                System.out.println("Printing page #" + i);
            }
        }
        if (isDuplex()) {
            if (i %2 != 0) {
                i ++;
            }
            System.out.println("\nPrinting complete. You have printed " + i/2 + " pages, front and back.");
        }
        else {
            System.out.println("\nPrinting complete. You have printed " + i + " pages.");
        }


    }

    public int fillToner() {
        if (this.tonerLevel == 100) {
            System.out.println("Toner is already full");
        }
        else {
            System.out.println("Toner refill...\nToner level = " + this.tonerLevel + "%\n");
            this.tonerLevel = 100;
        }
        return this.tonerLevel;
    }

}

/*
UNIT TESTING IN MAIN:

    public static void main(String[] args) {

        Printer hewlettPackard = new Printer(65, 50, false);
        System.out.println("This printer stats:\n\nToner level = " + hewlettPackard.getTonerLevel() + "%\nPrinted pages = " + hewlettPackard.getPrtPages() + "\nDuplex printing able = " + hewlettPackard.isDuplex() + "\n");
        hewlettPackard.fillToner();
        System.out.println("This printer stats:\n\nToner level = " + hewlettPackard.getTonerLevel() + "%\nPrinted pages = " + hewlettPackard.getPrtPages() + "\nDuplex printing able = " + hewlettPackard.isDuplex() + "\n");
        hewlettPackard.printing(11);
    }*/

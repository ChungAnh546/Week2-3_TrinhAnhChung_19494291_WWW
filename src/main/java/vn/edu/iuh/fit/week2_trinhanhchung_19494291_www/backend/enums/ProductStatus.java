package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.enums;

public enum ProductStatus {
    ACTION(1),IN_ACTION(-1),CEASE(0);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

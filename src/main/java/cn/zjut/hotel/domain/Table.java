package cn.zjut.hotel.domain;

import java.util.List;

/**
 * @author kuluo
 */
public class Table {
    private List<?> items;
    private int total;

    public Table(List<?> items, int total) {
        this.items = items;
        this.total = total;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

package cn.zjut.hotel.domain;

import java.util.List;

/**
 * @author kuluo
 */
public class Table {
    private List<?> items;
    private long total;

    public Table(List<?> items, long total) {
        this.items = items;
        this.total = total;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

package com.trycloud.pojo.Spartan;

import java.util.List;

public class SpartanSearch {
    private List<Spartan> content;
    private int totalElement;

    @Override
    public String toString() {
        return "Search{" +
                "content=" + content +
                ", totalElement=" + totalElement +
                '}';
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public List<Spartan> getContent() {
        return content;
    }

    public void setContent(List<Spartan> content) {
        this.content = content;
    }
}

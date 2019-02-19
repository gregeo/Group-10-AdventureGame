package demo1;

public class Item {
    boolean toBeFound;
    String showName;

    public void use() {
        
    }

    public String getName() {
        String tempName = this.showName;
        return tempName;
    }

    public Item() {
        this.toBeFound = false;
    }
    public Item(Item oldItem) {
        this.toBeFound = oldItem.toBeFound;
        this.showName = oldItem.showName;
    }
}
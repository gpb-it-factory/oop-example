
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

void main() {
    var cart = new ShoppingCart();
    cart.addItem(new ShoppingCartItem("item 1"));
    cart.addItem(new ShoppingCartItem("item 2"));

    System.out.println(cart);
    cart.getItems().clear();

    System.out.println("/////////");
    System.out.println(cart);
}

class ShoppingCart {
    private List<ShoppingCartItem> items = new ArrayList<>();

    public List<ShoppingCartItem> getItems() {
        return this.items;
    }

    public void addItem(ShoppingCartItem item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return this.items.stream()
                .map(x -> x.name)
                .collect(Collectors.joining("-", "{", "}"));
    }
}

class ShoppingCartItem {
    private String name;

    public ShoppingCartItem(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
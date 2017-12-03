package lesson5.utils;

public enum MenuItem {

    ORDER_HISTORY("ORDER HISTORY"),
    MY_CREDIT_SLIPS("CREDIT SLIPS"),
    MY_ADRESSES("MY ADDRESSES"),
    MY_PERSONAL_INFORMATION("YOUR PERSONAL INFORMATION"),
    MY_WHISHLIST("MY WISHLISTS");

    private String menuItem;

    MenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItem() {
        return menuItem;
    }
}

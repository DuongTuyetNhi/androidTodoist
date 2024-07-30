package enums;

public enum View {
    LIST("List"),
    BOARD("Board");

    private final String view;

    View(String view) {
        this.view = view;
    }
    public String getValueView(){
        return view;
    }
}

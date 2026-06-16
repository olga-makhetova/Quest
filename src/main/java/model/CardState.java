package model;

public enum CardState {
    NORMAL("quest-normal"),
    WIN("quest-win"),
    LOSE("quest-lose");

    private final String cssClassName;

    CardState(String cssClassName) {
        this.cssClassName = cssClassName;
    }
    public String getCssClassName() {
        return cssClassName;
    }
}

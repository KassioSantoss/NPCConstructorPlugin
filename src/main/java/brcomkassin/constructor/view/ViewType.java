package brcomkassin.constructor.view;

import lombok.Getter;

@Getter
public enum ViewType {

    HOME_CONSTRUCTOR("mainPageConstructor"),
    REVIEW_PAGE("reviewPageConstructor");

    private final String name;

    ViewType(String name) {
        this.name = name;
    }

}

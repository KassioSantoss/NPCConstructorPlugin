package brcomkassin.constructor.view;

import lombok.Getter;

@Getter
public enum ViewType {

    MAIN_PAGE_CONSTRUCTOR("mainPageConstructor"),
    REVIEW_PAGE_CONSTRUCTOR("reviewPageConstructor"),
    BUILD_PAGE_CONSTRUCTOR("buildPageConstructor");

    private final String name;

    ViewType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

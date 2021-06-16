package chap23_annotations.database;

public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
}
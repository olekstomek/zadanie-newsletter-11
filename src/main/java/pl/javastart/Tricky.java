package pl.javastart;

class Tricky {
    private String field;

    /*private*/ public Tricky(String field) { //TODO: must be private not public
        this.field = field;
    }

    void show() {
        System.out.println(field);
    }
}

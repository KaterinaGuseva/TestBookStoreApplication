package utils.apiutils;

public enum Endpoints {

    GET_BOOK_STORE ("/BookStore/v1/Books");
    private String endpoint;

    Endpoints (String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}

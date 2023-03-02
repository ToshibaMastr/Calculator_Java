class CalcException extends Exception {

    String message;
    CalcException(String str){
        message = str;
    }

    public String toString() {
        return ("throws Exception: " + message);
    }
}

package javastart.pl;

public class Message {
    private String author;
    private String text;

    public Message(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return author + ": " + text;
    }
}

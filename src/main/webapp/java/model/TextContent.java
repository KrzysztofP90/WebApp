package model;


import javax.persistence.*;

@Entity
public class TextContent {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String header;

    @Column(columnDefinition="TEXT")
    private String describe;

    public TextContent() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

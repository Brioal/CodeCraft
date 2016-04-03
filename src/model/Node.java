package model;

/**
 * Created by Brioal on 2016/4/2.
 */
public class Node {
    private int mLink ;
    private int mWeight ;
    private StringBuilder mBuilder;

    public Node() {
        mLink = -1;
        mWeight = 1000;
        mBuilder = new StringBuilder();
    }

    public Node(int mLink, int mWeight, StringBuilder mBuilder) {
        this.mLink = mLink;
        this.mWeight = mWeight;
        this.mBuilder = mBuilder;
    }


    public int getmLink() {
        return mLink;
    }

    public int getmWeight() {
        return mWeight;
    }

    public StringBuilder getmBuilder() {
        return mBuilder;
    }

    public void setmLink(int mLink) {
        this.mLink = mLink;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public void setmBuilder(StringBuilder mBuilder) {
        this.mBuilder = mBuilder;
    }
}

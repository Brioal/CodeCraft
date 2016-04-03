package tool;

/**
 * Created by Brioal on 2016/4/2.
 */
public class Cases {
    private int [] [] D ; //权重矩阵
    private int start ; // 起点
    private int end ; //终点
    private int [] nodes ; //必经顶点
    private String[][] links; //路径
    private String [] [] points ; // 所经过的顶点

    public Cases(int[][] d, int start, int end, int[] nodes, String[][] links, String[][] points) {
        D = d;
        this.start = start;
        this.end = end;
        this.nodes = nodes;
        this.links = links;
        this.points = points;
    }

    public String[][] getPoints() {
        return points;
    }

    public int[][] getD() {
        return D;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int[] getNodes() {
        return nodes;
    }

    public String[][] getLinks() {
        return links;
    }
}

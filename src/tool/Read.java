package tool;

import java.io.*;

/**
 * Created by Brioal on 2016/4/2.
 */
public class Read {
    private int[][] D; //权重矩阵
    private int start; // 起点
    private int end; //终点
    private int[] nodes; //必经顶点
    private String[][] links; //路径
    private String[][] points; // 所经过的终点


    private Cases cases;

    public static final String CASE0 = "case0";
    public static final String CASE1 = "case1";
    public static final String CASE2 = "case2";
    public static final String CASE3 = "case3";
    public static final String CASE4 = "case4";

    private File file_topo;
    private File file_demand;

    public Read(String mCase) {
        switch (mCase) {
            case CASE0:
                file_topo = new File("topo.csv");
                file_demand = new File("demand.csv");
                break;
            case CASE1:
                file_topo = new File("topo1.csv");
                file_demand = new File("demand1.csv");
                break;
            case "case2":
                file_topo = new File("topo2.csv");
                file_demand = new File("demand2.csv");
                break;
            case "case3":
                file_topo = new File("topo3.csv");
                file_demand = new File("demand3.csv");
                break;
            case "case4":
                file_topo = new File("topo4.csv");
                file_demand = new File("demand4.csv");
                break;
        }
        int row = 0;
        BufferedReader br = null;
        FileReader fb = null;

        try {
            fb = new FileReader(file_topo);
            br = new BufferedReader(fb);

            String str = null;
            int index = 0;
            while ((str = br.readLine()) != null) {
                int s = Integer.parseInt(str.split(",")[1]);
                if (s > row) {
                    row = s;
                }

            }
            fb = new FileReader(file_topo);
            br = new BufferedReader(fb);
            D = new int[row + 1][row + 1];
            links = new String[row + 1][row + 1];
            points = new String[row + 1][row + 1];
            for (int i = 0; i < links.length; i++) {
                for (int j = 0; j < links.length; j++) {
                    links[i][j] = "";
                    points[i][j] = "";
                }
            }
            str = null;

            while ((str = br.readLine()) != null) {
                String[] s = str.split(",");
                String mLink = s[0];
                String mEnd = s[2];
                int start = Integer.parseInt(s[1]);
                int end = Integer.parseInt(mEnd);
                int d = Integer.parseInt(s[3]);
                D[start][end] = d;
                links[start][end] = mLink;
                points[start][end] = mEnd;

            }


            for (int i = 0; i < D.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    if (D[i][j] == 0 && i != j) {
                        D[i][j] = 1000;
                    }
                }
            }


            fb = new FileReader(file_demand);
            br = new BufferedReader(fb);
            str = br.readLine();
            String[] demands = str.split(",");
            start = Integer.parseInt(demands[0]);
            end = Integer.parseInt(demands[1]);
            String[] nos = demands[2].split("\\|");
            nodes = new int[nos.length];
            for (int i = 0; i < nos.length; i++) {
                nodes[i] = Integer.parseInt(nos[i]);
            }


            cases = new Cases(D, start, end, nodes, links,points);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(br);
            closeQuietly(fb);
        }
    }


    public Cases getCases() {
        return cases;
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
        }
    }

}

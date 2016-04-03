package warshall;

import tool.Cases;
import tool.Read;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Brioal on 2016/4/2.
 */
public class WarShallTest {
//    int[][] R;
    int [][] D;
    int start;
    int end  ;
    int[] nodes;
    String [][]links ;
    String [] [] points ;
    String result  = "";
    int time = 0;
    int []n ;
    Map<Integer , Integer> map ;


    public WarShallTest(Cases cases) {

        D = cases.getD() ;
        start = cases.getStart();
        end = cases.getEnd();
        nodes = cases.getNodes();
        links = cases.getLinks();
        points = cases.getPoints();
//        printD();


//        printR();
//        long srtartTimer = System.currentTimeMillis();
//        for (int i = 0; i < R.length; i++) {
//            for (int j = 0; j < R.length; j++) {
//                for (int k = 0; k < R.length; k++) {
//                    if (R[j][k] == 0) {
//                        R[j][k] = R[j][i] * R[i][k];
//                    }
//                }
//            }
//        }
//        System.out.println("R(" + R.length + ")矩阵");
//        System.out.println(System.currentTimeMillis() - srtartTimer);
//        printR();


        //判断是否存在这样一条路径,只需要判断start-end , start-任意一顶点==1即可
//        if (R[start][end] == 1) {
//
//            for (int i = 0; i < ss.length; i++) {
//                if (R[start][ss[i]] == 1) {
//                    continue;
//                } else {
//                    System.out.println("NA");
//                    System.exit(0);
//                }
//            }
//            isExit = true;
//        } else {
//            System.out.println("NA");
//        }

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                for (int k = 0; k < D.length; k++) {
                    if (D[i][j] > (D[i][k] + D[k][j])) {
                        D[i][j] =  D[i][k] + D[k][j];
                        links[i][j] = links[i][k] +"|"+ links[k][j];
                        points[i][j] = points[i][k] + "|" + points[k][j];
                    }
                }
            }
        }

//        System.out.println("最终权重矩阵");
//        printD();
        n = nodes;
        getMin(start,0);


        Set<Integer> iterator = map.keySet();
        Iterator iterator1 = iterator.iterator();
        while (iterator1.hasNext()) {
            System.out.printf("%5s",points[iterator1.]);
        }


    }

    private void getMin(int start , int node_index) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != -1) {
                int temp = nodes[i];
                map.put(start, nodes[i]);
                getMin(temp, 0);
                nodes[i] = -1;
                break;
            }
        }

    }



    public boolean hasSame(String s, String ss) {
        String[] sss = ss.split("|");
        for (String ssss : sss) {
            if (s.contains(ssss)) {
                return false;
            }
        }

        return true;
    }


//    public void getMin(int s) { //点的值
//        int minD = 1000;
//        int index = s;
//        for (int i = 0; i < nodes.length; i++) {
//            if (nodes[i] != s&&nodes[i]!=-1) {
//                if (D[s][nodes[i]] < minD) {
//                    index = nodes[i];
//                    minD = D[s][nodes[i]];
//                }
//            }
//        }
//        result += links[s][index] + "|";
////        System.out.println(links[s][index]);
//        time++;
//        for (int i = 0; i < nodes.length; i++) {
//            if (nodes[i] == s) {
//                nodes[i] = -1;
//            }
//        }
//        if (time != nodes.length) {
//            getMin(index);
//        } else {
//            result += links[index][end];
//        }
//
//    }


//    public void printR() {
//        for (int i = 0; i < R.length; i++) {
//            for (int j = 0; j < R[0].length; j++) {
//                System.out.printf("%3d", R[i][j]);
//            }
//            System.out.println();
//        }
//    }

    public void printD() {
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[0].length; j++) {
//                if (D[i][j] == 1000) {
//                    System.out.printf("%3d", -1);
//                } else {
//                    System.out.printf("%3d", D[i][j]);
//                }
//                System.out.printf("%5s",links[i][j]);
                System.out.printf("%5s",points[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        new WarShallTest(new Read(Read.CASE0).getCases());
    }
}

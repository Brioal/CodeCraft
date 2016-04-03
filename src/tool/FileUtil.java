package tool;

import model.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileUtil
{



    public static int sum = 0 ;
    /** 
     * 读取文件并按行输出
     * @param filePath
     * @param spec 允许解析的最大行数， spec==null时，解析所有行
     * @return
     * @author
     * @since 2016-3-1
     */
    public static  Node [] []  read(final String filePath, final Integer spec)
    {
        File file = new File(filePath);
        // 当文件不存在或者不可读时
        if ((!isFileExists(file)) || (!file.canRead()))
        {
            System.out.println("file [" + filePath + "] is not exist or cannot read!!!");
            return null;
        }
        Node [] [] D  = null;
        BufferedReader br = null;
        FileReader fb = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            fb = new FileReader(file);
            br = new BufferedReader(fb);

            String str = null;
            int index = 0;
            while (((spec == null) || index++ < spec) && (str = br.readLine()) != null)
            {
                int s = Integer.parseInt(str.split(",")[1]);
                if (s > sum) {
                    sum = s;
                }

            }
            fb = new FileReader(file);
            br = new BufferedReader(fb);
            D = new Node[sum + 1][sum + 1];
            str = null;
            Node node = null;
            for (int i = 0; i < D.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    node = new Node();
                    D[i][j] = node;
                }
            }
            while ((str = br.readLine()) != null) {
                String[] s = str.split(",");
                String mLink = s[0];
                int start = Integer.parseInt(s[1]);
                int end= Integer.parseInt(s[2]);
                int d = Integer.parseInt(s[3]);
                D[start][end].setmWeight(d);
                StringBuilder builder = new StringBuilder();
                builder.append(mLink);
                D[start][end].setmBuilder(builder);
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeQuietly(br);
            closeQuietly(fb);
        }
        return D;
    }

    public int getSum() {
        return sum;
    }
    /** 
     * 写文件
     * @param filePath 输出文件路径
     * @param content 要写入的内容
     * @param append 是否追加
     * @return
     * @author s00274007
     * @since 2016-3-1
     */
    public static int write(final String filePath, final String content, final boolean append)
    {
        File file = new File(filePath);
        if (content == null)
        {
            System.out.println("file [" + filePath + "] invalid!!!");
            return 0;
        }

        // 当文件存在但不可写时
        if (isFileExists(file) && (!file.canRead()))
        {
            return 0;
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            if (!isFileExists(file))
            {
                file.createNewFile();
            }

            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);

            bw.write(content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            closeQuietly(bw);
            closeQuietly(fw);
        }

        return 1;
    }

    private static void closeQuietly(Closeable closeable)
    {
        try
        {
            if (closeable != null)
            {
                closeable.close();
            }
        }
        catch (IOException e)
        {
        }
    }

    private static boolean isFileExists(final File file)
    {
        if (file.exists() && file.isFile())
        {
            return true;
        }

        return false;
    }

}

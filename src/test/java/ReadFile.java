import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Thread.sleep;

/**
 * @author Chenjh
 * @create 2019-08-03-10:50
 */

public class ReadFile {

    private Logger log = LoggerFactory.getLogger(ReadFile.class);

    /*static void readOutcol(String filePath,Connection conn){
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                String[] s;
                StringBuffer suffix = new StringBuffer();
                String prefix = "INSERT INTO subbasin (subid,stateid,dt,RO,NH4,TN,TP,COD,TSS) VALUES ";
                //Objects.requireNonNull(conn).setAutoCommit(false);
                conn.setAutoCommit(false);
                // Statement st = conn.createStatement();
                // 比起st，pst会更好些
                PreparedStatement pst = null;
                long i = 1;
                int j = 1;
                Long begin = System.currentTimeMillis();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    s=lineTxt.split("\t");
                    if (s[0].equals("T")) continue;
                    //System.out.println(lineTxt);
                    StringBuffer dt = new StringBuffer();
                    dt.append(s[1]).append("/").append(s[2]).append("/").append(s[3]).append(" ").append(s[4]).append(":").append(s[5]).append(":00");
                    //System.out.println(dt);
                    suffix.append("(").append(s[0]).append(", ").append(1).append(", ").append("\'").append(dt).append("\'").append(", ")
                            .append((new BigDecimal(s[27]).multiply(BigDecimal.valueOf(0.0283168)))).append(", ").append(s[74]).append(", ").append(s[75]).append(", ").append(s[76])
                            .append(", ").append(s[77]).append(", ").append(s[78]).append("),");
                    //j++;
                    // System.out.println(suffix);
                    *//*if(i==1000){
                        String sql = prefix + suffix.substring(0, suffix.length() - 1);
                        //System.out.println(sql);
                        // 添加执行sql
                        //pst = conn.prepareStatement(sql);
                        pst.addBatch(sql);
                        // 执行操作
                        pst.executeBatch();
                        // 提交事务
                        conn.commit();
                        pst.clearBatch();
                        i=0;
                        //j=1;
                        suffix = new StringBuffer();
                    }
                    i++;*//*
                    s = null;
                }
                if(suffix.length()!=0){
                    String sql = prefix + suffix.substring(0, suffix.length() - 1);
                    // 添加执行sql
                    pst = conn.prepareStatement(sql);
                    pst.addBatch(sql);
                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
                }
                //pst.close();
                //conn.close();
                read.close();
                Long end = System.currentTimeMillis();
                // 耗时
                System.out.println("cast : " + (end - begin) / 1000 + " s");
            } else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    static void readTxtFileAndInsert(String filePath, Connection conn) {
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                String[] s;
                StringBuffer suffix = new StringBuffer();
                String prefix = "INSERT INTO linkout (stateid,dt,link,flow) VALUES ";
                //Objects.requireNonNull(conn).setAutoCommit(false);
                conn.setAutoCommit(false);
                // Statement st = conn.createStatement();
                // 比起st，pst会更好些
                PreparedStatement pst = conn.prepareStatement("");
                //PreparedStatement pst = null;
                long i = 1;
                int j = 1;
                long count = 0;
                Long begin = System.currentTimeMillis();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    s=lineTxt.split("\t");
                    if (s[0].equals("Date")) continue;
                    //System.out.println(lineTxt);
                    StringBuffer dt = new StringBuffer();
                    dt.append(s[0].substring(6)).append("/").append(s[0], 0, 5);
                    //System.out.println(dt);
                    if (i<=10000) {
                        suffix.append("(").append(1).append(", ")
                                .append("\'").append(dt).append(" ").append(s[1]).append("\'").append(", ")
                                .append("\'").append(s[2]).append("\'").append(", ")
                                .append(s[4]).append("),");
                        //j++;
                    }
                   // System.out.println(suffix);
                    if(i==10000){
                        String sql = prefix + suffix.substring(0, suffix.length() - 1);
                        //System.out.println(sql);
                        // 添加执行sql
                        //pst = conn.prepareStatement(sql);
                        pst.addBatch(sql);
                        // 执行操作
                        pst.executeBatch();
                        // 提交事务
                        conn.commit();
                        pst.clearBatch();
                        i=0;
                        //j=1;
                        suffix = new StringBuffer();
                    }
                    i++;
                    //TestInsert.inserttest();
                    //count++;
                    //if(count==10000000) break;
                    //System.out.println(lineTxt);
                    s = null;
                    //break;
                }
                if(suffix.length()!=0){
                    String sql = prefix + suffix.substring(0, suffix.length() - 1);
                    // 添加执行sql
                    pst.addBatch(sql);
                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
                }
                pst.close();
                conn.close();
                read.close();
                Long end = System.currentTimeMillis();
                // 耗时
                System.out.println("cast : " + (end - begin) / 1000 + " s");
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    /**
     * 更新fid字段
     * @param
     */
    /*public  void Update(Connection conn,Integer fid,String link) throws SQLException {
        String sql = "UPDATE linkout SET fid=? WHERE link=?";		//sql语句
        try {
            PreparedStatement ps = null;
            //ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1,fid);
            ps.setString(2,link);
            ps.executeUpdate();
            System.out.println("修改成功(*￣︶￣)");
        } catch (SQLException e) {
            System.out.println("操作失败o(╥﹏╥)");
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

     void setFid(Connection conn){
        List<Linktoid> linktoids = linktoidService.findlink();
        List<Linkout> linkouts = linkoutService.findlink();
        for(Linktoid linktoid : linktoids){
            for (Linkout linkout : linkouts) {
                if (linktoid.getLink().equals(linkout.getLink())){
                    try {
                        Update(conn,linktoid.getId(),linkout.getLink());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }*/

    public static void main(String [] args){
        Connection conn;
        String url = "jdbc:mysql://192.168.1.11:3306/jzdb?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String name = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "root!@#$%";
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, username, password);
            String filepath = "D:\\TencentFiles\\768126439\\FileRecv\\JZ\\LinkOUT.txt";
            ReadFile.readTxtFileAndInsert(filepath,conn);
            //ReadFile readFile = new ReadFile();
            //readFile.setFid(conn);
            //ReadFile.readOutcol(filepath,conn);
            //File file = new File(filepath);
            //String[] fileName = file.list();
            //System.out.println(fileName.length);
            /*for(String s : fileName != null ? fileName : new String[0]){
                String path = filepath+"\\"+s;
                //System.out.println(s);
                new Thread(()->{
                    ReadFile.readOutcol(path,conn);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();


            }*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
package com.fcc.jdk8api.core.io_nio.home_work;

import java.io.*;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:12 2018/12/6
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        method1();
//        method2();
//        method3();
        method4();
    }

    public static void method1() {
        FileInputStream fin = null;
        FileOutputStream fos1 = null;
        try {
            fin = new FileInputStream("F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt");
            fos1 = new FileOutputStream("F:\\java_code\\jdk8_api\\src\\main\\resources\\out1.txt");

            byte[] buf = new byte[1024];
            int len = 0;
            StringBuffer sb = new StringBuffer();
            while ((len = fin.read(buf)) != -1) {
                System.out.print(new String(buf));
                sb.append(new String(buf));
                fos1.write(buf,0,buf.length);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (fos1 != null) {
                    fos1.flush();
                    fos1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void method2() {
        FileInputStream fin = null;
        FileOutputStream fos = null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            fin = new FileInputStream("F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt");
            bis=new BufferedInputStream(fin);
            fos = new FileOutputStream("F:\\java_code\\jdk8_api\\src\\main\\resources\\out2.txt");

            bos=new BufferedOutputStream(fos);
            byte[] buf = new byte[1024];
            int len = 0;
            StringBuffer sb = new StringBuffer();
            while ((len = bis.read(buf)) != -1) {
                System.out.print(new String(buf));
                sb.append(new String(buf));
                bos.write(buf,0,buf.length);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (fos != null) {
                    fin.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.flush();
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void method3() {
        FileReader fReader = null;
        FileWriter fWriter = null;
        try {
            fReader = new FileReader("F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt");

            fWriter = new FileWriter("F:\\java_code\\jdk8_api\\src\\main\\resources\\out3.txt");

            char[] cBuf = new char[1024];
            int len = 0;
            StringBuffer sb = new StringBuffer();
            while ((len = fReader.read(cBuf)) != -1) {
                System.out.print(new String(cBuf));
                sb.append(new String(cBuf));
                fWriter.write(cBuf,0,cBuf.length);
//                fWriter.write(new String(cBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (fReader != null) {
                    fReader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (fWriter != null) {
                    fWriter.flush();
                    fWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void method4() {
        FileReader fReader = null;
        BufferedReader br=null;
        FileWriter fWriter = null;
        BufferedWriter bw=null;
        try {
            fReader = new FileReader("F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt");
            br=new BufferedReader(fReader);
            fWriter = new FileWriter("F:\\java_code\\jdk8_api\\src\\main\\resources\\out4.txt");
            bw=new BufferedWriter(fWriter);
            StringBuffer sb = new StringBuffer();
            String str=null;
            while ( (str=br.readLine())!= null) {
                bw.write(str);
                bw.write("\\r\\n");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void getPath() throws IOException {
        System.out.println(Test.class.getClassLoader().getResource("").getPath());//   /F:/java_code/jdk8_api/target/classes/
//        InputStream is= Test.class.getClassLoader().getResourceAsStream("in.txt");//getResourceAsStream()in.txt在resource目录下能拿到
        InputStream is = Test.class.getClassLoader().getResourceAsStream(
                "F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt");//in.txt在resources目录下能拿到
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(temp);
        }

        System.out.println(Test.class.getClassLoader().getResourceAsStream("in.txt"));
    }
}

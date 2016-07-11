package com.jzc.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



/**
 * @author jzc
 * 源代码文件分析工具
 */
public class CodeAnalUtil {
    
    //源文件存放路径
    private String filePath;
    
    //主URL
    private String rootUrl;
    
    private boolean rootFlag=true;
    
    private ArrayList<Method> methods;
    
    //存放URL和对应的Method
    //private HashMap<String,>
    
    //读取源代码文件
    /**
     * @author jzc
     * @name analFile
     * @param {"id":"String","name":"String","age":"int"}
     * @return {"id":"String","name":"String","age":"int"}
     * 
     * 
     * */
    public void analFile() throws IOException{
        File codefile = new File(filePath);
        FileInputStream fis = new FileInputStream(codefile);
        BufferedReader buf = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while((line=buf.readLine())!=null){
            //如果是整个类的注释
            line = line.trim();
            if(rootFlag==true){
                if(line.startsWith("@RequestMapping")){
                    this.rootUrl = getURL(line);
                }else if(line.startsWith("public")){
                    rootFlag=false;
                }
            }
            //如果是某个方法的注释
            else{
                //首先读取该方法所有的注释
                if(line.startsWith("/*")){
                    ArrayList<String> anotation = new ArrayList<String>();
                    anotation.add(line);
                    while((line=buf.readLine())!=null){
                          anotation.add(line);
                          if(line.startsWith("@RequestMapping")){
                              analAnotation(anotation);
                              break;
                          }
                      }
                    
                }
                //然后分析@RequestMapping
                else if(line.startsWith("@RequestMapping")){
                    
                }
            }
        }
    }
    
    public String getURL(String line){
        int left = line.indexOf('\"');
        int right = line.indexOf('\"', left+1);
        String url = line.substring(left, right);
        return url;
    }
    
    //解析方法的注释
    public void analAnotation(ArrayList<String> anotation){
        if(anotation!=null){
            Method method = new Method();
            Iterator<String> ite = anotation.iterator();
            while(ite.hasNext()){
                String line = ite.next();
                if(line.contains("@author")){
                    String temp = line.substring(line.indexOf("@author")+6);
                    method.setAuthor(temp.trim());
                }else if(line.contains("@name")){
                    String temp = line.substring(line.indexOf("@author")+5);
                    method.setName(temp.trim());
                }else if(line.contains("@param")){
                    if(line.contains("}")){
                        analParam(line);
                    }else{
                        String temp="";
                        while(!(temp = ite.next()).contains("}")){
                            line = line+temp;
                        }
                        line += temp;
                        analParam(line);
                    }
                    
                }else if(line.contains("@return")){
                    
                }else if(line.contains("@RequestMapping")){
                    
                }
            }
        }
    }
    
    public void analParam(String line){
        
    }
    
}

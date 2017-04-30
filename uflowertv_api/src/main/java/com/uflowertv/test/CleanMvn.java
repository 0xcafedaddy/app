package com.uflowertv.test;

import java.io.File;
/**
 * 版权所有：2017年1月10日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：用于清空maven下载失败文件
 * 类名称：com.uflowertv.test.CleanMvn     
 * 创建人：liguoliang 
 * 创建时间：2017年1月10日 下午4:23:13   
 * 修改人：
 * 修改时间：2017年1月10日 下午4:23:13   
 * 修改备注：   
 * @version   V1.0
 */
public class CleanMvn {
	
    public static void main(String[] args){
        findAndDelete(new File("D:\\apache-maven-3.5.0\\repository"));
        System.exit(0);
    }
    public static boolean findAndDelete(File file){
        if(!file.exists()){
        } else if(file.isFile()){
            if(file.getName().endsWith("lastUpdated")){
                deleteFile(file.getParentFile());
                return true;
            }
        } else if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                if(findAndDelete(f)){
                    break;
                }
            }
        }
        return false;
    }
    public static void deleteFile(File file){
        if(!file.exists()){
        } else if(file.isFile()){
            print("删除文件:" + file.getAbsolutePath());
            file.delete();
        } else if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                deleteFile(f);
            }
            print("删除文件夹:" + file.getAbsolutePath());
            print("====================================");
            file.delete();
        }
    }
    public static void print(String msg){
        System.out.println(msg);
    }
}
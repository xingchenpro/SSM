package com.hly.ssm.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author :hly
 * @date :2018/5/14
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public ModelAndView beforeUpload(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("upload");
        return mv;
    }

    @RequestMapping(value = "/uploadAfter",method = RequestMethod.POST)
    public ModelAndView uploadAfter(@Param("file")MultipartFile file){
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        //根目录
        String rootPath = "D:/MidnightSunFile/";
        //文件完整名称，.jpg等
        String fileName = file.getOriginalFilename();
        //文件名，不包括后缀
        String name = fileName.substring(0,fileName.indexOf("."));
        //文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        //按年月存放
        //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
        Calendar date = Calendar.getInstance();
        //个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
        File dataFile  = new File(date.get(Calendar.YEAR)+File.separator+(date.get(Calendar.MONTH)+1));

        File newFile = new File(rootPath+File.separator+dataFile+File.separator+fileName);
        //文件存在就重命名
        int i =0;
        String newFileName = fileName;
        while(newFile.exists()){
            newFileName = name+"("+i+")"+suffixName;
            String parentPath = newFile.getParent();
            newFile = new File(parentPath+File.separator+newFileName);
            i++;
        }

        //目录是否存在
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
            String url = rootPath+"/"+dataFile+"/"+newFile;
        }
        try {
            file.transferTo(newFile);
            mv.addObject("success",true);
            mv.addObject("msg","上传成功");
        } catch (IOException e) {
            mv.addObject("success",false);
            mv.addObject("msg","上传失败");
            e.printStackTrace();
        }
        return mv;
    }
}

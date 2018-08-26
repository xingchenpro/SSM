package com.hly.ssm.controller.fileUploadController;

import com.hly.ssm.pojo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/15
 */
@Controller
@RequestMapping(value = "/fileUpload" )
public class EditormdFileUploadController {
    /**
     * 边界页面
     * @return
     */
    @RequestMapping("editorMD")
    public ModelAndView editormd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/editor/simple");
        return mv;
    }
    /**
     * 图片上传
     * @param request
     * @param response
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "/editorMDUpload" ,method = RequestMethod.POST)
    public void editorMD(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws IOException {
        try {
            request.setCharacterEncoding( "utf-8" );
            /*这里返回格式是html/txt才能上传*/
            response.setHeader( "Content-Type" , "application/json" );
            //获得web项目的全路径
            String rootPath = request.getSession().getServletContext().getRealPath("/resource/upload/");
            //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
            Calendar date = Calendar.getInstance();
            //获得日期路径,MONTH个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
            File dateFile = new File(date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+(date.get(Calendar.DATE)));
            //获得文件最初的路径
            String originalFile = file.getOriginalFilename();
            //得到完整路径名
            File newFile = new File(rootPath+File.separator+dateFile+File.separator+originalFile);

            /*文件不存在就创建*/
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
            //System.out.println("/resources/upload/"+dateFile+File.separator+originalFile);
            System.out.println(dateFile+"/"+file.getOriginalFilename());
            /*JSON格式*/
            response.getWriter().write("{\"success\":1,\"message\":\"上传成功\",\"url\":\"/resource/upload/"+date.get(Calendar.YEAR)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE)+"/"+file.getOriginalFilename()+"\"}");

        } catch (Exception e) {
            response.getWriter().write("{\"success\":0}");
        }
    }
    /**
     * 获取文章内容
     */
    @RequestMapping(value = "editorContent",method = RequestMethod.POST)
    public ModelAndView articleContent(@RequestBody Article article){
        System.out.println("MD文本");
        System.out.println(article.getMarkdownContent());
        System.out.println("HTML文本");
        System.out.println(article.getHtmlContent());

        ModelAndView mv = new ModelAndView();
        mv.addObject("html",article.getHtmlContent());
        mv.addObject("md",article.getMarkdownContent());
        mv.setViewName("editor/article");
        return  mv;
    }
}

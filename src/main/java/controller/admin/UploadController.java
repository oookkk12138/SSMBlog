package controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.JSONObject;

@Controller
public class UploadController {
	
	//上传用户头像(直接使用一个类做返回值，jackson就会制动封装成json了)
	//在编辑文章中上传图片，也是使用这个接口
	@RequestMapping(value="/admin/user/uploadUserAvator/avator",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadUserAvator(@RequestParam("file") MultipartFile  file,HttpServletRequest request) {
		//获取文件名并进行后缀判断（jpg、png）
		String pictureName = file.getOriginalFilename();
		//定义最终保存的文件名
		String fileName = null;
		//获取tomcat的工作目录
		String tomcatPath = request.getSession().getServletContext().getRealPath("/resource/upload");
		//判断文件传过来的格式起对应的后缀名
		if(pictureName.endsWith(".jpg")) {
			fileName = System.currentTimeMillis() + ".jpg";
		}
		else if(pictureName.endsWith(".png")){
			fileName = System.currentTimeMillis() + ".png";
		}else {
			//若文件名不是以jpg/png结尾的话就返回json提示信息
			JSONObject json = new JSONObject();
			json.setCode(0);
			json.setMsg("只支持上传jpg/png格式的图片");
			json.setData(null);
			return json;
		}
		//判断tomcat下的那个上传目录是否存在，若不存在就创建一个
		File tomcatPathFolder = new File(tomcatPath);
		if(!tomcatPathFolder.exists()) {
			tomcatPathFolder.mkdir();
		}
		
		//获取刚刚tomcat下的upload下的刚上传了的那个图片
		File tomcatPathFile = new File(tomcatPathFolder,fileName);
		try {
			//写入文件到tomcat工作目录下
			file.transferTo(tomcatPathFile);
			//再写一份到eclipse工作目录下，部署到linux时改为linux的目录
			File tomcatFile1 = new File(tomcatPathFile.toString());
			FileInputStream fis = new FileInputStream(tomcatFile1);
			FileOutputStream fos = new FileOutputStream("D:\\EclipseEE64位\\project\\SSMBlog\\src\\main\\webapp\\resource\\upload" + File.separator + fileName);
			byte[] b = new byte[(int) tomcatFile1.length()];
			fis.read(b);
			fos.write(b);
			fis.close();
			fos.close();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//上传成功后返回json数据
		JSONObject json = new JSONObject();
		json.setCode(0);
		json.setMsg("上传成功");
		Map<String,Object> data = new HashMap<String,Object>();
		//这是刚刚上传的那个文件的路径
		data.put("src","/SSMBlog/resource/upload/" + fileName);
		json.setData(data);
		return json;
	}
	
}

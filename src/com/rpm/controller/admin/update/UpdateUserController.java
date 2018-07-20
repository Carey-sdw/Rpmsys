package com.rpm.controller.admin.update;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.rpm.domain.User;
import com.rpm.service.UserService;
import com.rpm.service.update.UpdateUserService;

@Controller
public class UpdateUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UpdateUserService updateUserService;
	
	/*
	 * 转到修改页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/updateuser")
	public String updateUser(Long id,Model model,String error) {
		model.addAttribute("user", userService.findU(id));
		model.addAttribute("error",error);
		return "admin/userdetails";
	}
	/*
	 * 转到修改页面
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updateuser",produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User updateUsers(User user) {
		try {
			updateUserService.updateUser(user);
			user.setUsername("用户资料修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			user.setUsername("未按要求修改，用户资料修改失败!");
		}
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/upphoto")
	public String upPthot(HttpServletRequest request,Long id) throws IllegalStateException, IOException{
		CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());
        cmr.setDefaultEncoding("utf-8");
        cmr.setMaxInMemorySize(40960);
        cmr.setMaxUploadSize(10485760000L);
        MultipartHttpServletRequest multipartRequest = cmr.resolveMultipart(request);
     
        MultipartFile file = multipartRequest.getFile("photo_url");// 与页面input的name相同
        String fileName = file.getOriginalFilename();  
        // 获取图片的扩展名  
        String extensionName = fileName  
                .substring(fileName.lastIndexOf(".") + 1);
        // 新的图片文件名 = 获取时间戳+"."图片扩展名  
        String newFileName = String.valueOf(System.currentTimeMillis())  
                + "." + extensionName;  
//        String path=request.getSession().getServletContext().getRealPath("/WebContent/public/images/user");
//        System.out.println(path);
        File imageFile = new File("D:\\workspace\\Rpmsys\\WebContent\\public\\images\\user",newFileName);// 上传后的文件保存目录及名字
        String imgurl="/Rpmsys/assets/images/user/"+newFileName;
        if (!file.isEmpty()) { 
//        	imageFile.mkdirs(); //创建多级文件夹
        	file.transferTo(imageFile);// 将上传文件保存到相应位置 
        	
           }  
        imageFile.exists();
        updateUserService.updateUserPhoto(imgurl, id);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:updateuser?id="+id;
	}
}

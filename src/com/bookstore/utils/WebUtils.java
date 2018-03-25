package com.bookstore.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bookstore.bean.Book;
import com.bookstore.bean.Category;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;

public class WebUtils {
	public static <T> T request2bean(HttpServletRequest request,Class<T> beanclass){
		try {
			T t = beanclass.newInstance();
			Map map = request.getParameterMap();
			BeanUtils.populate(t, map);
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Book upload(HttpServletRequest request,String uploadpath){
		try {
			Book book = new Book();
			BusinessService service = new BusinessServiceImpl();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
		
			for(FileItem item:list){
				if(item.isFormField()){
					String inputName = item.getFieldName();
					String value = item.getString("UTF-8");
					if(inputName.equals("category_id")){
						Category c = service.findCategory(value);
						book.setCategory(c);
					}else{
						BeanUtils.setProperty(book, inputName, value);
					}
				}else{
					String filename = item.getName();
				    filename = filename.substring(filename.lastIndexOf("\\")+1);
					
					String savepath = uploadpath;
					String savefilename = UUID.randomUUID().toString()+filename;
					InputStream in = item.getInputStream();
					
					FileOutputStream out = new FileOutputStream(uploadpath+"\\"+savefilename);
					int len = 0;
					byte[] buffer = new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					book.setImage(savefilename);
				}
			}
			book.setId(UUID.randomUUID().toString());
			return book;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

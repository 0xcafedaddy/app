package com.util.ctvit.vdp;

import com.util.ctvit.gather.DateUtil;

import javax.servlet.http.HttpServlet;
import java.util.Date;

public class UploadFile extends HttpServlet {
	
	public String getFileURL(String fileType,String objectId,String fileName){
		Date date = new Date();
		String strdate = DateUtil.getDateTime("yyyy-MM-dd",date);
		String[] ymd = strdate.split("-");		
		String url = fileType+ "/" + ymd[0] + "/" + ymd[1] + ymd[2] + "/" + objectId + "/" + fileName;
		return url;
	}
	
	
//	// 获取预览图（只有一张）
//	public ProductImage getPreviewImageByProductID(String ProductID) {
//		ProductImageExample example = new ProductImageExample();
//		example.createCriteria().andProductidEqualTo(ProductID).andImagetypeEqualTo("预览图");
//		List<ProductImage> productImages = productImageMapper.selectByExample(example);
//		if(productImages!=null && productImages.size()>0) {
//			ProductImage productImage = productImages.get(0);
//			StorageAccess access = accessService.getStorageAccess(productImage.getStorageid(),Constants.ACCESS_PLAY);
//			productImage.setImageurl(access.getAccessaddress() + productImage.getImageurl());
//			return productImage;
//		}else {
//			return null;
//		}
//	}
//	// 上传图片（预览图，海报，普通图）
//	public String addProductImage(String productid,String imagetype,String imagename) {
//		ProductImage image = new ProductImage();
//		String imageid = GUIDUtil.get();
//		image.setImageid(imageid);
//		image.setProductid(productid);
//		image.setDeletteflag(0);
//		image.setImagename(imagename);
//		image.setImagetype(imagetype);
//		String storageid = storageService.chooseStorage(Constants.STORAGE_PRODUCT).getStorageid();
//		image.setStorageid(storageid);
//		Date date = new Date();
//		image.setCreatetime(date);
//		String strdate = DateUtil.getDateTime("yyyy-MM-dd",date);
//		String[] ymd = strdate.split("-");		
//		String url = "/" + ymd[0] + "/" + ymd[1] + ymd[2] + "/" + productid + "/" + imagename;
//		image.setImageurl(url);
//		int flag = productImageMapper.insert(image);
//		if(flag>0) {
//			//返回存储图片路径
//			String address = accessService.getStorageAccess(storageid, Constants.ACCESS_FILEMOVE).getAccessaddress();
//			return address + url;
//		}else {
//			return null;
//		}
//	}
	

	
//	// 删除图片（预览图，海报，普通图）
//	public int deleteProductImage(String imageid) {
//		ProductImage image = loadProductImage(imageid);
//		int flag = productImageMapper.deleteByPrimaryKey(imageid);
//		if(flag>0) { // 删除记录成功，再删除文件
//			StorageAccess access = accessService.getStorageAccess(image.getStorageid(),Constants.ACCESS_FILEMOVE);
//			String path = access.getAccessaddress() + image.getImageurl();
//			File imageFile = new File(path);
//			imageFile.deleteOnExit();
//		}
//		return flag;
//	}
}

package com.util.ctvit.vdp;


/** 
* 
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;


/** 
* @author Administrator 
* 
*/
public class VoUtils {
	public VoUtils() {
	}

	//���java���������ͷ���vo���� 
	public static String getClassType(Class c) {
		String typeName = c.getSimpleName();
		if (typeName.equals("String") || typeName.equals("Date")) {
			return typeName;
		} else if (typeName.equals("BigDecimal") || typeName.equals("Decimal") || typeName.equals("Double")) {
			return "Number";
		} else if (typeName.equals("Integer")) {
			return "int";
		} else if (typeName.equals("Boolean")) {
			return "boolean";
		} else {
			return "*";//�������͵�����Ϊδ֪���� 
		}
	}

	//�ظ�c�ַ�count�Σ����ڸ�ʽ����ɵ�as�ļ� 
	public static String repeat(String c, int count) {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp += c;
		}
		return temp;
	}

	/** 
	* ���as�ļ� 
	* @param pojoName java������� 
	* @param packageName flex��vo����İ��� 
	* @throws ClassNotFoundException 
	* @throws IOException 
	*/
	public static void generateAsFile(String pojoName, String packageName, String folder) throws ClassNotFoundException, IOException {
		Class c = Class.forName(pojoName);
		Field[] fields = c.getDeclaredFields();
		//as��vo������ƽ�β����VO��־ 
		File f = new File(folder + c.getSimpleName() + "VO.as");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		//����û�����ð����ȡ��java pojoһ��İ��� 
		if (StringUtils.isEmpty(packageName)) {
			bw.write("package " + c.getPackage().getName() + "\n{\n");
		} else {
			bw.write("package " + packageName + "\n{\n");
		}
		//д��Ӧ��ϵ
		bw.write(repeat(" ", 4) + "[Bindable]\n");
		bw.write(repeat(" ", 4) + "[RemoteClass(alias=\"" + c.getPackage().getName() + "." + c.getSimpleName() + "\")]\n");
		//д�� 
		bw.write(repeat(" ", 4) + "public class " + c.getSimpleName() + "VO\n");
		bw.write(repeat(" ", 4) + "{\n");
		//д���� 
		for (int i = 0; i < fields.length; i++) {
			Class fieldType = fields[i].getType();
			String typeName = getClassType(fieldType);
			bw.write(repeat(" ", 8) + "private var _" + fields[i].getName() + ":" + typeName + ";\n");
		}
		bw.write("\n\n\n");
		//д�յĹ��캯�� 
		bw.write(repeat(" ", 8) + "public function " + c.getSimpleName() + "VO(){}\n\n");
		//д setter/getter ���� 
		for (int i = 0; i < fields.length; i++) {
			Class fieldType = fields[i].getType();
			String typeName = getClassType(fieldType);
			//setter 
			bw.write(repeat(" ", 8) + "public function set " + fields[i].getName() + "(value:" + typeName + "):void{\n");
			bw.write(repeat(" ", 12) + "this._" + fields[i].getName() + " = value;\n");
			bw.write(repeat(" ", 8) + "}\n\n");
			//getter 
			bw.write(repeat(" ", 8) + "public function get " + fields[i].getName() + "():" + typeName + "{\n");
			bw.write(repeat(" ", 12) + "return this._" + fields[i].getName() + ";\n");
			bw.write(repeat(" ", 8) + "}\n\n\n");
		}
		bw.write(repeat(" ", 4) + "}\n");
		bw.write("}");
		bw.close();
	}

	//���ԣ�д�˸����� 
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// 
		String[] pojos = {
		//"com.ctvit.vdp.entity.AchieveMaterial",
		//"com.ctvit.vdp.entity.Advertise",
		//"com.ctvit.vdp.entity.BeginAndEndPublish",
		//"com.ctvit.vdp.entity.BeginAndEndStoreHouse",
		//"com.ctvit.vdp.entity.BroadCast",
		//"com.ctvit.vdp.entity.BroadCastBusiness",
		//"com.ctvit.vdp.entity.BusinessModel",
		//"com.ctvit.vdp.entity.CataTemplate",
		//"com.ctvit.vdp.entity.CataTemplateEntityRelatio",
		//"com.ctvit.vdp.entity.CodeRate",
		//"com.ctvit.vdp.entity.DomainTreeRelation",
		//"com.ctvit.vdp.entity.LiveBusiness",
		//"com.ctvit.vdp.entity.LiveForm",
		//"com.ctvit.vdp.entity.LiveRefForm",
		//"com.ctvit.vdp.entity.LiveToVod",
		//"com.ctvit.vdp.entity.ModelPtemplateRelation",
		//"com.ctvit.vdp.entity.ModelTreeRelation",
		//"com.ctvit.vdp.entity.NetTerminalPublish",
		//"com.ctvit.vdp.entity.Node",
		//"com.ctvit.vdp.entity.Organization",
		//"com.ctvit.vdp.entity.PpackagePtemplateRelation",
		//"com.ctvit.vdp.entity.ProducctPublish",
		//"com.ctvit.vdp.entity.Product",
		//"com.ctvit.vdp.entity.ProductCopyRight",
		//"com.ctvit.vdp.entity.ProductFavorite",
		//"com.ctvit.vdp.entity.ProductFileGroup",
		//"com.ctvit.vdp.entity.ProductImage",
		//"com.ctvit.vdp.entity.ProductOperation",
		//"com.ctvit.vdp.entity.ProductRelated",
		//"com.ctvit.vdp.entity.ProductSepcialTopicRelati",
		//"com.ctvit.vdp.entity.PublishCataData",
		//"com.ctvit.vdp.entity.PublishDetails",
		//"com.ctvit.vdp.entity.PublishPackage",
		//"com.ctvit.vdp.entity.PublishTemplate",
		//"com.ctvit.vdp.entity.PublishTerminal",
		//"com.ctvit.vdp.entity.PublishTreeRelation",
		//"com.ctvit.vdp.entity.RecoverProduct",
		//"com.ctvit.vdp.entity.Role",
		//"com.ctvit.vdp.entity.Service",
		//"com.ctvit.vdp.entity.Sort",
		//"com.ctvit.vdp.entity.SortTree",
		//"com.ctvit.vdp.entity.Source",
		//"com.ctvit.vdp.entity.SpecialTopic",
		//"com.ctvit.vdp.entity.Storage",
		//"com.ctvit.vdp.entity.StorageAccess",
		//"com.ctvit.vdp.entity.StoreHouse",
		//"com.ctvit.vdp.entity.SystemConfig",
		//"com.ctvit.vdp.entity.Terminal",
		//"com.ctvit.vdp.entity.TerminalDomainRelation",
		//"com.ctvit.vdp.entity.TopicMatch",
		//"com.ctvit.vdp.entity.User",
		//"com.ctvit.vdp.entity.UserRoles",
		//"com.ctvit.vdp.entity.VirtualLiveBusiness"
		"com.ctvit.vdp.entity.manual.ContentConverge" };
		for (int i = 0; i < pojos.length; i++) {
			//Class c = Class.forName(pojos[i]); 
			//System.out.println("registerClassAlias('"+pojos[i]+"',com.nstar.orderexpress.vo."+c.getSimpleName()+"VO);"); 
			//VoUtils.generateAsFile(pojos[i],"com.vdp.common.vo.","d:/temp/vo/"); 
			VoUtils.generateAsFile(pojos[i], "com.vdp.common.vo.manual.", "d:/temp/vo/manual/");
		}
	}

}

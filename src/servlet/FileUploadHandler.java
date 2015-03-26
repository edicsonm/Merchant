package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.CertificateVO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DB.ManageData;

public class FileUploadHandler extends HttpServlet {
	
	private static final long serialVersionUID = -2441641214608547223L;
	
	private String UPLOAD_DIRECTORY;
	private String keyName;
	private String passwordKeyStore;
	private String passwordKey;
	private String merchant;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}else{
						System.out.println("item.getFieldName(): " + item.getFieldName() + ":"+item.getString());
						if(item.getFieldName().equalsIgnoreCase("passwordKeyStore")){
							passwordKeyStore = item.getString();
						}else if(item.getFieldName().equalsIgnoreCase("passwordKey")){
							passwordKey = item.getString();	
						}else if(item.getFieldName().equalsIgnoreCase("keyName")){
							keyName = item.getString();
						}else if(item.getFieldName().equalsIgnoreCase("merchant")){
							merchant = item.getString();
						}
					}
				}
				// File uploaded successfully
				
				CertificateVO certificateVO = new CertificateVO();
				certificateVO.setIdMerchant(merchant);
				certificateVO.setPasswordKeyStore(passwordKeyStore);
				certificateVO.setPasswordKey(passwordKey);
				certificateVO.setKeyName(keyName);
				
				ManageData manageData = new ManageData();
				int answer = manageData.insertUpdateCertificate(certificateVO);
				System.out.println("\nRespuesta: " + answer);
				if(answer == 1){
					request.setAttribute("message", "File Uploaded Successfully");
				}else{
					request.setAttribute("message", "File Upload Failed due was imposible save your data in our data base ");
				}
				
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}
		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	public void init() throws ServletException {
		UPLOAD_DIRECTORY = getServletContext().getInitParameter("file-upload");
		super.init();
	}
}
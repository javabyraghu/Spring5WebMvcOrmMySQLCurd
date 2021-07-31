package in.nareshit.raghu.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeePdfView extends AbstractPdfView {

	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//file name
		response.setHeader("Content-Disposition", "attachment;filename=employees.pdf");
		
		//create element
		Paragraph title = new Paragraph("WELCOME TO EMPLOYEE PDF!");

		//add element to document
		document.add(title);
	}
}

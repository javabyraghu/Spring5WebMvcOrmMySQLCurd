package in.nareshit.raghu.pdf;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nareshit.raghu.model.Employee;

public class EmployeePdfView extends AbstractPdfView {

	/***
	 * To provide header and footer
	 */
	protected void buildPdfMetadata(
			Map<String, Object> model, 
			Document document,
			HttpServletRequest request) 
	{

		HeaderFooter header = new HeaderFooter(new Phrase("EMPLOYEE DATA"),false);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setHeader(header);
		
		HeaderFooter footer = new HeaderFooter(new Phrase(new Date() + " ||  REPORT FOR EMPLOYEES || Page#"),true);
		footer.setAlignment(Element.ALIGN_RIGHT);
		document.setFooter(footer);
	}



	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {

		//file name
		response.setHeader("Content-Disposition", "attachment;filename=employees.pdf");

		/**adding image*/

		Image img = Image.getInstance("https://image3.mouthshut.com/images/imagesp/925727702s.png");
		img.setAlignment(Element.ALIGN_CENTER);
		document.add(img);

		/**Title */
		
		Font titleFont = new Font(Font.TIMES_ROMAN, 30, Font.BOLD, Color.RED);
		Paragraph title = new Paragraph("WELCOME TO EMPLOYEE PDF!",titleFont);

		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(20.0f);
		title.setSpacingAfter(35.0f);
		//add element to document
		document.add(title);

		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("list");

		/**Table with Data**/
		Font tableFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.WHITE);

		PdfPTable table = new PdfPTable(6);//no.of columns
		table.addCell(getCellData("ID",tableFont));
		table.addCell(getCellData("NAME",tableFont));
		table.addCell(getCellData("SAL",tableFont));

		table.addCell(getCellData("DEPT",tableFont));
		table.addCell(getCellData("HRA",tableFont));
		table.addCell(getCellData("TA",tableFont));

		for(Employee emp:list) {
			table.addCell(emp.getEmpId().toString());
			table.addCell(emp.getEmpName());
			table.addCell(emp.getEmpSal().toString());

			table.addCell(emp.getEmpDept());
			table.addCell(emp.getEmpHra().toString());
			table.addCell(emp.getEmpTa().toString());
		}


		document.add(table);
	}

	//table cell design
	private PdfPCell getCellData(String input,Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(input,font));
		cell.setBackgroundColor(Color.BLACK);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		return cell;
	}
}

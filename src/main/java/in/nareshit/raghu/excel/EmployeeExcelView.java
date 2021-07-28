package in.nareshit.raghu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nareshit.raghu.model.Employee;

public class EmployeeExcelView extends AbstractXlsxView {

	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {

		//file name (download)
		response.addHeader("Content-Disposition", "attachment;filename=EMPLOYEES.xlsx");

		//read data from ModelAndView
		@SuppressWarnings("unchecked")
		List<Employee> list =  (List<Employee>) model.get("list");

		//create a New Sheet
		Sheet sheet = workbook.createSheet("EMPLOYEES");

		setHeader(sheet);
		setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<Employee> list) {
		int rowNum = 1;
		for(Employee e : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getEmpId());
			row.createCell(1).setCellValue(e.getEmpName());
			row.createCell(2).setCellValue(e.getEmpSal());
			row.createCell(3).setCellValue(e.getEmpDept());
			row.createCell(4).setCellValue(e.getEmpHra());
			row.createCell(5).setCellValue(e.getEmpTa());
		}
	}

	private void setHeader(Sheet sheet) {
		int rowNum = 0;
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("SAL");
		row.createCell(3).setCellValue("DEPT");
		row.createCell(4).setCellValue("HRA");
		row.createCell(5).setCellValue("TA");
	}
}
